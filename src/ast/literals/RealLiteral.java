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
 * The Class RealLiteral.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class RealLiteral extends AbstractExpression implements Literal<Double> {

	/** The column. */
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	/** The value. */
	private double value;

	/**
	 * Instantiates a new real literal.
	 *
	 * @param i the i
	 * @param j the j
	 * @param value the value
	 */
	public RealLiteral( int i, int j, double value ) {
		this.row = i;
		this.column = j;
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@Override
	public Double getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the value to set
	 */
	@Override
	public void setValue( Double value ) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#getLine()
	 */
	@Override
	public int getLine() {
		return this.row;
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
		return Double.toString( value );
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
