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
 * Instance of the read statement.
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802112355
 */
public class Read implements Statement {

    private int line = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
    private Expression expression;

    /**
     * Allocates a Read object and initializes.
     * 
     * @param line
     *            where the read statement is.
     * @param column
     *            where the read statement is.
     * @param expression
     *            to read.
     */
    public Read(int line, int column, Expression expression) {
	this.line = line;
	this.column = column;
	this.expression = expression;
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
	return "input " + this.expression.toString();
    }

}
