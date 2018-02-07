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
 * Instance of Read.java
 * 
 * @author
 * @version
 */
public class Read implements Statement {
	
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
	private Expression expression;

	/**
	 * Allocates a [] object and initializes it so that it represents
	 * 
	 * @param i
	 * @param j
	 * @param variable
	 */
	public Read( int i, int j, Variable variable ) {
		this.row = i;
		this.column = j;
		this.expression = variable;
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
		return "input " + this.expression.toString();
	}

}
