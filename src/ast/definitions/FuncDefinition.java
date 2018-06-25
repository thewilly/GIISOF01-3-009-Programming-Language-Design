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

import java.util.List;

import ast.ASTNode;
import ast.statements.Statement;
import ast.types.FunctionType;
import ast.types.Type;
import visitor.Visitor;

/**
 * The Class FuncDefinition.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class FuncDefinition implements Definition {

	/** The statements. */
	private List<Statement> statements;
	
	/** The name. */
	private String name;
	
	/** The type. */
	private Type type;
	
	/** The scope. */
	private int scope;

	/** The row. */
	private int row = ASTNode.DEFAULT_ROW_COLUMN;
	
	/** The column. */
	private int column = ASTNode.DEFAULT_ROW_COLUMN;

	/**
	 * Instantiates a new func definition.
	 *
	 * @param i the i
	 * @param j the j
	 * @param name the name
	 * @param type the type
	 * @param statements the statements
	 */
	public FuncDefinition( int i, int j, String name, Type type, List<Statement> statements ) {
		this.row = i;
		this.column = j;
		this.statements = statements;
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
	 * @see ast.definitions.Definition#setType(ast.types.Type)
	 */
	public void setType( Type type ) {
		this.type = type;
	}

	/**
	 * Gets the statements.
	 *
	 * @return the statements
	 */
	public List<Statement> getStatements() {
		return statements;
	}

	/**
	 * Sets the statements.
	 *
	 * @param statements the new statements
	 */
	public void setStatements( List<Statement> statements ) {
		this.statements = statements;
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
	 * @see ast.definitions.Definition#getScope()
	 */
	@Override
	public int getScope() {
		return this.scope;
	}

	/* (non-Javadoc)
	 * @see ast.definitions.Definition#setScope(int)
	 */
	@Override
	public void setScope( int scope ) {
		this.scope = scope;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder funcDef = new StringBuilder();
		funcDef.append( "def " + this.name + this.type.toString() + " {\n" );
		for (Statement statement : this.getStatements()) {
			funcDef.append( "\n \t" + statement.toString() );
		}
		funcDef.append( "\n}" );
		return funcDef.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see ast.ASTNode#accept(ast.Visitor, java.lang.Object)
	 */
	@Override
	public <P, R> R accept( Visitor<P, R> visitor, P param ) {
		return visitor.visit( this, param );
	}

	/**
	 * Local bytes.
	 *
	 * @return the int
	 */
	public int localBytes() {
		int total = 0;
		for (Statement s : statements) {
			if (s instanceof VarDefinition) {
				total += ( (VarDefinition) s ).getType().getNumberOfBytes();
			}
		}
		return total;
	}

	/**
	 * Param bytes.
	 *
	 * @return the int
	 */
	public int paramBytes() {
		int total = 0;
		for (VarDefinition v : ( (FunctionType) getType() ).getParameters()) {
			total += v.getType().getNumberOfBytes();

		}
		return total;
	}

	/* (non-Javadoc)
	 * @see ast.statements.Statement#promotesToReturn()
	 */
	@Override
	public boolean promotesToReturn() {
		return false;
	}

}
