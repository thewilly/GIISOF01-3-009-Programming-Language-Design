/*
 * This source file is part of the PmmCompiler open source project.
 *
 * Copyright (c) 2018 willy and the PmmCompiler project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package ast.types;

import java.util.List;

import ast.ASTNode;
import ast.literals.RecordField;
import visitor.Visitor;

/**
 * Instance of AbstractType.java
 * 
 * @author
 * @version
 */
public abstract class AbstractType implements Type {

	protected int row = ASTNode.DEFAULT_ROW_COLUMN;
	protected int column = ASTNode.DEFAULT_ROW_COLUMN;

	@Override
	public boolean isLogical() {
		return false;
	}

	@Override
	public int getLine() {
		return row;
	}

	@Override
	public int getColumn() {
		return column;
	}

	@Override
	public <P, R> R accept( Visitor<P, R> visitor, P param ) {
		return null;
	}

	@Override
	public Type arithmetic( Type type ) {
		return null;
	}

	@Override
	public Type arithmetic() {
		return null;
	}

	@Override
	public Type comparison( Type type ) {
		return null;
	}

	@Override
	public Type logical( Type type ) {
		return null;
	}

	@Override
	public Type logical() {
		return null;
	}

	@Override
	public Type dot( String s ) {
		return null;
	}

	@Override
	public Type squareBrackets( Type type ) {
		return null;
	}

	@Override
	public Type canBeCast( Type type ) {
		return null;
	}

	@Override
	public Type promotesTo( Type type ) {
		return null;
	}

	@Override
	public Type parentesis( List<Type> types ) {
		return null;
	}

	@Override
	public char subfix() {
		return ' ';
	}

	@Override
	public Type superType( Type type ) {
		return null;
	}

	@Override
	public boolean isBuildInType() {
		return false;
	}

	@Override
	public RecordField get( String identifier ) {
		return null;
	}
	
	@Override
	public boolean isReferenceType() {
		return false;
	}
}
