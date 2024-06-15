
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.*;
import java.util.LinkedList;

public class Casos extends Instruccion {
    public Instruccion condicion;
    private LinkedList<Instruccion> instrucciones;

    public Casos(Instruccion condicion, LinkedList<Instruccion> instrucciones, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.condicion = condicion;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        var cond = this.condicion.interpretar(arbol, tabla);
        if (cond instanceof Errores){
            return cond;
        }
        
        var newTabla = new TablaSimbolos(tabla);
        LinkedList<Errores> errores = new LinkedList<>();

        for (var instruccion : this.instrucciones) {
            var resultado = instruccion.interpretar(arbol, newTabla);
            if (instruccion instanceof Continue) {//aqui ay que comparar dos cosas el for tambien
               // System.out.println("Aqui1");
                continue; // Saltar a la siguiente iteración si es una instrucción Continue
            }
            //System.out.println("Afuera");
            
            if (resultado  instanceof Continue){
                //System.out.println("Aqui2");
                continue;
            }
            
            // Manejo de errores dentro del nuevo entorno
            if (resultado instanceof Errores) {
                errores.add((Errores) resultado);
                arbol.setErrores(errores);
            }
        }
        
        
        return this;
    }
    
    
    
    
    public Instruccion getCondicion() {
        return condicion;
    }

    public void setCondicion(Instruccion condicion) {
        this.condicion = condicion;
    }

    public LinkedList<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }
    
    
}
