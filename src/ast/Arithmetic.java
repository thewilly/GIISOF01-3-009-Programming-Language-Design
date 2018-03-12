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
 * Instance of Arithmetic expression, defined by an expression, am arithmetic
 * operator and another expression.
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802112314
 */
public class Arithmetic extends AbstractExpression {

    private Expression left, right;
    private int line = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
    private String operator = "";

    /**
     * Allocates an arithmetic object and initializes it so that it represents and
     * arithmetic expression composed by Arithmetic operator Arithmetic.
     * 
     * @param line
     *            is the line of the expression.
     * @param column
     *            is the column of the expression.
     * @param left
     *            is the left side of the operation.
     * @param operator
     *            string representing the arithmetic operator for the expression.
     * @param right
     */
    public Arithmetic(int line, int column, Expression left, String operator, Expression right) {
	this.line = line;
	this.column = column;
	this.left = left;
	this.operator = operator;
	this.right = right;
    }

    @Override
    public int getLine() {
	return this.line;
    }

    @Override
    public int getColumn() {
	return this.column;
    }

    /**
     * @return the left
     */
    public Expression getLeft() {
	return left;
    }

    /**
     * @param left
     *            the left to set
     */
    public void setLeft(Expression left) {
	this.left = left;
    }

    /**
     * @return the right
     */
    public Expression getRight() {
	return right;
    }

    /**
     * @param right
     *            the right to set
     */
    public void setRight(Expression right) {
	this.right = right;
    }

    @Override
    public String toString() {
	return left.toString() + operator + right.toString();
    }

    /* (non-Javadoc)
     * @see ast.ASTNode#accept(ast.Visitor, java.lang.Object)
     */
    @Override
    public <P, R> R accept(Visitor<P, R> visitor, P param) {
	return visitor.visit(this, param);
    }

}
