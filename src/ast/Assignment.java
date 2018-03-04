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
 * Instance of the Assignment statement. It assigns the value of the right node
 * to the left node.
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802112339
 */
public class Assignment implements Statement {

    private Expression left, right;
    private int line = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

    /**
     * Allocates an assignment object and initializes it.
     * 
     * @param line
     *            where the statement is.
     * @param column
     *            where the statement is.
     * @param left
     *            side of the assignment.
     * @param right
     *            side of the assignment.
     */
    public Assignment(int line, int column, Expression left, Expression right) {
	this.line = line;
	this.column = column;
	this.left = left;
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

    @Override
    public String toString() {
	return this.left.toString() + "=" + this.right.toString();
    }

}
