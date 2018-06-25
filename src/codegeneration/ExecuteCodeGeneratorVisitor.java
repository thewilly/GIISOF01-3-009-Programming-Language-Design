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
package codegeneration;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Invocation;
import ast.statements.Assignment;
import ast.statements.DoWhileStatement;
import ast.statements.IfStatement;
import ast.statements.Read;
import ast.statements.Return;
import ast.statements.Statement;
import ast.statements.WhileStatement;
import ast.statements.Write;
import ast.types.FunctionType;
import ast.types.Type;
import ast.types.VoidType;

/**
 * Instance of ExecuteCodeGeneratorVisitor.java
 * 
 * @author
 * @version
 */
public class ExecuteCodeGeneratorVisitor extends CodeGeneratorVisitor {

	/** The value visitor. */
	private ValueCodeGeneratorVisitor valueVisitor;
	
	/** The address visitor. */
	private AddressCodeGeneratorVisitor addressVisitor;

	/** The input name. */
	private String inputName;

	/**
	 * Allocates a [] object and initializes it so that it represents.
	 *
	 * @param generator the generator
	 */
	private ExecuteCodeGeneratorVisitor( CodeGenerator generator ) {
		super( generator );
	}

	/**
	 * Instantiates a new execute code generator visitor.
	 *
	 * @param entrada the entrada
	 * @param salida the salida
	 */
	public ExecuteCodeGeneratorVisitor( String entrada, String salida ) {
		this( new CodeGenerator( entrada, salida ) );
		addressVisitor = new AddressCodeGeneratorVisitor( this.generator );
		valueVisitor = new ValueCodeGeneratorVisitor( this.generator, addressVisitor );
		addressVisitor.setValueVisitor( valueVisitor );

		this.inputName = entrada;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.Program, java.lang.Object)
	 */
	@Override
	public Object visit( Program program, Object o ) {

		generator.sourceComment( inputName );

		for (Definition def : program.getDefinitions()) {
			if (def instanceof VarDefinition) {
				def.accept( this, o );
				generator.varComment( def );
			}
		}
		generator.white();
		generator.mainComment();
		generator.call( "main" );
		generator.halt();

		for (Definition def : program.getDefinitions()) {
			if (def instanceof FuncDefinition) {
				def.accept( this, o );
			}
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.definitions.FuncDefinition, java.lang.Object)
	 */
	@Override
	public Object visit( FuncDefinition funcDefinition, Object o ) {

		generator.etiqueta( funcDefinition.getName() );

		////////////////////////////////////////////////////////////////////////////////////////////////////

		// Comentarios parámetros
		generator.paramComment();
		for (VarDefinition v : ( (FunctionType) funcDefinition.getType() ).getParameters()) {
			generator.varComment( v );
		}
		generator.white();

		// Comentarios locales
		generator.localComment();
		for (Statement d : funcDefinition.getStatements()) {
			if (d instanceof VarDefinition) {
				generator.varComment( (VarDefinition) d );
			}
		}
		generator.white();
		////////////////////////////////////////////////////////////////////////////////////////////////////

		generator.enter( funcDefinition.localBytes() );

		for (Statement d : funcDefinition.getStatements()) {
			if (!( d instanceof VarDefinition )) {
				generator.lineComment( d.getLine() );
				d.accept( this, funcDefinition );

				// BEGIN OF: DEAD CODE OPTIMIZATION
				if (d.promotesToReturn()) {
					break;
				}
				// END OF: DEAD CODE OPTIMIZATION
			}
		}

		Type ret = ( (FunctionType) funcDefinition.getType() ).getReturnType();
		if (ret == VoidType.getInstance()) {
			generator.ret( 0, funcDefinition.localBytes(), funcDefinition.paramBytes() );
		}

		return null;

	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.statements.Write, java.lang.Object)
	 */
	@Override
	public Object visit( Write write, Object o ) {

		write.getExpression().accept( valueVisitor, o );
		generator.out( write.getExpression().getType() );

		return null;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.statements.Read, java.lang.Object)
	 */
	@Override
	public Object visit( Read read, Object o ) {

		read.getExpression().accept( addressVisitor, o );
		generator.in( read.getExpression().getType() );
		generator.store( read.getExpression().getType() );

		return null;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.statements.Assignment, java.lang.Object)
	 */
	@Override
	public Object visit( Assignment assignment, Object o ) {

		assignment.getLeft().accept( addressVisitor, o );
		assignment.getRight().accept( valueVisitor, o );
		generator.convert( assignment.getRight().getType(), assignment.getLeft().getType() );
		generator.store( assignment.getLeft().getType() );

		return null;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.statements.IfStatement, java.lang.Object)
	 */
	@Override
	public Object visit( IfStatement ifStatement, Object o ) {
		int label = generator.getLabels( 2 );

		ifStatement.getCondition().accept( valueVisitor, o );
		generator.jz( label );
		for (Statement s : ifStatement.getIfBody()) {
			generator.lineComment( s.getLine() );
			s.accept( this, o );

			// BEGIN OF: DEAD CODE OPTIMIZATION
			if (s.promotesToReturn()) {
				break;
			}
			// END OF: DEAD CODE OPTIMIZATION

		}

		// BEGIN OF: DEAD CODE OPTIMIZATION
		if (!ifStatement.isIfBodyReturns()) {
			// END OF: DEAD CODE OPTIMIZATION
			generator.jmp( label + 1 );
		}

		generator.label( label );
		if (ifStatement.getElseBody() != null) {
			for (Statement s : ifStatement.getElseBody()) {
				generator.lineComment( s.getLine() );
				s.accept( this, o );

				// BEGIN OF: DEAD CODE OPTIMIZATION
				if (s.promotesToReturn()) {
					break;
				}
				// END OF: DEAD CODE OPTIMIZATION
			}
		}

		// BEGIN OF: DEAD CODE OPTIMIZATION
		if (!ifStatement.isIfBodyReturns()) {
			// END OF: DEAD CODE OPTIMIZATION
			generator.label( label + 1 );
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.statements.WhileStatement, java.lang.Object)
	 */
	@Override
	public Object visit( WhileStatement whileStatement, Object o ) {
		int label = generator.getLabels( 2 );
		generator.label( label );
		whileStatement.getCondition().accept( valueVisitor, o );
		generator.jz( label + 1 );
		for (Statement s : whileStatement.getBody()) {
			generator.lineComment( s.getLine() );
			s.accept( this, o );

			// Dead code removal...
			if (s.promotesToReturn()) {
				break;
			}
		}
		generator.jmp( label );
		generator.label( label + 1 );

		return null;
	}
	
	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.statements.DoWhileStatement, java.lang.Object)
	 */
	@Override
	public Object visit( DoWhileStatement doWhileStatement, Object o ) {
		int label = generator.getLabels( 1 );
		generator.label( label );
		for (Statement s : doWhileStatement.getBody()) {
			generator.lineComment( s.getLine() );
			s.accept( this, o );

			// Dead code removal...
			if (s.promotesToReturn()) {
				break;
			}
		}
		doWhileStatement.getCondition().accept( valueVisitor, o );
		generator.jnz( label );
		
		return null;
	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.expressions.Invocation, java.lang.Object)
	 */
	@Override
	public Object visit( Invocation invocation, Object o ) {
		invocation.accept( valueVisitor, o );
		if (( (FunctionType) invocation.getFuncion().getType() ).getReturnType() != VoidType
				.getInstance()) {
			generator.pop(
					( (FunctionType) invocation.getFuncion().getType() ).getReturnType().subfix() );
		}

		return null;

	}

	/* (non-Javadoc)
	 * @see codegeneration.CodeGeneratorVisitor#visit(ast.statements.Return, java.lang.Object)
	 */
	@Override
	public Object visit( Return returnExp, Object o ) {
		returnExp.getExpression().accept( valueVisitor, o );

		FuncDefinition f = (FuncDefinition) o;

		generator.convert( returnExp.getExpression().getType(),
				( (FunctionType) f.getType() ).getReturnType() );

		generator.ret( ( (FunctionType) f.getType() ).getReturnType().getNumberOfBytes(),
				f.localBytes(), f.paramBytes() );

		return null;
	}
}
