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

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import ast.types.ErrorType;

/**
 * Instance of EH.java
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802051217
 */
public class EH {

	private List<ErrorType> errors = new ArrayList<ErrorType>();
	private static EH instance;

	public static EH getInstance() {
		if (instance == null) {
			return instance = new EH();
		}
		return instance;
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public void addError( ErrorType error ) {
		errors.add( error );
	}

	public void showErrors( PrintStream stream ) {
		for (ErrorType error : errors) {
			stream.println( "EERROR : At " + error.getLine() + ", " + error.getColumn() + ". "
					+ error.getMessage() );
		}
	}
}
