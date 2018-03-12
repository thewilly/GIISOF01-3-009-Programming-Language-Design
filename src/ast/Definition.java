package ast;

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

    public void setType(Type type);

}
