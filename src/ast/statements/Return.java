package ast.statements;

import ast.ASTNode;
import ast.expressions.Expression;
import visitor.Visitor;

public class Return implements Statement {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	private Expression expression;

	public Return( int row, int column, Expression expression ) {
		this.row = row;
		this.column = column;
		this.expression = expression;
	}

	@Override
	public int getLine() {
		return row;
	}

	@Override
	public int getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	public void setRow( int row ) {
		this.row = row;
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression( Expression expression ) {
		this.expression = expression;
	}

	public void setColumn( int column ) {
		this.column = column;
	}

	@Override
	public String toString() {
		return "return " + this.expression.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see ast.ASTNode#accept(ast.Visitor, java.lang.Object)
	 */
	@Override
	public <P, R> R accept( Visitor<P, R> visitor, P param ) {
		return visitor.visit( this, param );
	}

	@Override
	public boolean promotesToReturn() {
		return true;
	}
}
