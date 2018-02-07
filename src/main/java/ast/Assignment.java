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
 * Instance of Assignment.java
 * 
 * @author
 * @version
 */
public class Assignment implements Statement {

	private Expression left, right;
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	/**
	 * Allocates a [] object and initializes it so that it represents
	 * 
	 * @param i
	 * @param j
	 * @param variable
	 * @param arithmetic
	 */
	public Assignment( int i, int j, Variable variable, Arithmetic arithmetic ) {
		this.row = i;
		this.column = j;
		this.left = variable;
		this.right = arithmetic;
	}

	@Override public int getLine() {
		return this.row;
	}

	@Override public int getColumn() {
		return this.column;
	}

	public String toString() {
		return this.left.toString() + "=" + this.right.toString();
	}

}
