package ast.type;

import ast.ASTNode;
import visitor.Visitor;

public class VoidType extends AbstractType {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	private static final int NUMBER_OF_BYTES = 0;

	private static VoidType instance = new VoidType();

	private VoidType() {}

	public static VoidType getInstance() {
		// Never its gonna be null but just in case we check.
		if (instance == null)
			instance = new VoidType();
		return instance;
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

	public void setColumn( int column ) {
		this.column = column;
	}

	@Override
	public String toString() {
		return "void";
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
	public int getNumberOfBytes() {
		return NUMBER_OF_BYTES;
	}
	
	@Override
	public boolean isBuildInType() {
		return true;
	}
}
