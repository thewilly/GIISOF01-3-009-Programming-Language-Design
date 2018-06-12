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

import visitor.Visitor;

/**
 * Instance of the Variable type.
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802120001
 */
public class Variable extends AbstractExpression {

	private int line = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
	private String name;
	private Definition definition;

	/**
	 * Allocates a variable object and initializes it.
	 * 
	 * @param line where the variable is.
	 * @param column where the variable is.
	 * @param name that represents the lexeme of the variable.
	 */
	public Variable( int line, int column, String name ) {
		this.line = line;
		this.column = column;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Definition getDefinition() {
		return this.definition;
	}

	public void setDefinition( Definition definition ) {
		this.definition = definition;
	}

	@Override
	public int getLine() {
		return this.line;
	}

	@Override
	public int getColumn() {
		return this.column;
	}

	@Override
	public String toString() {
		return this.name;
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
