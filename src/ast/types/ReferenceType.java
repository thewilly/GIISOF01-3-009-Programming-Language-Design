package ast.types;


import ast.ASTNode;

public class ReferenceType extends AbstractType {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
	
	private Type type;
	
	public ReferenceType(int row, int column, Type ofType) {
		this.row = row;
		this.column = column;
		this.type = ofType;
	}
	
	public void setTypeOfReference(Type type) {
		this.type = type;
	}

	@Override
	public int getNumberOfBytes() {
		return this.type.getNumberOfBytes();
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
		return this.type;
	}
	
	@Override
	public char subfix() {
		return this.type.subfix();
	}
	
	@Override
	public boolean isReferenceType() {
		return true;
	}
	
	@Override
	public Type promotesTo( Type type ) {
		return this.type.promotesTo( type );
	}
	
	public String toString() {
		return "[ReferenceType] : " + this.type;
	}
}
