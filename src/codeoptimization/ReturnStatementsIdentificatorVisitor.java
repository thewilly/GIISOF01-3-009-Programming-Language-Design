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
package codeoptimization;

import ast.statements.IfStatement;
import ast.statements.Statement;
import visitor.AbstractVisitor;

/**
 * The Class ReturnStatementsIdentificatorVisitor.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class ReturnStatementsIdentificatorVisitor extends AbstractVisitor<Object, Object> {

	/* (non-Javadoc)
	 * @see visitor.AbstractVisitor#visit(ast.statements.IfStatement, java.lang.Object)
	 */
	@Override
	public Object visit( IfStatement ifStatement, Object o ) {

		for (Statement s : ifStatement.getIfBody()) {
			s.accept( this, null );
			if (s.promotesToReturn()) {
				ifStatement.setIfBodyReturns( true );
				break;
			}
		}
		if(ifStatement.getElseBody()== null) {
			return null;
		}
		
		for (Statement s : ifStatement.getElseBody()) {
			s.accept( this, null );
			if (s.promotesToReturn()) {
				ifStatement.setElseBodyReturs( true );
				break;
			}
		}

		return null;
	}
}
