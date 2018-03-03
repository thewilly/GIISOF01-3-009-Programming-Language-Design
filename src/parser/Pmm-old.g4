grammar Pmm;

@header {
  import ast.*;
  import java.util.*;
}

program returns [Program ast]
 : {List<Definition> defs = new ArrayList<Definition>();}(var_definition {defs.addAll($var_definition.ast);}|func_definition {defs.add($func_definition.ast);})* main_definition {defs.add($main_definition.ast);$ast = new Program(0,0,defs);}
 ;

//Parser rules

var_definition returns [List<Definition> ast = new ArrayList<Definition>()]
 : simple_var_definition ';'? {$ast.add($simple_var_definition.ast);}
 | multi_var_definition ';'? {$ast.addAll($multi_var_definition.ast);}
 | array ';'? {$ast.add($array.ast);}
 | struct_def ';'? {$ast.add($struct_def.ast);}
 ;

multi_var_definition returns [List<Definition> ast = new ArrayList<Definition>()]
 : id1=ID {$ast.add(new VarDefinition(0,0,$id1.text,null));}
 (',' id2=ID {$ast.add(new VarDefinition(0,0,$id2.text,null));})* ':' build_in_type { for (Definition def : $ast) {def.setType($build_in_type.ast);}}
 ;

simple_var_definition returns [VarDefinition ast]
 : ID ':' build_in_type {$ast = new VarDefinition(0,0, $ID.getText(), $build_in_type.ast);}
 ;

var_call
 : ID
 ;

build_in_type returns [Type ast]
 : 'int' {$ast = IntType.getInstance();}
 | 'char' {$ast = CharType.getInstance();}
 | 'double' {$ast = RealType.getInstance();}
 | 'void' {$ast = VoidType.getInstance();}
 ;

func_definition returns [Definition ast]
 : 'def' ID parameters ':' build_in_type '{' func_body '}' {$ast = new FuncDefinition(0,0,$ID.text,new FunctionType(0,0,$build_in_type.ast, $parameters.ast),$func_body.ast);}
 ;

func_body returns [List<Statement> ast = new ArrayList<Statement>()]
 : (var_definition {$ast.addAll($var_definition.ast);})* ((expression {$ast.add($expression.ast);}|statement {$ast.add($statement.ast);}) ';'?)* (return_statement {$ast.add($return_statement.ast);})?
 ;

func_call returns [Statement ast]
 : ID argument ';'? {$ast = new Invocation(0,0, new Variable(0,0, $ID.text), $argument.ast);}
 | cast ';'?
 ;

main_definition returns [Definition ast]
 : 'def' 'main' '('')' ':' 'void' '{' func_body '}'
 ;

parameters returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]
 : '('')'
 | '(' s1=simple_var_definition {$ast.add($s1.ast);}(',' s2=simple_var_definition {$ast.add($s2.ast);})* ')'
 ;

argument returns [List<Expression> ast = new ArrayList<Expression>()]
 : '('')'
 | '('expression {} (',' expression)*')'
 ;

array returns [Definition ast]
 : ID ':' '['INT_CONSTANT']'('['INT_CONSTANT']')* build_in_type
 ;

array_call
 : ID '['INT_CONSTANT']'('['INT_CONSTANT']')*
 ;

cast
 : '('build_in_type')' expression
 ;

struct_def returns [Definition ast]
 : ID ':' 'struct' '{' (field)+ '}'
 ;

field
 : simple_var_definition ';'
 | array ';'
 | struct_def
 ;

return_statement returns [Statement ast]
 : 'return' expression ';' {$ast = new Return(0,0, $expression.ast);}
 ;

expression returns [Expression ast]
 : '('expression')'
 | '['expression']'
 | array_call
 | var_call('.'var_call)*
 | cast
 | '-' expression
 | '!' expression
 | expression op=('*'|'/'|'%') expression
 | expression op=('+'|'-') expression
 | expression op=('>'|'>='|'<'|'<='|'!='|'==') expression
 | expression op=('&&'|'||') expression
 | expression '=' expression
 | INT_CONSTANT | REAL_CONSTANT
 | CHAR_CONSTANT
 | INT_CONSTANT
 | REAL_CONSTANT
 ;

statement returns [Statement ast]
 : func_call {$ast = $func_call.ast;}
 | if_stmt
 | while_stmt
 | print_stmt
 | read_stmt
 ;

condition
 : expression op=('>'|'>='|'<'|'<='|'!='|'==') expression
 ;

if_stmt
 : 'if' condition+ ':' (if_simple_body | if_body) else_stmt?
 ;

if_simple_body
 : expression ';'?
 ;

if_body
 : '{' (expression ';')+ '}'
 ;

else_stmt
 : 'else' (else_simple_body | else_body)
 ;

else_simple_body
 : expression ';'?
 ;

else_body
 : '{' (expression ';')+ '}'
 ;

while_stmt
 : 'while' condition+ ':' while_body
 ;

while_body
 : '{' (expression ';'?)+ '}'
 ;

print_stmt
 : 'print' expression (','expression)*
 ;

read_stmt
 : 'input' expression (','expression)*
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
