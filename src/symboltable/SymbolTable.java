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

import java.util.HashMap;
import java.util.LinkedList;

import ast.Definition;
import ast.VarDefinition;

/**
 * Instance of SymbolTable.java
 * 
 * @author
 * @version
 */
public class SymbolTable {

	private LinkedList<HashMap<String, Definition>> tables;
	private int scope = 0;

	private static SymbolTable instance;

	public static SymbolTable getInstance() {
		if (instance == null)
			instance = new SymbolTable();
		return instance;
	}

	public SymbolTable() {
		tables = new LinkedList<HashMap<String, Definition>>();
		tables.add( new HashMap<String, Definition>() );
	}

	public boolean insert( Definition definition ) {

		if (tables.getLast().containsKey( definition.getName() ))
			return false;

		if (definition instanceof VarDefinition)
			( (VarDefinition) definition ).setScope( this.scope );

		tables.getLast().put( definition.getName(), definition );
		return true;
	}

	public Definition find( String name ) {
		for (HashMap<String, Definition> table : tables) {
			if (table.containsKey( name ))
				return table.get( name );
		}
		return null;
	}

	public void set() {
		this.scope++;
		this.tables.addLast( new HashMap<String, Definition>() );
	}

	public void reset() {
		this.scope--;
		this.tables.removeLast();
	}

	public Definition findInCurrentScope( String name ) {
		if (tables.getLast().containsKey( name ))
			return tables.getLast().get( name );
		return null;
	}

}
