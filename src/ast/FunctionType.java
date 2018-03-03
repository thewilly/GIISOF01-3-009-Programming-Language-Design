package ast;

import java.util.List;

public class FunctionType implements Type {

    private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

    private Type returnType;
    private List<VarDefinition> parameters;

    public FunctionType(int row, int column, Type returnType, List<VarDefinition> parameters) {
	this.row = row;
	this.column = column;
	this.returnType = returnType;
	this.parameters = parameters;
    }

    @Override
    public int getLine() {
	return row;
    }

    @Override
    public int getColumn() {
	return column;
    }

    public void setRow(int row) {
	this.row = row;
    }

    public void setColumn(int column) {
	this.column = column;
    }

    public Type getReturnType() {
	return returnType;
    }

    public void setReturnType(Type returnType) {
	this.returnType = returnType;
    }

    public List<VarDefinition> getParameters() {
	return parameters;
    }

    public void setParameters(List<VarDefinition> parameters) {
	this.parameters = parameters;
    }

    @Override
    public String toString() {
	StringBuilder functionType = new StringBuilder();
	functionType.append("(");
	
	for (VarDefinition varDef : this.getParameters()) {
	    if(varDef.equals(this.getParameters().get(0)))
		functionType.append(varDef.toString());
	    else
		functionType.append(", " + varDef.toString());
	}
	
	functionType.append("):");
	functionType.append(getReturnType().toString());
	
	return functionType.toString();
    }
}
