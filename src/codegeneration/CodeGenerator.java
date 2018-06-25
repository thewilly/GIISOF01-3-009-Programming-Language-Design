/* 
 * MIT License
 * 
 * Copyright (c) 2018 Guillermo Facundo Colunga
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package codegeneration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import ast.definitions.Definition;
import ast.definitions.VarDefinition;
import ast.types.CharType;
import ast.types.IntType;
import ast.types.RealType;
import ast.types.Type;

/**
 * Instance of CodeGenerator.java
 * 
 * @author
 * @version
 */
public class CodeGenerator {

	/** The writter. */
	private PrintWriter writter;
	
	/** The label counter. */
	private int labelCounter;

	/**
	 * Instantiates a new code generator.
	 *
	 * @param inputFileName the input file name
	 * @param writterputFileName the writterput file name
	 */
	public CodeGenerator( String inputFileName, String writterputFileName ) {

		try {
			writter = new PrintWriter( new File( writterputFileName ) );
			labelCounter = 0;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Pushbp.
	 */
	public void pushbp() {
		writter.println( "\tPUSH BP" );
		writter.flush();
	}

	/**
	 * Load.
	 *
	 * @param type the type
	 */
	public void load( Type type ) {
		writter.println( "\tLOAD" + type.subfix() );
		writter.flush();
	}

	/**
	 * Pusha.
	 *
	 * @param n the n
	 */
	public void pusha( int n ) {
		writter.println( "\tPUSHA " + n );
		writter.flush();
	}

	/**
	 * Push.
	 *
	 * @param n the n
	 */
	public void push( int n ) {
		writter.println( "\tPUSHI " + n );
		writter.flush();
	}

	/**
	 * Push.
	 *
	 * @param n the n
	 */
	public void push( double n ) {
		writter.println( "\tPUSHF " + n );
		writter.flush();
	}

	/**
	 * Push.
	 *
	 * @param n the n
	 */
	public void push( char n ) {
		writter.println( "\tPUSHB " + (int) n );
		writter.flush();
	}

	/**
	 * Halt.
	 */
	public void halt() {
		writter.println( "\tHALT" );
		writter.flush();
	}

	/**
	 * Out.
	 *
	 * @param type the type
	 */
	public void out( Type type ) {
		writter.println( "\tOUT" + type.subfix() );
		writter.flush();
	}

	/**
	 * Store.
	 *
	 * @param type the type
	 */
	public void store( Type type ) {
		writter.println( "\tSTORE" + type.subfix() );
		writter.flush();

	}

	/**
	 * Call.
	 *
	 * @param nameString the name string
	 */
	public void call( String nameString ) {
		writter.println( "\tCALL " + nameString );
		writter.flush();

	}

	/**
	 * Aritmetic.
	 *
	 * @param operator the operator
	 * @param type the type
	 */
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

	/**
	 * Adds the.
	 *
	 * @param type the type
	 */
	public void add( Type type ) {
		writter.println( "\tADD" + type.subfix() );
		writter.flush();
	}

	/**
	 * Sub.
	 *
	 * @param type the type
	 */
	public void sub( Type type ) {
		writter.println( "\tSUB" + type.subfix() );
		writter.flush();
	}

	/**
	 * Mul.
	 *
	 * @param type the type
	 */
	public void mul( Type type ) {
		writter.println( "\tMUL" + type.subfix() );
		writter.flush();
	}

	/**
	 * Div.
	 *
	 * @param type the type
	 */
	public void div( Type type ) {
		writter.println( "\tDIV" + type.subfix() );
		writter.flush();
	}

	/**
	 * Jz.
	 *
	 * @param label the label
	 */
	public void jz( int label ) {
		writter.println( "\tJZ Label" + label );
		writter.flush();
	}

	/**
	 * Jmp.
	 *
	 * @param label the label
	 */
	public void jmp( int label ) {
		writter.println( "\tJMP Label" + label );
		writter.flush();
	}

	/**
	 * Jnz.
	 *
	 * @param label the label
	 */
	public void jnz( int label ) {
		writter.println( "\tJNZ Label" + label );
		writter.flush();
	}

	/**
	 * Etiqueta.
	 *
	 * @param name the name
	 */
	public void etiqueta( String name ) {
		writter.println( " " + name + ":" );
		writter.flush();

	}

	/**
	 * Enter.
	 *
	 * @param locals the locals
	 */
	public void enter( int locals ) {
		writter.println( "\tenter " + locals );
		writter.flush();
	}

	/**
	 * Ret.
	 *
	 * @param ret the ret
	 * @param locals the locals
	 * @param params the params
	 */
	public void ret( int ret, int locals, int params ) {
		writter.println( "\tret " + ret + "," + locals + "," + params );
		writter.flush();

	}

	/**
	 * In.
	 *
	 * @param type the type
	 */
	public void in( Type type ) {
		writter.println( "\tIN" + type.subfix() );
		writter.flush();
	}

	/**
	 * B 2 i.
	 */
	public void b2i() {
		writter.println( "\tB2I" );
		writter.flush();
	}

	/**
	 * I 2 f.
	 */
	public void i2f() {
		writter.println( "\tI2F" );
		writter.flush();
	}

	/**
	 * F 2 i.
	 */
	public void f2i() {
		writter.println( "\tF2I" );
		writter.flush();
	}

	/**
	 * I 2 b.
	 */
	public void i2b() {
		writter.println( "\tI2B" );
		writter.flush();
	}

	/**
	 * Cast.
	 *
	 * @param type the type
	 * @param castType the cast type
	 */
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

	/**
	 * Logic.
	 *
	 * @param logicalOperator the logical operator
	 */
	public void logic( String logicalOperator ) {
		String op = "";
		if (logicalOperator.equals( "&&" ) || logicalOperator.equals( "&&=" )) {
			op = "\tAND";
		}

		if (logicalOperator.equals( "||" ) || logicalOperator.equals( "||=" )) {
			op = "\tOR";
		}

		writter.println( op );
		writter.flush();

	}

	/**
	 * Comparison.
	 *
	 * @param comparator the comparator
	 * @param type the type
	 */
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

	/**
	 * Not.
	 */
	public void not() {
		writter.println( "\tNOT" );
		writter.flush();

	}

	/**
	 * Label.
	 *
	 * @param num the num
	 */
	public void label( int num ) {
		writter.println( "Label" + num + ":" );
		writter.flush();
	}

	/**
	 * Gets the labels.
	 *
	 * @param i the i
	 * @return the labels
	 */
	public int getLabels( int i ) {
		labelCounter += i;
		return labelCounter - i;
	}

	/**
	 * Pop.
	 *
	 * @param subfix the subfix
	 */
	public void pop( char subfix ) {
		writter.println( "\tPOP" + subfix );
		writter.flush();
	}

	/**
	 * Convert.
	 *
	 * @param t1 the t 1
	 * @param t2 the t 2
	 */
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

	/**
	 * Alter.
	 *
	 * @param operator the operator
	 * @param type the type
	 */
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

	/**
	 * Alter assig.
	 *
	 * @param operator the operator
	 * @param superType the super type
	 */
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

	/**
	 * Var comment.
	 *
	 * @param d the d
	 */
	public void varComment( Definition d ) {
		writter.println( "\t' * " + d.getType() + " " + d.getName() + " (offset "
				+ ( (VarDefinition) d ).getOffset() + ")" );
		writter.flush();
	}

	/**
	 * Param comment.
	 */
	public void paramComment() {
		writter.println( "\t' * Parameters" );
		writter.flush();
	}

	/**
	 * Local comment.
	 */
	public void localComment() {
		writter.println( "\t' * Local variables" );
		writter.flush();
	}

	/**
	 * Function body comment.
	 */
	public void functionBodyComment() {
		writter.println( "\t' * Function body" );
		writter.flush();
	}

	/**
	 * Main comment.
	 */
	public void mainComment() {
		writter.println( " ' Invocation to the main function" );
		writter.flush();
	}

	/**
	 * Source comment.
	 *
	 * @param constante the constante
	 */
	public void sourceComment( String constante ) {
		writter.println( "#source \"" + constante + "\"" );
		writter.println();
		writter.flush();
	}

	/**
	 * Line comment.
	 *
	 * @param num the num
	 */
	public void lineComment( int num ) {
		writter.println();
		writter.println( "#line\t" + num );
		writter.println();
		writter.flush();
	}

	/**
	 * White.
	 */
	public void white() {
		writter.println();
		writter.flush();
	}
}
