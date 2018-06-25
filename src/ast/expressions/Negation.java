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
 * The Class Negation.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class Negation extends AbstractExpression {

	/** The column. */
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	/** The expresion. */
	private Expression expresion;

	/**
	 * Instantiates a new negation.
	 *
	 * @param row the row
	 * @param column the column
	 * @param expresion the expresion
	 */
	public Negation( int row, int column, Expression expresion ) {
		this.row = row;
		this.column = column;
		this.expresion = expresion;
	}

	/**
	 * Gets the operand.
	 *
	 * @return the operand
	 */
	public Expression getOperand() {
		return expresion;
	}

	/**
	 * Sets the operand.
	 *
	 * @param operand the operand to set
	 */
	public void setOperand( Expression operand ) {
		this.expresion = operand;
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
		return "!" + this.expresion.toString();
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
