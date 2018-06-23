package ast.definitions;

import java.util.List;

import ast.ASTNode;
import ast.statements.Statement;
import ast.types.FunctionType;
import ast.types.Type;
import visitor.Visitor;

public class FuncDefinition implements Definition {

	private List<Statement> statements;
	private String name;
	private Type type;
	private int scope;

	private int row = ASTNode.DEFAULT_ROW_COLUMN;
	private int column = ASTNode.DEFAULT_ROW_COLUMN;

	public FuncDefinition( int i, int j, String name, Type type, List<Statement> statements ) {
		this.row = i;
		this.column = j;
		this.statements = statements;
		this.name = name;
		this.type = type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Type getType() {
		return type;
	}

	public void setType( Type type ) {
		this.type = type;
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements( List<Statement> statements ) {
		this.statements = statements;
	}

	@Override
	public int getLine() {
		return row;
	}

	@Override
	public int getColumn() {
		return column;
	}

	@Override
	public int getScope() {
		return this.scope;
	}

	@Override
	public void setScope( int scope ) {
		this.scope = scope;
	}

	@Override
	public String toString() {
		StringBuilder funcDef = new StringBuilder();
		funcDef.append( "def " + this.name + this.type.toString() + " {\n" );
		for (Statement statement : this.getStatements()) {
			funcDef.append( "\n \t" + statement.toString() );
		}
		funcDef.append( "\n}" );
		return funcDef.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see ast.ASTNode#accept(ast.Visitor, java.lang.Object)
	 */
	@Override
	public <P, R> R accept( Visitor<P, R> visitor, P param ) {
		return visitor.visit( this, param );
	}

	public int localBytes() {
		int total = 0;
		for (Statement s : statements) {
			if (s instanceof VarDefinition) {
				total += ( (VarDefinition) s ).getType().getNumberOfBytes();
			}
		}
		return total;
	}

	public int paramBytes() {
		int total = 0;
		for (VarDefinition v : ( (FunctionType) getType() ).getParameters()) {
			total += v.getType().getNumberOfBytes();

		}
		return total;
	}

	@Override
	public boolean promotesToReturn() {
		return false;
	}

}
