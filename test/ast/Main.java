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

import parser.*;
import visitor.impl.IdentificationVisitor;
import visitor.impl.OffsetVisitor;
import visitor.impl.TypeCheckingVisitor;

import org.antlr.v4.runtime.*;

import ast.Program;
import codegeneration.ExecuteCodeGeneratorVisitor;
import codeoptimization.ReturnStatementsIdentificatorVisitor;
import errorhandler.EH;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;

/**
 * The Class Main.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main( String... args ) throws Exception {
		if (args.length < 1) {
			System.err.println( "Please, pass me the input file." );
			return;
		}

		// create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName( args[0] );
		PmmLexer lexer = new PmmLexer( input );

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream( lexer );
		PmmParser parser = new PmmParser( tokens );
		Program ast = parser.program().ast;

		ast.accept( new IdentificationVisitor(), null );

		// * Check errors
		if (EH.getInstance().hasErrors()) {

			// * Show errors
			EH.getInstance().showErrors( System.err );

		} else {

			ast.accept( new TypeCheckingVisitor(), null );

			if (EH.getInstance().hasErrors()) {

				EH.getInstance().showErrors( System.err );

			} else {

				ast.accept( new OffsetVisitor(), null );

				if (EH.getInstance().hasErrors()) {

					EH.getInstance().showErrors( System.err );

				} else {
					ast.accept( new ReturnStatementsIdentificatorVisitor(), null );
					ast.accept( new ExecuteCodeGeneratorVisitor( args[0], args[1] ), null );

					// * The AST is shown
					IntrospectorModel model = new IntrospectorModel( "Program", ast );
					new IntrospectorTree( "Introspector", model );
					
					// Y colorín colorado este compilador se ha acabado...!
				}
			}

		}
	}
}
