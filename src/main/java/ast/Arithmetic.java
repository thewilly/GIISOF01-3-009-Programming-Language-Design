/*
 * This source file is part of the p--compiler open source project.
 *
 * Copyright (c) 2018 willy and the lab01 project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package ast;

/**
 * Instance of Arithmetic expression, defined by an expression, am arithmetic
 * operator and another expression.
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802112314
 */
public class Arithmetic implements Expression {

	private Expression left, right;
	private int line = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
	private String arithmeticOperator = "";

	/**
	 * Allocates an arithmetic object and initializes it so that it represents
	 * and arithmetic expression composed by Arithmetic operator Arithmetic.
	 * 
	 * @param line is the line of the expression.
	 * @param column is the column of the expression.
	 * @param left is the left side of the operation.
	 * @param arithmeticOperator string representing the arithmetic operator for the expression.
	 * @param right
	 */
	public Arithmetic( int line, int column, Arithmetic left, String arithmeticOperator,
			Arithmetic right ) {
		this.line = line;
		this.column = column;
		this.left = left;
		this.arithmeticOperator = arithmeticOperator;
		this.right = right;
	}

	/**
	 * Allocates an arithmetic object and initializes it so that it represents
	 * and arithmetic expression composed by Arithmetic operator Variable.
	 * 
	 * @param line of the expression.
	 * @param column of the expression.
	 * @param left side of the expression.
	 * @param arithmeticOperator string representing the arithmetic operator for the expression.
	 * @param right side of the expression.
	 */
	public Arithmetic( int line, int column, Arithmetic left, String arithmeticOperator, Variable right ) {
		this.line = line;
		this.column = column;
		this.left = left;
		this.arithmeticOperator = arithmeticOperator;
		this.right = right;
	}

	/**
	 * Allocates an arithmetic object and initializes it so that it represents
	 * and arithmetic expression composed by UnaryMinus operator IntLiteral.
	 * 
	 * @param line of the expression.
	 * @param column of the expression.
	 * @param left side of the expression.
	 * @param arithmeticOperator string representing the arithmetic operator for the expression.
	 * @param right side of the expression.
	 */
	public Arithmetic( int line, int column, UnaryMinus left, String arithmeticOperator, IntLiteral right ) {
		this.line = line;
		this.column = column;
		this.left = left;
		this.arithmeticOperator = arithmeticOperator;
		this.right = right;
	}

	/**
	 * Allocates an arithmetic object and initializes it so that it represents
	 * and arithmetic expression composed by IntLiteral operator Variable.
	 * 
	 * @param line of the expression.
	 * @param column of the expression.
	 * @param left side of the expression.
	 * @param arithmeticOperator string representing the arithmetic operator for the expression.
	 * @param right side of the expression.
	 */
	public Arithmetic( int line, int column, IntLiteral left, String arithmeticOperator, Variable right ) {
		this.line = line;
		this.column = column;
		this.left = left;
		this.arithmeticOperator = arithmeticOperator;
		this.right = right;
	}

	@Override public int getLine() {
		return this.line;
	}

	@Override public int getColumn() {
		return this.column;
	}

	@Override public String toString() {
		return left.toString() + arithmeticOperator + right.toString();
	}

}
