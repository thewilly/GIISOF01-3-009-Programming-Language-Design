/*
 * This source file is part of the PmmCompiler open source project.
 *
 * Copyright (c) 2018 willy and the PmmCompiler project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package visitor.impl;

import java.util.ArrayList;
import java.util.List;

import ast.*;
import ast.type.CharType;
import ast.type.ErrorType;
import ast.type.IntType;
import ast.type.RealType;
import ast.type.Type;
import visitor.AbstractVisitor;

/**
 * Instance of TypeCheckingVisitor.java
 * 
 * @author
 * @version
 */
public class TypeCheckingVisitor extends AbstractVisitor<Object, Object> {

	@Override
	public Object visit( Variable var, Object param ) {
		if (var.getDefinition() != null) {
			var.setType( var.getDefinition().getType() );
		}
		var.setLValue( true );
		return true;
	}

	@Override
	public Object visit( Arithmetic arithmetic, Object param ) {
		arithmetic.getLeft().accept( this, param );
		arithmetic.getRight().accept( this, param );

		arithmetic.setType(
				arithmetic.getLeft().getType().arithmetic( arithmetic.getRight().getType() ) );
		if (arithmetic.getType() == null) {
			arithmetic.setType( new ErrorType( arithmetic,
					"ERROR: Se esperaban tipos iguales (Reales o Enteros) en "
							+ arithmetic.toString() ) );
		}
		arithmetic.setLValue( false );
		return null;
	}

	@Override
	public Object visit( Assignment assignment, Object param ) {
		assignment.getLeft().accept( this, param );
		assignment.getRight().accept( this, param );
		if (!assignment.getLeft().getLValue()) {
			new ErrorType( assignment.getLeft(),
					"ERROR: LValue expected at: " + assignment.getLeft().getClass().getName() );
		}

		if (assignment.getLeft().getType() != null && assignment.getRight().getType() != null) {
			assignment.getLeft().setType(
					assignment.getRight().getType().promotesTo( assignment.getLeft().getType() ) );
			if (assignment.getLeft().getType() == null) {
				assignment.getLeft().setType( new ErrorType( assignment.getLeft(),
						"ERROR: Type missmatch cannot convert from "
								+ assignment.getRight().getClass().toString() + " to "
								+ assignment.getLeft().getClass().toString() + " at "
								+ assignment.getLine() + ", " + assignment.getColumn() ) );
			}
		}

		return null;
	}

	@Override
	public Object visit( Indexing indexing, Object param ) {
		indexing.getVariable().accept( this, param );
		indexing.getArguments().accept( this, param );

		indexing.setType(
				indexing.getArguments().getType()
						.squareBrackets( indexing.getVariable().getType() ) );
		if (indexing.getType() == null) {
			indexing.setType(
					new ErrorType( indexing,
							"ERROR: Index out of bounds at " + indexing.getLine() + ", "
									+ indexing.getColumn() + ". For index : "
									+ indexing.toString() ) );
		}

		if (!indexing.getArguments().getLValue()) {
			new ErrorType( indexing,
					"ERROR: LValue expected at: " + indexing.getArguments() );
		} else {
			indexing.setLValue( true );
		}

		return true;
	}

	@Override
	public Object visit( Read read, Object param ) {
		read.getExpression().accept( this, param );

		if (!read.getExpression().getLValue())
			new ErrorType( read.getExpression(),
					"Lvalue expected at: " + read.getExpression().getClass().getName() );
		return null;
	}

	@Override
	public Object visit( Cast cast, Object o ) {
		cast.getExp().accept( this, o );
		cast.getCastType().accept( this, o );

		cast.setType( cast.getCastType().canBeCast( cast.getExp().getType() ) );
		if (cast.getCastType() == null) {
			cast.setCastType( new ErrorType( cast,
					"ERROR: No es posible realizar el casteo en " + cast.toString() ) );
		}

		cast.setLValue( false );
		return null;
	}

	@Override
	public Object visit( Comparison comparison, Object o ) {
		comparison.getLeft().accept( this, o );
		comparison.getRight().accept( this, o );

		comparison.setType(
				comparison.getLeft().getType().comparison( comparison.getRight().getType() ) );
		if (comparison.getType() == null) {
			comparison.setType(
					new ErrorType( comparison,
							"ERROR: Se esperaban tipos iguales en " + comparison.toString() ) );
		}

		comparison.setLValue( false );
		return null;
	}

	@Override
	public Object visit( CharLiteral charLiteral, Object o ) {
		charLiteral.setType( CharType.getInstance() );
		charLiteral.setLValue( false );
		return null;
	}

	@Override
	public Object visit( FieldAccess fieldAccess, Object o ) {
		fieldAccess.getExp().accept( this, o );

		if (fieldAccess.getExp().getType() != null) {
			fieldAccess.setType( fieldAccess.getExp().getType().dot( fieldAccess.getName() ) );
			if (fieldAccess.getType() == null) {
				fieldAccess.setType( new ErrorType( fieldAccess,
						"ERROR: Impossible to access to the field "
								+ fieldAccess.toString() ) );
			}
		}

		if (fieldAccess.getExp().getLValue()) {
			fieldAccess.setLValue( true );
		}
		return null;
	}

	@Override
	public Object visit( IntLiteral intLiteral, Object o ) {
		intLiteral.setType( IntType.getInstance() );
		intLiteral.setLValue( false );
		return true;
	}

	@Override
	public Object visit( Invocation invocation, Object param ) {
		invocation.getFuncion().accept( this, param );

		List<Type> types = new ArrayList<Type>();
		if (invocation.getArguments() != null) {

			for (Expression expression : invocation.getArguments()) {
				expression.accept( this, param );
				types.add( expression.getType() );
				System.out.println( "Expression " + expression );
				System.out.println( "Parameter type adding: " + expression.getType() );
			}
		}

		invocation.setType( invocation.getFuncion().getType().parentesis( types ) );
		if (invocation.getType() == null) {
			invocation.setType( new ErrorType( invocation,
					"ERROR: No ha sido posible invocar a la función en: "
							+ invocation.toString() ) );
		}

		invocation.setLValue( false );
		return null;
	}

	@Override
	public Object visit( Logical logical, Object o ) {
		logical.getLeft().accept( this, o );
		logical.getRight().accept( this, o );

		logical.setType( logical.getLeft().getType().logical( logical.getRight().getType() ) );
		if (logical.getType() == null) {
			logical.setType( new ErrorType( logical,
					"ERROR: Se esperaban tipos iguales (Enteros o Carácteres) en "
							+ logical.toString() ) );
		}

		logical.setLValue( false );
		return null;
	}

	@Override
	public Object visit( UnaryNot negation, Object o ) {
		negation.getOperand().accept( this, o );

		negation.setType( negation.getOperand().getType().logical() );
		if (negation.getType() == null) {
			negation.setType(
					new ErrorType( negation, "ERROR: Se esperaba un tipo entero o caracter en "
							+ negation.toString() ) );
		}

		negation.setLValue( false );
		return null;
	}

	@Override
	public Object visit( RealLiteral realLiteral, Object o ) {
		realLiteral.setType( RealType.getInstance() );
		realLiteral.setLValue( false );
		return null;
	}

	@Override
	public Object visit( UnaryMinus unaryMinus, Object o ) {
		unaryMinus.getExpression().accept( this, o );

		unaryMinus.setType( unaryMinus.getExpression().getType().arithmetic() );
		if (unaryMinus.getType() == null) {
			unaryMinus.setType(
					new ErrorType( unaryMinus, "ERROR: Se esperaba un tipo entero o real en "
							+ unaryMinus.toString() ) );
		}

		unaryMinus.setLValue( false );
		return null;
	}

	@Override
	public Object visit( WhileStatement whileStatement, Object o ) {
		whileStatement.getCondition().accept( this, o );

		if (whileStatement.getCondition().getType() != null) {
			if (!whileStatement.getCondition().getType().isLogical()) {
				whileStatement.getCondition().setType( new ErrorType( whileStatement.getCondition(),
						"ERROR: No se ha encontrado un valor booleano en "
								+ whileStatement.getCondition().toString() ) );
			}
		}

		for (Statement s : whileStatement.getBody()) {
			s.accept( this, o );
		}
		return null;
	}

	@Override
	public Object visit( IfStatement ifStatement, Object o ) {
		ifStatement.getCondition().accept( this, o );

		if (!ifStatement.getCondition().getType().isLogical()) {
			ifStatement.getCondition().setType( new ErrorType( ifStatement.getCondition(),
					"ERROR: No se ha encontrado un valor booleano en "
							+ ifStatement.getCondition().toString() ) );
		}

		if (ifStatement.getIfBody() != null) {
			for (Statement statement : ifStatement.getIfBody()) {
				statement.accept( this, o );
			}
		}

		if (ifStatement.getElseBody() != null) {
			for (Statement statement : ifStatement.getElseBody()) {
				statement.accept( this, o );
			}
		}
		return null;
	}
}
