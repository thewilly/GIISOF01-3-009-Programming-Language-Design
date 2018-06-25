package ast.literals;

import ast.ASTNode;
import ast.expressions.AbstractExpression;
import visitor.Visitor;

public class RealLiteral extends AbstractExpression implements Literal<Double> {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	private double value;

	public RealLiteral( int i, int j, double value ) {
		this.row = i;
		this.column = j;
		this.value = value;
	}

	/**
	 * @return the value
	 */
	@Override
	public Double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	@Override
	public void setValue( Double value ) {
		this.value = value;
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
		return Double.toString( value );
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
