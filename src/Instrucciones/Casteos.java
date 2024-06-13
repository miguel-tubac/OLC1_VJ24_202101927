
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.*;

public class Casteos extends Instruccion {
    private OperadoresVariables tipoVar;
    private Instruccion expresion;

    public Casteos(OperadoresVariables tipoVar, Instruccion expresion, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.tipoVar = tipoVar;
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        // interpretar el nuevo valor a asignar
        var newExpresion = this.expresion.interpretar(arbol, tabla);
        if (newExpresion instanceof Errores) {
            return newExpresion;
        }
        
        
        if(this.tipoVar == OperadoresVariables.DOUBLE){
            if(this.expresion.tipo.getTipo() == TipoDato.ENTERO){
                   this.tipo.setTipo(TipoDato.DECIMAL);
                   return ((Number) newExpresion).doubleValue();//((Number) op1).doubleValue()
            }
            else if(this.expresion.tipo.getTipo() == TipoDato.CARACTER){
                   this.tipo.setTipo(TipoDato.DECIMAL);
                   return (double)((int)(newExpresion.toString()).charAt(0)); 
            }
        }
        else if(this.tipoVar == OperadoresVariables.CHAR){
            if(this.expresion.tipo.getTipo() == TipoDato.ENTERO){
                   this.tipo.setTipo(TipoDato.CARACTER);
                   int intValue = Integer.parseInt(newExpresion.toString()); // Convierte el Object a String y luego a int
                   return (char) intValue;  //(int)(newExpresion.toString()).charAt(0)
            }
        }
        else if(this.tipoVar == OperadoresVariables.INT){
            if(this.expresion.tipo.getTipo() == TipoDato.DECIMAL){
                   this.tipo.setTipo(TipoDato.ENTERO);
                   return ((Number) newExpresion).intValue();
            }
            else if(this.expresion.tipo.getTipo() == TipoDato.CARACTER){
                   this.tipo.setTipo(TipoDato.ENTERO);
                   return (int)(newExpresion.toString()).charAt(0);
            }
        }
        else {
            return new Errores("SEMANTICO", "Casteo no permitido con el tipo de expresion ingresada.", this.linea, this.col);
        }
        
        return true;
    }
    
    
}
