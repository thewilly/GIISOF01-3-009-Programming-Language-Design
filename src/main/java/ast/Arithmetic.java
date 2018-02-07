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
 * Instance of Arithmetic.java
 * 
 * @author
 * @version
 */
public class Arithmetic implements Expression {

	private Expression left, right;
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
	private String arithmeticOperator = "";

	/**
	 * Allocates a [] object and initializes it so that it represents
	 * 
	 * @param i
	 * @param j
	 * @param arithmetic
	 * @param string
	 * @param arithmetic2
	 */
	public Arithmetic( int i, int j, Arithmetic arithmetic, String string,
			Arithmetic arithmetic2 ) {
		this.row = i;
		this.column = j;
		this.left = arithmetic;
		this.arithmeticOperator = string;
		this.right = arithmetic2;
	}

	/**
	 * Allocates a [] object and initializes it so that it represents
	 * 
	 * @param i
	 * @param j
	 * @param arithmetic
	 * @param string
	 * @param variable
	 */
	public Arithmetic( int i, int j, Arithmetic arithmetic, String string, Variable variable ) {
		this.row = i;
		this.column = j;
		this.left = arithmetic;
		this.arithmeticOperator = string;
		this.right = variable;
	}

	/**
	 * Allocates a [] object and initializes it so that it represents
	 * 
	 * @param i
	 * @param j
	 * @param unaryMinus
	 * @param string
	 * @param intLiteral
	 */
	public Arithmetic( int i, int j, UnaryMinus unaryMinus, String string, IntLiteral intLiteral ) {
		this.row = i;
		this.column = j;
		this.left = unaryMinus;
		this.arithmeticOperator = string;
		this.right = intLiteral;
	}

	/**
	 * Allocates a [] object and initializes it so that it represents
	 * 
	 * @param i
	 * @param j
	 * @param intLiteral
	 * @param string
	 * @param variable
	 */
	public Arithmetic( int i, int j, IntLiteral intLiteral, String string, Variable variable ) {
		this.row = i;
		this.column = j;
		this.left = intLiteral;
		this.arithmeticOperator = string;
		this.right = variable;
	}

	@Override public int getLine() {
		return this.row;
	}

	@Override public int getColumn() {
		return this.column;
	}

	public String toString() {
		return left.toString() + arithmeticOperator + right.toString();
	}

}
