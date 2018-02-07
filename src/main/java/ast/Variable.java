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
 * Instance of Variable.java
 * 
 * @author
 * @version
 */
public class Variable implements Expression {
	
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
	private String name;

	/**
	 * Allocates a [] object and initializes it so that it represents
	 * 
	 * @param i
	 * @param j
	 * @param string
	 */
	public Variable( int i, int j, String string ) {
		this.row = i;
		this.column = j;
		this.name = string;
	}

	/*
	 * (non-Javadoc)
	 * @see ast.ASTNode#getLine()
	 */
	@Override public int getLine() {
		return this.row;
	}

	/*
	 * (non-Javadoc)
	 * @see ast.ASTNode#getColumn()
	 */
	@Override public int getColumn() {
		return this.column;
	}
	
	public String toString() {
		return this.name;
	}

}
