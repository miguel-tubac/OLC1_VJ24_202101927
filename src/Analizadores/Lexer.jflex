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
%} 
//Esto es extra para estados:
//%state CADENA//estados
// ------> Expresiones Regulares, aqui debo de definir todas las expreciones 

entero = [0-9]+
numero_decimal = ([0-9]+\.[0-9]+)
espacio = [ ]
id = [a-zA-Z][a-zA-Z0-9_]*|[\"][^\n\"]*[\"]
comentario_linea = "//".*
comentario_multiple = [/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]

caracter = ["\'"]([^"\'"])?["\'"]


%%
// ------------  Reglas Lexicas -------------------
//Aqui se llaman a las expreciones regulares, se generan los tokens
//luego de cada declarion debo de ir y declararla en Parser.cup en "Declaración de terminales"


//------> Simbolos
":"       { return new Symbol(sym.DOSPUNTOS, yycolumn, yyline, yytext());}
"::"      { return new Symbol(sym.DOBLEDOSPUNTOS, yycolumn, yyline, yytext());}
","       { return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
"("       { return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext());}
")"       { return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext());}
";"       { return new Symbol(sym.PUNTOYCOMA, yycolumn, yyline, yytext());}
"="       { return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());}
"<"       { return new Symbol(sym.MENOR, yycolumn, yyline, yytext());}
">"       { return new Symbol(sym.MAYOR, yycolumn, yyline, yytext());}
"["       { return new Symbol(sym.CORCHETE_A, yycolumn, yyline, yytext());}
"]"       { return new Symbol(sym.CORCHETE_C, yycolumn, yyline, yytext());}
"-"       { return new Symbol(sym.GUION, yycolumn, yyline, yytext());}
//------> Instrucciones
"println"       { return new Symbol(sym.PRINTLN, yycolumn, yyline, yytext());}


//------> Operadores


//------> Expresiones
{espacio}           {}
{entero}            { return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); }
{numero_decimal}    { return new Symbol(sym.NUMERODECIMAL, yycolumn, yyline, yytext()); }
{id}                { return new Symbol(sym.ID, yycolumn, yyline, yytext()); }
{comentario_linea}        {}
{comentario_multiple}     {}
{caracter}          { return new Symbol(sym.CHAR, yycolumn, yyline, yytext()); }


//------> Ignorados 
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}

//------> Errores Léxicos 
.           	{  
                    System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); 
                }
