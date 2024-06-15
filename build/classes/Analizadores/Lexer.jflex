// ------------  Paquete e importaciones ------------
package Analizadores; 

import java_cup.runtime.*;
import java.util.LinkedList;
import Excepciones.Errores;

%%	
%{
    public LinkedList<Errores> listaErrores = new LinkedList<>();
    String cadena = "";
%}

%init{
    yyline = 1;
    yycolumn = 1;
    listaErrores = new LinkedList<>();
%init}


//-------> Directivas (No tocar)

%cup 
%class Lexer
%public
%line
%char
%column
//%unicode
%ignorecase


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
<YYINITIAL> ":"       { return new Symbol(sym.DOSPUNTOS, yyline, yycolumn, yytext());}
<YYINITIAL> "::"      { return new Symbol(sym.DOBLEDOSPUNTOS, yyline, yycolumn, yytext());}
<YYINITIAL> ","       { return new Symbol(sym.COMA, yyline, yycolumn, yytext());}
<YYINITIAL> "("       { return new Symbol(sym.PARENTESIS_A, yyline, yycolumn, yytext());}
<YYINITIAL> ")"       { return new Symbol(sym.PARENTESIS_C, yyline, yycolumn, yytext());}
<YYINITIAL> ";"       { return new Symbol(sym.PUNTOYCOMA, yyline, yycolumn, yytext());}
<YYINITIAL> "="       { return new Symbol(sym.IGUAL, yyline,yycolumn, yytext());}
<YYINITIAL> "=>"      { return new Symbol(sym.DATOSMATCH, yyline,yycolumn, yytext());}
<YYINITIAL> "=="      { return new Symbol(sym.DOBLEIGUAL, yyline, yycolumn, yytext());}
<YYINITIAL> "!="      { return new Symbol(sym.DIFERENCIA, yyline, yycolumn, yytext());}
<YYINITIAL> "<"       { return new Symbol(sym.MENOR, yyline, yycolumn, yytext());}
<YYINITIAL> "<="      { return new Symbol(sym.MENORIGUAL, yyline, yycolumn, yytext());}
<YYINITIAL> ">"       { return new Symbol(sym.MAYOR, yyline, yycolumn, yytext());}
<YYINITIAL> ">="      { return new Symbol(sym.MAYORIGUAL, yyline, yycolumn, yytext());}
<YYINITIAL> "["       { return new Symbol(sym.CORCHETE_A,  yyline,yycolumn, yytext());}
<YYINITIAL> "]"       { return new Symbol(sym.CORCHETE_C,  yyline,yycolumn, yytext());}
<YYINITIAL> "{"       { return new Symbol(sym.LLAVE_A,  yyline,yycolumn, yytext());}
<YYINITIAL> "}"       { return new Symbol(sym.LLAVE_C, yyline,yycolumn, yytext());}
<YYINITIAL> "-"       { return new Symbol(sym.MENOS, yyline,yycolumn, yytext());}
<YYINITIAL> "--"      { return new Symbol(sym.DOBLEMENOS, yyline,yycolumn, yytext());}
<YYINITIAL> "+"       { return new Symbol(sym.MAS,  yyline,yycolumn, yytext());}
<YYINITIAL> "++"      { return new Symbol(sym.DOBLEMAS,  yyline,yycolumn, yytext());}
<YYINITIAL> "*"       { return new Symbol(sym.POR, yyline,yycolumn, yytext());}
<YYINITIAL> "/"       { return new Symbol(sym.DIV, yyline,yycolumn, yytext());}
<YYINITIAL> "**"      { return new Symbol(sym.POTENCIA,  yyline,yycolumn, yytext());}
<YYINITIAL> "%"       { return new Symbol(sym.MODULO,  yyline,yycolumn, yytext());}
<YYINITIAL> "||"      { return new Symbol(sym.OR, yyline, yycolumn,yytext());}
<YYINITIAL> "&&"      { return new Symbol(sym.AND, yyline,yycolumn, yytext());}
<YYINITIAL> "^"       { return new Symbol(sym.XOR, yyline, yycolumn,yytext());}
<YYINITIAL> "!"       { return new Symbol(sym.NOT, yyline,yycolumn, yytext());}
<YYINITIAL> "_"       { return new Symbol(sym.BAJO, yyline,yycolumn, yytext());}

//------> Instrucciones
<YYINITIAL> "println"       { return new Symbol(sym.PRINTLN, yyline, yycolumn, yytext());}
<YYINITIAL> "true"          { return new Symbol(sym.TRUE, yyline,yycolumn, yytext());}
<YYINITIAL> "false"         { return new Symbol(sym.FALSE, yyline,yycolumn, yytext());}
<YYINITIAL> "var"           { return new Symbol(sym.VAR, yyline,yycolumn, yytext());}
<YYINITIAL> "const"         { return new Symbol(sym.CONST, yyline,yycolumn, yytext());}
<YYINITIAL> "int"           { return new Symbol(sym.INT, yyline,yycolumn, yytext());}
<YYINITIAL> "double"        { return new Symbol(sym.DOUBLE, yyline,yycolumn, yytext());}
<YYINITIAL> "bool"          { return new Symbol(sym.BOOL, yyline,yycolumn, yytext());}
<YYINITIAL> "char"          { return new Symbol(sym.CHAR, yyline, yycolumn,yytext());}
<YYINITIAL> "String"        { return new Symbol(sym.STRING, yyline, yycolumn,yytext());}
<YYINITIAL> "if"            { return new Symbol(sym.IF, yyline, yycolumn,yytext());}
<YYINITIAL> "else"          { return new Symbol(sym.ELSE, yyline, yycolumn,yytext());}
<YYINITIAL> "break"         { return new Symbol(sym.BREAK, yyline, yycolumn,yytext());}
<YYINITIAL> "continue"      { return new Symbol(sym.CONTINUE, yyline, yycolumn,yytext());}
<YYINITIAL> "return"        { return new Symbol(sym.RETURN, yyline, yycolumn,yytext());}
<YYINITIAL> "match"         { return new Symbol(sym.MATCH, yyline, yycolumn,yytext());}
<YYINITIAL> "while"         { return new Symbol(sym.WHILE, yyline, yycolumn,yytext());}
<YYINITIAL> "for"           { return new Symbol(sym.FOR, yyline, yycolumn,yytext());}
<YYINITIAL> "do"            { return new Symbol(sym.DO, yyline, yycolumn,yytext());}

//------> Operadores

//------> Expresiones
<YYINITIAL> {entero}            { return new Symbol(sym.ENTERO, yyline, yycolumn, yytext()); }
<YYINITIAL> {numero_decimal}    { return new Symbol(sym.NUMERODECIMAL,  yyline,yycolumn, yytext()); }
<YYINITIAL> {id}                { return new Symbol(sym.ID,  yyline, yycolumn, yytext()); }
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
<YYINITIAL> .   {  
                    listaErrores.add(new Errores("LEXICO","El caracter "+yytext()+" NO pertenece al lenguaje", yyline, yycolumn));
                    System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); 
                }
