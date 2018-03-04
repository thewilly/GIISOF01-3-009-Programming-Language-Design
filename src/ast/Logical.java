package ast;

public class Logical implements Expression, Statement {

    private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

    private Expression left, right;
    private String operator;

    public Logical(int row, int column, Expression left, String operator, Expression right) {
	this.row = row;
	this.column = column;
	this.left = left;
	this.operator = operator;
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

    public String getLogicalOperator() {
	return operator;
    }

    public void setLogicalOperator(String logicalOperator) {
	this.operator = logicalOperator;
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
	return this.left.toString() + this.operator + this.right.toString();
    }

}
