package ast.literals;

public interface Literal<T> {

	/**
	 * Gets the value of the literal.
	 * 
	 * @return the value of the literal.
	 */
	public T getValue();

	/**
	 * Sets the value of the literal.
	 * 
	 * @param value is the value for the literal.
	 */
	public void setValue( T value );
}
