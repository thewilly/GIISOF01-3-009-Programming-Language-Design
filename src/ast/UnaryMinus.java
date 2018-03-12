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
 * Instance of UnaryMinus, represents a (-).
 * 
 * @author
 * @version 201802112359
 */
public class UnaryMinus extends AbstractExpression {

    private int line = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
    private Expression expression;

    /**
     * Allocates a UnaryMinus object and initializes it.
     * 
     * @param line
     *            where the unary minus is.
     * @param column
     *            where the unary minus is.
     * @param variable
     *            to apply the unary minus
     */
    public UnaryMinus(int line, int column, Expression variable) {
	this.line = line;
	this.column = column;
	this.expression = variable;

    }
    
    public Expression getExpression() {
	return this.expression;
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
	return "-" + this.expression.toString();
    }

    /* (non-Javadoc)
     * @see ast.ASTNode#accept(ast.Visitor, java.lang.Object)
     */
    @Override
    public <P, R> R accept(Visitor<P, R> visitor, P param) {
	return visitor.visit(this, param);
    }

}
