package ast.type;

import java.util.List;

import ast.ASTNode;
import ast.RecordField;

public interface Type extends ASTNode {

	boolean isLogical();

	Type arithmetic( Type type );

	Type arithmetic();

	Type comparison( Type type );

	Type logical( Type type );

	Type logical();

	Type dot( String s );
	
	RecordField get(String identifier);

	Type squareBrackets( Type type );

	Type canBeCast( Type type );

	Type promotesTo( Type type );

	Type parentesis( List<Type> types );

	int getNumberOfBytes();

	char subfix();
	
	Type superType(Type type);

	boolean isBuildInType();
}
