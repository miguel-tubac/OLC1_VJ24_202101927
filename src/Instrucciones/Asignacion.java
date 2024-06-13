
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.*;


public class Asignacion extends Instruccion{
    private String identificador;
    private Instruccion expresion;

    public Asignacion(String identificador, Instruccion expresion, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.identificador = identificador;
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        //variable exista
        var variable = tabla.buscarSimbolo(this.identificador);
        if (variable == null) {
            return new Errores("Semantico", "La Variable " + identificador + " no ha sido declarada", this.linea, this.col);
        }
        
        // interpretar el nuevo valor a asignar
        var newValor = this.expresion.interpretar(arbol, tabla);
        if (newValor instanceof Errores) {
            return newValor;
        }
        
        
        if(variable.getTipo().getTipo() == TipoDato.CONST){
            return new Errores("Semantico", "La Variable " + identificador + " es de tipo CONST", this.linea, this.col);
        }
        
        
        //validar tipos
        ValorVariable valor = (ValorVariable) variable.getValor();
        //variable.getTipo().getTipo()  const o var
        //valor.getTipo()      int, double ......
        switch (valor.getTipo()) {
            case INT -> {
                if (this.expresion.tipo.getTipo() == TipoDato.ENTERO) {
                    valor.setValor((int) newValor);
                } else {
                    return new Errores("SEMANTICO", "Tipos erroneos en asignacion de variable con el id: " + identificador, this.linea, this.col);
                }
            }
            case DOUBLE -> {
                if (this.expresion.tipo.getTipo() == TipoDato.DECIMAL) {
                    valor.setValorDouble((double) newValor);
                } else {
                    return new Errores("SEMANTICO", "Tipos erroneos en asignacion de variable con el id: " + identificador, this.linea, this.col);
                }
            }
            case BOOL -> {
                if (this.expresion.tipo.getTipo() == TipoDato.BOOLEANO) {
                    valor.setValorBoolean((boolean) newValor);
                } else {
                    return new Errores("SEMANTICO", "Tipos erroneos en asignacion de variable con el id: " + identificador, this.linea, this.col);
                }
            }
            case CHAR -> {
                if (this.expresion.tipo.getTipo() == TipoDato.CARACTER) {
                    valor.setValorChar(((newValor).toString()).charAt(0));
                } else {
                    return new Errores("SEMANTICO", "Tipos erroneos en asignacion de variable con el id: " + identificador, this.linea, this.col);
                }
            }
            case STRING -> {
                if (this.expresion.tipo.getTipo() == TipoDato.CADENA) {
                    valor.setValorString((String) newValor);
                } else {
                    return new Errores("SEMANTICO", "Tipos erroneos en asignacion de variable con el id: " + identificador, this.linea, this.col);
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Tipo de dato desconocido, con el id: " + identificador, this.linea, this.col);
            }
        }

        // Asumimos que una función exitosa retorna null o algún valor de éxito específico.
        return true;
    }
     
}
