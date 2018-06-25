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
package symboltable;

import ast.definitions.VarDefinition;

/**
 * The Class SymbolTableTest.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class SymbolTableTest {

	/**
	 * Test insert.
	 */
	public void testInsert() {
		SymbolTable st = new SymbolTable();
		VarDefinition definition = new VarDefinition( 0, 0, "a", null );
		assert st.insert( definition );
		assert definition.getScope() == 0;
		assert !st.insert( definition );
		st.set();
		VarDefinition definition2 = new VarDefinition( 0, 0, "a", null );
		assert st.insert( definition2 );
		assert definition2.getScope() == 1;
		assert !st.insert( definition2 );
		st.reset();
		assert !st.insert( definition );
	}

	/**
	 * Test find.
	 */
	public void testFind() {
		SymbolTable st = new SymbolTable();
		VarDefinition varDefinition = new VarDefinition( 0, 0, "a", null );
		assert st.insert( varDefinition );
		assert st.find( "a" ) != null;
		assert st.find( "b" ) == null;
		st.set();
		VarDefinition varDefinition2 = new VarDefinition( 0, 0, "b", null );
		assert st.insert( varDefinition2 );
		assert st.find( "b" ) != null;
		assert st.find( "a" ) != null;
		assert st.find( "c" ) == null;
		st.reset();
		assert st.find( "a" ) != null;
		assert st.find( "b" ) == null;
	}

	/**
	 * Test find in current scope.
	 */
	public void testFindInCurrentScope() {
		SymbolTable st = new SymbolTable();
		VarDefinition varDefinition = new VarDefinition( 0, 0, "a", null );
		assert st.insert( varDefinition );
		assert st.findInCurrentScope( "a" ) != null;
		assert st.findInCurrentScope( "b" ) == null;
		st.set();
		VarDefinition varDefinition2 = new VarDefinition( 0, 0, "b", null );
		assert st.insert( varDefinition2 );
		assert st.findInCurrentScope( "b" ) != null;
		assert st.findInCurrentScope( "a" ) == null;
		assert st.findInCurrentScope( "c" ) == null;
		st.reset();
		assert st.findInCurrentScope( "a" ) != null;
		assert st.findInCurrentScope( "b" ) == null;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main( String[] args ) {
		SymbolTableTest test = new SymbolTableTest();
		test.testInsert();
		test.testFind();
		test.testFindInCurrentScope();
	}

}
