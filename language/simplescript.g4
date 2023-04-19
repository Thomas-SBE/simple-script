grammar simplescript;

type: 'bool' | 'int';
boolean: 'true' | 'false';
unary_operator: '!' | '-' | '+';
binary_operator: '+' | '-' | '/' | '*' | '==' | '!=' | '>' | '>=' | '<' | '<=' | '||' | '&&';
increments_operator: '++' | '--';

function_parameter: ID ':' type;
function_declaration: 'function' ID '(' (function_parameter (',' function_parameter)*)? ')' ':' type '=>' instruction;

expression:
    INT #expressionInt
    | boolean #expressionBoolean
    | expression binary_operator expression #expressionBinary
    | unary_operator expression #expressionUnary
    | '(' expression ')' #expressionEmbedded
    | ID '(' (expression (',' expression)*)? ')' #expressionFunctionCall
    | ID #expressionIdentifier
    | ID '[' expression ']' #expressionIdentifierArray
    | ID increments_operator #expressionIncrementation
    ;

instruction:
    'return' expression EOIC #instructionReturn
    | 'var' ID ':' type ('=' expression)? EOIC #instructionVariableDeclaration
    | 'var' ID ':' type '[' INT ']' ('=' '[' expression (',' expression)* ']')? EOIC #instructionVariableArrayDeclaration
    | ID '=' expression EOIC #instructionVariableAssign
    | ID '[' expression ']' '=' expression EOIC #instructionVariableArrayAssign
    | 'if' '(' expression ')' '=>' instruction ('else' '=>' instruction)? #instructionIf
    | 'while' '(' expression ')' '=>' instruction #instructionWhile
    | 'for' '(' 'var' ID ':' type '=' expression EOIC expression EOIC instruction ')' '=>' instruction #instructionFor
    | '{' instruction* '}' #instructionBlock
    | ID increments_operator EOIC #instructionIncrementation
    | ID '(' (expression (',' expression)*)? ')' #instructionFunctionCall
    ;

program: (instruction|function_declaration)*;

EOIC: ';'; // End of Instruction Character
ID:[a-zA-Z][a-zA-Z0-9]*;
INT:[0-9]+;
WS:[ \t\n\r] -> skip;