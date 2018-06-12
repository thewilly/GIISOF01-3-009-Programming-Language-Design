/*
 * This source file is part of the PmmCompiler open source project.
 *
 * Copyright (c) 2018 willy and the PmmCompiler project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package visitor.impl;

import ast.FuncDefinition;
import ast.Statement;
import ast.VarDefinition;
import ast.Variable;
import ast.type.ErrorType;
import symboltable.SymbolTable;
import visitor.AbstractVisitor;

/**
 * Instance of IdentificationVisitor.java
 * 
 * @author
 * @version
 */
public class IdentificationVisitor extends AbstractVisitor<Object, Object> {

	@Override
	public Object visit( Variable variable, Object param ) {

		variable.setDefinition(
				SymbolTable.getInstance().find( variable.getName() ) );
		if (variable.getDefinition() == null)
			variable.setDefinition( new VarDefinition( variable.getLine(), variable.getColumn(),
					variable.getName(), new ErrorType( variable,
							"No variable definition found for: " + variable.getName() ) ) );

		return null;
	}

	@Override
	public Object visit( FuncDefinition funcDefinition, Object param ) {

		if (!SymbolTable.getInstance().insert( funcDefinition ))
			new ErrorType( funcDefinition,
					"Duplicate function definition for: " + funcDefinition.getName() );

		SymbolTable.getInstance().set();
		funcDefinition.getType().accept( this, param );
		for (Statement statement : funcDefinition.getStatements()) {
			statement.accept( this, param );
		}
		SymbolTable.getInstance().reset();

		return null;
	}

	@Override
	public Object visit( VarDefinition varDefinition, Object param ) {

		if (!SymbolTable.getInstance().insert( varDefinition ))
			new ErrorType( varDefinition,
					"Duplicate variable definition for: " + varDefinition.getName() );

		return null;
	}

}
