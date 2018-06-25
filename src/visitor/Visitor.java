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
package visitor;

import ast.Program;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Arithmetic;
import ast.expressions.Cast;
import ast.expressions.Comparison;
import ast.expressions.FieldAccess;
import ast.expressions.Indexing;
import ast.expressions.Invocation;
import ast.expressions.Logical;
import ast.expressions.Negation;
import ast.expressions.UnaryMinus;
import ast.expressions.UnaryNot;
import ast.expressions.Variable;
import ast.literals.CharLiteral;
import ast.literals.IntLiteral;
import ast.literals.RealLiteral;
import ast.literals.RecordField;
import ast.statements.Assignment;
import ast.statements.DoWhileStatement;
import ast.statements.IfStatement;
import ast.statements.Read;
import ast.statements.Return;
import ast.statements.WhileStatement;
import ast.statements.Write;
import ast.types.ArrayType;
import ast.types.CharType;
import ast.types.ErrorType;
import ast.types.FunctionType;
import ast.types.IntType;
import ast.types.RealType;
import ast.types.RecordType;
import ast.types.VoidType;

/**
 * Instance of Visitor.java
 *
 * @author Guillermo Facundo Colunga.
 * @version 201803121239
 * @param <P> the generic type
 * @param <R> the generic type
 */
public interface Visitor<P, R> {

	/**
	 * Visit.
	 *
	 * @param arithmetic the arithmetic
	 * @param param the param
	 * @return the r
	 */
	R visit( Arithmetic arithmetic, P param );

	/**
	 * Visit.
	 *
	 * @param arrayType the array type
	 * @param param the param
	 * @return the r
	 */
	R visit( ArrayType arrayType, P param );

	/**
	 * Visit.
	 *
	 * @param assignment the assignment
	 * @param param the param
	 * @return the r
	 */
	R visit( Assignment assignment, P param );

	/**
	 * Visit.
	 *
	 * @param cast the cast
	 * @param param the param
	 * @return the r
	 */
	R visit( Cast cast, P param );

	/**
	 * Visit.
	 *
	 * @param charLiteral the char literal
	 * @param param the param
	 * @return the r
	 */
	R visit( CharLiteral charLiteral, P param );

	/**
	 * Visit.
	 *
	 * @param charType the char type
	 * @param param the param
	 * @return the r
	 */
	R visit( CharType charType, P param );

	/**
	 * Visit.
	 *
	 * @param comparison the comparison
	 * @param param the param
	 * @return the r
	 */
	R visit( Comparison comparison, P param );

	/**
	 * Visit.
	 *
	 * @param fieldAccess the field access
	 * @param param the param
	 * @return the r
	 */
	R visit( FieldAccess fieldAccess, P param );

	/**
	 * Visit.
	 *
	 * @param funcDefinition the func definition
	 * @param param the param
	 * @return the r
	 */
	R visit( FuncDefinition funcDefinition, P param );

	/**
	 * Visit.
	 *
	 * @param functionType the function type
	 * @param param the param
	 * @return the r
	 */
	R visit( FunctionType functionType, P param );

	/**
	 * Visit.
	 *
	 * @param ifStatement the if statement
	 * @param param the param
	 * @return the r
	 */
	R visit( IfStatement ifStatement, P param );

	/**
	 * Visit.
	 *
	 * @param indexing the indexing
	 * @param param the param
	 * @return the r
	 */
	R visit( Indexing indexing, P param );

	/**
	 * Visit.
	 *
	 * @param intLiteral the int literal
	 * @param param the param
	 * @return the r
	 */
	R visit( IntLiteral intLiteral, P param );

	/**
	 * Visit.
	 *
	 * @param intType the int type
	 * @param param the param
	 * @return the r
	 */
	R visit( IntType intType, P param );

	/**
	 * Visit.
	 *
	 * @param invocation the invocation
	 * @param param the param
	 * @return the r
	 */
	R visit( Invocation invocation, P param );

	/**
	 * Visit.
	 *
	 * @param logical the logical
	 * @param param the param
	 * @return the r
	 */
	R visit( Logical logical, P param );

	/**
	 * Visit.
	 *
	 * @param negation the negation
	 * @param param the param
	 * @return the r
	 */
	R visit( Negation negation, P param );

	/**
	 * Visit.
	 *
	 * @param program the program
	 * @param param the param
	 * @return the r
	 */
	R visit( Program program, P param );

	/**
	 * Visit.
	 *
	 * @param read the read
	 * @param param the param
	 * @return the r
	 */
	R visit( Read read, P param );

	/**
	 * Visit.
	 *
	 * @param realLiteral the real literal
	 * @param param the param
	 * @return the r
	 */
	R visit( RealLiteral realLiteral, P param );

	/**
	 * Visit.
	 *
	 * @param realType the real type
	 * @param param the param
	 * @return the r
	 */
	R visit( RealType realType, P param );

	/**
	 * Visit.
	 *
	 * @param recordField the record field
	 * @param param the param
	 * @return the r
	 */
	R visit( RecordField recordField, P param );

	/**
	 * Visit.
	 *
	 * @param recordType the record type
	 * @param param the param
	 * @return the r
	 */
	R visit( RecordType recordType, P param );

	/**
	 * Visit.
	 *
	 * @param return1 the return 1
	 * @param param the param
	 * @return the r
	 */
	R visit( Return return1, P param );

	/**
	 * Visit.
	 *
	 * @param unaryMinus the unary minus
	 * @param param the param
	 * @return the r
	 */
	R visit( UnaryMinus unaryMinus, P param );

	/**
	 * Visit.
	 *
	 * @param unaryNot the unary not
	 * @param param the param
	 * @return the r
	 */
	R visit( UnaryNot unaryNot, P param );

	/**
	 * Visit.
	 *
	 * @param varDefinition the var definition
	 * @param param the param
	 * @return the r
	 */
	R visit( VarDefinition varDefinition, P param );

	/**
	 * Visit.
	 *
	 * @param variable the variable
	 * @param param the param
	 * @return the r
	 */
	R visit( Variable variable, P param );

	/**
	 * Visit.
	 *
	 * @param voidType the void type
	 * @param param the param
	 * @return the r
	 */
	R visit( VoidType voidType, P param );

	/**
	 * Visit.
	 *
	 * @param whileStatement the while statement
	 * @param param the param
	 * @return the r
	 */
	R visit( WhileStatement whileStatement, P param );
	
	/**
	 * Visit.
	 *
	 * @param doWhileStatement the do while statement
	 * @param param the param
	 * @return the r
	 */
	R visit( DoWhileStatement doWhileStatement, P param );

	/**
	 * Visit.
	 *
	 * @param write the write
	 * @param param the param
	 * @return the r
	 */
	R visit( Write write, P param );

	/**
	 * Visit.
	 *
	 * @param errorType the error type
	 * @param param the param
	 * @return the r
	 */
	R visit( ErrorType errorType, P param );

}
