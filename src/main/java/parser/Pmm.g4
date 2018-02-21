grammar Pmm;

program
 : (var_definition|func_definition)* main_definition
 ;

//Parser rules

var_definition
 : simple_var_definition ';'?
 | multi_var_definition ';'?
 | array ';'?
 | struct_def ';'?
 ;

multi_var_definition
 : ID (',' ID)* ':' build_in_type
 ;

simple_var_definition
 : ID ':' build_in_type
 ;

var_call
 : ID
 ;

build_in_type
 : 'int' | 'char' | 'double'
 ;

func_definition
 : 'def' ID parameters ':' (build_in_type|'void') '{' func_body '}'
 ;

func_body
 : var_definition* (expression ';'?)* return_statement?
 ;

func_call
 : ID argument ';'?
 | cast ';'?
 ;

main_definition
 : 'def' 'main' '('')' ':' 'void' '{' func_body '}'
 ;

parameters
 : '('')'
 | '(' simple_var_definition (',' simple_var_definition)* ')'
 ;

argument
 : '('')'
 | '('expression (',' expression)*')'
 ;

array
 : ID ':' '['INT_CONSTANT']'('['INT_CONSTANT']')* build_in_type
 ;

array_call
 : ID '['INT_CONSTANT']'('['INT_CONSTANT']')*
 ;

cast
 : '('build_in_type')' expression
 ;

struct_def
 : ID ':' 'struct' '{' (field)+ '}'
 ;

field
 : simple_var_definition ';'
 | array ';'
 | struct_def
 ;

return_statement
 : 'return' expression ';'
 ;

expression
 : func_call
 | '('expression')'
 | '['expression']'
 | array_call
 | var_call('.'var_call)*
 | cast
 | '-' expression
 | '!' expression
 | expression '*' expression | expression '/' expression | expression '%' expression
 | expression '+' expression | expression '-' expression
 | expression '>' expression | expression '>=' expression | expression '<' expression | expression '<=' expression | expression '!=' expression | expression '==' expression
 | expression '&&' expression | expression '||' expression
 | expression '=' expression
 | INT_CONSTANT | REAL_CONSTANT
 | if_stmt
 | while_stmt
 | print_stmt
 | read_stmt
 | CHAR_CONSTANT
 | INT_CONSTANT
 | REAL_CONSTANT
 ;

condition
 : expression '>' expression | expression '>=' expression | expression '<' expression | expression '<=' expression | expression '!=' expression | expression '==' expression
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
