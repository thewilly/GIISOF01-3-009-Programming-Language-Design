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

import ast.Definition;
import ast.VarDefinition;
import ast.type.CharType;
import ast.type.IntType;
import ast.type.RealType;
import ast.type.Type;

/**
 * Instance of CodeGenerator.java
 * 
 * @author
 * @version
 */
public class CodeGenerator {

	private PrintWriter writter;
	private int labelCounter;

	public CodeGenerator( String inputFileName, String writterputFileName ) {

		try {
			writter = new PrintWriter( new File( writterputFileName ) );
			labelCounter = 0;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void pushbp() {
		writter.println( "\tPUSH BP" );
		writter.flush();
	}

	public void load( Type type ) {
		writter.println( "\tLOAD" + type.subfix() );
		writter.flush();
	}

	public void pusha( int n ) {
		writter.println( "\tPUSHA " + n );
		writter.flush();
	}

	public void push( int n ) {
		writter.println( "\tPUSHI " + n );
		writter.flush();
	}

	public void push( double n ) {
		writter.println( "\tPUSHF " + n );
		writter.flush();
	}

	public void push( char n ) {
		writter.println( "\tPUSHB " + (int) n );
		writter.flush();
	}

	public void halt() {
		writter.println( "\tHALT" );
		writter.flush();
	}

	public void out( Type type ) {
		writter.println( "\tOUT" + type.subfix() );
		writter.flush();
	}

	public void store( Type type ) {
		writter.println( "\tSTORE" + type.subfix() );
		writter.flush();

	}

	public void call( String nameString ) {
		writter.println( "\tCALL " + nameString );
		writter.flush();

	}

	public void aritmetic( String operator, Type type ) {
		String op = "";
		if (operator.equals( "+" ) || operator.equals( "++" ) || operator.equals( "+=" )) {
			op = "\tADD";
		}

		if (operator.equals( "-" ) || operator.equals( "--" ) || operator.equals( "-=" )) {
			op = "\tSUB";
		}

		if (operator.equals( "*" ) || operator.equals( "*=" )) {
			op = "\tMUL";
		}

		if (operator.equals( "/" ) || operator.equals( "/=" )) {
			op = "\tDIV";
		}

		if (operator.equals( "%" )) {
			op = "\tMOD";
		}

		writter.println( op + "" + type.subfix() );

		writter.flush();
	}

	public void add( Type type ) {
		writter.println( "\tADD" + type.subfix() );
		writter.flush();
	}

	public void sub( Type type ) {
		writter.println( "\tSUB" + type.subfix() );
		writter.flush();
	}

	public void mul( Type type ) {
		writter.println( "\tMUL" + type.subfix() );
		writter.flush();
	}

	public void div( Type type ) {
		writter.println( "\tDIV" + type.subfix() );
		writter.flush();
	}

	public void jz( int label ) {
		writter.println( "\tJZ Label" + label );
		writter.flush();
	}

	public void jmp( int label ) {
		writter.println( "\tJMP Label" + label );
		writter.flush();
	}

	public void jnz( int label ) {
		writter.println( "\tJNZ Label" + label );
		writter.flush();
	}

	public void etiqueta( String name ) {
		writter.println( " " + name + ":" );
		writter.flush();

	}

	public void enter( int locals ) {
		writter.println( "\tenter " + locals );
		writter.flush();
	}

	public void ret( int ret, int locals, int params ) {
		writter.println( "\tret " + ret + "," + locals + "," + params );
		writter.flush();

	}

	public void in( Type type ) {
		writter.println( "\tIN" + type.subfix() );
		writter.flush();
	}

	public void b2i() {
		writter.println( "\tB2I" );
		writter.flush();
	}

	public void i2f() {
		writter.println( "\tI2F" );
		writter.flush();
	}

	public void f2i() {
		writter.println( "\tF2I" );
		writter.flush();
	}

	public void i2b() {
		writter.println( "\tI2B" );
		writter.flush();
	}

	public void cast( Type type, Type castType ) {
		if (type.equals( CharType.getInstance() ) && castType.equals( IntType.getInstance() )) {
			b2i();
		}

		if (type.equals( IntType.getInstance() ) && castType.equals( RealType.getInstance() )) {
			i2f();
		}

		if (type.equals( RealType.getInstance() ) && castType.equals( IntType.getInstance() )) {
			f2i();
		}

		if (type.equals( IntType.getInstance() ) && castType.equals( CharType.getInstance() )) {
			i2b();
		}

		if (type.equals( CharType.getInstance() ) && castType.equals( RealType.getInstance() )) {
			b2i();
			i2f();
		}

		if (type.equals( RealType.getInstance() ) && castType.equals( CharType.getInstance() )) {
			f2i();
			i2b();
		}

	}

	public void logic( String logicalOperator ) {
		String op = "";
		if (logicalOperator.equals( "&&" )) {
			op = "\tAND";
		}

		if (logicalOperator.equals( "||" )) {
			op = "\tOR";
		}

		writter.println( op );
		writter.flush();

	}

	public void comparison( String comparator, Type type ) {
		String op = "";
		if (comparator.equals( ">" )) {
			op = "\tGT";
		}

		if (comparator.equals( "<" )) {
			op = "\tLT";
		}

		if (comparator.equals( ">=" )) {
			op = "\tGE";
		}

		if (comparator.equals( "<=" )) {
			op = "\tLE";
		}

		if (comparator.equals( "==" )) {
			op = "\tEQ";
		}

		if (comparator.equals( "!=" )) {
			op = "\tNE";
		}

		writter.println( op + "" + type.subfix() );
		writter.flush();
	}

	public void not() {
		writter.println( "\tNOT" );
		writter.flush();

	}

	public void label( int num ) {
		writter.println( "Label" + num + ":" );
		writter.flush();
	}

	public int getLabels( int i ) {
		labelCounter += i;
		return labelCounter - i;
	}

	public void pop( char subfix ) {
		writter.println( "\tPOP" + subfix );
		writter.flush();
	}

	public void convert( Type t1, Type t2 ) {
		switch (t1.subfix()) {
			case 'I':
				if (t2.subfix() == 'B') {
					i2b();
				} else if (t2.subfix() == 'F') {
					i2f();
				}
				break;
			case 'B':
				if (t2.subfix() == 'F') {
					b2i();
					i2f();
				} else if (t2.subfix() == 'I') {
					b2i();
				}
				break;
		}
	}

	public void alter( String operator, Type type ) {
		String op = "";
		if (operator.equals( "++" )) {
			op = "\tADD";
		}

		if (operator.equals( "--" )) {
			op = "\tSUB";
		}

		writter.println( op + type.subfix() );
		writter.flush();

	}

	public void alterAssig( String operator, Type superType ) {
		String op = "";
		if (operator.equals( "+=" )) {
			op = "\tADD";
		}

		if (operator.equals( "-=" )) {
			op = "\tSUB";
		}

		writter.println( op + superType.subfix() );
		writter.flush();
	}

	// ####################### COMMENTS ############################

	public void varComment( Definition d ) {
		writter.println( "\t' * " + d.getType() + " " + d.getName() + " (offset "
				+ ( (VarDefinition) d ).getOffset() + ")" );
		writter.flush();
	}

	public void paramComment() {
		writter.println( "\t' * Parameters" );
		writter.flush();
	}

	public void localComment() {
		writter.println( "\t' * Local variables" );
		writter.flush();
	}

	public void functionBodyComment() {
		writter.println( "\t' * Function body" );
		writter.flush();
	}

	public void mainComment() {
		writter.println( " ' Invocation to the main function" );
		writter.flush();
	}

	public void sourceComment( String constante ) {
		writter.println( "#source \"" + constante + "\"" );
		writter.println();
		writter.flush();
	}

	public void lineComment( int num ) {
		writter.println();
		writter.println( "#line\t" + num );
		writter.println();
		writter.flush();
	}

	public void white() {
		writter.println();
		writter.flush();
	}
}
