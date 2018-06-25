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

import ast.expressions.Expression;
import visitor.Visitor;

/**
 * The Class DoWhileStatement.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class DoWhileStatement extends WhileStatement {

	/**
	 * Instantiates a new do while statement.
	 *
	 * @param row the row
	 * @param column the column
	 * @param body the body
	 * @param condition the condition
	 */
	public DoWhileStatement( int row, int column, List<Statement> body, Expression condition ) {
		super( row, column, body, condition );
	}
	
	/* (non-Javadoc)
	 * @see ast.statements.WhileStatement#toString()
	 */
	@Override
	public String toString() {
		StringBuilder whileStmt = new StringBuilder();

		whileStmt.append( "do : {" );
		for (Statement s : this.getBody()) {
			whileStmt.append( "\n \t" + s.toString() );
		}
		whileStmt.append( "\n} while " + super.getCondition() );

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
