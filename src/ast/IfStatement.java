package ast;

import java.util.List;

import visitor.Visitor;

public class IfStatement implements Statement {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	private List<Statement> ifBody, elseBody;

	private Expression condition;
	
	private boolean ifBodyReturns = false, elseBodyReturs = false;

	public IfStatement( int row, int column, List<Statement> ifBody, List<Statement> elseBody,
			Expression condition ) {
		this.row = row;
		this.column = column;
		this.ifBody = ifBody;
		this.elseBody = elseBody;
		this.condition = condition;
	}

	@Override
	public int getLine() {
		return row;
	}

	@Override
	public int getColumn() {
		return column;
	}

	public List<Statement> getIfBody() {
		return ifBody;
	}

	public void setIfBody( List<Statement> ifBody ) {
		this.ifBody = ifBody;
	}

	public List<Statement> getElseBody() {
		return elseBody;
	}

	public void setElseBody( List<Statement> elseBody ) {
		this.elseBody = elseBody;
	}

	public Expression getCondition() {
		return condition;
	}

	public void setCondition( Expression condition ) {
		this.condition = condition;
	}

	public boolean isIfBodyReturns() {
		return ifBodyReturns;
	}

	public void setIfBodyReturns( boolean ifBodyReturns ) {
		this.ifBodyReturns = ifBodyReturns;
	}

	public boolean isElseBodyReturns() {
		return elseBodyReturs;
	}

	public void setElseBodyReturs( boolean elseBodyReturs ) {
		this.elseBodyReturs = elseBodyReturs;
	}

	@Override
	public String toString() {
		StringBuilder ifStatement = new StringBuilder();
		ifStatement.append( "if " + this.condition.toString() + ":" );
		for (Statement statement : this.getIfBody()) {
			ifStatement.append( "\n \t" + statement.toString() );
		}

		if (elseBody != null && !elseBody.isEmpty()) {
			ifStatement.append( "\n else :" );
			for (Statement statement : this.getElseBody()) {
				ifStatement.append( "\n \t" + statement.toString() );
			}
		}
		return ifStatement.toString();
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
