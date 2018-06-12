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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import ast.Type;

/**
 * Instance of CodeGenerator.java
 * 
 * @author
 * @version
 */
public class CodeGenerator {

	private PrintWriter writter;
	private int labelCounter;

	public CodeGenerator( String inputFileName, String outputFileName ) {

		try {
			writter = new PrintWriter( new File( outputFileName ) );
			labelCounter = 0;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public void halt() {
		writter.println( "\tHALT" );
		writter.flush();
	}
	
	public void call(String tag) {
		writter.println("\tCALL " + tag);
		writter.flush();

	}
	
	public void out(Type type) {
		writter.println( "\tOUT" + type.subfix());
	}
}
