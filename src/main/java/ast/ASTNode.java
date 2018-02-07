/*
 * This source file is part of the lab01 open source project.
 *
 * Copyright (c) 2018 willy and the lab01 project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package ast;

/**
 * Instance of ASTNode.java
 * 
 * @author
 * @version
 */
public interface ASTNode {

	public final static int DEFAULT_ROW_COLUMN = -1;

	/**
	 * 
	 * @return
	 */
	public int getLine();

	/**
	 * 
	 * @return
	 */
	public int getColumn();

}
