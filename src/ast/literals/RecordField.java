package ast.literals;

import ast.ASTNode;
import ast.types.Type;
import visitor.Visitor;

public class RecordField implements ASTNode {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	private String name;
	private Type type;
	private int offset;

	public RecordField( int row, int column, String name, Type type, int offset ) {
		this.row = row;
		this.column = column;
		this.name = name;
		this.type = type;
		this.offset = offset;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType( Type type ) {
		this.type = type;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset( int offset ) {
		this.offset = offset;
	}

	@Override
	public int getLine() {
		return row;
	}

	@Override
	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return this.name + ":" + this.type.toString();
	}

	@Override
	public boolean equals( Object other ) {
		if (other == null)
			return false;
		if (!( other instanceof RecordField ))
			return false;
		RecordField otherField = (RecordField) other;
		if (this.getName().equals( otherField.getName() ))
			return true;
		return false;
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
