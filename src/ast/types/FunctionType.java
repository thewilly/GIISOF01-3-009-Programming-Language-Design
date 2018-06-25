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
import ast.definitions.VarDefinition;
import visitor.Visitor;

/**
 * The Class FunctionType.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class FunctionType extends AbstractType {

	/** The column. */
	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	/** The return type. */
	private Type returnType;
	
	/** The parameters. */
	private List<VarDefinition> parameters;

	/**
	 * Instantiates a new function type.
	 *
	 * @param row the row
	 * @param column the column
	 * @param returnType the return type
	 * @param parameters the parameters
	 */
	public FunctionType( int row, int column, Type returnType, List<VarDefinition> parameters ) {
		this.row = row;
		this.column = column;
		this.returnType = returnType;
		this.parameters = parameters;
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
	 * Gets the return type.
	 *
	 * @return the return type
	 */
	public Type getReturnType() {
		return returnType;
	}

	/**
	 * Sets the return type.
	 *
	 * @param returnType the new return type
	 */
	public void setReturnType( Type returnType ) {
		this.returnType = returnType;
	}

	/**
	 * Gets the parameters.
	 *
	 * @return the parameters
	 */
	public List<VarDefinition> getParameters() {
		return parameters;
	}

	/**
	 * Sets the parameters.
	 *
	 * @param parameters the new parameters
	 */
	public void setParameters( List<VarDefinition> parameters ) {
		this.parameters = parameters;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder functionType = new StringBuilder();
		functionType.append( "(" );

		for (VarDefinition varDef : this.getParameters()) {
			if (varDef.equals( this.getParameters().get( 0 ) ))
				functionType.append( varDef.toString() );
			else
				functionType.append( ", " + varDef.toString() );
		}

		functionType.append( "):" );
		functionType.append( getReturnType().toString() );

		return functionType.toString();
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
	 * @see ast.types.AbstractType#parentesis(java.util.List)
	 */
	@Override
	public Type parentesis( List<Type> types ) {
		if (types.size() == parameters.size()) {
			for (int i = 0; i < types.size(); i++) {
				System.out.println( "Parameters value: " + parameters );
				System.out.println( "Types value: " + types );
				System.out.println( "Parameters " + i + " type: " + parameters.get( i ).getType() );
				if (types.get( i ).promotesTo( parameters.get( i ).getType() ) == null) {
					return null;
				}
			}
			return returnType;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see ast.types.Type#getNumberOfBytes()
	 */
	@Override
	public int getNumberOfBytes() {
		if (this.getReturnType() instanceof VoidType) {
			return 0;
		}

		if (this.getReturnType() instanceof ErrorType) {
			throw new IllegalStateException();
		}

		return this.getReturnType().getNumberOfBytes();
	}

	/*
	 * (non-Javadoc)
	 * @see ast.Type#subfix()
	 */
	@Override
	public char subfix() {
		return this.returnType.subfix();
	}
}
