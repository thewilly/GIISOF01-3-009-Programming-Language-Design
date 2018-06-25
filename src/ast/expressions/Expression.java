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
package ast.expressions;

import ast.ASTNode;
import ast.types.Type;

/**
 * Instance of Espression, represents only those nodes of the AST tree that are
 * expressions.
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802112343
 */
public interface Expression extends ASTNode {

	/**
	 * Gets the l value.
	 *
	 * @return the l value
	 */
	public boolean getLValue();

	/**
	 * Sets the l value.
	 *
	 * @param lValue the new l value
	 */
	public void setLValue( boolean lValue );

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	Type getType();

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	void setType( Type type );

}
