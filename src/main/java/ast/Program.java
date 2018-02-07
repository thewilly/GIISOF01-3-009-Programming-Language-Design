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

import java.util.List;

/**
 * Instance of Program.java
 * 
 * @author
 * @version
 */
public class Program implements ASTNode, Statement {
	
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
	@SuppressWarnings("unused") private List<Statement> statements;

	/**
	 * Allocates a [] object and initializes it so that it represents
	 * 
	 * @param i
	 * @param j
	 * @param statements
	 */
	public Program( int i, int j, List<Statement> statements ) {
		this.row = i;
		this.column = j;
		this.statements = statements;
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
		return "Program";
	}

}
