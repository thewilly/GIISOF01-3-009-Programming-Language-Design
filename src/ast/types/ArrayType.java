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
 * The Class ArrayType.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class ArrayType extends AbstractType {

	/** The column. */
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	/** The offset. */
	private int offset;
	
	/** The array type. */
	private Type arrayType;

	/**
	 * Instantiates a new array type.
	 *
	 * @param row the row
	 * @param column the column
	 * @param offset the offset
	 * @param arrayType the array type
	 */
	public ArrayType( int row, int column, int offset, Type arrayType ) {
		super();
		this.row = row;
		this.column = column;
		this.offset = offset;
		this.arrayType = arrayType;
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

	/**
	 * Gets the off.
	 *
	 * @return the off
	 */
	public int getOff() {
		return offset;
	}

	/**
	 * Sets the off.
	 *
	 * @param off the new off
	 */
	public void setOff( int off ) {
		this.offset = off;
	}

	/**
	 * Gets the of.
	 *
	 * @return the of
	 */
	public Type getOf() {
		return arrayType;
	}

	/**
	 * Sets the array type.
	 *
	 * @param arrayType the new array type
	 */
	public void setArrayType( Type arrayType ) {
		this.arrayType = arrayType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + this.offset + "]" + this.arrayType.toString();
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
	 * @see ast.types.AbstractType#squareBrackets(ast.types.Type)
	 */
	@Override
	public Type squareBrackets( Type type ) {

		if (type instanceof ErrorType) {
			return type;
		}

		if (type instanceof IntType) {
			return arrayType;
		}

		System.out.println( type.getClass().toString() );

		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#getNumberOfBytes()
	 */
	@Override
	public int getNumberOfBytes() {
		return arrayType.getNumberOfBytes() * offset;
	}

}
