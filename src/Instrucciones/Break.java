
package Instrucciones;

import Abstracto.Instruccion;
import Simbolo.*;

public class Break extends Instruccion {
    public Break( int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
    } 

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        this.tipo.setTipo(TipoDato.BREAK);
        return null;
    }
    
}
