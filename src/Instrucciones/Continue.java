
package Instrucciones;

import Abstracto.Instruccion;
import Simbolo.*;

public class Continue extends Instruccion {
    public Continue( int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
    } 

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
    
}
