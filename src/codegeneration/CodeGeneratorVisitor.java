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
import visitor.Visitor;

/**
 * Instance of AbstractCodeGeneratorVisitor.java
 *
 * @author
 * @version
 */
public class CodeGeneratorVisitor implements Visitor<Object, Object> {

	/** The generator. */
	CodeGenerator generator;

	/**
	 * Instantiates a new code generator visitor.
	 *
	 * @param generator the generator
	 */
	public CodeGeneratorVisitor( CodeGenerator generator ) {
		this.generator = generator;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Arithmetic, java.lang.Object)
	 */
	@Override
	public Object visit( Arithmetic arithmetic, Object param ) {
		throw new IllegalStateException( "No template defined for Arithmetic." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.ArrayType, java.lang.Object)
	 */
	@Override
	public Object visit( ArrayType arrayType, Object param ) {
		throw new IllegalStateException( "No template defined for ArrayType." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Assignment, java.lang.Object)
	 */
	@Override
	public Object visit( Assignment assignment, Object param ) {
		throw new IllegalStateException( "No template defined for Assignment." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Cast, java.lang.Object)
	 */
	@Override
	public Object visit( Cast cast, Object param ) {
		throw new IllegalStateException( "No template defined for Cast." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.CharLiteral, java.lang.Object)
	 */
	@Override
	public Object visit( CharLiteral charLiteral, Object param ) {
		throw new IllegalStateException( "No template defined for CharLiteral." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.CharType, java.lang.Object)
	 */
	@Override
	public Object visit( CharType charType, Object param ) {
		throw new IllegalStateException( "No template defined for CharType." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Comparison, java.lang.Object)
	 */
	@Override
	public Object visit( Comparison comparison, Object param ) {
		throw new IllegalStateException( "No template defined for Comparison." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.FieldAccess, java.lang.Object)
	 */
	@Override
	public Object visit( FieldAccess fieldAccess, Object param ) {
		throw new IllegalStateException( "No template defined for FieldAccess." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.FuncDefinition, java.lang.Object)
	 */
	@Override
	public Object visit( FuncDefinition funcDefinition, Object param ) {
		throw new IllegalStateException( "No template defined for FuncDefinition." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.FunctionType, java.lang.Object)
	 */
	@Override
	public Object visit( FunctionType functionType, Object param ) {
		throw new IllegalStateException( "No template defined for FunctionType." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.IfStatement, java.lang.Object)
	 */
	@Override
	public Object visit( IfStatement ifStatement, Object param ) {
		throw new IllegalStateException( "No template defined for IfStatement." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Indexing, java.lang.Object)
	 */
	@Override
	public Object visit( Indexing indexing, Object param ) {
		throw new IllegalStateException( "No template defined for Indexing." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.IntLiteral, java.lang.Object)
	 */
	@Override
	public Object visit( IntLiteral intLiteral, Object param ) {
		throw new IllegalStateException( "No template defined for IntLiteral." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.IntType, java.lang.Object)
	 */
	@Override
	public Object visit( IntType intType, Object param ) {
		throw new IllegalStateException( "No template defined for IntType." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Invocation, java.lang.Object)
	 */
	@Override
	public Object visit( Invocation invocation, Object param ) {
		throw new IllegalStateException( "No template defined for Invocation." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Logical, java.lang.Object)
	 */
	@Override
	public Object visit( Logical logical, Object param ) {
		throw new IllegalStateException( "No template defined for Logical." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Negation, java.lang.Object)
	 */
	@Override
	public Object visit( Negation negation, Object param ) {
		throw new IllegalStateException( "No template defined for Negation." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Program, java.lang.Object)
	 */
	@Override
	public Object visit( Program program, Object param ) {
		throw new IllegalStateException( "No template defined for Program." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Read, java.lang.Object)
	 */
	@Override
	public Object visit( Read read, Object param ) {
		throw new IllegalStateException( "No template defined for Read." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.RealLiteral, java.lang.Object)
	 */
	@Override
	public Object visit( RealLiteral realLiteral, Object param ) {
		throw new IllegalStateException( "No template defined for RealLiteral." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.RealType, java.lang.Object)
	 */
	@Override
	public Object visit( RealType realType, Object param ) {
		throw new IllegalStateException( "No template defined for RealType." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.RecordField, java.lang.Object)
	 */
	@Override
	public Object visit( RecordField recordField, Object param ) {
		throw new IllegalStateException( "No template defined for RecordField." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.RecordType, java.lang.Object)
	 */
	@Override
	public Object visit( RecordType recordType, Object param ) {
		throw new IllegalStateException( "No template defined for RecordType." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Return, java.lang.Object)
	 */
	@Override
	public Object visit( Return return1, Object param ) {
		throw new IllegalStateException( "No template defined for Return." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.UnaryMinus, java.lang.Object)
	 */
	@Override
	public Object visit( UnaryMinus unaryMinus, Object param ) {
		throw new IllegalStateException( "No template defined for UnaryMinus." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.UnaryNot, java.lang.Object)
	 */
	@Override
	public Object visit( UnaryNot unaryNot, Object param ) {
		throw new IllegalStateException( "No template defined for UnaryNot." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.VarDefinition, java.lang.Object)
	 */
	@Override
	public Object visit( VarDefinition varDefinition, Object param ) {
		return null;
		// throw new IllegalStateException( "No template defined for
		// VarDefinition." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Variable, java.lang.Object)
	 */
	@Override
	public Object visit( Variable variable, Object param ) {
		throw new IllegalStateException( "No template defined for Variable." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.VoidType, java.lang.Object)
	 */
	@Override
	public Object visit( VoidType voidType, Object param ) {
		throw new IllegalStateException( "No template defined for VoidType." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.WhileStatement, java.lang.Object)
	 */
	@Override
	public Object visit( WhileStatement whileStatement, Object param ) {
		throw new IllegalStateException( "No template defined for WhileStatement." );
	}
	
	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.WhileStatement, java.lang.Object)
	 */
	@Override
	public Object visit( DoWhileStatement doWhileStatement, Object param ) {
		throw new IllegalStateException( "No template defined for DoWhileStatement." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Write, java.lang.Object)
	 */
	@Override
	public Object visit( Write write, Object param ) {
		throw new IllegalStateException( "No template defined for Write." );
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(errorhandler.ErrorType, java.lang.Object)
	 */
	@Override
	public Object visit( ErrorType errorType, Object param ) {
		throw new IllegalStateException( "No template defined for ErrorType." );
	}

}
