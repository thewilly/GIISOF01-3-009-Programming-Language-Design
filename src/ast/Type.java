package ast;

import java.util.List;


public interface Type extends ASTNode {
	
	boolean isLogical();

	Type arithmetic(Type type);

	Type arithmetic();

	Type comparison(Type type);

	Type logical(Type type);

	Type logical();

	Type dot(String s);

	Type squareBrackets(Type type);

	Type canBeCast(Type type);

	Type promotesTo(Type type);

	Type parentesis(List<Type> types);
	
	int getNumberOfBytes();
}
