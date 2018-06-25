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
import visitor.Visitor;

/**
 * Instance of Arithmetic expression, defined by an expression, am arithmetic
 * operator and another expression.
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802112314
 */
public class Arithmetic extends AbstractExpression {

	/** The right. */
	private Expression left, right;
	
	/** The column. */
	private int line = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
	
	/** The operator. */
	private String operator = "";

	/**
	 * Allocates an arithmetic object and initializes it so that it represents
	 * and arithmetic expression composed by Arithmetic operator Arithmetic.
	 *
	 * @param line is the line of the expression.
	 * @param column is the column of the expression.
	 * @param left is the left side of the operation.
	 * @param operator string representing the arithmetic operator for the
	 *            expression.
	 * @param right the right
	 */
	public Arithmetic( int line, int column, Expression left, String operator, Expression right ) {
		this.line = line;
		this.column = column;
		this.left = left;
		this.operator = operator;
		this.right = right;
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
	 * Gets the operator.
	 *
	 * @return the operator
	 */
	public String getOperator() {
		return this.operator;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return left.toString() + operator + right.toString();
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
