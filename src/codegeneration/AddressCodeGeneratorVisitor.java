package codegeneration;

import ast.definitions.VarDefinition;
import ast.expressions.FieldAccess;
import ast.expressions.Indexing;
import ast.expressions.Variable;
import ast.types.IntType;

public class AddressCodeGeneratorVisitor extends CodeGeneratorVisitor {

	private ValueCodeGeneratorVisitor valueCgVisitor;

	public AddressCodeGeneratorVisitor( CodeGenerator generator ) {
		super( generator );
	}

	public void setValueVisitor( ValueCodeGeneratorVisitor valueVisitor ) {
		this.valueCgVisitor = valueVisitor;
	}

	@Override
	public Object visit( Variable variable, Object object ) {

		VarDefinition v = (VarDefinition) variable.getDefinition();

		if (variable.getDefinition().getScope() == 0) {
			generator.pusha( v.getOffset() );
		} else {
			generator.pushbp();
			generator.push( v.getOffset() );
			generator.add( IntType.getInstance() );
		}

		return null;
	}

	@Override
	public Object visit( FieldAccess fieldAccess, Object param ) {
		fieldAccess.getExp().accept( this, param );
		generator.push(
				fieldAccess.getExp().getType().get(
						fieldAccess.getName() ).getOffset() );
		generator.add( IntType.getInstance() );
		return null;
	}

	@Override
	public Object visit( Indexing indexing, Object o ) {
		indexing.getArguments().accept( this, o );
		indexing.getVariable().accept( valueCgVisitor, o );
		generator.push( indexing.getType().getNumberOfBytes() );
		generator.mul( IntType.getInstance() );
		generator.add( IntType.getInstance() );
		return null;
	}

}
