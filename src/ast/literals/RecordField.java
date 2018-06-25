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
package ast.literals;

import ast.ASTNode;
import ast.types.Type;
import visitor.Visitor;

/**
 * The Class RecordField.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class RecordField implements ASTNode {

	/** The column. */
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	/** The name. */
	private String name;
	
	/** The type. */
	private Type type;
	
	/** The offset. */
	private int offset;

	/**
	 * Instantiates a new record field.
	 *
	 * @param row the row
	 * @param column the column
	 * @param name the name
	 * @param type the type
	 * @param offset the offset
	 */
	public RecordField( int row, int column, String name, Type type, int offset ) {
		this.row = row;
		this.column = column;
		this.name = name;
		this.type = type;
		this.offset = offset;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName( String name ) {
		this.name = name;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType( Type type ) {
		this.type = type;
	}

	/**
	 * Gets the offset.
	 *
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * Sets the offset.
	 *
	 * @param offset the new offset
	 */
	public void setOffset( int offset ) {
		this.offset = offset;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name + ":" + this.type.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals( Object other ) {
		if (other == null)
			return false;
		if (!( other instanceof RecordField ))
			return false;
		RecordField otherField = (RecordField) other;
		if (this.getName().equals( otherField.getName() ))
			return true;
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ast.ASTNode#accept(ast.Visitor, java.lang.Object)
	 */
	@Override
	public <P, R> R accept( Visitor<P, R> visitor, P param ) {
		return visitor.visit( this, param );
	}
}
