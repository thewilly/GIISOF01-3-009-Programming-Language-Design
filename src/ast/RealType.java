package ast;

import errorhandler.ErrorType;
import visitor.Visitor;

public class RealType extends AbstractType {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
	
	private static final int NUMBER_OF_BYTES = 4;

	private static RealType instance = new RealType();

	private RealType() {}

	public static RealType getInstance() {
		if (instance == null)
			instance = new RealType();
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
		return "real";
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
	public Type arithmetic( Type type ) {

		if (type instanceof ErrorType) {
			return type;
		}

		if (type instanceof RealType) {
			return this;
		}

		return null;
	}

	@Override
	public Type arithmetic() {
		return this;
	}

	@Override
	public Type comparison( Type type ) {
		if (type instanceof ErrorType) {
			return type;
		}

		if (type instanceof RealType) {
			return this;
		}

		return null;
	}

	@Override
	public Type canBeCast( Type type ) {
		if (type instanceof ErrorType) {
			return type;
		}

		if (type instanceof RealType) {
			return this;
		}

		return null;
	}

	@Override
	public Type promotesTo( Type type ) {
		if (type instanceof ErrorType) {
			return type;
		}

		if (type instanceof RealType) {
			return this;
		}

		return null;
	}
	
	@Override
	public int getNumberOfBytes() {
		return NUMBER_OF_BYTES;
	}

}
