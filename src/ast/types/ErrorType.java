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
package ast.types;

import ast.ASTNode;
import errorhandler.EH;
import visitor.Visitor;

/**
 * Instance of ErrorType.java
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802051202
 */
public class ErrorType extends AbstractType {

	/** The column. */
	private int line = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
	
	/** The Constant NUMBER_OF_BYTES. */
	private static final int NUMBER_OF_BYTES = 0;

	/** The node. */
	private ASTNode node;
	
	/** The message. */
	private String message;

	/**
	 * Instantiates a new error type.
	 *
	 * @param node the node
	 * @param message the message
	 */
	public ErrorType( ASTNode node, String message ) {
		this.node = node;
		this.message = message;
		EH.getInstance().addError( this );
	}

	/**
	 * Instantiates a new error type.
	 *
	 * @param row the row
	 * @param column the column
	 * @param message the message
	 */
	public ErrorType( int row, int column, String message ) {
		this.line = row;
		this.column = column;
		this.message = message;
		EH.getInstance().addError( this );
	}

	/**
	 * Gets the node.
	 *
	 * @return the node
	 */
	public ASTNode getNode() {
		return this.node;
	}

	/**
	 * Sets the node.
	 *
	 * @param node the new node
	 */
	public void setNode( ASTNode node ) {
		this.node = node;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage( String message ) {
		this.message = message;
	}

	/**
	 * Gets the line.
	 *
	 * @return the line
	 * @see ast.ASTNode#getLine()
	 */
	@Override
	public int getLine() {
		if (node == null)
			return this.line;
		return node.getLine();
	}

	/**
	 * Gets the column.
	 *
	 * @return the column
	 * @see ast.ASTNode#getColumn()
	 */
	@Override
	public int getColumn() {
		if (node == null)
			return this.column;
		return node.getColumn();
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
	 * @see ast.types.Type#getNumberOfBytes()
	 */
	@Override
	public int getNumberOfBytes() {
		return NUMBER_OF_BYTES;
	}

}
