package ast.types;


import ast.ASTNode;

public class ReferenceType extends AbstractType {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
	
	private Type ofType;
	
	public ReferenceType(int row, int column, Type ofType) {
		this.row = row;
		this.column = column;
		this.ofType = ofType;
	}
	
	public void setTypeOfReference(Type type) {
		this.ofType = type;
	}

	@Override
	public int getNumberOfBytes() {
		return this.ofType.getNumberOfBytes();
	}
	
	@Override
	public int getLine() {
		return this.row;
	}
	
	@Override
	public int getColumn() {
		return this.column;
	}
	
	public Type getOfType() {
		return this.ofType;
	}
	
	@Override
	public char subfix() {
		return this.ofType.subfix();
	}
	
	@Override
	public boolean isReferenceType() {
		return true;
	}
	
	@Override
	public Type promotesTo( Type type ) {
		return this.ofType.promotesTo( type );
	}
	
	public String toString() {
		return "[ReferenceType] : " + this.ofType;
	}
}
