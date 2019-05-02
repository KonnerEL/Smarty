grammar Smarty;

/* Parser Rules */
contractDefinition
    : entity* event+ invoke+ EOF
    ;

entity 
    : Identifier ':{' field '}'
    ;

field
    : Identifier ':' Type (',' Identifier ':' Type)*
    ;

event
    : custom_event  
    | insert_object
    ;

custom_event
    : '@event' Identifier ':' 
        argument?
        entities?
        precondition*
        action+ 
        postcondition*
    ;

argument
    : '@args' '[' Identifier (',' Identifier)* ']'
    ; 

entities
    : subjects
    ;

subjects
    : '@subjects' '[' Identifier ('=>' Identifier)? ']'
    ;    

insert_object
    : '@create_'Identifier ':'
        argument
        invariant*
        action*
    ; 

get_info
    : '@get_info:'
        argument
        subjects
        (Write StringLiteral)?
    ;

invariant
    : '@invariant' condition
      '@warning' StringLiteral  
    ;

precondition
    : '@pre' condition
      exceptionHandler
    ;

action
    : '@action' statement
    ;

postcondition
    : '@post' condition
      '@reverts'?    
    ;

exceptionHandler
    : '@fails' StringLiteral
    ;

condition
    : left_Side Logic_Operator right_Side 
    ;

statement
    : left_Side ((':=' right_Side (Arithmetic_Operator right_Side)*) | StringLiteral)
    ;    

left_Side
    : '@after.'? (Identifier('.'Identifier)?(Arithmetic_Operator right_Side)*)
    | Write
    ;

right_Side
    : value
    | '@before.'? (Identifier('.'Identifier)?(Arithmetic_Operator right_Side)*)
    ; 

value
    : Boolean
    | Integer
    | Decimal 
    | Identifier
    ;             

invoke
    : value Identifier value invocation_argument? 
    | Identifier invocation_argument?
    ;  

invocation_argument
    : '[' value (',' value)* ']'
    ;


/* Lexer Rules */

Logic_Operator
    : '>'
    | '>='
    | '='
    | '!='
    | '<'
    | '<='
    ; 

Arithmetic_Operator
    : '+'
    | '-'
    | '*'
    | '/' 
    | '+='
    | '-='
    | '*='
    | '/='  
    | '%'
    | '^' 
    | '++'
    | '--'
    ;     

Boolean
    : 'true'
    | 'false'
    ;

Integer
    : [0-9]+
    ;

Decimal
    : [0-9]+ '.' [0-9]+
    ;

Type
    : 'bool'
    | 'integer'
    | 'decimal'
    | 'string'
    ;    

StringLiteral
    : UnterminatedStringLiteral '"'
    ;

UnterminatedStringLiteral
    : '"' (~["\\\r\n] | '\\' (. | EOF))*
    ;    

Identifier
    : [a-zA-Z$_][a-zA-Z0-9$_]* 
    ;

ID
    : [a-zA-Z$_][a-zA-Z0-9$_]* 
    ;

Write
    : 'Write' 
    ; 

WS 
    : [ \t\n\r]+ -> skip 
    ;