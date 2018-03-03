package ast;

public class RealType implements Type {

    private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

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

    public void setRow(int row) {
	this.row = row;
    }

    public void setColumn(int column) {
	this.column = column;
    }

    @Override
    public String toString() {
	return "real";
    }

}
