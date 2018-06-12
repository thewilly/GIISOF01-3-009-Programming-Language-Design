package ast;

import visitor.Visitor;

public class FieldAccess extends AbstractExpression {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
	private Expression expresion;
	private String name;

	public FieldAccess( int row, int column, Expression expresion, String name ) {
		this.row = row;
		this.column = column;
		this.expresion = expresion;
		this.name = name;
	}

	@Override
	public int getLine() {
		return row;
	}

	@Override
	public int getColumn() {
		return column;
	}

	public Expression getExp() {
		return expresion;
	}

	public void setExp( Expression exp ) {
		this.expresion = exp;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public int getRow() {
		return row;
	}

	public void setRow( int row ) {
		this.row = row;
	}

	public void setColumn( int column ) {
		this.column = column;
	}

	@Override
	public String toString() {
		return this.expresion.toString() + "." + this.name;
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
