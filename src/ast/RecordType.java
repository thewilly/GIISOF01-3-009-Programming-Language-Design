package ast;

import java.util.List;

public class RecordType implements Type {

    private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;

    private List<RecordField> fields;

    public RecordType(int row, int column, List<RecordField> fields) {
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

    public void setFields(List<RecordField> fields) {
	this.fields = fields;
    }

    public void setRow(int row) {
	this.row = row;
    }

    public void setColumn(int column) {
	this.column = column;
    }

    @Override
    public String toString() {
	StringBuilder recordType = new StringBuilder();
	recordType.append("struct {");
	for (RecordField r : this.getFields()) {
	    recordType.append("\n \t" + r.toString());
	}
	recordType.append("\n }");
	return recordType.toString();
    }
}
