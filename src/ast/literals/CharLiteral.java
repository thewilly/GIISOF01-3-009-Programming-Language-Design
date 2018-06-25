package ast.literals;

import ast.ASTNode;
import ast.expressions.AbstractExpression;
import visitor.Visitor;

public class CharLiteral extends AbstractExpression implements Literal<Character> {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	private char value;

	public CharLiteral( int row, int column, char value ) {
		this.row = row;
		this.column = column;
		this.value = value;
	}

	/**
	 * @return the value
	 */
	@Override
	public Character getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	@Override
	public void setValue( Character value ) {
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
		return Character.toString( value );
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
