
package Interprete;


public abstract class Expresion {
    public Object valor;
    public String tipo;
    public int fila;
    public int columna;

    public Expresion(Object valor, String tipo, int fila, int columna) {
        this.valor = valor;
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
    }

    public abstract Expresion interpretar(Interprete.entorno.Entorno entorno);
}

