/*
 * This source file is part of the PmmCompiler open source project.
 *
 * Copyright (c) 2018 willy and the PmmCompiler project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
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

	private int line = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
	private static final int NUMBER_OF_BYTES = 0;

	private ASTNode node;
	private String message;

	public ErrorType( ASTNode node, String message ) {
		this.node = node;
		this.message = message;
		EH.getInstance().addError( this );
	}

	public ErrorType( int row, int column, String message ) {
		this.line = row;
		this.column = column;
		this.message = message;
		EH.getInstance().addError( this );
	}

	public ASTNode getNode() {
		return this.node;
	}

	public void setNode( ASTNode node ) {
		this.node = node;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage( String message ) {
		this.message = message;
	}

	/**
	 * @see ast.ASTNode#getLine()
	 */
	@Override
	public int getLine() {
		if (node == null)
			return this.line;
		return node.getLine();
	}

	/**
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

	@Override
	public int getNumberOfBytes() {
		return NUMBER_OF_BYTES;
	}

}
