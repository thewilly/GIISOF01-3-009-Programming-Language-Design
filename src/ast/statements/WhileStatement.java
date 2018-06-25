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

import java.util.List;

import ast.ASTNode;
import ast.expressions.Expression;
import visitor.Visitor;

/**
 * The Class WhileStatement.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class WhileStatement implements Statement {

	/** The column. */
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	/** The body. */
	private List<Statement> body;
	
	/** The condition. */
	private Expression condition;

	/**
	 * Instantiates a new while statement.
	 *
	 * @param row the row
	 * @param column the column
	 * @param body the body
	 * @param condition the condition
	 */
	public WhileStatement( int row, int column, List<Statement> body, Expression condition ) {
		super();
		this.row = row;
		this.column = column;
		this.body = body;
		this.condition = condition;
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
	 * Gets the body.
	 *
	 * @return the body
	 */
	public List<Statement> getBody() {
		return body;
	}

	/**
	 * Sets the body.
	 *
	 * @param body the new body
	 */
	public void setBody( List<Statement> body ) {
		this.body = body;
	}

	/**
	 * Gets the condition.
	 *
	 * @return the condition
	 */
	public Expression getCondition() {
		return condition;
	}

	/**
	 * Sets the condition.
	 *
	 * @param condition the new condition
	 */
	public void setCondition( Expression condition ) {
		this.condition = condition;
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
		StringBuilder whileStmt = new StringBuilder();

		whileStmt.append( "while " + this.condition + ":" );
		for (Statement s : this.getBody()) {
			whileStmt.append( "\n \t" + s.toString() );
		}
		whileStmt.append( "\n}" );

		return whileStmt.toString();
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
