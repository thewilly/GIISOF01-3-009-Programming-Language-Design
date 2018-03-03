grammar Pmm;

@header {
  import ast.*;
  import java.util.*;
}

// Sequence of variable and function definitions and a main function definition.
program returns [Program ast]
 : {List<Definition> defs = new ArrayList<Definition>();}((var_def';'){defs.addAll($var_def.defs);}|func_def{defs.add($func_def.def);})* main_def{defs.add($main_def.def);$ast = new Program(0,0,defs);}
 ;

// --------------------------
// BUILT-IN
// --------------------------

// Built-in types are int, double and char.
build_in_type returns [Type type]
 : 'int' {$type = IntType.getInstance();} | 'double' {$type = RealType.getInstance();} | 'char' {$type = CharType.getInstance();}
 ;


// --------------------------
// VARIABLE DEFINITIONS
// --------------------------

// Non-empty enumeration of comma-separated identifiers followed by a ':' and a type.
var_def returns [List<Definition> defs = new ArrayList<Definition>()]
 : single_var_def {$defs.add($single_var_def.var);}
 | multi_var_def {$defs.addAll($multi_var_def.vars);}
 | {List<RecordField> fields = new ArrayList<RecordField>();}ID ':' 'struct' '{' (fields{fields.addAll($fields.vars);}) '}' {$defs.add(new VarDefinition($ID.line, $ID.pos+1, $ID.text, new RecordType($ID.line, $ID.pos+1, fields)));}
 ;

// When we only have one variable definition.
single_var_def returns [VarDefinition var]
 : ID {$var = new VarDefinition($ID.line, $ID.pos+1, $ID.text, null);}':' ('['INT_CONSTANT']')* build_in_type {$var.setType($build_in_type.type);}
 ;

// When we have an enumeration of variable and a definition.
multi_var_def returns [List<VarDefinition> vars = new ArrayList<VarDefinition>()]
 : id1=ID {$vars.add(new VarDefinition($id1.line, $id1.pos+1, $id1.text, null));}(','id2=ID {$vars.add(new VarDefinition($id2.line, $id2.pos+1, $id2.text, null));})+ ':' ('['INT_CONSTANT']')* build_in_type {for(Definition def : $vars) {def.setType($build_in_type.type);}}
 ;

// Declared as a variable and ending with ';' always.
fields returns [List<RecordField> vars = new ArrayList<RecordField>()]
 : (var_def {for(Definition def : $var_def.defs) {$vars.add(new RecordField(def.getLine(), def.getColumn(), def.getName(), def.getType(), 0));}}';')+
 ;


// --------------------------
// FUNCTION DEFINITIONS
// --------------------------

// It's defined by the def keyword, the function identifier and a list of
// comma-separated parameters between ( and ) followed by a ':' and a return
// type or the void keyword. The return type and parameter types must be build-in.
// The function body goes between { and }.
func_def returns [FuncDefinition def]
 : 'def' ID parameters {$def = new FuncDefinition($ID.line, $ID.pos+1, $ID.text, new FunctionType($ID.line, $ID.pos+1, null, $parameters.vars), null);}':' (build_in_type{((FunctionType)$def.getType()).setReturnType($build_in_type.type);}|'void'{((FunctionType)$def.getType()).setReturnType(VoidType.getInstance());}) '{' func_body '}' {$def.setStatements($func_body.statements);}
 ;

// Is the last mandatory function in every program.
// Always no parameters and void return type;
main_def returns [Definition def]
 : 'def' 'main' '('')' ':' 'void' '{' func_body '}'{ $def = new FuncDefinition($start.getLine(), $start.getCharPositionInLine()+1, "main", VoidType.getInstance(), $func_body.statements); }
 ;

//
parameters returns [List<VarDefinition> vars = new ArrayList<VarDefinition>()]
 : '('')'
 | '(' s1=single_var_def{$vars.add($s1.var);} (',' s2=single_var_def{$vars.add($s2.var);} )* ')'
 ;

// Sequence of variable definitions followed by sequences of statements.
// Both must end with the ';' character.
func_body returns [List<Statement> statements = new ArrayList<Statement>()]
 : (var_def {$statements.addAll($var_def.defs);}';')*(statement{$statements.add($statement.st);})*
 ;


// --------------------------
// EXPRESSIONS
// --------------------------

expression
 : '('expression')'
 | '['expression']'
 | ID '.' expression
 | cast
 | '-' expression
 | '!' expression
 | expression op=('*'|'%') expression
 | expression op=('+'|'-') expression
 | expression op=('>'|'>='|'<'|'<='|'!='|'==') expression
 | expression op=('&&'|'||') expression
 | expression '=' expression
 | var_invocation
 | func_invocation
 | INT_CONSTANT
 | REAL_CONSTANT
 | CHAR_CONSTANT
 ;


// --------------------------
// STATEMENTS
// --------------------------

statement returns [Statement st]
 : if_st
 | while_st
 | write_st
 | read_st
 | func_invocation
 | proc_invocation
 | assigment
 | return_st
 ;

// The word print followed by a non-empty comma separated list of expressions.
write_st
 : 'print' expression (','expression)*
 ;

// The word input followed by a non-empty comma separated list of expressions.
read_st
 : 'input' expression (','expression)*
 ;

// Built from and expression, a '=' operator and another expression.
assigment
 : expression '=' expression
 ;

// An expression, the conditional operator and the expression to compare.
condition
 : expression op=('>'|'>='|'<'|'<='|'!='|'==') expression
 ;
// If statement can have a complex body associated or not. Same with the else.
if_st
 : 'if' condition+ ':' (elif_simple_body | elif_body) else_st?
 ;

// Else cal have a complex body.
else_st
 : 'else' (elif_simple_body | elif_body)
 ;

// Simple body for the else and if blocks. Only one expression.
// the expression ends in ';'.
elif_simple_body
 : statement ';'
 ;

// Multiple expressions in the else if body.
elif_body
 : '{' (statement ';')+ '}'
 ;

// While statement.
while_st
 : 'while' condition+ ':' while_body
 ;

// Body of the while statement, must have at least one expression.
// Every expression ends in ';'
while_body
 : '{' (statement)+ '}'
 ;

// the word return and the expression, that is mandatory.
return_st
 : 'return' expression
 ;

cast
 : '('build_in_type')' expression
 ;


// --------------------------
// INVOCATIONS
// --------------------------

func_invocation
 : ID argument
 ;

argument
 : '('')'
 | '('expression {} (',' expression)*')'
 ;

proc_invocation
 : ';'
 ;

var_invocation
 : ID ('['expression']')*
 ;




















// Tokens.

SKIP_
 : ( WHITE_SPACE | ONE_LINE_COMMENT | MULTI_LINE_COMMENT ) -> skip
 ;

fragment	 WHITE_SPACE
 : [ \t\r\n\fEOF]+
 ;

fragment	 ONE_LINE_COMMENT
 : '#'.*? '\n'
 // '#'.*?[ \r\fEOF]*
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
