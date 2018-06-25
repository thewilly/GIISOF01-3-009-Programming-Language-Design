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
package ast.literals;

import ast.ASTNode;
import ast.expressions.AbstractExpression;
import visitor.Visitor;

/**
 * Represents an integer literal value in the AST tree.
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802112344
 */
public class IntLiteral extends AbstractExpression implements Literal<Integer> {

	/** The value. */
	private int line = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN, value;

	/**
	 * Allocates an integer literal object and initializes it.
	 * 
	 * @param line where the int literal is.
	 * @param column where the int literal is.
	 * @param value of the int literal.
	 */
	public IntLiteral( int line, int column, int value ) {
		this.line = line;
		this.column = column;
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see ast.literals.Literal#getValue()
	 */
	@Override
	public Integer getValue() {
		return this.value;
	}

	/* (non-Javadoc)
	 * @see ast.literals.Literal#setValue(java.lang.Object)
	 */
	@Override
	public void setValue( Integer value ) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#getLine()
	 */
	@Override
	public int getLine() {
		return this.line;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#getColumn()
	 */
	@Override
	public int getColumn() {
		return this.column;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Integer.toString( this.value );
	}

	/*
	 * (non-Javadoc)
	 * @see ast.ASTNode#accept(ast.Visitor, java.lang.Object)
	 */
	@Override
	public <P, R> R accept( Visitor<P, R> visitor, P param ) {
		return visitor.visit( this, param );
	}

}
