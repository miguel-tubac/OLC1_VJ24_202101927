
package Expresiones;

import Abstracto.Instruccion;
import Simbolo.*;
import Excepciones.Errores;

public class Logicos extends Instruccion {
    private Instruccion operando1;
    private Instruccion operando2;
    private OperadoresLogicos operacion;


    //cualquier operacion menos negacion
    public Logicos(Instruccion operando1, Instruccion operando2, OperadoresLogicos operacion, int linea, int col) {
        super(new Tipo(TipoDato.ENTERO), linea, col);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object opIzq = null, opDer = null;
        
        //esto es cuando se instancia objetos del metodo constructor que recive dos parametros de operacion
        opIzq = this.operando1.interpretar(arbol, tabla);//aca se interpreta
        if (opIzq instanceof Errores) {
            return opIzq;
        }
        opDer = this.operando2.interpretar(arbol, tabla);
        if (opDer instanceof Errores) {//Se comprueban si son de la clase errores
            return opDer;
        }
        
        //si todo sale bien ingresa a esta parte
        return switch (operacion) {
            case OR ->
                this.or(opIzq, opDer);//llama al metodo or
            case AND ->
                this.and(opIzq, opDer);//llama al metodo or
            case XOR ->
                this.xor(opIzq, opDer);//llama al metodo or
            case NOT ->
                this.not(opIzq, opDer);//llama al metodo or
            default ->
                new Errores("SEMANTICO", "Operador Logico invalido", this.linea, this.col);
        };
    }
    
    
    //*************************************************OR**************************************
    public Object or(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            //entero -------- mas casos
            case TipoDato.BOOLEANO -> {
                switch (tipo2) {
                    //boolean || bolean = boolean
                    case TipoDato.BOOLEANO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (boolean) op1 || (boolean) op2;
                    }
                    //Error
                    default -> {
                        return new Errores("SEMANTICO", "OR erronea", this.linea, this.col);
                    }
                }
            }
            // Error por si el sigono no es suma
            default -> {
                return new Errores("SEMANTICO", "OR erronea", this.linea, this.col);

            }
        }
    }
    
    
    //*************************************************AND**************************************
    public Object and(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            //entero -------- mas casos
            case TipoDato.BOOLEANO -> {
                switch (tipo2) {
                    //boolean || bolean = boolean
                    case TipoDato.BOOLEANO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (boolean) op1 && (boolean) op2;
                    }
                    //Error
                    default -> {
                        return new Errores("SEMANTICO", "AND erronea", this.linea, this.col);
                    }
                }
            }
            // Error por si el sigono no es suma
            default -> {
                return new Errores("SEMANTICO", "AND erronea", this.linea, this.col);

            }
        }
    }
    
    //*************************************************XOR**************************************
    public Object xor(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            //entero -------- mas casos
            case TipoDato.BOOLEANO -> {
                switch (tipo2) {
                    //boolean || bolean = boolean
                    case TipoDato.BOOLEANO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (boolean) op1 ^ (boolean) op2;
                    }
                    //Error
                    default -> {
                        return new Errores("SEMANTICO", "XOR erronea", this.linea, this.col);
                    }
                }
            }
            // Error por si el sigono no es suma
            default -> {
                return new Errores("SEMANTICO", "XOR erronea", this.linea, this.col);

            }
        }
    }
    
    
    //*************************************************NOT**************************************
    public Object not(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            //entero -------- mas casos
            case TipoDato.BOOLEANO -> {
                switch (tipo2) {
                    //boolean || bolean = boolean
                    case TipoDato.BOOLEANO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return  !(boolean) op2;
                    }
                    //Error
                    default -> {
                        return new Errores("SEMANTICO", "NOT erronea", this.linea, this.col);
                    }
                }
            }
            // Error por si el sigono no es suma
            default -> {
                return new Errores("SEMANTICO", "NOT erronea", this.linea, this.col);

            }
        }
    }
    
}
