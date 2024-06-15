
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
            //System.out.println("Aqui: "+ opIzq);
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
            case RESTA ->
                this.resta(opIzq, opDer);//llama al metodo resta
            case MULTIPLICACION ->
                this.multiplicacion(opIzq, opDer);//llama al metodo multiplicacion
            case DIVISION ->
                this.divicion(opIzq, opDer);//llama al metodo divicion
            case POTENCIA ->
                this.potencia(opIzq, opDer);//llama al metodo potencia
            case MODULO->
                this.modulo(opIzq, opDer);//llama al metodo modulo
            case NEGACION ->
                this.negacion(Unico);
            default ->
                new Errores("SEMANTICO", "Operador invalido", this.linea, this.col);
        };
    }

    //*************************************************Suma**************************************
    public Object suma(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        //System.out.println("Tipo: "+ tipo1);
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            //entero -------- mas casos
            case TipoDato.ENTERO -> {
                switch (tipo2) {
                    //entero + entero = entero
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.ENTERO);
                        return ((Number) op1).intValue() + ((Number) op2).intValue();
                    }
                    //entero + decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).intValue() + ((Number) op2).doubleValue();
                    }
                    //entero + cadena = cadena
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.ENTERO);
                        return ((Number) op1).intValue() +  (int)(op2.toString()).charAt(0);
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
            //decimal ------- mas casos
            case TipoDato.DECIMAL -> {
                switch (tipo2) {
                    // decima + entero = decimal
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).doubleValue() + ((Number) op2).intValue();
                    }
                    // decimal + decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).doubleValue() + ((Number) op2).doubleValue();
                    }
                    //decimal + caracter = decimal
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).doubleValue() +  (int)(op2.toString()).charAt(0);
                    }
                    //decimal + cadena = cadena
                    case TipoDato.CADENA -> {
                        this.tipo.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.linea, this.col);
                    }
                }
            }
            //booleano ------- mas casos
            case TipoDato.BOOLEANO -> {
                switch (tipo2) {
                    //decimal + cadena = cadena
                    case TipoDato.CADENA -> {
                        this.tipo.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.linea, this.col);
                    }
                }
            }
            //caracter ------- mas casos
            case TipoDato.CARACTER -> {
                switch (tipo2) {
                    // caracter + entero = entero
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.ENTERO);
                        return (int)(op1.toString()).charAt(0) + (int) op2;
                    }
                    // caracter + decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return (int)(op1.toString()).charAt(0) + (double) op2;
                    }
                    //decimal + caracter = decimal
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    //decimal + cadena = cadena
                    case TipoDato.CADENA -> {
                        this.tipo.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.linea, this.col);
                    }
                }
            }
            //cadena ------- mas casos
            case TipoDato.CADENA -> {
                switch (tipo2) {
                    // caracter + entero = entero
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    // caracter + decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    //decimal + caracter = decimal
                    case TipoDato.BOOLEANO -> {
                        this.tipo.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    //decimal + caracter = decimal
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    //decimal + cadena = cadena
                    case TipoDato.CADENA -> {
                        this.tipo.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.linea, this.col);
                    }
                }
            }
            // Error por si el sigono no es suma
            default -> {
                return new Errores("SEMANTICO", "Suma erronea", this.linea, this.col);

            }
        }
    }
    
    
    //*************************************************Resta**************************************
    public Object resta(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            //entero -------- mas casos
            case TipoDato.ENTERO -> {
                switch (tipo2) {
                    //entero - entero = entero
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.ENTERO);
                        return ((Number) op1).intValue() - ((Number) op2).intValue();
                    }
                    //entero - decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).intValue() - ((Number) op2).doubleValue();
                    }
                    //entero - caracter = entero
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.ENTERO);
                        return ((Number) op1).intValue() -  (int)(op2.toString()).charAt(0);
                    }
                    //Error
                    default -> {
                        return new Errores("SEMANTICO", "Resta erronea", this.linea, this.col);
                    }
                }
            }
            //decimal ------- mas casos
            case TipoDato.DECIMAL -> {
                switch (tipo2) {
                    // decima - entero = decimal
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).intValue() - ((Number) op2).intValue();
                    }
                    // decimal - decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).doubleValue() - ((Number) op2).doubleValue();
                    }
                    //decimal - caracter = decimal
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).doubleValue() -  (int)(op2.toString()).charAt(0);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Resta erronea", this.linea, this.col);
                    }
                }
            }
            //caracter ------- mas casos
            case TipoDato.CARACTER -> {
                switch (tipo2) {
                    // caracter - entero = entero
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.ENTERO);
                        return (int)(op1.toString()).charAt(0) - ((Number) op2).intValue();
                    }
                    // caracter - decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return (int)(op1.toString()).charAt(0) - ((Number) op2).doubleValue();
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Resta erronea", this.linea, this.col);
                    }
                }
            }
            // Error por si el sigono no es suma
            default -> {
                return new Errores("SEMANTICO", "Resta erronea", this.linea, this.col);

            }
        }
    }

    
    //*************************************************Multiplicacion**************************************
    public Object multiplicacion(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            //entero -------- mas casos
            case TipoDato.ENTERO -> {
                switch (tipo2) {
                    //entero * entero = entero
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.ENTERO);
                        return ((Number) op1).intValue() * ((Number) op2).intValue();
                    }
                    //entero * decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).intValue() * ((Number) op2).doubleValue();
                    }
                    //entero * caracter = entero
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.ENTERO);
                        return ((Number) op1).intValue() *  (int)(op2.toString()).charAt(0);
                    }
                    //Error
                    default -> {
                        return new Errores("SEMANTICO", "Multiplicacion erronea", this.linea, this.col);
                    }
                }
            }
            //decimal ------- mas casos
            case TipoDato.DECIMAL -> {
                switch (tipo2) {
                    // decima * entero = decimal
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).doubleValue() * ((Number) op2).intValue();
                    }
                    // decimal * decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).doubleValue() * ((Number) op2).doubleValue();
                    }
                    //decimal * caracter = decimal
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).doubleValue() *  (int)(op2.toString()).charAt(0);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Multiplicacion erronea", this.linea, this.col);
                    }
                }
            }
            //caracter ------- mas casos
            case TipoDato.CARACTER -> {
                switch (tipo2) {
                    // caracter * entero = entero
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.ENTERO);
                        return (int)(op1.toString()).charAt(0) * ((Number) op2).intValue();
                    }
                    // caracter * decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return (int)(op1.toString()).charAt(0) * ((Number) op2).doubleValue();
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Multiplicacion erronea", this.linea, this.col);
                    }
                }
            }
            // Error por si el sigono no es suma
            default -> {
                return new Errores("SEMANTICO", "Multiplicacion erronea", this.linea, this.col);

            }
        }
    }
    
    
    
    //*************************************************Divicion**************************************
    public Object divicion(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();
        
        if(op2.toString().equals("0")){
            //System.out.println("SEMANTICO: Divicion entre 0 no es posible");
            return new Errores("SEMANTICO", "Divicion entre 0 no es posible", this.linea, this.col);
        }
        
        switch (tipo1) {
            //entero -------- mas casos
            case TipoDato.ENTERO -> {
                switch (tipo2) {
                    //entero / entero = decimal
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        //System.out.println("op1 "+ (double) op1);
                        //System.out.println("op2 "+ (double) op2);
                        return ((Number) op1).doubleValue() / ((Number) op2).doubleValue();
                    }
                    //entero / decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).intValue() / ((Number) op2).doubleValue();
                    }
                    //entero - caracter = entero
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).doubleValue() /  (double)((int)(op2.toString()).charAt(0));
                    }
                    //Error
                    default -> {
                        return new Errores("SEMANTICO", "Divicion erronea", this.linea, this.col);
                    }
                }
            }
            //decimal ------- mas casos
            case TipoDato.DECIMAL -> {
                switch (tipo2) {
                    // decima / entero = decimal
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).doubleValue() / ((Number) op2).intValue();
                    }
                    // decimal / decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).doubleValue() / ((Number) op2).doubleValue();
                    }
                    //decimal / caracter = decimal
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).doubleValue() /  (int)(op2.toString()).charAt(0);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Divicion erronea", this.linea, this.col);
                    }
                }
            }
            //caracter ------- mas casos
            case TipoDato.CARACTER -> {
                switch (tipo2) {
                    // caracter / entero = decimal
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return (double)((int)(op1.toString()).charAt(0)) / ((Number) op2).doubleValue();
                    }
                    // caracter / decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return (int)(op1.toString()).charAt(0) / ((Number) op2).doubleValue();
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Divicion erronea", this.linea, this.col);
                    }
                }
            }
            // Error por si el sigono no es suma
            default -> {
                return new Errores("SEMANTICO", "Divicion erronea", this.linea, this.col);

            }
        }
    }
    
    
    //*************************************************Potencia**************************************
    public Object potencia(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            //entero -------- mas casos
            case TipoDato.ENTERO -> {
                switch (tipo2) {
                    //entero ** entero = entero
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.ENTERO);
                        return Math.pow(((Number) op1).intValue(), ((Number) op2).intValue());
                    }
                    //entero ** decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return Math.pow(((Number) op1).intValue(), ((Number) op2).doubleValue());
                    }
                    //Error
                    default -> {
                        return new Errores("SEMANTICO", "Potencia erronea", this.linea, this.col);
                    }
                }
            }
            //decimal ------- mas casos
            case TipoDato.DECIMAL -> {
                switch (tipo2) {
                    // decima ** entero = decimal
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return Math.pow(((Number) op1).doubleValue(), ((Number) op2).intValue());
                    }
                    // decimal - decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return Math.pow(((Number) op1).doubleValue(), ((Number) op2).doubleValue());
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Potencia erronea", this.linea, this.col);
                    }
                }
            }
            // Error por si el sigono no es suma
            default -> {
                return new Errores("SEMANTICO", "Potencia erronea", this.linea, this.col);

            }
        }
    }
    
    
    //*************************************************Modulo**************************************
    public Object modulo(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            //entero -------- mas casos
            case TipoDato.ENTERO -> {
                switch (tipo2) {
                    //entero % entero = decimal
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).intValue() % ((Number) op2).intValue();
                    }
                    //entero % decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).intValue() % ((Number) op2).doubleValue();
                    }
                    //Error
                    default -> {
                        return new Errores("SEMANTICO", "Modulo erronea", this.linea, this.col);
                    }
                }
            }
            //decimal ------- mas casos
            case TipoDato.DECIMAL -> {
                switch (tipo2) {
                    // decima % entero = decimal
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).doubleValue() % ((Number) op2).intValue();
                    }
                    // decimal % decimal = decimal
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.DECIMAL);
                        return ((Number) op1).doubleValue() % ((Number) op2).doubleValue();
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Modulo erronea", this.linea, this.col);
                    }
                }
            }
            // Error por si el sigono no es suma
            default -> {
                return new Errores("SEMANTICO", "Modulo erronea", this.linea, this.col);

            }
        }
    }
    
    //*************************************************Negacion**************************************
    public Object negacion(Object op1) {
        var opU = this.operandoUnico.tipo.getTipo();
        switch (opU) {
            case TipoDato.ENTERO -> {
                this.tipo.setTipo(TipoDato.ENTERO);
                return ((Number) op1).intValue() * -1;
            }
            case TipoDato.DECIMAL -> {
                this.tipo.setTipo(TipoDato.DECIMAL);
                return ((Number) op1).doubleValue() * -1;
            }
            default -> {
                return new Errores("SEMANTICO", "Negacion erronea", this.linea, this.col);
            }
        }
    }  
}
