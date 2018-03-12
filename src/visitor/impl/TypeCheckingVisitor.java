/*
 * This source file is part of the PmmCompiler open source project.
 *
 * Copyright (c) 2018 willy and the PmmCompiler project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package visitor.impl;

import ast.Arithmetic;
import ast.Assignment;
import ast.Indexing;
import ast.Read;
import ast.Variable;
import errorhandler.ErrorType;
import visitor.AbstractVisitor;

/**
 * Instance of TypeCheckingVisitor.java
 * 
 * @author
 * @version
 */
public class TypeCheckingVisitor extends AbstractVisitor<Object, Object> {

    @Override
    public Object visit(Variable var, Object param) {
	var.setLValue(true);
	return true;
    }

    @Override
    public Object visit(Arithmetic arithmetic, Object param) {
	arithmetic.getLeft().accept(this, param);
	arithmetic.getRight().accept(this, param);
	arithmetic.setLValue(false);
	return null;
    }
    
    @Override
    public Object visit(Assignment assignment, Object param) {
	assignment.getLeft().accept(this, param);
	assignment.getRight().accept(this, param);
	if(!assignment.getLeft().getLValue())
	    new ErrorType(assignment.getLeft(), "Lvalue expected at: " +assignment.getLeft().getClass().getName());
	return null;
    }
    
    @Override
    public Object visit(Indexing indexing, Object param) {
	indexing.getVariable().accept(this, param);
	indexing.getArguments().accept(this, param);
	indexing.setLValue(true);
	return null;
    }
    
    @Override
    public Object visit(Read read, Object param) {
	read.getExpression().accept(this, param);
	
	if(!read.getExpression().getLValue())
	    new ErrorType(read.getExpression(), "Lvalue expected at: " +read.getExpression().getClass().getName());
	return null;
    }

}
