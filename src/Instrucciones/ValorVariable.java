
package Instrucciones;


public class ValorVariable {
    private OperadoresVariables tipo;
    private int valor;
    private double valorDouble;
    private boolean valorBoolean;
    private char valorChar;
    private String valorString;

    
    //metodo constructor para int
    public ValorVariable(OperadoresVariables tipo, int valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
    
    //metodo constructor para double
    public ValorVariable(OperadoresVariables tipo, double valorDouble) {
        this.tipo = tipo;
        this.valorDouble = valorDouble;
    }
    
    //metodo constructor para boolean
    public ValorVariable(OperadoresVariables tipo, boolean valorBoolean) {
        this.tipo = tipo;
        this.valorBoolean = valorBoolean;
    }
    
    //metodo constructor para char
    public ValorVariable(OperadoresVariables tipo, char valorChar) {
        this.tipo = tipo;
        this.valorChar = valorChar;
    }
    
    //metodo constructor para char
    public ValorVariable(OperadoresVariables tipo, String valorString) {
        this.tipo = tipo;
        this.valorString = valorString;
    }
    
    //Aca estan los geter y seters
    public OperadoresVariables getTipo() {
        return tipo;
    }

    public void setTipo(OperadoresVariables tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public double getValorDouble() {
        return valorDouble;
    }

    public void setValorDouble(double valorDouble) {
        this.valorDouble = valorDouble;
    }

    public boolean isValorBoolean() {
        return valorBoolean;
    }

    public void setValorBoolean(boolean valorBoolean) {
        this.valorBoolean = valorBoolean;
    }

    public char getValorChar() {
        return valorChar;
    }

    public void setValorChar(char valorChar) {
        this.valorChar = valorChar;
    }

    public String getValorString() {
        return valorString;
    }

    public void setValorString(String valorString) {
        this.valorString = valorString;
    }
    
}
