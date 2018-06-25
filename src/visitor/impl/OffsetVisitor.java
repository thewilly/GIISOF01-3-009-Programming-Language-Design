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
import ast.literals.RecordField;
import ast.statements.Statement;
import ast.types.FunctionType;
import ast.types.RecordType;
import visitor.AbstractVisitor;

/**
 * Instance of OffsetVisitor.java
 *
 * @author
 * @version
 */
public class OffsetVisitor extends AbstractVisitor<Object, Object> {

	/** The global off set. */
	private int globalOffSet = 0;
	
	/** The param off set. */
	private int paramOffSet = 4;
	
	/** The local off set. */
	private int localOffSet = 0;

	/* (non-Javadoc)
	 * @see visitor.AbstractVisitor#visit(ast.definitions.VarDefinition, java.lang.Object)
	 */
	@Override
	public Object visit( VarDefinition varDefinition, Object param ) {
		varDefinition.getType().accept( this, param );
		if (varDefinition.getScope() == 0) {
			varDefinition.setOffset( globalOffSet );
			globalOffSet += varDefinition.getType().getNumberOfBytes();
		} else {

			if ((boolean) param) {
				varDefinition.setOffset( paramOffSet );
				paramOffSet += varDefinition.getType().getNumberOfBytes();
			} else {
				localOffSet -= varDefinition.getType().getNumberOfBytes();
				varDefinition.setOffset( localOffSet );
			}
		}
		System.out.println(
				"Nombre: " + varDefinition.getName() + " OffSet: " + varDefinition.getOffset() );
		return null;
	}

	/* (non-Javadoc)
	 * @see visitor.AbstractVisitor#visit(ast.definitions.FuncDefinition, java.lang.Object)
	 */
	@Override
	public Object visit( FuncDefinition funDefinition, Object param ) {
		funDefinition.getType().accept( this, param );
		if (funDefinition.getStatements() != null) {
			for (Statement statement : funDefinition.getStatements()) {
				statement.accept( this, false );
			}
		}
		this.localOffSet = 0;
		this.paramOffSet = 4;
		return null;

	}

	/* (non-Javadoc)
	 * @see visitor.AbstractVisitor#visit(ast.types.FunctionType, java.lang.Object)
	 */
	@Override
	public Object visit( FunctionType functionType, Object param ) {
		functionType.getReturnType().accept( this, param );
		for (int i = functionType.getParameters().size() - 1; i >= 0; i--) {
			functionType.getParameters().get( i ).accept( this, true );
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see visitor.AbstractVisitor#visit(ast.types.RecordType, java.lang.Object)
	 */
	@Override
	public Object visit( RecordType recordType, Object param ) {
		int fieldOffset = 0;
		for (RecordField r : recordType.getFields()) {
			r.accept( this, param );
			r.setOffset( fieldOffset );
			fieldOffset += r.getType().getNumberOfBytes();
		}
		return null;
	}

}
