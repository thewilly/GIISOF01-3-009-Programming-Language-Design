package ast;

public class ArrayType implements Type {

    private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

    private int offset;
    private Type arrayType;

    public ArrayType(int row, int column, int offset, Type arrayType) {
	super();
	this.row = row;
	this.column = column;
	this.offset = offset;
	this.arrayType = arrayType;
    }

    @Override
    public int getLine() {
	return row;
    }

    @Override
    public int getColumn() {
	return column;
    }

    public void setRow(int row) {
	this.row = row;
    }

    public void setColumn(int column) {
	this.column = column;
    }

    public int getOff() {
	return offset;
    }

    public void setOff(int off) {
	this.offset = off;
    }

    public Type getOf() {
	return arrayType;
    }

    public void setArrayType(Type arrayType) {
	this.arrayType = arrayType;
    }

    @Override
    public String toString() {
	return "[" + this.offset + "]" + this.arrayType.toString();
    }

}
