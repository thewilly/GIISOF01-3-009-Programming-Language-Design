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
 * The Class RecordType.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class RecordType extends AbstractType {

	/** The column. */
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	/** The fields. */
	private List<RecordField> fields;

	/**
	 * Instantiates a new record type.
	 *
	 * @param row the row
	 * @param column the column
	 * @param fields the fields
	 */
	public RecordType( int row, int column, List<RecordField> fields ) {
		this.row = row;
		this.column = column;
		this.fields = fields;
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
	 * Gets the fields.
	 *
	 * @return the fields
	 */
	public List<RecordField> getFields() {
		return fields;
	}

	/**
	 * Sets the fields.
	 *
	 * @param fields the new fields
	 */
	public void setFields( List<RecordField> fields ) {
		this.fields = fields;
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
		StringBuilder recordType = new StringBuilder();
		recordType.append( "struct {" );
		for (RecordField r : this.getFields()) {
			recordType.append( " \t" + r.toString() );
		}
		recordType.append( " }" );
		return recordType.toString();
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
	 * @see ast.types.AbstractType#dot(java.lang.String)
	 */
	@Override
	public Type dot( String identifier ) {
		for (RecordField r : getFields()) {
			if (r.getName().equals( identifier )) {
				return r.getType();
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#getNumberOfBytes()
	 */
	@Override
	public int getNumberOfBytes() {
		int numberOfBytes = 0;
		for (RecordField field : this.getFields()) {
			numberOfBytes += field.getType().getNumberOfBytes();
		}
		return numberOfBytes;
	}

	/* (non-Javadoc)
	 * @see ast.types.AbstractType#get(java.lang.String)
	 */
	@Override
	public RecordField get( String nombre ) {
		for (RecordField r : fields) {
			if (nombre.equals( r.getName() )) {
				return r;
			}
		}
		return null;
	}
}
