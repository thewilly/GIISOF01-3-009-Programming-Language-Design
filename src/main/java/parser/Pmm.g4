grammar Pmm;	

program : 
 ;
 
SKIP_
 : ( WHITE_SPACE | ONE_LINE_COMMENT | MULTI_LINE_COMMENT ) -> skip
 ;
       
fragment	 WHITE_SPACE
 : [ \t\r\n]+
 ;

fragment MULTI_LINE_COMMENT
 : '"""'.*?'"""'
 ;

fragment	 ONE_LINE_COMMENT
 : '#' ~[\r\n\f]*
 ;

fragment DIGIT
 : [0-9]
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
