/*
 * This source file is part of the p--compiler open source project.
 *
 * Copyright (c) 2018 willy and the lab01 project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package ast.statements;

import ast.ASTNode;

/**
 * Statement interface to represent those nodes form the AST tree that are
 * statements.
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802112358
 */
public interface Statement extends ASTNode {

	public default boolean promotesToReturn() {
		return false;
	}
}
