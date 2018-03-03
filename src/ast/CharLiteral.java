package ast;

public class CharLiteral implements Expression {

    private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
    
    private char value;

    public CharLiteral(int row, int column, char value) {
	this.row = row;
	this.column = column;
	this.value = value;
    }

    /**
     * @return the value
     */
    public char getValue() {
	return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(char value) {
	this.value = value;
    }

    @Override
    public int getLine() {
	return this.row;
    }

    @Override
    public int getColumn() {
	return this.column;
    }

    @Override
    public String toString() {
	return Character.toString(value);
    }

}
