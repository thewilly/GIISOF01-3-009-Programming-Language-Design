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

import ast.ASTNode;
import visitor.Visitor;

/**
 * The Class CharType.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class CharType extends AbstractType {

	/** The column. */
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	/** The Constant NUMBER_OF_BYTES. */
	private static final int NUMBER_OF_BYTES = 1;

	/** The instance. */
	private static CharType instance = new CharType();

	/**
	 * Instantiates a new char type.
	 */
	private CharType() {}

	/**
	 * Gets the single instance of CharType.
	 *
	 * @return single instance of CharType
	 */
	public static CharType getInstance() {
		if (instance == null)
			instance = new CharType();
		return instance;
	}

	/* (non-Javadoc)
	 * @see ast.types.AbstractType#getLine()
	 */
	@Override
	public int getLine() {
		return row;
	}

	/* (non-Javadoc)
	 * @see ast.types.AbstractType#getColumn()
	 */
	@Override
	public int getColumn() {
		return column;
	}

	/**
	 * Gets the row.
	 *
	 * @return the row
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * Sets the row.
	 *
	 * @param row the new row
	 */
	public void setRow( int row ) {
		this.row = row;
	}

	/**
	 * Sets the column.
	 *
	 * @param column the new column
	 */
	public void setColumn( int column ) {
		this.column = column;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "char";
	}

	/*
	 * (non-Javadoc)
	 * @see ast.ASTNode#accept(ast.Visitor, java.lang.Object)
	 */
	@Override
	public <P, R> R accept( Visitor<P, R> visitor, P param ) {
		return visitor.visit( this, param );
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#getNumberOfBytes()
	 */
	@Override
	public int getNumberOfBytes() {
		return NUMBER_OF_BYTES;
	}

	/* (non-Javadoc)
	 * @see ast.types.AbstractType#arithmetic(ast.types.Type)
	 */
	@Override
	public Type arithmetic( Type type ) {

		if (type instanceof ErrorType || type instanceof RealType || type instanceof IntType) {
			return type;
		}

		if (type instanceof CharType) {
			return this;
		}

		return null;

	}

	/* (non-Javadoc)
	 * @see ast.types.AbstractType#comparison(ast.types.Type)
	 */
	@Override
	public Type comparison( Type type ) {
		if (type instanceof ErrorType) {
			return type;
		}

		if (type instanceof CharType || type instanceof IntType || type instanceof RealType) {
			return IntType.getInstance();
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.AbstractType#logical(ast.types.Type)
	 */
	@Override
	public Type logical( Type type ) {
		if (type instanceof ErrorType) {
			return type;
		}

		if (type instanceof CharType || type instanceof IntType) {
			return IntType.getInstance();
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.AbstractType#logical()
	 */
	@Override
	public Type logical() {
		return this;
	}

	/* (non-Javadoc)
	 * @see ast.types.AbstractType#canBeCast(ast.types.Type)
	 */
	@Override
	public Type canBeCast( Type type ) {
		if (type instanceof ErrorType) {
			return type;
		}

		if (type instanceof CharType) {
			return this;
		}

		if (type instanceof IntType) {
			return this;
		}

		if (type instanceof RealType) {
			return this;
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.AbstractType#promotesTo(ast.types.Type)
	 */
	@Override
	public Type promotesTo( Type type ) {
		if (type instanceof ErrorType || type instanceof IntType || type instanceof RealType) {
			return type;
		}

		if (type instanceof CharType) {
			return this;
		}
		
		if (type instanceof ReferenceType) {
			return this.promotesTo( type.promotesTo( (( ReferenceType ) type).getOfType() ) );
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.AbstractType#isBuildInType()
	 */
	@Override
	public boolean isBuildInType() {
		return true;
	}

	/* (non-Javadoc)
	 * @see ast.types.AbstractType#subfix()
	 */
	@Override
	public char subfix() {
		return 'B';
	}

	/* (non-Javadoc)
	 * @see ast.types.AbstractType#superType(ast.types.Type)
	 */
	@Override
	public Type superType( Type type ) {

		if (type instanceof ErrorType || type instanceof RealType || type instanceof IntType) {
			return type;
		}

		if (type instanceof CharType) {
			return IntType.getInstance();
		}

		return null;
	}
}
