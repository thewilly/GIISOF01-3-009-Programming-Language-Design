package ast;

import java.util.List;

public class Invocation implements Statement, Expression {

    private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
    private List<Expression> arguments;
    private Variable funcionName;

    public Invocation(int row, int column, Variable funcionName, List<Expression> arguments) {
	this.row = row;
	this.column = column;
	this.arguments = arguments;
	this.funcionName = funcionName;
    }

    @Override
    public int getLine() {
	return row;
    }

    @Override
    public int getColumn() {
	return column;
    }

    public List<Expression> getArguments() {
	return arguments;
    }

    public void setArguments(List<Expression> arguments) {
	this.arguments = arguments;
    }

    public int getRow() {
	return row;
    }

    public void setRow(int row) {
	this.row = row;
    }

    public Variable getFuncion() {
	return funcionName;
    }

    public void setFuncion(Variable funcion) {
	this.funcionName = funcion;
    }

    public void setColumn(int column) {
	this.column = column;
    }

    @Override
    public String toString() {
	StringBuilder invocation = new StringBuilder();
	invocation.append(this.funcionName + "(");

	for (Expression expression : this.getArguments()) {
	    // If its the first expression no comma and space before the
	    // expresion.toString().
	    if (expression.equals(this.getArguments().get(0)))
		invocation.append(expression.toString());
	    else
		invocation.append(", " + expression.toString());
	}

	invocation.append(" )");
	return invocation.toString();
    }
}