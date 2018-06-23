/*
 * This source file is part of the PmmCompiler open source project.
 *
 * Copyright (c) 2018 willy and the PmmCompiler project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
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

	private List<Map<String, Definition>> table;
	private int scope = 0;

	public SymbolTable() {
		table = new ArrayList<Map<String, Definition>>();
		table.add( new HashMap<String, Definition>() );
	}

	public void set() {
		table.add( new HashMap<String, Definition>() );
		this.scope++;
	}

	public void reset() {
		table.remove( this.scope );
		this.scope--;
	}

	public boolean insert( Definition definition ) {
		if (definition != null && findInCurrentScope( definition.getName() ) == null) {
			this.table.get( this.scope ).put( definition.getName(), definition );
			definition.setScope( this.scope );
			return true;
		}
		return false;
	}

	public Definition find( String id ) {
		for (int i = this.scope; i >= 0; i--) {
			if (this.table.get( i ).containsKey( id )) {
				return this.table.get( i ).get( id );
			}
		}
		return null;
	}

	public Definition findInCurrentScope( String id ) {
		return this.table.get( this.scope ).get( id );
	}

}
