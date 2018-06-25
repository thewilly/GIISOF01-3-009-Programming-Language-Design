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
package errorhandler;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import ast.types.ErrorType;

/**
 * Instance of EH.java
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802051217
 */
public class EH {

	/** The errors. */
	private List<ErrorType> errors = new ArrayList<ErrorType>();
	
	/** The instance. */
	private static EH instance;

	/**
	 * Gets the single instance of EH.
	 *
	 * @return single instance of EH
	 */
	public static EH getInstance() {
		if (instance == null) {
			return instance = new EH();
		}
		return instance;
	}

	/**
	 * Checks for errors.
	 *
	 * @return true, if successful
	 */
	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	/**
	 * Adds the error.
	 *
	 * @param error the error
	 */
	public void addError( ErrorType error ) {
		errors.add( error );
	}

	/**
	 * Show errors.
	 *
	 * @param stream the stream
	 */
	public void showErrors( PrintStream stream ) {
		for (ErrorType error : errors) {
			stream.println( "EERROR : At " + error.getLine() + ", " + error.getColumn() + ". "
					+ error.getMessage() );
		}
	}
}
