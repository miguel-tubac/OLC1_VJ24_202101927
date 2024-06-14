
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
        var newTabla = new TablaSimbolos(tabla);
        LinkedList<Errores> errores = new LinkedList<>();

        for (var instruccion : this.instrucciones) {
            var resultado = instruccion.interpretar(arbol, newTabla);
            if (instruccion instanceof Continue) {//aqui ay que comparar dos cosas el for tambien
                System.out.println("Aqui1");
                continue; // Saltar a la siguiente iteración si es una instrucción Continue
            }
            System.out.println("Afuera");
            
            if (resultado  instanceof Continue){
                System.out.println("Aqui2");
                continue;
            }
            /*
            // Manejo de errores dentro del nuevo entorno
            if (resultado instanceof Errores) {
                errores.add((Errores) resultado);
                arbol.setErrores(errores);
            }*/
        }

        return null;
    }
    
}
