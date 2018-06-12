package ast;

import parser.*;
import visitor.OffsetVisitor;
import visitor.impl.IdentificationVisitor;
import visitor.impl.TypeCheckingVisitor;

import org.antlr.v4.runtime.*;

import ast.Program;
import codegeneration.ExecuteCodeGeneratorVisitor;
import errorhandler.EH;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;

public class Main {

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
		ast.accept( new TypeCheckingVisitor(), null );
		ast.accept( new OffsetVisitor(), null );
		ast.accept( new ExecuteCodeGeneratorVisitor(args[0], args[1]), null );

		// * Check errors
		if (EH.getInstance().hasErrors()) {
			// * Show errors
			EH.getInstance().showErrors( System.err );
		} else {
			// * The AST is shown
			IntrospectorModel model = new IntrospectorModel( "Program", ast );
			new IntrospectorTree( "Introspector", model );
		}
	}
}
