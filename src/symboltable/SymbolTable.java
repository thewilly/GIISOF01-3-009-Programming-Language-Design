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
package symboltable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ast.definitions.Definition;

/**
 * Instance of SymbolTable.java
 * 
 * @author
 * @version
 */
public class SymbolTable {

	/** The table. */
	private List<Map<String, Definition>> table;
	
	/** The scope. */
	private int scope = 0;

	/**
	 * Instantiates a new symbol table.
	 */
	public SymbolTable() {
		table = new ArrayList<Map<String, Definition>>();
		table.add( new HashMap<String, Definition>() );
	}

	/**
	 * Sets the.
	 */
	public void set() {
		table.add( new HashMap<String, Definition>() );
		this.scope++;
	}

	/**
	 * Reset.
	 */
	public void reset() {
		table.remove( this.scope );
		this.scope--;
	}

	/**
	 * Insert.
	 *
	 * @param definition the definition
	 * @return true, if successful
	 */
	public boolean insert( Definition definition ) {
		if (definition != null && findInCurrentScope( definition.getName() ) == null) {
			this.table.get( this.scope ).put( definition.getName(), definition );
			definition.setScope( this.scope );
			return true;
		}
		return false;
	}

	/**
	 * Find.
	 *
	 * @param id the id
	 * @return the definition
	 */
	public Definition find( String id ) {
		for (int i = this.scope; i >= 0; i--) {
			if (this.table.get( i ).containsKey( id )) {
				return this.table.get( i ).get( id );
			}
		}
		return null;
	}

	/**
	 * Find in current scope.
	 *
	 * @param id the id
	 * @return the definition
	 */
	public Definition findInCurrentScope( String id ) {
		return this.table.get( this.scope ).get( id );
	}

}
