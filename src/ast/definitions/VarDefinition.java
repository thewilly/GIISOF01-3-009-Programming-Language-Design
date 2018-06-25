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
package ast.definitions;

import ast.ASTNode;
import ast.types.Type;
import visitor.Visitor;

/**
 * The Class VarDefinition.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class VarDefinition implements Definition {

	/** The column. */
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	/** The offset. */
	private int scope = 0, offset;
	
	/** The name. */
	private String name;
	
	/** The type. */
	private Type type;

	/**
	 * Instantiates a new var definition.
	 *
	 * @param row the row
	 * @param column the column
	 * @param name the name
	 * @param type the type
	 */
	public VarDefinition( int row, int column, String name, Type type ) {
		this.row = row;
		this.column = column;
		this.name = name;
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see ast.definitions.Definition#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see ast.definitions.Definition#getType()
	 */
	@Override
	public Type getType() {
		return type;
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
	 * @see ast.definitions.Definition#getScope()
	 */
	@Override
	public int getScope() {
		return scope;
	}

	/* (non-Javadoc)
	 * @see ast.definitions.Definition#setScope(int)
	 */
	@Override
	public void setScope( int scope ) {
		this.scope = scope;
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
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName( String name ) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see ast.definitions.Definition#setType(ast.types.Type)
	 */
	public void setType( Type type ) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name + ":" + this.type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals( Object other ) {
		if (other == null)
			return false;
		if (!( other instanceof VarDefinition ))
			return false;
		VarDefinition variable = (VarDefinition) other;
		return ( this.getName().equals( variable.getName() )
				&& this.getScope() == variable.getScope() );
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
