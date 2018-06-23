/*
 * This source file is part of the PmmCompiler open source project.
 *
 * Copyright (c) 2018 willy and the PmmCompiler project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package ast.expressions;

import ast.ASTNode;
import visitor.Visitor;

/**
 * Instance of UnaryNot.java
 * 
 * @author
 * @version
 */
public class UnaryNot extends AbstractExpression {

	private Expression expresion;

	private int row = ASTNode.DEFAULT_ROW_COLUMN;
	private int column = ASTNode.DEFAULT_ROW_COLUMN;

	public UnaryNot( int i, int j, Expression expresion ) {
		this.row = i;
		this.column = j;
		this.expresion = expresion;
	}

	/**
	 * @return the operand
	 */
	public Expression getOperand() {
		return expresion;
	}

	/**
	 * @param operand the operand to set
	 */
	public void setOperand( Expression operand ) {
		this.expresion = operand;
	}

	@Override
	public int getLine() {
		return this.row;
	}

	@Override
	public int getColumn() {
		return this.column;
	}

	@Override
	public String toString() {
		return "! " + expresion.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see ast.ASTNode#accept(visitor.Visitor, java.lang.Object)
	 */
	@Override
	public <P, R> R accept( Visitor<P, R> visitor, P param ) {
		return visitor.visit( this, param );
	}

}
