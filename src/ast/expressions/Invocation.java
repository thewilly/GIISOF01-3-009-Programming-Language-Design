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

import java.util.List;

import ast.ASTNode;
import ast.statements.Statement;
import visitor.Visitor;

/**
 * The Class Invocation.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class Invocation extends AbstractExpression implements Statement {

	/** The column. */
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
	
	/** The arguments. */
	private List<Expression> arguments;
	
	/** The funcion name. */
	private Variable funcionName;

	/**
	 * Instantiates a new invocation.
	 *
	 * @param row the row
	 * @param column the column
	 * @param funcionName the funcion name
	 * @param arguments the arguments
	 */
	public Invocation( int row, int column, Variable funcionName, List<Expression> arguments ) {
		this.row = row;
		this.column = column;
		this.arguments = arguments;
		this.funcionName = funcionName;
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
	 * Gets the arguments.
	 *
	 * @return the arguments
	 */
	public List<Expression> getArguments() {
		return arguments;
	}

	/**
	 * Sets the arguments.
	 *
	 * @param arguments the new arguments
	 */
	public void setArguments( List<Expression> arguments ) {
		this.arguments = arguments;
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
	 * Gets the funcion.
	 *
	 * @return the funcion
	 */
	public Variable getFuncion() {
		return funcionName;
	}

	/**
	 * Sets the funcion.
	 *
	 * @param funcion the new funcion
	 */
	public void setFuncion( Variable funcion ) {
		this.funcionName = funcion;
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
		StringBuilder invocation = new StringBuilder();
		invocation.append( this.funcionName + "(" );

		for (Expression expression : this.getArguments()) {
			// If its the first expression no comma and space before the
			// expresion.toString().
			if (expression.equals( this.getArguments().get( 0 ) ))
				invocation.append( expression.toString() );
			else
				invocation.append( ", " + expression.toString() );
		}

		invocation.append( " )" );
		return invocation.toString();
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
