/* 
 * MIT License
 * 
 * Copyright (c) 2018 Guillermo Facundo Colunga
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package visitor.impl;

import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Variable;
import ast.statements.Statement;
import ast.types.ErrorType;
import symboltable.SymbolTable;
import visitor.AbstractVisitor;

/**
 * Instance of IdentificationVisitor.java
 * 
 * @author
 * @version
 */
public class IdentificationVisitor extends AbstractVisitor<Object, Object> {

	/** The st. */
	SymbolTable st = new SymbolTable();

	/* (non-Javadoc)
	 * @see visitor.AbstractVisitor#visit(ast.expressions.Variable, java.lang.Object)
	 */
	@Override
	public Object visit( Variable variable, Object param ) {

		variable.setDefinition(
				st.find( variable.getName() ) );
		if (variable.getDefinition() == null)
			variable.setDefinition( new VarDefinition( variable.getLine(), variable.getColumn(),
					variable.getName(), new ErrorType( variable,
							"No variable definition found for: " + variable.getName() ) ) );

		return null;
	}

	/* (non-Javadoc)
	 * @see visitor.AbstractVisitor#visit(ast.definitions.FuncDefinition, java.lang.Object)
	 */
	@Override
	public Object visit( FuncDefinition funcDefinition, Object param ) {

		if (!st.insert( funcDefinition ))
			new ErrorType( funcDefinition,
					"Duplicate function definition for: " + funcDefinition.getName() );

		st.set();
		funcDefinition.getType().accept( this, param );
		for (Statement statement : funcDefinition.getStatements()) {
			statement.accept( this, param );
		}
		st.reset();

		return null;
	}

	/* (non-Javadoc)
	 * @see visitor.AbstractVisitor#visit(ast.definitions.VarDefinition, java.lang.Object)
	 */
	@Override
	public Object visit( VarDefinition varDefinition, Object param ) {

		if (!st.insert( varDefinition ))
			new ErrorType( varDefinition,
					"Duplicate variable definition for: " + varDefinition.getName() );
		varDefinition.getType().accept( this, param );
		return null;
	}

}
