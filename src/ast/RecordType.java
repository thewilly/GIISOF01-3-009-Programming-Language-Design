package ast;

import java.util.List;

import visitor.Visitor;

public class RecordType extends AbstractType {

	private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

	private List<RecordField> fields;

	public RecordType( int row, int column, List<RecordField> fields ) {
		this.row = row;
		this.column = column;
		this.fields = fields;
	}

	@Override
	public int getLine() {
		return row;
	}

	@Override
	public int getColumn() {
		return column;
	}

	public List<RecordField> getFields() {
		return fields;
	}

	public void setFields( List<RecordField> fields ) {
		this.fields = fields;
	}

	public void setRow( int row ) {
		this.row = row;
	}

	public void setColumn( int column ) {
		this.column = column;
	}

	@Override
	public String toString() {
		StringBuilder recordType = new StringBuilder();
		recordType.append( "struct {" );
		for (RecordField r : this.getFields()) {
			recordType.append( "\n \t" + r.toString() );
		}
		recordType.append( "\n }" );
		return recordType.toString();
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
	public Type dot( String s ) {
		for (RecordField r : getFields()) {
			if (r.getName().equals( s )) {
				return r.getType();
			}
		}
		return null;
	}
	
	@Override
	public int getNumberOfBytes() {
		int numberOfBytes = 0;
		for(RecordField field : this.getFields()) {
			numberOfBytes =+ field.getType().getNumberOfBytes();
		}
		return numberOfBytes;
	}
}
