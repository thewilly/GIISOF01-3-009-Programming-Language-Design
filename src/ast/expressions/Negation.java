package ast.expressions;

import ast.ASTNode;
import visitor.Visitor;

public class Negation extends AbstractExpression {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	private Expression expresion;

	public Negation( int row, int column, Expression expresion ) {
		this.row = row;
		this.column = column;
		this.expresion = expresion;
	}

	/**
	 * @return the operand
	 */
	public Expression getOperand() {
		return expresion;
	}

	/**
	 * @param operand the operand to set
	 */
	public void setOperand( Expression operand ) {
		this.expresion = operand;
	}

	@Override
	public int getLine() {
		return this.row;
	}

	@Override
	public int getColumn() {
		return this.column;
	}

	@Override
	public String toString() {
		return "!" + this.expresion.toString();
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
