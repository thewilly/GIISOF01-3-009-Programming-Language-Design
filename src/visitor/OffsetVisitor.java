/*
 * This source file is part of the PmmCompiler open source project.
 *
 * Copyright (c) 2018 willy and the PmmCompiler project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package visitor;

import ast.FuncDefinition;
import ast.Statement;
import ast.VarDefinition;
import ast.type.FunctionType;

/**
 * Instance of OffsetVisitor.java
 * 
 * @author
 * @version
 * @param <P>
 */
public class OffsetVisitor extends AbstractVisitor<Object, Object> {

	private int globalOffSet = 0;
	private int paramOffSet = 4;
	private int localOffSet = 0;

	@Override
	public Object visit( VarDefinition varDefinition, Object param ) {
		if (varDefinition.getScope() == 0) {
			varDefinition.setOffset( globalOffSet );
			globalOffSet += varDefinition.getType().getNumberOfBytes();
		} else {

			if ((boolean) param) {
				varDefinition.setOffset( paramOffSet );
				paramOffSet += varDefinition.getType().getNumberOfBytes();
			} else {
				localOffSet -= varDefinition.getType().getNumberOfBytes();
				varDefinition.setOffset( localOffSet );
			}
		}
		System.out.println(
				"Nombre: " + varDefinition.getName() + " OffSet: " + varDefinition.getOffset() );
		return null;
	}

	@Override
	public Object visit( FuncDefinition funDefinition, Object param ) {
		funDefinition.getType().accept( this, param );
		if (funDefinition.getStatements() != null) {
			for (Statement statement : funDefinition.getStatements()) {
				statement.accept( this, false );
			}
		}
		this.localOffSet = 0;
		this.paramOffSet = 4;
		return null;

	}

	@Override
	public Object visit( FunctionType functionType, Object param ) {
		functionType.getReturnType().accept( this, param );
		for (int i = functionType.getParameters().size() - 1; i >= 0; i--) {
			functionType.getParameters().get( i ).accept( this, true );
		}
		return null;
	}

}
