package codegeneration;

import ast.FieldAccess;
import ast.Indexing;
import ast.VarDefinition;
import ast.Variable;
import ast.type.IntType;

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
	public Object visit( FieldAccess fieldAccess, Object o ) {
		fieldAccess.getExp().accept( this, o );
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
