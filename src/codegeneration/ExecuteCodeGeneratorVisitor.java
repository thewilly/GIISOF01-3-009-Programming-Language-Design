/*
 * This source file is part of the PmmCompiler open source project.
 *
 * Copyright (c) 2018 willy and the PmmCompiler project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package codegeneration;

import ast.Definition;
import ast.FuncDefinition;
import ast.Program;
import ast.VarDefinition;
import ast.Write;

/**
 * Instance of ExecuteCodeGeneratorVisitor.java
 * 
 * @author
 * @version
 */
public class ExecuteCodeGeneratorVisitor extends CodeGeneratorVisitor {

	/**
	 * Allocates a [] object and initializes it so that it represents
	 * 
	 * @param generator
	 */
	public ExecuteCodeGeneratorVisitor( CodeGenerator generator ) {
		super( generator );
	}

	@Override
	public Object visit( Program program, Object param ) {

		for (Definition definition : program.getDefinitions()) {
			if (definition instanceof VarDefinition) {
				definition.accept( this, param );
			}
		}
		
		// Call the main and the halt.
		super.generator.call( "main" );
		super.generator.halt();
		
		for (Definition definition : program.getDefinitions()) {
			if (definition instanceof FuncDefinition) {
				definition.accept( this, param );
			}
		}

		return null;
	}

	@Override
	public Object visit( Write write, Object param ) {
		
		return null;
	}
}
