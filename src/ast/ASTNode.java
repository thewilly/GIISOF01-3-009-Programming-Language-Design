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

	/** The Constant DEFAULT_ROW_COLUMN. */
	public final static int DEFAULT_ROW_COLUMN = -1;

	/**
	 * Gets the line where the element that is contained by the node is written.
	 * 
	 * @return the line where the element that the node contains is written in
	 *         the input file.
	 */
	public int getLine();

	/**
	 * Gets the column where the element that is contained by the node is
	 * written.
	 * 
	 * @return the column where the element that the node contains is written in
	 *         the input file.
	 */
	public int getColumn();

	/**
	 * Accept method for the visitor template.
	 *
	 * @param <P> the generic type
	 * @param <R> the generic type
	 * @param visitor to accept.
	 * @param param to pass to the visitor.
	 * @return a return type if need.
	 */
	public <P, R> R accept( Visitor<P, R> visitor, P param );

}
