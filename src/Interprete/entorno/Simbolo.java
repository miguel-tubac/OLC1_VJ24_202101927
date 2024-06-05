
package Interprete.entorno;



public class Simbolo {
    private String nombre;
    private Object valor;
    private String tipo;
    private String tipoVar;
    private int fila;
    private int columna;

    public Simbolo(String nombre, Object valor, String tipo, String tipoVar, int fila, int columna) {
        this.nombre = nombre;
        this.valor = valor;
        this.tipo = tipo;
        this.tipoVar = tipoVar;
        this.fila = fila;
        this.columna = columna;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
