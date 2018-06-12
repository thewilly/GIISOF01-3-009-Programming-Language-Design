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

import ast.*;
import ast.type.ArrayType;
import ast.type.CharType;
import ast.type.ErrorType;
import ast.type.FunctionType;
import ast.type.IntType;
import ast.type.RealType;
import ast.type.RecordType;
import ast.type.VoidType;

/**
 * Instance of AbstractVisitor.java
 * 
 * @author
 * @version
 */
public class AbstractVisitor<P, R> implements Visitor<P, R> {

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Arithmetic, java.lang.Object)
	 */
	@Override
	public R visit( Arithmetic arithmetic, P param ) {
		if (arithmetic.getLeft() != null)
			arithmetic.getLeft().accept( this, param );
		if (arithmetic.getRight() != null)
			arithmetic.getRight().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.ArrayType, java.lang.Object)
	 */
	@Override
	public R visit( ArrayType arrayType, P param ) {
		if (arrayType.getOf() != null)
			arrayType.getOf().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Assignment, java.lang.Object)
	 */
	@Override
	public R visit( Assignment assignment, P param ) {
		assignment.getLeft().accept( this, param );
		assignment.getRight().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Cast, java.lang.Object)
	 */
	@Override
	public R visit( Cast cast, P param ) {
		if (cast.getCastType() != null)
			cast.getCastType().accept( this, param );
		if (cast.getExp() != null)
			cast.getExp().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.CharLiteral, java.lang.Object)
	 */
	@Override
	public R visit( CharLiteral charLiteral, P param ) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.CharType, java.lang.Object)
	 */
	@Override
	public R visit( CharType charType, P param ) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Comparison, java.lang.Object)
	 */
	@Override
	public R visit( Comparison comparison, P param ) {
		if (comparison.getLeft() != null)
			comparison.getLeft().accept( this, param );

		if (comparison.getRight() != null)
			comparison.getRight().accept( this, param );

		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.FieldAccess, java.lang.Object)
	 */
	@Override
	public R visit( FieldAccess fieldAccess, P param ) {
		if (fieldAccess.getExp() != null)
			fieldAccess.getExp().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.FuncDefinition, java.lang.Object)
	 */
	@Override
	public R visit( FuncDefinition funcDefinition, P param ) {
		for (Statement statement : funcDefinition.getStatements())
			statement.accept( this, param );
		funcDefinition.getType().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.FunctionType, java.lang.Object)
	 */
	@Override
	public R visit( FunctionType functionType, P param ) {
		if (functionType.getParameters() != null)
			for (VarDefinition var : functionType.getParameters())
				var.accept( this, param );
		functionType.getReturnType().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.IfStatement, java.lang.Object)
	 */
	@Override
	public R visit( IfStatement ifStatement, P param ) {
		if (ifStatement.getCondition() != null)
			ifStatement.getCondition().accept( this, param );
		if (ifStatement.getIfBody() != null)
			for (Statement statement : ifStatement.getIfBody())
				statement.accept( this, param );
		if (ifStatement.getElseBody() != null)
			for (Statement statement : ifStatement.getElseBody())
				statement.accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Indexing, java.lang.Object)
	 */
	@Override
	public R visit( Indexing indexing, P param ) {
		if (indexing.getArguments() != null)
			indexing.getArguments().accept( this, param );
		if (indexing.getVariable() != null)
			indexing.getVariable().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.IntLiteral, java.lang.Object)
	 */
	@Override
	public R visit( IntLiteral intLiteral, P param ) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.IntType, java.lang.Object)
	 */
	@Override
	public R visit( IntType intType, P param ) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Invocation, java.lang.Object)
	 */
	@Override
	public R visit( Invocation invocation, P param ) {
		if (invocation.getFuncion() != null)
			invocation.getFuncion().accept( this, param );
		if (invocation.getArguments() != null)
			for (Expression ex : invocation.getArguments())
				ex.accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Logical, java.lang.Object)
	 */
	@Override
	public R visit( Logical logical, P param ) {
		if (logical.getLeft() != null)
			logical.getLeft().accept( this, param );
		if (logical.getRight() != null)
			logical.getRight().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Negation, java.lang.Object)
	 */
	@Override
	public R visit( Negation negation, P param ) {
		if (negation.getOperand() != null)
			negation.getOperand().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Program, java.lang.Object)
	 */
	@Override
	public R visit( Program program, P param ) {
		for (Definition def : program.getDefinitions()) {
			def.accept( this, param );
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Read, java.lang.Object)
	 */
	@Override
	public R visit( Read read, P param ) {
		if (read.getExpression() != null)
			read.getExpression().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.RealLiteral, java.lang.Object)
	 */
	@Override
	public R visit( RealLiteral realLiteral, P param ) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.RealType, java.lang.Object)
	 */
	@Override
	public R visit( RealType realType, P param ) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.RecordField, java.lang.Object)
	 */
	@Override
	public R visit( RecordField recordField, P param ) {
		if (recordField != null)
			recordField.getType().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.RecordType, java.lang.Object)
	 */
	@Override
	public R visit( RecordType recordType, P param ) {
		if (recordType.getFields() != null)
			for (RecordField field : recordType.getFields())
				field.accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Return, java.lang.Object)
	 */
	@Override
	public R visit( Return return1, P param ) {
		if (return1.getExpression() != null)
			return1.getExpression().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.UnaryMinus, java.lang.Object)
	 */
	@Override
	public R visit( UnaryMinus unaryMinus, P param ) {
		if (unaryMinus.getExpression() != null)
			unaryMinus.getExpression().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.VarDefinition, java.lang.Object)
	 */
	@Override
	public R visit( VarDefinition varDefinition, P param ) {
		if (varDefinition.getType() != null)
			varDefinition.getType().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Variable, java.lang.Object)
	 */
	@Override
	public R visit( Variable variable, P param ) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.VoidType, java.lang.Object)
	 */
	@Override
	public R visit( VoidType voidType, P param ) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.WhileStatement, java.lang.Object)
	 */
	@Override
	public R visit( WhileStatement whileStatement, P param ) {
		if (whileStatement.getCondition() != null)
			whileStatement.getCondition().accept( this, param );
		if (whileStatement.getBody() != null)
			for (Statement st : whileStatement.getBody())
				st.accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Write, java.lang.Object)
	 */
	@Override
	public R visit( Write write, P param ) {
		if (write.getExpression() != null)
			write.getExpression().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(errorhandler.ErrorType, java.lang.Object)
	 */
	@Override
	public R visit( ErrorType errorType, P param ) {
		if (errorType.getNode() != null)
			errorType.getNode().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.UnaryNot, java.lang.Object)
	 */
	@Override
	public R visit( UnaryNot unaryNot, P param ) {
		unaryNot.getOperand().accept( this, param );
		return null;
	}

}
