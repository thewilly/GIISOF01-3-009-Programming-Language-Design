package ast;

import java.util.List;

public class WhileStatement implements Statement {

    private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

    private List<Statement> body;
    private Expression condition;

    public WhileStatement(int row, int column, List<Statement> body, Expression condition) {
	super();
	this.row = row;
	this.column = column;
	this.body = body;
	this.condition = condition;
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

    public List<Statement> getBody() {
	return body;
    }

    public void setBody(List<Statement> body) {
	this.body = body;
    }

    public Expression getCondition() {
	return condition;
    }

    public void setCondition(Expression condition) {
	this.condition = condition;
    }

    public void setColumn(int column) {
	this.column = column;
    }

    @Override
    public String toString() {
	StringBuilder whileStmt = new StringBuilder();
	
	whileStmt.append("while " + this.condition + ":");
	for (Statement s : this.getBody()) {
	    whileStmt.append("\n \t" + s.toString());
	}
	whileStmt.append("\n}");
	
	return whileStmt.toString();
    }
}
