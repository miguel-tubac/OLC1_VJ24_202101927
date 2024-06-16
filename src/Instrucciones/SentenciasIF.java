
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
        
        // ver que cond sea booleano
        if (this.condicion.tipo.getTipo() != TipoDato.BOOLEANO) {
            return new Errores("SEMANTICO", "Expresion invalida para condicion IF",this.linea, this.col);
        }
         
        if ((boolean) cond) {
            var newTabla = new TablaSimbolos(tabla);
            newTabla.setNombre("Sentenci IF");
            var respuesta = this.bloque.interpretar(arbol, newTabla);
            if (respuesta instanceof Errores){
                arbol.agregarError((Errores) respuesta);
                return respuesta;
            }
            if(respuesta == TipoDato.BREAK){
                this.tipo.setTipo(TipoDato.BREAK);
                arbol.agregarSim(newTabla);
                return this.tipo.getTipo();
            }
            if(respuesta == TipoDato.CONTINUE){
                this.tipo.setTipo(TipoDato.CONTINUE);
                arbol.agregarSim(newTabla);
                return this.tipo.getTipo();
            }
            //this.bloque.interpretar(arbol, newTabla);
            arbol.agregarSim(newTabla);
        }
        else if(this.condicionelseif != null){
            var newTabla = new TablaSimbolos(tabla);
            newTabla.setNombre("Sentenci IF");
            var respuesta = this.condicionelseif.interpretar(arbol, newTabla);
            if (respuesta instanceof Errores){
                arbol.agregarError((Errores) respuesta);
                return respuesta;
            }
            if(respuesta == TipoDato.BREAK){
                this.tipo.setTipo(TipoDato.BREAK);
                arbol.agregarSim(newTabla);
                return this.tipo.getTipo();
            }
            if(respuesta == TipoDato.CONTINUE){
                this.tipo.setTipo(TipoDato.CONTINUE);
                arbol.agregarSim(newTabla);
                return this.tipo.getTipo();
            }
            //this.condicionelseif.interpretar(arbol, newTabla);
            arbol.agregarSim(newTabla);
        }
        
        return null;
    }
    
}
