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

import ast.Arithmetic;
import ast.ArrayType;
import ast.Assignment;
import ast.Cast;
import ast.CharLiteral;
import ast.CharType;
import ast.Comparison;
import ast.FieldAccess;
import ast.FuncDefinition;
import ast.FunctionType;
import ast.IfStatement;
import ast.Indexing;
import ast.IntLiteral;
import ast.IntType;
import ast.Invocation;
import ast.Logical;
import ast.Negation;
import ast.Program;
import ast.Read;
import ast.RealLiteral;
import ast.RealType;
import ast.RecordField;
import ast.RecordType;
import ast.Return;
import ast.UnaryMinus;
import ast.UnaryNot;
import ast.VarDefinition;
import ast.Variable;
import ast.VoidType;
import ast.WhileStatement;
import ast.Write;
import errorhandler.ErrorType;

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
    R visit(Arithmetic arithmetic, P param);

    /**
     * @param arrayType
     * @param param
     * @return
     */
    R visit(ArrayType arrayType, P param);

    /**
     * @param assignment
     * @param param
     * @return
     */
    R visit(Assignment assignment, P param);

    /**
     * @param cast
     * @param param
     * @return
     */
    R visit(Cast cast, P param);

    /**
     * @param charLiteral
     * @param param
     * @return
     */
    R visit(CharLiteral charLiteral, P param);

    /**
     * @param charType
     * @param param
     * @return
     */
    R visit(CharType charType, P param);

    /**
     * @param comparison
     * @param param
     * @return
     */
    R visit(Comparison comparison, P param);

    /**
     * @param fieldAccess
     * @param param
     * @return
     */
    R visit(FieldAccess fieldAccess, P param);

    /**
     * @param funcDefinition
     * @param param
     * @return
     */
    R visit(FuncDefinition funcDefinition, P param);

    /**
     * @param functionType
     * @param param
     * @return
     */
    R visit(FunctionType functionType, P param);

    /**
     * @param ifStatement
     * @param param
     * @return
     */
    R visit(IfStatement ifStatement, P param);

    /**
     * @param indexing
     * @param param
     * @return
     */
    R visit(Indexing indexing, P param);

    /**
     * @param intLiteral
     * @param param
     * @return
     */
    R visit(IntLiteral intLiteral, P param);

    /**
     * @param intType
     * @param param
     * @return
     */
    R visit(IntType intType, P param);

    /**
     * @param invocation
     * @param param
     * @return
     */
    R visit(Invocation invocation, P param);

    /**
     * @param logical
     * @param param
     * @return
     */
    R visit(Logical logical, P param);

    /**
     * @param negation
     * @param param
     * @return
     */
    R visit(Negation negation, P param);

    /**
     * @param program
     * @param param
     * @return
     */
    R visit(Program program, P param);

    /**
     * @param read
     * @param param
     * @return
     */
    R visit(Read read, P param);

    /**
     * @param realLiteral
     * @param param
     * @return
     */
    R visit(RealLiteral realLiteral, P param);

    /**
     * @param realType
     * @param param
     * @return
     */
    R visit(RealType realType, P param);

    /**
     * @param recordField
     * @param param
     * @return
     */
    R visit(RecordField recordField, P param);

    /**
     * @param recordType
     * @param param
     * @return
     */
    R visit(RecordType recordType, P param);

    /**
     * @param return1
     * @param param
     * @return
     */
    R visit(Return return1, P param);

    /**
     * @param unaryMinus
     * @param param
     * @return
     */
    R visit(UnaryMinus unaryMinus, P param);
    
    /**
     * @param unaryMinus
     * @param param
     * @return
     */
    R visit(UnaryNot unaryNot, P param);

    /**
     * @param varDefinition
     * @param param
     * @return
     */
    R visit(VarDefinition varDefinition, P param);

    /**
     * @param variable
     * @param param
     * @return
     */
    R visit(Variable variable, P param);

    /**
     * @param voidType
     * @param param
     * @return
     */
    R visit(VoidType voidType, P param);

    /**
     * @param whileStatement
     * @param param
     * @return
     */
    R visit(WhileStatement whileStatement, P param);

    /**
     * @param write
     * @param param
     * @return
     */
    R visit(Write write, P param);

    /**
     * @param errorType
     * @param param
     * @return
     */
    R visit(ErrorType errorType, P param);

}
