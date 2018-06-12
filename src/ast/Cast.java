package ast;

import ast.type.Type;
import visitor.Visitor;

public class Cast extends AbstractExpression {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	private Expression expresion;
	private Type castType;

	public Cast( int row, int column, Expression expresion, Type castType ) {
		this.row = row;
		this.column = column;
		this.expresion = expresion;
		this.castType = castType;
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

	public Expression getExp() {
		return expresion;
	}

	public void setExp( Expression exp ) {
		this.expresion = exp;
	}

	public Type getCastType() {
		return castType;
	}

	public void setCastType( Type castType ) {
		this.castType = castType;
	}

	public void setColumn( int column ) {
		this.column = column;
	}

	@Override
	public String toString() {
		return "(" + this.castType.toString() + ")" + this.expresion.toString();
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
