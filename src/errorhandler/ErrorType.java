/*
 * This source file is part of the PmmCompiler open source project.
 *
 * Copyright (c) 2018 willy and the PmmCompiler project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package errorhandler;

import ast.ASTNode;
import ast.Type;

/**
 * Instance of ErrorType.java
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802051202
 */
public class ErrorType implements Type {

    private int line = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
    private ASTNode node;
    private String message;
    
    public ErrorType(ASTNode node, String message) {
	this.node = node;
	this.message = message;
    }
    
    public ErrorType(int row, int column, String message) {
	this.line = row;
	this.column = column;
	this.message = message;
    }
    
    public ASTNode getNode() {
	return this.node;
    }
    
    public void setNode(ASTNode node) {
	this.node = node;
    }
    
    public String getMessage() {
	return this.message;
    }
    
    public void setMessage(String message) {
	this.message = message;
    }
    
    /**
     * @see ast.ASTNode#getLine()
     */
    @Override
    public int getLine() {
	if(node==null)
	    return this.line;
	return node.getLine();
    }

    /**
     * @see ast.ASTNode#getColumn()
     */
    @Override
    public int getColumn() {
	if(node==null)
	    return this.column;
	return node.getColumn();
    }

}
