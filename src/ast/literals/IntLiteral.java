/*
 * This source file is part of the p--compiler open source project.
 *
 * Copyright (c) 2018 willy and the lab01 project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package ast.literals;

import ast.ASTNode;
import ast.expressions.AbstractExpression;
import visitor.Visitor;

/**
 * Represents an integer literal value in the AST tree.
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802112344
 */
public class IntLiteral extends AbstractExpression implements Literal<Integer> {

	private int line = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN, value;

	/**
	 * Allocates an integer literal object and initializes it.
	 * 
	 * @param line where the int literal is.
	 * @param column where the int literal is.
	 * @param value of the int literal.
	 */
	public IntLiteral( int line, int column, int value ) {
		this.line = line;
		this.column = column;
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return this.value;
	}

	@Override
	public void setValue( Integer value ) {
		this.value = value;
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
		return Integer.toString( this.value );
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
