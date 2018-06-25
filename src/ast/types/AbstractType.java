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
package ast.types;

import java.util.List;

import ast.ASTNode;
import ast.literals.RecordField;
import visitor.Visitor;

/**
 * Instance of AbstractType.java
 * 
 * @author
 * @version
 */
public abstract class AbstractType implements Type {

	/** The row. */
	protected int row = ASTNode.DEFAULT_ROW_COLUMN;
	
	/** The column. */
	protected int column = ASTNode.DEFAULT_ROW_COLUMN;

	/* (non-Javadoc)
	 * @see ast.types.Type#isLogical()
	 */
	@Override
	public boolean isLogical() {
		return false;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#getLine()
	 */
	@Override
	public int getLine() {
		return row;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#getColumn()
	 */
	@Override
	public int getColumn() {
		return column;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(visitor.Visitor, java.lang.Object)
	 */
	@Override
	public <P, R> R accept( Visitor<P, R> visitor, P param ) {
		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#arithmetic(ast.types.Type)
	 */
	@Override
	public Type arithmetic( Type type ) {
		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#arithmetic()
	 */
	@Override
	public Type arithmetic() {
		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#comparison(ast.types.Type)
	 */
	@Override
	public Type comparison( Type type ) {
		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#logical(ast.types.Type)
	 */
	@Override
	public Type logical( Type type ) {
		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#logical()
	 */
	@Override
	public Type logical() {
		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#dot(java.lang.String)
	 */
	@Override
	public Type dot( String s ) {
		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#squareBrackets(ast.types.Type)
	 */
	@Override
	public Type squareBrackets( Type type ) {
		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#canBeCast(ast.types.Type)
	 */
	@Override
	public Type canBeCast( Type type ) {
		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#promotesTo(ast.types.Type)
	 */
	@Override
	public Type promotesTo( Type type ) {
		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#parentesis(java.util.List)
	 */
	@Override
	public Type parentesis( List<Type> types ) {
		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#subfix()
	 */
	@Override
	public char subfix() {
		return ' ';
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#superType(ast.types.Type)
	 */
	@Override
	public Type superType( Type type ) {
		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#isBuildInType()
	 */
	@Override
	public boolean isBuildInType() {
		return false;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#get(java.lang.String)
	 */
	@Override
	public RecordField get( String identifier ) {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see ast.types.Type#isReferenceType()
	 */
	@Override
	public boolean isReferenceType() {
		return false;
	}
}
