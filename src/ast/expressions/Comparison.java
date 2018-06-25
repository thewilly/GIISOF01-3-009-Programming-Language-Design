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
package ast.expressions;

import ast.ASTNode;
import ast.statements.Statement;
import visitor.Visitor;

/**
 * The Class Comparison.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class Comparison extends AbstractExpression implements Statement {

	/** The column. */
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	/** The right. */
	private Expression left, right;
	
	/** The comparator. */
	private String comparator;

	/**
	 * Instantiates a new comparison.
	 *
	 * @param i the i
	 * @param j the j
	 * @param left the left
	 * @param comparator the comparator
	 * @param right the right
	 */
	public Comparison( int i, int j, Expression left, String comparator, Expression right ) {
		this.row = i;
		this.column = j;
		this.left = left;
		this.comparator = comparator;
		this.right = right;
	}

	/**
	 * Gets the left.
	 *
	 * @return the left
	 */
	public Expression getLeft() {
		return left;
	}

	/**
	 * Sets the left.
	 *
	 * @param left the left to set
	 */
	public void setLeft( Expression left ) {
		this.left = left;
	}

	/**
	 * Gets the right.
	 *
	 * @return the right
	 */
	public Expression getRight() {
		return right;
	}

	/**
	 * Sets the right.
	 *
	 * @param right the right to set
	 */
	public void setRight( Expression right ) {
		this.right = right;
	}

	/**
	 * Gets the comparator.
	 *
	 * @return the comparator
	 */
	public String getComparator() {
		return comparator;
	}

	/**
	 * Sets the comparator.
	 *
	 * @param comparator the new comparator
	 */
	public void setComparator( String comparator ) {
		this.comparator = comparator;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#getLine()
	 */
	@Override
	public int getLine() {
		return column;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#getColumn()
	 */
	@Override
	public int getColumn() {
		return row;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.left.toString() + this.comparator + this.right.toString();
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
