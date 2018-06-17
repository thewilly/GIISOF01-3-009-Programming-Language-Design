grammar Pmm;

@header {
  import ast.*;
  import ast.type.*;
  import java.util.*;
}

// Sequence of variable and function definitions and a main function definition.
program returns [Program ast]
 : {List<Definition> defs = new ArrayList<Definition>();}((var_def';'){defs.addAll($var_def.ast);}|func_def{defs.add($func_def.ast);})* main_def EOF{defs.add($main_def.ast);$ast = new Program(0,0,defs);}
 ;


// --------------------------
// BUILT-IN
// --------------------------

// Built-in types are int, double and char.
build_in_type returns [Type ast]
 : 'int' {$ast = IntType.getInstance();}
 | 'double' {$ast = RealType.getInstance();}
 | 'char' {$ast = CharType.getInstance();}
 | {List<RecordField> fields = new ArrayList<RecordField>();} STRUCT '{' (fields{fields.addAll($fields.ast);}) '}' {$ast = new RecordType($STRUCT.line, $STRUCT.pos+1, fields);}
 | ('['size=INT_CONSTANT']') arr_type=build_in_type {$ast = new ArrayType($start.getLine(), $start.getCharPositionInLine()+1, LexerHelper.lexemeToInt($size.text), $arr_type.ast);}
 ;


// --------------------------
// VARIABLE DEFINITIONS
// --------------------------

// Non-empty enumeration of comma-separated identifiers followed by a ':' and a type.
var_def returns [List<Definition> ast = new ArrayList<Definition>()]
 : single_var_def {$ast.add($single_var_def.ast);}
 | multi_var_def {$ast.addAll($multi_var_def.ast);}
 | {List<RecordField> fields = new ArrayList<RecordField>();}ID ':' 'struct' '{' (fields{fields.addAll($fields.ast);}) '}' {$ast.add(new VarDefinition($ID.line, $ID.pos+1, $ID.text, new RecordType($ID.line, $ID.pos+1, fields)));}
 ;

// When we only have one variable definition.
single_var_def returns [VarDefinition ast]
 : ID {$ast = new VarDefinition($ID.line, $ID.pos+1, $ID.text, null);}':' build_in_type {$ast.setType($build_in_type.ast);}
 ;

// When we have an enumeration of variable and a definition.
multi_var_def returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]
 : id1=ID {$ast.add(new VarDefinition($id1.line, $id1.pos+1, $id1.text, null));}(','id2=ID {if($ast.contains(new VarDefinition($id2.line, $id2.pos+1, $id2.text, null))){new ErrorType($id2.line, $id2.pos+1, "Duplicate variable definition error: " + $id2.text);}else{$ast.add(new VarDefinition($id2.line, $id2.pos+1, $id2.text, null));}})+ ':' build_in_type {for(Definition def : $ast) {def.setType($build_in_type.ast);}}
 ;

// Declared as a variable and ending with ';' always.
fields returns [List<RecordField> ast = new ArrayList<RecordField>()]
 : (var_def {for(Definition def : $var_def.ast) {if($ast.contains(new RecordField(def.getLine(), def.getColumn(), def.getName(), def.getType(), 0))) {new ErrorType(def.getLine(), def.getColumn(), "Duplicate field error: " + def.getName());} else {$ast.add(new RecordField(def.getLine(), def.getColumn(), def.getName(), def.getType(), 0));}}}';')+
 ;


// --------------------------
// FUNCTION DEFINITIONS
// --------------------------

// It's defined by the def keyword, the function identifier and a list of
// comma-separated parameters between ( and ) followed by a ':' and a return
// type or the void keyword. The return type and parameter types must be build-in.
// The function body goes between { and }.
func_def returns [FuncDefinition ast]
 : 'def' ID parameters {$ast = new FuncDefinition($ID.line, $ID.pos+1, $ID.text, new FunctionType($ID.line, $ID.pos+1, null, $parameters.ast), null);}':' (build_in_type{((FunctionType)$ast.getType()).setReturnType($build_in_type.ast);}|'void'{((FunctionType)$ast.getType()).setReturnType(VoidType.getInstance());}) '{' func_body '}' {$ast.setStatements($func_body.ast);}
 ;

// Is the last mandatory function in every program.
// Always no parameters and void return type;
main_def returns [Definition ast]
 : {List<VarDefinition> null_list = new ArrayList<VarDefinition>();}'def' 'main' '('')' ':' 'void' '{' func_body '}'{ $ast = new FuncDefinition($start.getLine(), $start.getCharPositionInLine()+1, "main", new FunctionType($start.getLine(), $start.getCharPositionInLine()+1, VoidType.getInstance(), null_list), $func_body.ast); }
 ;

//
parameters returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]
 : '('')'
 | '(' s1=single_var_def{$ast.add($s1.ast);} (',' s2=single_var_def{$ast.add($s2.ast);} )* ')'
 ;

// Sequence of variable definitions followed by sequences of statements.
// Both must end with the ';' character.
func_body returns [List<Statement> ast = new ArrayList<Statement>()]
 : (var_def {$ast.addAll($var_def.ast);}';'?)*(statement{$ast.addAll($statement.ast);}';'?)*
 ;


// --------------------------
// EXPRESSIONS
// --------------------------

expression returns [Expression ast]
 : '('expression')' {$ast = $expression.ast;}
 | ex1=expression '['ex2=expression']' {$ast=new Indexing($start.getLine(), $start.getCharPositionInLine()+1, $ex1.ast, $ex2.ast);}
 | exp=expression '.' ID {$ast = new FieldAccess($ID.line, $ID.pos, $exp.ast, $ID.text);}
 | cast {$ast = $cast.ast;}
 | '-' expression {$ast = new UnaryMinus($start.getLine(), $start.getCharPositionInLine()+1, $expression.ast);}
 | '!' expression {$ast = new Negation($start.getLine(), $start.getCharPositionInLine()+1, $expression.ast);}
 | ex1=expression op=('*'|'%') ex2=expression {$ast = new Arithmetic($start.getLine(), $start.getCharPositionInLine()+1, $ex1.ast, $op.text, $ex2.ast);}
 | ex1=expression op=('+'|'-') ex2=expression {$ast = new Arithmetic($start.getLine(), $start.getCharPositionInLine()+1, $ex1.ast, $op.text, $ex2.ast);}
 | ex1=expression op=('>'|'>='|'<'|'<='|'!='|'==') ex2=expression {$ast = new Comparison($start.getLine(), $start.getCharPositionInLine()+1, $ex1.ast, $op.text, $ex2.ast);}
 | ex1=expression op=('&&'|'||') ex2=expression {$ast = new Logical($start.getLine(), $start.getCharPositionInLine()+1, $ex1.ast, $op.text, $ex2.ast);}
 | var_invocation {$ast = $var_invocation.ast;}
 | func_invocation {$ast = $func_invocation.ast;}
 | INT_CONSTANT {$ast = new IntLiteral($start.getLine(), $start.getCharPositionInLine()+1, LexerHelper.lexemeToInt($INT_CONSTANT.text));}
 | REAL_CONSTANT {$ast = new RealLiteral($start.getLine(), $start.getCharPositionInLine()+1, LexerHelper.lexemeToReal($REAL_CONSTANT.text));}
 | CHAR_CONSTANT {$ast = new CharLiteral($start.getLine(), $start.getCharPositionInLine()+1, LexerHelper.lexemeToChar($CHAR_CONSTANT.text));}
 ;


// --------------------------
// STATEMENTS
// --------------------------

statement returns [List<Statement> ast = new ArrayList<Statement>()]
 : if_st {$ast.add($if_st.ast);}
 | while_st {$ast.add($while_st.ast);}
 | write_st {$ast.addAll($write_st.ast);}
 | read_st {$ast.addAll($read_st.ast);}
 | func_invocation {$ast.add((Statement)$func_invocation.ast);}
 | assigment {$ast.add($assigment.ast);}
 | return_st {$ast.add($return_st.ast);}
 ;

// The word print followed by a non-empty comma separated list of expressions.
write_st returns [List<Statement> ast = new ArrayList<Statement>()]
 : 'print' ex1=expression {$ast.add(new Write($start.getLine(), $start.getCharPositionInLine()+1, $ex1.ast));} (','ex2=expression {$ast.add(new Write($start.getLine(), $start.getCharPositionInLine()+1, $ex2.ast));})* ';'?
 ;

// The word input followed by a non-empty comma separated list of expressions.
read_st returns [List<Statement> ast = new ArrayList<Statement>()]
 : 'input' ex1=expression {$ast.add(new Read($start.getLine(), $start.getCharPositionInLine()+1, $ex1.ast));} (','ex2=expression {$ast.add(new Read($start.getLine(), $start.getCharPositionInLine()+1, $ex2.ast));})* ';'?
 ;

// Built from and expression, a '=' operator and another expression.
assigment returns [Statement ast]
 : ex1=expression '=' ex2=expression ';'? {$ast = new Assignment($start.getLine(), $start.getCharPositionInLine()+1, $ex1.ast, $ex2.ast);}
 | ex=expression op=('++'|'--') {$ast = new Assignment($start.getLine(), $start.getCharPositionInLine()+1, $ex.ast, new Arithmetic($start.getLine(), $start.getCharPositionInLine()+1, $ex.ast, $op.text, new IntLiteral($start.getLine(), $start.getCharPositionInLine(), 1)));}
 | ex1=expression op=('+='|'-='|'*='|'/=') ex2=expression {$ast = new Assignment($start.getLine(), $start.getCharPositionInLine()+1, $ex1.ast, new Arithmetic($start.getLine(), $start.getCharPositionInLine()+1, $ex1.ast, $op.text, $ex2.ast));}
 ;

// An expression, the conditional operator and the expression to compare.
condition returns [Statement ast]
 : ex1=expression op=('>'|'>='|'<'|'<='|'!='|'==') ex2=expression {$ast = new Comparison($start.getLine(), $start.getCharPositionInLine()+1, $ex1.ast, $op.text, $ex2.ast);}
 | ex1=expression op=('&&'|'||') ex2=expression {$ast = new Logical($start.getLine(), $start.getCharPositionInLine()+1, $ex1.ast, $op.text, $ex2.ast);}
 ;

// If statement can have a complex body associated or not. Same with the else.
if_st returns [Statement ast]
 : 'if' expression {$ast = new IfStatement($start.getLine(), $start.getCharPositionInLine()+1, null, null, (Expression)$expression.ast);} ':' (elif_simple_body {((IfStatement)$ast).setIfBody($elif_simple_body.ast);}| elif_body{((IfStatement)$ast).setIfBody($elif_body.ast);}) (else_st {((IfStatement)$ast).setElseBody($else_st.ast);})?
 ;

// Else cal have a complex body.
else_st returns [List<Statement> ast = new ArrayList<Statement>()]
 : 'else' (elif_simple_body {$ast.addAll($elif_simple_body.ast);}| elif_body {$ast.addAll($elif_body.ast);})
 ;

// Simple body for the else and if blocks. Only one expression.
// the expression ends in ';'.
elif_simple_body returns [List<Statement> ast = new ArrayList<Statement>()]
 : statement ';'? {$ast.addAll($statement.ast);}
 ;

// Multiple expressions in the else if body.
elif_body returns [List<Statement> ast = new ArrayList<Statement>()]
 : '{' (statement {$ast.addAll($statement.ast);}';'?)+ '}'
 ;

// While statement. before + after condition!
while_st returns [Statement ast]
 : 'while' expression ':' while_body {$ast = new WhileStatement($start.getLine(), $start.getCharPositionInLine()+1, $while_body.ast, (Expression)$expression.ast);}
 ;

// Body of the while statement, must have at least one expression.
// Every expression ends in ';'
while_body returns [List<Statement> ast = new ArrayList<Statement>()]
 : '{' (statement {$ast.addAll($statement.ast);} ';'?)+ '}'
 ;

// the word return and the expression, that is mandatory.
return_st returns [Statement ast]
 : 'return' expression ';'? {$ast = new Return($start.getLine(), $start.getCharPositionInLine()+1, $expression.ast);}
 ;

cast returns [Expression ast]
 : '('build_in_type')' expression ';'? {$ast = new Cast($start.getLine(), $start.getCharPositionInLine()+1, $expression.ast, $build_in_type.ast);}
 ;


// --------------------------
// INVOCATIONS
// --------------------------

func_invocation returns [Expression ast]
 : ID argument ';'? {$ast = new Invocation($start.getLine(), $start.getCharPositionInLine()+1, new Variable($ID.line, $ID.pos, $ID.text), $argument.ast);}
 ;

argument returns [List<Expression> ast = new ArrayList<Expression>()]
 : '('')'
 | '('ex1=expression {$ast.add($ex1.ast);} (',' ex2=expression {$ast.add($ex2.ast);})*')'
 ;

proc_invocation
 : ';'
 ;

var_invocation returns [Expression ast]
 : ID {$ast = new Variable($ID.line, $ID.pos, $ID.text);} ';'?
 ;


 // --------------------------
 // TOKENS
 // --------------------------

SKIP_
 : ( WHITE_SPACE | ONE_LINE_COMMENT | MULTI_LINE_COMMENT ) -> skip
 ;

fragment	 WHITE_SPACE
 : [ \t\r\n\fEOF]+
 ;

fragment	 ONE_LINE_COMMENT
 //: '#'.*? [\n\fEOF]
 // '#'.*?[ \r\fEOF]*
 : '#' ~[\r\n\f]*
 ;

fragment MULTI_LINE_COMMENT
 : '"""'.*?'"""'
 ;

fragment DIGIT
 : [0-9]
 ;

fragment NON_ZERO_DIGIT
 : [1-9]
 ;

fragment EXPONENT
 : [eE] [+-]? DIGIT+
 ;

fragment FRACTION
 : '.' DIGIT+
 ;

INT_CONSTANT
 : '0'
 | [1-9]DIGIT*
 ;

REAL_CONSTANT
 : INT_CONSTANT? FRACTION
 | INT_CONSTANT '.'
 | INT_CONSTANT EXPONENT
 | INT_CONSTANT '.' DIGIT* EXPONENT
 ;

STRUCT
 : 'struct'
 ;

CHAR_CONSTANT
 : '\'' . '\''
 | '\'' '\\' INT_CONSTANT INT_CONSTANT INT_CONSTANT'\''
 | '\'' '\\n' '\''
 | '\'' '\\t' '\''
 | '\'' '-' '\''
 ;

ID
 : [a-zA-Z_][a-zA-Z0-9_]*
 ;
