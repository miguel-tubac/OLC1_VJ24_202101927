
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
        //LinkedList<Errores> errores = new LinkedList<>();
        //var newTabla = new TablaSimbolos(tabla.getTablaAnterior());
        for (var instruccion : this.instrucciones) {
            if (instruccion instanceof Continue){
                System.out.println("Aqui1");
                this.tipo.setTipo(TipoDato.CONTINUE);
                return this.tipo.getTipo();
            }
            if (instruccion instanceof Break){
                System.out.println("Aqui2");
                this.tipo.setTipo(TipoDato.BREAK);
                return this.tipo.getTipo();
            }
            var resultado = instruccion.interpretar(arbol, tabla);
            // Manejo de errores dentro del nuevo entorno
            
            /*
            if (resultado instanceof Errores) {
                //errores.add((Errores) resultado);
                arbol.agregarError((Errores) resultado);
                //arbol.setErrores(errores);
            }*/
        }

        return null;
    }

    public LinkedList<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
}
