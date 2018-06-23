package codeoptimization;

import ast.statements.IfStatement;
import ast.statements.Statement;
import visitor.AbstractVisitor;

public class ReturnStatementsIdentificatorVisitor extends AbstractVisitor<Object, Object> {

	@Override
	public Object visit( IfStatement ifStatement, Object o ) {

		for (Statement s : ifStatement.getIfBody()) {
			s.accept( this, null );
			if (s.promotesToReturn()) {
				ifStatement.setIfBodyReturns( true );
				break;
			}
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
