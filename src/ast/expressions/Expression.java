/*
 * This source file is part of the p--compiler open source project.
 *
 * Copyright (c) 2018 willy and the lab01 project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package ast.expressions;

import ast.ASTNode;
import ast.types.Type;

/**
 * Instance of Espression, represents only those nodes of the AST tree that are
 * expressions.
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802112343
 */
public interface Expression extends ASTNode {

	public boolean getLValue();

	public void setLValue( boolean lValue );

	Type getType();

	void setType( Type type );

}
