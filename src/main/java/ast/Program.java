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

import java.util.List;

/**
 * A program represents a list of statements in the AST tree.
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802112346
 */
public class Program implements ASTNode, Statement {

    private int line = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
    @SuppressWarnings("unused")
    private List<Statement> statements;

    /**
     * Allocates a Program object and initializes it.
     * 
     * @param line
     *            where the program statement is.
     * @param column
     *            where the program statement is.
     * @param statements
     *            is the list of statements.
     */
    public Program(int line, int column, List<Statement> statements) {
	this.line = line;
	this.column = column;
	this.statements = statements;
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
	return "Program";
    }

}
