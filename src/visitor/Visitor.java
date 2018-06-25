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

import ast.Program;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Arithmetic;
import ast.expressions.Cast;
import ast.expressions.Comparison;
import ast.expressions.FieldAccess;
import ast.expressions.Indexing;
import ast.expressions.Invocation;
import ast.expressions.Logical;
import ast.expressions.Negation;
import ast.expressions.UnaryMinus;
import ast.expressions.UnaryNot;
import ast.expressions.Variable;
import ast.literals.CharLiteral;
import ast.literals.IntLiteral;
import ast.literals.RealLiteral;
import ast.literals.RecordField;
import ast.statements.Assignment;
import ast.statements.DoWhileStatement;
import ast.statements.IfStatement;
import ast.statements.Read;
import ast.statements.Return;
import ast.statements.WhileStatement;
import ast.statements.Write;
import ast.types.ArrayType;
import ast.types.CharType;
import ast.types.ErrorType;
import ast.types.FunctionType;
import ast.types.IntType;
import ast.types.RealType;
import ast.types.RecordType;
import ast.types.VoidType;

/**
 * Instance of Visitor.java
 * 
 * @author Guillermo Facundo Colunga.
 * @version 201803121239
 */
public interface Visitor<P, R> {

	/**
	 * @param arithmetic
	 * @param param
	 * @return
	 */
	R visit( Arithmetic arithmetic, P param );

	/**
	 * @param arrayType
	 * @param param
	 * @return
	 */
	R visit( ArrayType arrayType, P param );

	/**
	 * @param assignment
	 * @param param
	 * @return
	 */
	R visit( Assignment assignment, P param );

	/**
	 * @param cast
	 * @param param
	 * @return
	 */
	R visit( Cast cast, P param );

	/**
	 * @param charLiteral
	 * @param param
	 * @return
	 */
	R visit( CharLiteral charLiteral, P param );

	/**
	 * @param charType
	 * @param param
	 * @return
	 */
	R visit( CharType charType, P param );

	/**
	 * @param comparison
	 * @param param
	 * @return
	 */
	R visit( Comparison comparison, P param );

	/**
	 * @param fieldAccess
	 * @param param
	 * @return
	 */
	R visit( FieldAccess fieldAccess, P param );

	/**
	 * @param funcDefinition
	 * @param param
	 * @return
	 */
	R visit( FuncDefinition funcDefinition, P param );

	/**
	 * @param functionType
	 * @param param
	 * @return
	 */
	R visit( FunctionType functionType, P param );

	/**
	 * @param ifStatement
	 * @param param
	 * @return
	 */
	R visit( IfStatement ifStatement, P param );

	/**
	 * @param indexing
	 * @param param
	 * @return
	 */
	R visit( Indexing indexing, P param );

	/**
	 * @param intLiteral
	 * @param param
	 * @return
	 */
	R visit( IntLiteral intLiteral, P param );

	/**
	 * @param intType
	 * @param param
	 * @return
	 */
	R visit( IntType intType, P param );

	/**
	 * @param invocation
	 * @param param
	 * @return
	 */
	R visit( Invocation invocation, P param );

	/**
	 * @param logical
	 * @param param
	 * @return
	 */
	R visit( Logical logical, P param );

	/**
	 * @param negation
	 * @param param
	 * @return
	 */
	R visit( Negation negation, P param );

	/**
	 * @param program
	 * @param param
	 * @return
	 */
	R visit( Program program, P param );

	/**
	 * @param read
	 * @param param
	 * @return
	 */
	R visit( Read read, P param );

	/**
	 * @param realLiteral
	 * @param param
	 * @return
	 */
	R visit( RealLiteral realLiteral, P param );

	/**
	 * @param realType
	 * @param param
	 * @return
	 */
	R visit( RealType realType, P param );

	/**
	 * @param recordField
	 * @param param
	 * @return
	 */
	R visit( RecordField recordField, P param );

	/**
	 * @param recordType
	 * @param param
	 * @return
	 */
	R visit( RecordType recordType, P param );

	/**
	 * @param return1
	 * @param param
	 * @return
	 */
	R visit( Return return1, P param );

	/**
	 * @param unaryMinus
	 * @param param
	 * @return
	 */
	R visit( UnaryMinus unaryMinus, P param );

	/**
	 * @param unaryMinus
	 * @param param
	 * @return
	 */
	R visit( UnaryNot unaryNot, P param );

	/**
	 * @param varDefinition
	 * @param param
	 * @return
	 */
	R visit( VarDefinition varDefinition, P param );

	/**
	 * @param variable
	 * @param param
	 * @return
	 */
	R visit( Variable variable, P param );

	/**
	 * @param voidType
	 * @param param
	 * @return
	 */
	R visit( VoidType voidType, P param );

	/**
	 * @param whileStatement
	 * @param param
	 * @return
	 */
	R visit( WhileStatement whileStatement, P param );
	
	/**
	 * @param doWhileStatement
	 * @param param
	 * @return
	 */
	R visit( DoWhileStatement doWhileStatement, P param );

	/**
	 * @param write
	 * @param param
	 * @return
	 */
	R visit( Write write, P param );

	/**
	 * @param errorType
	 * @param param
	 * @return
	 */
	R visit( ErrorType errorType, P param );

}
