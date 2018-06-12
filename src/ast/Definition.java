package ast;

import ast.type.Type;

public interface Definition extends ASTNode, Statement {

	/**
	 * Gets the name of the definition.
	 * 
	 * @return the name of the definition.
	 */
	public String getName();

	/**
	 * Gets the type of the definition.
	 * 
	 * @return the type of the definition.
	 */
	public Type getType();

	/**
	 * Sets the type.
	 * 
	 * @param type to set.
	 */
	public void setType( Type type );

	/**
	 * @return the scope of the definition.
	 */
	public int getScope();

	/**
	 * Sets the scope of the definition.
	 * 
	 * @param scope of the definition.
	 */
	public void setScope( int scope );

}
