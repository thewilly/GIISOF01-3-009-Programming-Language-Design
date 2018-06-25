package ast.statements;

import java.util.List;

import ast.expressions.Expression;
import visitor.Visitor;

public class DoWhileStatement extends WhileStatement {

	public DoWhileStatement( int row, int column, List<Statement> body, Expression condition ) {
		super( row, column, body, condition );
	}
	
	@Override
	public String toString() {
		StringBuilder whileStmt = new StringBuilder();

		whileStmt.append( "do : {" );
		for (Statement s : this.getBody()) {
			whileStmt.append( "\n \t" + s.toString() );
		}
		whileStmt.append( "\n} while " + super.getCondition() );

		return whileStmt.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see ast.ASTNode#accept(ast.Visitor, java.lang.Object)
	 */
	@Override
	public <P, R> R accept( Visitor<P, R> visitor, P param ) {
		return visitor.visit( this, param );
	}

}
