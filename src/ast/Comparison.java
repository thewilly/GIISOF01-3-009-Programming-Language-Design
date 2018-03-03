package ast;

public class Comparison implements Expression {

    private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
    
    private Expression left, right;
    private String comparator;

    public Comparison(int i, int j, Expression left, String comparator, Expression right) {
	this.row = i;
	this.column = j;
	this.left = left;
	this.comparator = comparator;
	this.right = right;
    }

    /**
     * @return the left
     */
    public Expression getLeft() {
	return left;
    }

    /**
     * @param left
     *            the left to set
     */
    public void setLeft(Expression left) {
	this.left = left;
    }

    /**
     * @return the right
     */
    public Expression getRight() {
	return right;
    }

    /**
     * @param right
     *            the right to set
     */
    public void setRight(Expression right) {
	this.right = right;
    }

    public String getComparator() {
	return comparator;
    }

    public void setComparator(String comparator) {
	this.comparator = comparator;
    }
    
    @Override
    public int getLine() {
	return column;
    }

    @Override
    public int getColumn() {
	return row;
    }
    
    @Override
    public String toString() {
	return this.left.toString() + this.comparator + this.right.toString();
    }

}
