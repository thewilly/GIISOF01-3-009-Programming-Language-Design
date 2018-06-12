package ast.type;

import java.util.List;

import ast.ASTNode;
import ast.VarDefinition;
import visitor.Visitor;

public class FunctionType extends AbstractType {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	private Type returnType;
	private List<VarDefinition> parameters;

	public FunctionType( int row, int column, Type returnType, List<VarDefinition> parameters ) {
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

	public void setRow( int row ) {
		this.row = row;
	}

	public void setColumn( int column ) {
		this.column = column;
	}

	public Type getReturnType() {
		return returnType;
	}

	public void setReturnType( Type returnType ) {
		this.returnType = returnType;
	}

	public List<VarDefinition> getParameters() {
		return parameters;
	}

	public void setParameters( List<VarDefinition> parameters ) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		StringBuilder functionType = new StringBuilder();
		functionType.append( "(" );

		for (VarDefinition varDef : this.getParameters()) {
			if (varDef.equals( this.getParameters().get( 0 ) ))
				functionType.append( varDef.toString() );
			else
				functionType.append( ", " + varDef.toString() );
		}

		functionType.append( "):" );
		functionType.append( getReturnType().toString() );

		return functionType.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see ast.ASTNode#accept(ast.Visitor, java.lang.Object)
	 */
	@Override
	public <P, R> R accept( Visitor<P, R> visitor, P param ) {
		return visitor.visit( this, param );
	}

	@Override
	public Type parentesis( List<Type> types ) {
		if (types.size() == parameters.size()) {
			for (int i = 0; i < types.size(); i++) {
				if (types.get( i ).promotesTo( parameters.get( i ).getType() ) == null) {
					return null;
				}
			}
			return returnType;
		}
		return null;
	}

	@Override
	public int getNumberOfBytes() {
		if (this.getReturnType() instanceof VoidType) {
			return 0;
		}

		if (this.getReturnType() instanceof ErrorType) {
			throw new IllegalStateException();
		}

		return this.getReturnType().getNumberOfBytes();
	}

	/*
	 * (non-Javadoc)
	 * @see ast.Type#subfix()
	 */
	@Override
	public char subfix() {
		return this.returnType.subfix();
	}
}
