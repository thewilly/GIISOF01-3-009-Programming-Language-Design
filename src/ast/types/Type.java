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
package ast.types;

import java.util.List;

import ast.ASTNode;
import ast.literals.RecordField;

/**
 * The Interface Type.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public interface Type extends ASTNode {

	/**
	 * Checks if is logical.
	 *
	 * @return true, if is logical
	 */
	boolean isLogical();

	/**
	 * Arithmetic.
	 *
	 * @param type the type
	 * @return the type
	 */
	Type arithmetic( Type type );

	/**
	 * Arithmetic.
	 *
	 * @return the type
	 */
	Type arithmetic();

	/**
	 * Comparison.
	 *
	 * @param type the type
	 * @return the type
	 */
	Type comparison( Type type );

	/**
	 * Logical.
	 *
	 * @param type the type
	 * @return the type
	 */
	Type logical( Type type );

	/**
	 * Logical.
	 *
	 * @return the type
	 */
	Type logical();

	/**
	 * Dot.
	 *
	 * @param s the s
	 * @return the type
	 */
	Type dot( String s );

	/**
	 * Gets the.
	 *
	 * @param identifier the identifier
	 * @return the record field
	 */
	RecordField get( String identifier );

	/**
	 * Square brackets.
	 *
	 * @param type the type
	 * @return the type
	 */
	Type squareBrackets( Type type );

	/**
	 * Can be cast.
	 *
	 * @param type the type
	 * @return the type
	 */
	Type canBeCast( Type type );

	/**
	 * Promotes to.
	 *
	 * @param type the type
	 * @return the type
	 */
	Type promotesTo( Type type );

	/**
	 * Parentesis.
	 *
	 * @param types the types
	 * @return the type
	 */
	Type parentesis( List<Type> types );

	/**
	 * Gets the number of bytes.
	 *
	 * @return the number of bytes
	 */
	int getNumberOfBytes();

	/**
	 * Subfix.
	 *
	 * @return the char
	 */
	char subfix();

	/**
	 * Super type.
	 *
	 * @param type the type
	 * @return the type
	 */
	Type superType( Type type );

	/**
	 * Checks if is builds the in type.
	 *
	 * @return true, if is builds the in type
	 */
	boolean isBuildInType();

	/**
	 * Checks if is reference type.
	 *
	 * @return true, if is reference type
	 */
	boolean isReferenceType();
}
