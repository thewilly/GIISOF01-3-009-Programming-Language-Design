package ast;

import java.util.List;

public class IfStatement implements Statement {

    private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

    private List<Statement> ifBody, elseBody;

    private Expression condition;

    public IfStatement(int row, int column, List<Statement> ifBody, List<Statement> elseBody, Expression condition) {
	this.row = row;
	this.column = column;
	this.ifBody = ifBody;
	this.elseBody = elseBody;
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

    public List<Statement> getIfBody() {
	return ifBody;
    }

    public void setIfBody(List<Statement> ifBody) {
	this.ifBody = ifBody;
    }

    public List<Statement> getElseBody() {
	return elseBody;
    }

    public void setElseBody(List<Statement> elseBody) {
	this.elseBody = elseBody;
    }

    public Expression getCondition() {
	return condition;
    }

    public void setCondition(Expression condition) {
	this.condition = condition;
    }

    @Override
    public String toString() {
	StringBuilder ifStatement = new StringBuilder();
	ifStatement.append("if " + this.condition.toString() + ":");
	for (Statement statement : this.getIfBody()) {
	    ifStatement.append("\n \t" + statement.toString());
	}

	if (!elseBody.isEmpty()) {
	    ifStatement.append("\n else :");
	    for (Statement statement : this.getElseBody()) {
		ifStatement.append("\n \t" + statement.toString());
	    }
	}
	return ifStatement.toString();
    }

}
