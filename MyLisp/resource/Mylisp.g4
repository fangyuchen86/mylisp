grammar Mylisp;

file: (form|literal)*;
  
form: '(' (form|literal)* ')'
    ;
    
literal
    : STRING
    | NUMBER 
    | NIL
    | BOOLEAN
    | SYMBOL
    ;   
  
STRING : '"' ( ~'"' | '\\' '"' )* '"' ;
  
NUMBER : '-'? [0-9]+ ('.' [0-9]+)? ([eE] '-'? [0-9]+)? ;


NIL : 'nil';
  
BOOLEAN : 'true' | 'false' ;

SYMBOL: '.' | '/' | NAME ('/' NAME)? ;
  
fragment
NAME: SYMBOL_HEAD SYMBOL_REST* (':' SYMBOL_REST+)* ;

fragment
SYMBOL_HEAD
    :   'a'..'z' | 'A'..'Z' | '*' | '+' | '!' | '-' | '_' | '?' | '>' | '<' | '=' | '$'
    ;
    
fragment
SYMBOL_REST
    : SYMBOL_HEAD
    | '&' // apparently this is legal in an ID: "(defn- assoc-&-binding ..." TJP
    | '0'..'9'
    | '.'
    ;   

WS : [ \n\r\t\,] -> channel(HIDDEN) ;

COMMENT : ';' ~[\r\n]* -> channel(HIDDEN) ;
