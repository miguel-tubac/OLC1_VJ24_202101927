// ------------  Paquete e importaciones ------------
package Analizadores; 

import java_cup.runtime.*;

%%	
//-------> Directivas (No tocar)

%public 
%class Lexer
%cup
%char
%column
%line
%unicode
%ignorecase

%{
    //Tokens token;
    //Errores error;
    String cadena = "";
%} 

%state CADENA
%state CARACTER
// ------> Expresiones Regulares, aqui debo de definir todas las expreciones 

entero = [0-9]+
numero_decimal = ([0-9]+\.[0-9]+)
id = [a-zA-Z][a-zA-Z0-9_]*
comentario_linea = "//".*    
comentario_multiple = [/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]

%%
// ------------  Reglas Lexicas -------------------
//Aqui se llaman a las expreciones regulares, se generan los tokens
//luego de cada declarion debo de ir y declararla en Parser.cup en "Declaración de terminales"

//------> Simbolos
<YYINITIAL> ":"       { return new Symbol(sym.DOSPUNTOS, yycolumn, yyline, yytext());}
<YYINITIAL> "::"      { return new Symbol(sym.DOBLEDOSPUNTOS, yycolumn, yyline, yytext());}
<YYINITIAL> ","       { return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
<YYINITIAL> "("       { return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext());}
<YYINITIAL> ")"       { return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext());}
<YYINITIAL> ";"       { return new Symbol(sym.PUNTOYCOMA, yycolumn, yyline, yytext());}
<YYINITIAL> "="       { return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());}
<YYINITIAL> "=="      { return new Symbol(sym.DOBLEIGUAL, yycolumn, yyline, yytext());}
<YYINITIAL> "!="      { return new Symbol(sym.DIFERENCIA, yycolumn, yyline, yytext());}
<YYINITIAL> "<"       { return new Symbol(sym.MENOR, yycolumn, yyline, yytext());}
<YYINITIAL> "<="      { return new Symbol(sym.MENORIGUAL, yycolumn, yyline, yytext());}
<YYINITIAL> ">"       { return new Symbol(sym.MAYOR, yycolumn, yyline, yytext());}
<YYINITIAL> ">="      { return new Symbol(sym.MAYORIGUAL, yycolumn, yyline, yytext());}
<YYINITIAL> "["       { return new Symbol(sym.CORCHETE_A, yycolumn, yyline, yytext());}
<YYINITIAL> "]"       { return new Symbol(sym.CORCHETE_C, yycolumn, yyline, yytext());}
<YYINITIAL> "-"       { return new Symbol(sym.MENOS, yycolumn, yyline, yytext());}
<YYINITIAL> "+"       { return new Symbol(sym.MAS, yycolumn, yyline, yytext());}
<YYINITIAL> "*"       { return new Symbol(sym.POR, yycolumn, yyline, yytext());}
<YYINITIAL> "/"       { return new Symbol(sym.DIV, yycolumn, yyline, yytext());}
<YYINITIAL> "**"      { return new Symbol(sym.POTENCIA, yycolumn, yyline, yytext());}
<YYINITIAL> "%"       { return new Symbol(sym.MODULO, yycolumn, yyline, yytext());}
<YYINITIAL> "||"      { return new Symbol(sym.OR, yycolumn, yyline, yytext());}
<YYINITIAL> "&&"      { return new Symbol(sym.AND, yycolumn, yyline, yytext());}
<YYINITIAL> "^"       { return new Symbol(sym.XOR, yycolumn, yyline, yytext());}
<YYINITIAL> "!"       { return new Symbol(sym.NOT, yycolumn, yyline, yytext());}

//------> Instrucciones
<YYINITIAL> "println"       { return new Symbol(sym.PRINTLN, yycolumn, yyline, yytext());}
<YYINITIAL> "true"          { return new Symbol(sym.TRUE, yycolumn, yyline, yytext());}
<YYINITIAL> "false"         { return new Symbol(sym.FALSE, yycolumn, yyline, yytext());}
<YYINITIAL> "var"           { return new Symbol(sym.VAR, yycolumn, yyline, yytext());}
<YYINITIAL> "const"         { return new Symbol(sym.CONST, yycolumn, yyline, yytext());}
<YYINITIAL> "int"           { return new Symbol(sym.INT, yycolumn, yyline, yytext());}
<YYINITIAL> "double"        { return new Symbol(sym.DOUBLE, yycolumn, yyline, yytext());}
<YYINITIAL> "bool"          { return new Symbol(sym.BOOL, yycolumn, yyline, yytext());}
<YYINITIAL> "char"          { return new Symbol(sym.CHAR, yycolumn, yyline, yytext());}
<YYINITIAL> "String"        { return new Symbol(sym.STRING, yycolumn, yyline, yytext());}

//------> Operadores

//------> Expresiones
<YYINITIAL> {entero}            { return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); }
<YYINITIAL> {numero_decimal}    { return new Symbol(sym.NUMERODECIMAL, yycolumn, yyline, yytext()); }
<YYINITIAL> {id}                { return new Symbol(sym.ID, yycolumn, yyline, yytext()); }
<YYINITIAL> {comentario_linea}        {}
<YYINITIAL> {comentario_multiple}     {}


// -------> Manejo de cadenas de texto
<YYINITIAL> \" { cadena = ""; yybegin(CADENA); }

<CADENA> {
    \" { String tmp = cadena; cadena = ""; yybegin(YYINITIAL); return new Symbol(sym.CADENA, yyline, yycolumn, tmp); }
    \\\\ { cadena += "\\"; }
    \\\" { cadena += "\""; }
    \\\' { cadena += "\'"; }
    \\n { cadena += "\n"; }
    \\t { cadena += "\t"; }
    \\r { cadena += "\r"; }
    [^\"\\] { cadena += yytext(); }//aca es cuando se ignoran los otros casos, por lo tanto es el texto
}

<YYINITIAL> \' { cadena = ""; yybegin(CARACTER); }

<CARACTER> {
    \'      { String tmp = cadena; cadena = ""; yybegin(YYINITIAL); return new Symbol(sym.CARACTER, yyline, yycolumn, tmp); }
    \\\\    { cadena = "\\"; }
    \\\"    { cadena = "\""; }
    \\\'    { cadena = "\'"; }
    \\n     { cadena = "\n"; }
    \\t     { cadena = "\t"; }
    \\r     { cadena = "\r"; }
    [^\'\\] { cadena = yytext(); }//aca es cuando se ignoran los otros casos, por lo tanto es el texto
}


//------> Ignorados 
<YYINITIAL> [ \t\r\n\f]     {/* Espacios en blanco se ignoran */}

//------> Errores Léxicos 
<YYINITIAL> .           	{  
                    System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); 
                }
