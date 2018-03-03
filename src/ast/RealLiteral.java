package ast;

public class RealLiteral implements Expression {

    private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
    
    private double value;

    public RealLiteral(int i, int j, double value) {
	this.row = i;
	this.column = j;
	this.value = value;
    }

    /**
     * @return the value
     */
    public double getValue() {
	return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(double value) {
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
	return Double.toString(value);
    }

}
