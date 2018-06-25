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

/**
 * The Class ReferenceType.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class ReferenceType extends AbstractType {

	/** The column. */
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
	
	/** The of type. */
	private Type ofType;
	
	/**
	 * Instantiates a new reference type.
	 *
	 * @param row the row
	 * @param column the column
	 * @param ofType the of type
	 */
	public ReferenceType(int row, int column, Type ofType) {
		this.row = row;
		this.column = column;
		this.ofType = ofType;
	}
	
	/**
	 * Sets the type of reference.
	 *
	 * @param type the new type of reference
	 */
	public void setTypeOfReference(Type type) {
		this.ofType = type;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#getNumberOfBytes()
	 */
	@Override
	public int getNumberOfBytes() {
		return this.ofType.getNumberOfBytes();
	}
	
	/* (non-Javadoc)
	 * @see ast.types.AbstractType#getLine()
	 */
	@Override
	public int getLine() {
		return this.row;
	}
	
	/* (non-Javadoc)
	 * @see ast.types.AbstractType#getColumn()
	 */
	@Override
	public int getColumn() {
		return this.column;
	}
	
	/**
	 * Gets the of type.
	 *
	 * @return the of type
	 */
	public Type getOfType() {
		return this.ofType;
	}
	
	/* (non-Javadoc)
	 * @see ast.types.AbstractType#subfix()
	 */
	@Override
	public char subfix() {
		return this.ofType.subfix();
	}
	
	/* (non-Javadoc)
	 * @see ast.types.AbstractType#isReferenceType()
	 */
	@Override
	public boolean isReferenceType() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see ast.types.AbstractType#promotesTo(ast.types.Type)
	 */
	@Override
	public Type promotesTo( Type type ) {
		return this.ofType.promotesTo( type );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "[ReferenceType] : " + this.ofType;
	}
}
