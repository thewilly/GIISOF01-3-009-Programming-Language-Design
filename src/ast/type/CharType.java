package ast.type;

import ast.ASTNode;
import visitor.Visitor;

public class CharType extends AbstractType {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	private static final int NUMBER_OF_BYTES = 1;

	private static CharType instance = new CharType();

	private CharType() {}

	public static CharType getInstance() {
		if (instance == null)
			instance = new CharType();
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
		return this.row;
	}

	public void setRow( int row ) {
		this.row = row;
	}

	public void setColumn( int column ) {
		this.column = column;
	}

	@Override
	public String toString() {
		return "char";
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
	public Type arithmetic(Type type) {

		if (type instanceof ErrorType || type instanceof RealType || type instanceof IntType) {
			return type;
		}

		if (type instanceof CharType) {
			return this;
		}

		return null;

	}
	
	@Override
	public Type comparison(Type type) {
		if (type instanceof ErrorType) {
			return type;
		}

		if (type instanceof CharType || type instanceof IntType || type instanceof RealType) {
			return IntType.getInstance();
		}

		return null;
	}

	@Override
	public Type logical(Type type) {
		if (type instanceof ErrorType) {
			return type;
		}

		if (type instanceof CharType || type instanceof IntType) {
			return IntType.getInstance();
		}

		return null;
	}

	@Override
	public Type logical() {
		return this;
	}

	@Override
	public Type canBeCast(Type type) {
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
	public Type promotesTo(Type type) {
		if (type instanceof ErrorType || type instanceof IntType || type instanceof RealType) {
			return type;
		}

		if (type instanceof CharType) {
			return this;
		}

		return null;
	}

	@Override
	public boolean isBuildInType() {
		return true;
	}

	@Override
	public char subfix() {
		return 'B';
	}

	@Override
	public Type superType(Type type) {

		if (type instanceof ErrorType || type instanceof RealType || type instanceof IntType) {
			return type;
		}

		if (type instanceof CharType) {
			return IntType.getInstance();
		}

		return null;
	}
}
