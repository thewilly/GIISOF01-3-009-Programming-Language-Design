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
package codegeneration;

import ast.definitions.VarDefinition;
import ast.expressions.FieldAccess;
import ast.expressions.Indexing;
import ast.expressions.Variable;
import ast.types.IntType;

/**
 * The Class AddressCodeGeneratorVisitor.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class AddressCodeGeneratorVisitor extends CodeGeneratorVisitor {

	/** The value cg visitor. */
	private ValueCodeGeneratorVisitor valueCgVisitor;

	/**
	 * Instantiates a new address code generator visitor.
	 *
	 * @param generator the generator
	 */
	public AddressCodeGeneratorVisitor( CodeGenerator generator ) {
		super( generator );
	}

	/**
	 * Sets the value visitor.
	 *
	 * @param valueVisitor the new value visitor
	 */
	public void setValueVisitor( ValueCodeGeneratorVisitor valueVisitor ) {
		this.valueCgVisitor = valueVisitor;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.expressions.Variable, java.lang.Object)
	 */
	@Override
	public Object visit( Variable variable, Object object ) {

		VarDefinition v = (VarDefinition) variable.getDefinition();

		if (variable.getDefinition().getScope() == 0) {
			generator.pusha( v.getOffset() );
		} else {
			generator.pushbp();
			generator.push( v.getOffset() );
			generator.add( IntType.getInstance() );
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.expressions.FieldAccess, java.lang.Object)
	 */
	@Override
	public Object visit( FieldAccess fieldAccess, Object param ) {
		fieldAccess.getExp().accept( this, param );
		generator.push(
				fieldAccess.getExp().getType().get(
						fieldAccess.getName() ).getOffset() );
		generator.add( IntType.getInstance() );
		return null;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.expressions.Indexing, java.lang.Object)
	 */
	@Override
	public Object visit( Indexing indexing, Object o ) {
		indexing.getArguments().accept( this, o );
		indexing.getVariable().accept( valueCgVisitor, o );
		generator.push( indexing.getType().getNumberOfBytes() );
		generator.mul( IntType.getInstance() );
		generator.add( IntType.getInstance() );
		return null;
	}

}
