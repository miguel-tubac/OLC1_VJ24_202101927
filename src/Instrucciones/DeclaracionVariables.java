
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.*;
import Simbolo.*;


public class DeclaracionVariables extends Instruccion{
    private OperadoresVariables mutabilidad;
    private String id;
    private OperadoresVariables tipo;

    public DeclaracionVariables(OperadoresVariables mutabilidad, String id, OperadoresVariables tipo, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.mutabilidad = mutabilidad;
        this.id = id;
        this.tipo = tipo;
    }
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        switch (mutabilidad){
            case VAR:
                //Simbolo nuevoSimbolo = new Simbolo(new Tipo(TipoDato.VARIABLE), this.id, );
                break;
            case CONST:
                
                break;
            default:
                return new Errores("Error Semantico","Asociacon no declarada", this.linea, this.col);
        
        };
        
        return null;
    }    
    
    
}
