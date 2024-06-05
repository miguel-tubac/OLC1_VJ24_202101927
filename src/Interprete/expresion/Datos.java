
package Interprete.expresion;


public class Datos {
    
    public String valor;
    public String tipo;
    public String fila;
    public String columna;

    public Datos(String valor, String tipo, String fila, String columna) {
        this.valor = valor;
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
    }
    
    public Datos interpretar(Object entorno){
        
        return this;
    }
}
