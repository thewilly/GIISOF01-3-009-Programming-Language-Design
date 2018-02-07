/*
 * This source file is part of the lab01 open source project.
 *
 * Copyright (c) 2018 willy and the lab01 project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package ast;

/**
 * Instance of IntLiteral.java
 * 
 * @author
 * @version
 */
public class IntLiteral implements Expression {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN, value;

	/**
	 * Allocates a [] object and initializes it so that it represents
	 * 
	 * @param i
	 * @param j
	 * @param k
	 */
	public IntLiteral( int i, int j, int k ) {
		this.row = i;
		this.column = j;
		this.value = k;
	}

	@Override public int getLine() {
		return this.row;
	}

	@Override public int getColumn() {
		return this.column;
	}
	
	public String toString() {
		return Integer.toString( this.value );
	}

}
