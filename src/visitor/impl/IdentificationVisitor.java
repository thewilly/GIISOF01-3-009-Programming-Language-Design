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

import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Variable;
import ast.statements.Statement;
import ast.types.ErrorType;
import symboltable.SymbolTable;
import visitor.AbstractVisitor;

/**
 * Instance of IdentificationVisitor.java
 * 
 * @author
 * @version
 */
public class IdentificationVisitor extends AbstractVisitor<Object, Object> {

	SymbolTable st = new SymbolTable();

	@Override
	public Object visit( Variable variable, Object param ) {

		variable.setDefinition(
				st.find( variable.getName() ) );
		if (variable.getDefinition() == null)
			variable.setDefinition( new VarDefinition( variable.getLine(), variable.getColumn(),
					variable.getName(), new ErrorType( variable,
							"No variable definition found for: " + variable.getName() ) ) );

		return null;
	}

	@Override
	public Object visit( FuncDefinition funcDefinition, Object param ) {

		if (!st.insert( funcDefinition ))
			new ErrorType( funcDefinition,
					"Duplicate function definition for: " + funcDefinition.getName() );

		st.set();
		funcDefinition.getType().accept( this, param );
		for (Statement statement : funcDefinition.getStatements()) {
			statement.accept( this, param );
		}
		st.reset();

		return null;
	}

	@Override
	public Object visit( VarDefinition varDefinition, Object param ) {

		if (!st.insert( varDefinition ))
			new ErrorType( varDefinition,
					"Duplicate variable definition for: " + varDefinition.getName() );
		varDefinition.getType().accept( this, param );
		return null;
	}

}
