
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.*;
import java.util.LinkedList;

public class BloqueSentencia extends Instruccion {
    private LinkedList<Instruccion> instrucciones;

    public BloqueSentencia(LinkedList<Instruccion> instrucciones, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        LinkedList<Errores> errores = new LinkedList<>();
        
        for (var instruccion : this.instrucciones) {
            if (instruccion instanceof Continue){
                System.out.println("Aqui1");
                continue;
            }
            if (instruccion instanceof Break){
                System.out.println("Aqui2");
                
                this.tipo.setTipo(TipoDato.BREAK);
                
                return new Tipo(TipoDato.BREAK);
            }
            var resultado = instruccion.interpretar(arbol, tabla);
            /*
            if (instruccion instanceof Continue) {//aqui ay que comparar dos cosas el for tambien
                //System.out.println("Aqui1");
                continue; // Saltar a la siguiente iteración si es una instrucción Continue
            }
            //System.out.println("Afuera");
            */
            
            
            // Manejo de errores dentro del nuevo entorno
            /*
            if (resultado instanceof Errores) {
                errores.add((Errores) resultado);
                arbol.setErrores(errores);
            }*/
        }

        return null;
    }
    
}
