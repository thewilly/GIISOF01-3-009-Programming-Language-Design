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

import ast.expressions.Arithmetic;
import ast.expressions.Cast;
import ast.expressions.Comparison;
import ast.expressions.Expression;
import ast.expressions.FieldAccess;
import ast.expressions.Indexing;
import ast.expressions.Invocation;
import ast.expressions.Logical;
import ast.expressions.UnaryMinus;
import ast.expressions.UnaryNot;
import ast.expressions.Variable;
import ast.literals.CharLiteral;
import ast.literals.IntLiteral;
import ast.literals.RealLiteral;
import ast.types.FunctionType;
import ast.types.IntType;
import ast.types.Type;

/**
 * Instance of ValueCodeGeneratorVisitor.java
 * 
 * @author
 * @version
 */
public class ValueCodeGeneratorVisitor extends CodeGeneratorVisitor {

	/** The adress cg visitor. */
	AddressCodeGeneratorVisitor adressCgVisitor;

	/**
	 * Instantiates a new value code generator visitor.
	 *
	 * @param cg the cg
	 * @param adressCgVisitor the adress cg visitor
	 */
	public ValueCodeGeneratorVisitor( CodeGenerator cg,
			AddressCodeGeneratorVisitor adressCgVisitor ) {
		super( cg );
		this.adressCgVisitor = adressCgVisitor;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.literals.IntLiteral, java.lang.Object)
	 */
	@Override
	public Object visit( IntLiteral intLiteral, Object o ) {

		generator.push( intLiteral.getValue() );
		return null;

	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.literals.CharLiteral, java.lang.Object)
	 */
	@Override
	public Object visit( CharLiteral charLiteral, Object o ) {

		generator.push( charLiteral.getValue() );
		return null;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.literals.RealLiteral, java.lang.Object)
	 */
	@Override
	public Object visit( RealLiteral realLiteral, Object o ) {

		generator.push( realLiteral.getValue() );
		return null;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.expressions.Variable, java.lang.Object)
	 */
	@Override
	public Object visit( Variable variable, Object object ) {

		variable.accept( adressCgVisitor, object );
		generator.load( variable.getDefinition().getType() );
		if(variable.getType().isReferenceType()) {
			generator.load( variable.getDefinition().getType() );
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.expressions.Arithmetic, java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.expressions.Comparison, java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.expressions.Cast, java.lang.Object)
	 */
	@Override
	public Object visit( Cast cast, Object o ) {
		cast.getExp().accept( this, o );
		generator.cast( cast.getExp().getType(), cast.getCastType() );
		return null;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.expressions.Logical, java.lang.Object)
	 */
	@Override
	public Object visit( Logical logical, Object o ) {
		logical.getLeft().accept( this, o );
		generator.convert( logical.getLeft().getType(), logical.getType() );
		logical.getRight().accept( this, o );
		generator.convert( logical.getRight().getType(), logical.getType() );
		generator.logic( logical.getLogicalOperator() );

		return null;

	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.expressions.UnaryNot, java.lang.Object)
	 */
	@Override
	public Object visit( UnaryNot negation, Object o ) {
		negation.getOperand().accept( this, o );
		generator.not();
		return null;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.expressions.FieldAccess, java.lang.Object)
	 */
	@Override
	public Object visit( FieldAccess fieldAccess, Object o ) {
		fieldAccess.accept( adressCgVisitor, o );
		generator.load( fieldAccess.getType() );
		return null;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.expressions.Indexing, java.lang.Object)
	 */
	@Override
	public Object visit( Indexing indexing, Object o ) {
		indexing.accept( adressCgVisitor, o );
		generator.load( indexing.getType() );
		return null;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.expressions.Invocation, java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.expressions.UnaryMinus, java.lang.Object)
	 */
	@Override
	public Object visit( UnaryMinus unaryMinus, Object o ) {

		unaryMinus.getExpression().accept( this, o );
		generator.push( -1 );
		generator.convert( IntType.getInstance(), unaryMinus.getType() );
		generator.mul( unaryMinus.getExpression().getType() );
		return null;
	}

}
