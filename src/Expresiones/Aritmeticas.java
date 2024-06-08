
package Expresiones;

import Abstracto.Instruccion;
import Simbolo.*;
import Excepciones.Errores;

public class Aritmeticas extends Instruccion {
    private Instruccion operando1;
    private Instruccion operando2;
    private OperadoresAritmeticos operacion;
    private Instruccion operandoUnico;

    //negacion 
    public Aritmeticas(Instruccion operandoUnico, OperadoresAritmeticos operacion, int linea, int col) {
        super(new Tipo(TipoDato.ENTERO), linea, col);
        this.operacion = operacion;
        this.operandoUnico = operandoUnico;
    }

    //cualquier operacion menos negacion
    public Aritmeticas(Instruccion operando1, Instruccion operando2, OperadoresAritmeticos operacion, int linea, int col) {
        super(new Tipo(TipoDato.ENTERO), linea, col);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object opIzq = null, opDer = null, Unico = null;
        if (this.operandoUnico != null) {//aca se compruba el metodo constructor se instancio para la negacion
            Unico = this.operandoUnico.interpretar(arbol, tabla);
            if (Unico instanceof Errores) {
                return Unico;
            }
        } else {//esto es cuando se instancia objetos del metodo constructor que recive dos parametros de operacion
            opIzq = this.operando1.interpretar(arbol, tabla);//aca se interpreta
            if (opIzq instanceof Errores) {
                return opIzq;
            }
            opDer = this.operando2.interpretar(arbol, tabla);
            if (opDer instanceof Errores) {//Se comprueban si son de la clase errores
                return opDer;
            }
        }
        //si todo sale bien ingresa a esta parte
        return switch (operacion) {
            case SUMA ->
                this.suma(opIzq, opDer);//llama al metodo suma
            case NEGACION ->
                this.negacion(Unico);
            default ->
                new Errores("SEMANTICO", "Operador invalido", this.linea, this.col);
        };
    }

    //*************************************************Suma**************************************
    public Object suma(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            //entero
            case TipoDato.ENTERO -> {
                switch (tipo2) {
                    //entero + entero = entero
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.ENTERO);
                        return (int) op1 + (int) op2;
                    }
                    //entero + decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return (int) op1 + (double) op2;
                    }
                    //entero + cadena = cadena
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.ENTERO);
                        return (int) op1 +  (int)(op2.toString()).charAt(0);
                    }
                    //entero + cadena = cadena
                    case TipoDato.CADENA -> {
                        this.tipo.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    //Error
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.linea, this.col);
                    }
                }
            }
            //decimal
            case TipoDato.DECIMAL -> {
                switch (tipo2) {
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return (double) op1 + (int) op1;
                    }
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return (double) op1 + (double) op2;
                    }
                    case TipoDato.CADENA -> {
                        this.tipo.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.linea, this.col);
                    }
                }
            }
            case TipoDato.CADENA -> {
                this.tipo.setTipo(TipoDato.CADENA);
                return op1.toString() + op2.toString();
            }
            default -> {
                return new Errores("SEMANTICO", "Suma erronea", this.linea, this.col);

            }
        }
    }

    
    //*************************************************Negacion**************************************
    public Object negacion(Object op1) {
        var opU = this.operandoUnico.tipo.getTipo();
        switch (opU) {
            case TipoDato.ENTERO -> {
                this.tipo.setTipo(TipoDato.ENTERO);
                return (int) op1 * -1;
            }
            case TipoDato.DECIMAL -> {
                this.tipo.setTipo(TipoDato.DECIMAL);
                return (double) op1 * -1;
            }
            default -> {
                return new Errores("SEMANTICO", "Negacion erronea", this.linea, this.col);
            }
        }
    }  
}
