package ast;

public class VoidType implements Type {

    private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

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

    public void setRow(int row) {
	this.row = row;
    }

    public void setColumn(int column) {
	this.column = column;
    }

    @Override
    public String toString() {
	return "void";
    }

}
