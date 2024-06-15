
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.*;
import java.util.LinkedList;

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
        var newTabla = new TablaSimbolos(tabla);
        // ver que cond sea booleano
        if (this.condicion.tipo.getTipo() != TipoDato.BOOLEANO) {
            return new Errores("SEMANTICO", "Expresion invalida para condicion IF",this.linea, this.col);
        }
         
        if ((boolean) cond) {
            var respuesta = this.bloque.interpretar(arbol, newTabla);
            if (respuesta instanceof Errores){
                return respuesta;
            }
            System.out.println("IF: "+ this.bloque.tipo.getTipo());
            if(this.bloque.tipo.getTipo() == TipoDato.BREAK){
                this.tipo.setTipo(TipoDato.BREAK);
            }
            return new Tipo(TipoDato.BREAK);
        }
        else if(this.condicionelseif != null){
            var respuesta = this.condicionelseif.interpretar(arbol, newTabla);
            if (respuesta instanceof Errores){
                return respuesta;
            }
            System.out.println("else IF: "+ this.condicionelseif.tipo.getTipo());
            if(this.condicionelseif.tipo.getTipo() == TipoDato.BREAK){
                this.tipo.setTipo(TipoDato.BREAK);
            }
            return new Tipo(TipoDato.BREAK);
        }
        
        return null;
    }
    
}
