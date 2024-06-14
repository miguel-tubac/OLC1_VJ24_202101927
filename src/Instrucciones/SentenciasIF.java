
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.*;

public class SentenciasIF extends Instruccion {
    private Instruccion condicion;
    private Instruccion bloque;
    private Instruccion condicionelseif;

    public SentenciasIF(Instruccion condicion, Instruccion bloque, Instruccion condicionelseif, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.condicion = condicion;
        this.bloque = bloque;
        this.condicionelseif = condicionelseif;
    }  
    

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        var cond = this.condicion.interpretar(arbol, tabla);
        if (cond instanceof Errores) {
            return cond;
        }
        
        // ver que cond sea booleano
        if (this.condicion.tipo.getTipo() != TipoDato.BOOLEANO) {
            return new Errores("SEMANTICO", "Expresion invalida para condicion IF",this.linea, this.col);
        }
        
        if ((boolean) cond) {
            return this.bloque.interpretar(arbol, tabla);
        }
        else if(this.condicionelseif != null){
            return this.condicionelseif.interpretar(arbol, tabla);
        }
        
        return null;
    }
    
}
