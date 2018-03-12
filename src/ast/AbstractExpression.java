/*
 * This source file is part of the PmmCompiler open source project.
 *
 * Copyright (c) 2018 willy and the PmmCompiler project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package ast;

/**
 * Instance of AbstractExpression.java
 * 
 * @author 
 * @version 
 */
public abstract class AbstractExpression implements Expression {
    
    private boolean lValue = false;

    /* (non-Javadoc)
     * @see ast.Expression#getLValue()
     */
    @Override
    public boolean getLValue() {
	return this.lValue;
    }

    /* (non-Javadoc)
     * @see ast.Expression#setLValue(boolean)
     */
    @Override
    public void setLValue(boolean lValue) {
	this.lValue = lValue;
    }

}
