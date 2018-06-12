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

import ast.Arithmetic;
import ast.Cast;
import ast.CharLiteral;
import ast.Comparison;
import ast.Expression;
import ast.FieldAccess;
import ast.Indexing;
import ast.IntLiteral;
import ast.Invocation;
import ast.Logical;
import ast.RealLiteral;
import ast.UnaryMinus;
import ast.UnaryNot;
import ast.Variable;
import ast.type.FunctionType;
import ast.type.IntType;
import ast.type.Type;

/**
 * Instance of ValueCodeGeneratorVisitor.java
 * 
 * @author
 * @version
 */
public class ValueCodeGeneratorVisitor extends CodeGeneratorVisitor {

	AddressCodeGeneratorVisitor adressCgVisitor;

	public ValueCodeGeneratorVisitor( CodeGenerator cg,
			AddressCodeGeneratorVisitor adressCgVisitor ) {
		super( cg );
		this.adressCgVisitor = adressCgVisitor;
	}

	@Override
	public Object visit( IntLiteral intLiteral, Object o ) {

		generator.push( intLiteral.getValue() );
		return null;

	}

	@Override
	public Object visit( CharLiteral charLiteral, Object o ) {

		generator.push( charLiteral.getValue() );
		return null;
	}

	@Override
	public Object visit( RealLiteral realLiteral, Object o ) {

		generator.push( realLiteral.getValue() );
		return null;
	}

	@Override
	public Object visit( Variable variable, Object object ) {

		variable.accept( adressCgVisitor, object );
		generator.load( variable.getDefinition().getType() );

		return null;
	}

	@Override
	public Object visit( Arithmetic arithmetic, Object object ) {

		if (arithmetic.getLeft().getType().subfix() == 'B'
				&& arithmetic.getRight().getType().subfix() == 'B') {
			arithmetic.getLeft().accept( this, object );
			generator.b2i();
			arithmetic.getRight().accept( this, object );
			generator.b2i();
			generator.aritmetic( arithmetic.getOperator(), IntType.getInstance() );
			generator.i2b();
		} else {
			arithmetic.getLeft().accept( this, object );
			generator.convert( arithmetic.getLeft().getType(), arithmetic.getType() );
			arithmetic.getRight().accept( this, object );
			generator.convert( arithmetic.getRight().getType(), arithmetic.getType() );
			generator.aritmetic( arithmetic.getOperator(), arithmetic.getType() );
		}

		return null;

	}

	@Override
	public Object visit( Comparison comparison, Object o ) {

		Type superType = comparison.getLeft().getType()
				.superType( comparison.getRight().getType() );
		comparison.getLeft().accept( this, o );
		generator.convert( comparison.getLeft().getType(), superType );
		comparison.getRight().accept( this, o );
		generator.convert( comparison.getRight().getType(), superType );
		generator.comparison( comparison.getComparator(), superType );

		return null;
	}

	@Override
	public Object visit( Cast cast, Object o ) {
		cast.getExp().accept( this, o );
		generator.cast( cast.getExp().getType(), cast.getCastType() );
		return null;
	}

	@Override
	public Object visit( Logical logical, Object o ) {
		logical.getLeft().accept( this, o );
		generator.convert( logical.getLeft().getType(), logical.getType() );
		logical.getRight().accept( this, o );
		generator.convert( logical.getRight().getType(), logical.getType() );
		generator.logic( logical.getLogicalOperator() );

		return null;

	}

	@Override
	public Object visit( UnaryNot negation, Object o ) {
		negation.getOperand().accept( this, o );
		generator.not();
		return null;
	}

	@Override
	public Object visit( FieldAccess fieldAccess, Object o ) {
		fieldAccess.accept( adressCgVisitor, o );
		generator.load( fieldAccess.getType() );
		return null;
	}

	@Override
	public Object visit( Indexing indexing, Object o ) {
		indexing.accept( adressCgVisitor, o );
		generator.load( indexing.getType() );
		return null;
	}

	@Override
	public Object visit( Invocation invocation, Object o ) {
		int i = 0;
		for (Expression s : invocation.getArguments()) {
			s.accept( this, o );
			generator.convert( s.getType(),
					( (FunctionType) invocation.getFuncion().getType() ).getParameters().get( i++ )
							.getType() );
		}
		generator.call( invocation.getFuncion().getName() );
		return null;

	}

	@Override
	public Object visit( UnaryMinus unaryMinus, Object o ) {

		unaryMinus.getExpression().accept( this, o );
		generator.push( -1 );
		generator.convert( IntType.getInstance(), unaryMinus.getType() );
		generator.mul( unaryMinus.getExpression().getType() );
		return null;
	}

}
