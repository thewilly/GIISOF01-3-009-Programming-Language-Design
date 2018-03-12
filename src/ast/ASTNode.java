/*
 * This source file is part of the lab01 open source project.
 *
 * Copyright (c) 2018 willy and the lab01 project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package ast;

import visitor.Visitor;

/**
 * Instance of ASTNode java class, represents a node in the AST tree and
 * therefore will declare those common methods to all nodes in the AST tree.
 * 
 * @author Guillermo Facunod Colunga
 * @version 201802112329
 */
public interface ASTNode {

    public final static int DEFAULT_ROW_COLUMN = -1;

    /**
     * Gets the line where the element that is contained by the node is written.
     * 
     * @return the line where the element that the node contains is written in the
     *         input file.
     */
    public int getLine();

    /**
     * Gets the column where the element that is contained by the node is written.
     * 
     * @return the column where the element that the node contains is written in the
     *         input file.
     */
    public int getColumn();
    
    /**
     * Accept method for the visitor template.
     * 
     * @param visitor to accept.
     * @param param to pass to the visitor.
     * @return a return type if need.
     */
    public <P,R> R accept(Visitor<P,R> visitor, P param);

}
