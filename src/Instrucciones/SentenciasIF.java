
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.Arbol;
import Simbolo.TablaSimbolos;
import Simbolo.Tipo;
import java.util.LinkedList;
import simbolo.*;

public class SentenciasIF extends Instruccion {
    private Instruccion condicion;
    private LinkedList<Instruccion> instrucciones;
    private Instruccion condicionelse;

    public SentenciasIF(Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
