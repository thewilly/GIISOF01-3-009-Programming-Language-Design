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
package ast.statements;

import ast.ASTNode;
import ast.expressions.Expression;
import visitor.Visitor;

/**
 * The Class Return.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class Return implements Statement {

	/** The column. */
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	/** The expression. */
	private Expression expression;

	/**
	 * Instantiates a new return.
	 *
	 * @param row the row
	 * @param column the column
	 * @param expression the expression
	 */
	public Return( int row, int column, Expression expression ) {
		this.row = row;
		this.column = column;
		this.expression = expression;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#getLine()
	 */
	@Override
	public int getLine() {
		return row;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#getColumn()
	 */
	@Override
	public int getColumn() {
		return column;
	}

	/**
	 * Gets the row.
	 *
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Sets the row.
	 *
	 * @param row the new row
	 */
	public void setRow( int row ) {
		this.row = row;
	}

	/**
	 * Gets the expression.
	 *
	 * @return the expression
	 */
	public Expression getExpression() {
		return expression;
	}

	/**
	 * Sets the expression.
	 *
	 * @param expression the new expression
	 */
	public void setExpression( Expression expression ) {
		this.expression = expression;
	}

	/**
	 * Sets the column.
	 *
	 * @param column the new column
	 */
	public void setColumn( int column ) {
		this.column = column;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "return " + this.expression.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see ast.ASTNode#accept(ast.Visitor, java.lang.Object)
	 */
	@Override
	public <P, R> R accept( Visitor<P, R> visitor, P param ) {
		return visitor.visit( this, param );
	}

	/* (non-Javadoc)
	 * @see ast.statements.Statement#promotesToReturn()
	 */
	@Override
	public boolean promotesToReturn() {
		return true;
	}
}
