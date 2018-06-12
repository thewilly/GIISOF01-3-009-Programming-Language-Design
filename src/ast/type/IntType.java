package ast.type;

import ast.ASTNode;
import visitor.Visitor;

public class IntType extends AbstractType {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	private static final int NUMBER_OF_BYTES = 2;

	private static IntType instance = new IntType();

	private IntType() {}

	public static IntType getInstance() {
		if (instance == null)
			instance = new IntType();
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
		return "int";
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
	public boolean isLogical() {
		return true;
	}
	
	@Override
	public boolean isBuildInType() {
		return true;
	}

	@Override
	public Type arithmetic( Type type ) {

		if (type instanceof ErrorType) {
			return type;
		}

		if (type instanceof IntType) {
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

		if (type instanceof IntType) {
			return this;
		}

		return null;
	}

	@Override
	public Type logical( Type type ) {
		if (type instanceof ErrorType) {
			return type;
		}

		if (type instanceof IntType) {
			return this;
		}

		return null;
	}

	@Override
	public Type logical() {
		return this;
	}

	@Override
	public Type canBeCast( Type type ) {
		if (type instanceof ErrorType) {
			return type;
		}

		if (type instanceof CharType) {
			return this;
		}

		if (type instanceof IntType) {
			return this;
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

		if (type instanceof IntType) {
			return this;
		}

		return null;
	}

	@Override
	public int getNumberOfBytes() {
		return NUMBER_OF_BYTES;
	}

	/*
	 * (non-Javadoc)
	 * @see ast.Type#subfix()
	 */
	@Override
	public char subfix() {
		return 'I';
	}
	
	@Override
	public Type superType(Type type) {

		if (type instanceof ErrorType) {
			return type;
		}

		if (type instanceof RealType) {
			return RealType.getInstance();
		}

		if (type instanceof IntType || type instanceof CharType) {
			return this;
		}

		return null;

	}
}
