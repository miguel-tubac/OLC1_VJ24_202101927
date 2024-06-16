
package InterfasGrafica;


public class DatosTablaSimbolo {
    private String id;
    private String tipovar;
    private String tipo;
    private String entorno;
    private Object valor;
    private int linea;
    private int column;

    public DatosTablaSimbolo(String id, String tipovar, String tipo, String entorno, Object valor, int linea, int column) {
        this.id = id;
        this.tipovar = tipovar;
        this.tipo = tipo;
        this.entorno = entorno;
        this.valor = valor;
        this.linea = linea;
        this.column = column;
    }

    public String getId() {
        return id;
    }

    public String getTipovar() {
        return tipovar;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEntorno() {
        return entorno;
    }

    public Object getValor() {
        return valor;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumn() {
        return column;
    }


    
    
    
}
