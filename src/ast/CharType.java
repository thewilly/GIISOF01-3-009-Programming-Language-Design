package ast;

import visitor.Visitor;

public class CharType implements Type {

    private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

    private static CharType instance = new CharType();

    private CharType() {
    }

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

    public void setRow(int row) {
	this.row = row;
    }

    public void setColumn(int column) {
	this.column = column;
    }

    @Override
    public String toString() {
	return "char";
    }

    /* (non-Javadoc)
     * @see ast.ASTNode#accept(ast.Visitor, java.lang.Object)
     */
    @Override
    public <P, R> R accept(Visitor<P, R> visitor, P param) {
	return visitor.visit(this, param);
    }

}
