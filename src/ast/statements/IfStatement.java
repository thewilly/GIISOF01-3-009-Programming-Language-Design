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
 * The Class IfStatement.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class IfStatement implements Statement {

	/** The column. */
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	/** The else body. */
	private List<Statement> ifBody, elseBody;

	/** The condition. */
	private Expression condition;

	/** The else body returs. */
	private boolean ifBodyReturns = false, elseBodyReturs = false;

	/**
	 * Instantiates a new if statement.
	 *
	 * @param row the row
	 * @param column the column
	 * @param ifBody the if body
	 * @param elseBody the else body
	 * @param condition the condition
	 */
	public IfStatement( int row, int column, List<Statement> ifBody, List<Statement> elseBody,
			Expression condition ) {
		this.row = row;
		this.column = column;
		this.ifBody = ifBody;
		this.elseBody = elseBody;
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
	 * Gets the if body.
	 *
	 * @return the if body
	 */
	public List<Statement> getIfBody() {
		return ifBody;
	}

	/**
	 * Sets the if body.
	 *
	 * @param ifBody the new if body
	 */
	public void setIfBody( List<Statement> ifBody ) {
		this.ifBody = ifBody;
	}

	/**
	 * Gets the else body.
	 *
	 * @return the else body
	 */
	public List<Statement> getElseBody() {
		return elseBody;
	}

	/**
	 * Sets the else body.
	 *
	 * @param elseBody the new else body
	 */
	public void setElseBody( List<Statement> elseBody ) {
		this.elseBody = elseBody;
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
	 * Checks if is if body returns.
	 *
	 * @return true, if is if body returns
	 */
	public boolean isIfBodyReturns() {
		return ifBodyReturns;
	}

	/**
	 * Sets the if body returns.
	 *
	 * @param ifBodyReturns the new if body returns
	 */
	public void setIfBodyReturns( boolean ifBodyReturns ) {
		this.ifBodyReturns = ifBodyReturns;
	}

	/**
	 * Checks if is else body returns.
	 *
	 * @return true, if is else body returns
	 */
	public boolean isElseBodyReturns() {
		return elseBodyReturs;
	}

	/**
	 * Sets the else body returs.
	 *
	 * @param elseBodyReturs the new else body returs
	 */
	public void setElseBodyReturs( boolean elseBodyReturs ) {
		this.elseBodyReturs = elseBodyReturs;
	}

	/* (non-Javadoc)
	 * @see ast.statements.Statement#promotesToReturn()
	 */
	@Override
	public boolean promotesToReturn() {
		return ifBodyReturns && elseBodyReturs;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder ifStatement = new StringBuilder();
		ifStatement.append( "if " + this.condition.toString() + ":" );
		for (Statement statement : this.getIfBody()) {
			ifStatement.append( "\n \t" + statement.toString() );
		}

		if (elseBody != null && !elseBody.isEmpty()) {
			ifStatement.append( "\n else :" );
			for (Statement statement : this.getElseBody()) {
				ifStatement.append( "\n \t" + statement.toString() );
			}
		}
		return ifStatement.toString();
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
