grammar simplescript;

type: 'bool' | 'int' | 'string';
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
    ;

instruction:
    'return' expression EOIC #instructionReturn
    | 'var' ID ':' type ('=' expression)? EOIC #instructionVariableDeclaration
    | ID '=' expression EOIC #instructionVariableAssign
    | 'if' '(' expression ')' '=>' instruction ('else' '=>' instruction)? #instructionIf
    | 'while' '(' expression ')' '=>' instruction #instructionWhile
    | '{' instruction* '}' #instructionBlock
    | ID increments_operator EOIC #instructionIncrementation
    ;

program: (instruction|function_declaration)*;

EOIC: ';'; // End of Instruction Character
ID:[a-zA-Z][a-zA-Z0-9]*;
INT:[0-9]+;
WS:[ \t\n\r] -> skip;