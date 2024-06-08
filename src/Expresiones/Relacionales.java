
package Expresiones;

import Abstracto.Instruccion;
import Simbolo.*;
import Excepciones.Errores;

public class Relacionales extends Instruccion{
    private Instruccion operando1;
    private Instruccion operando2;
    private OperadoresRelacionales operacion;


    //cualquier operacion menos negacion
    public Relacionales(Instruccion operando1, Instruccion operando2, OperadoresRelacionales operacion, int linea, int col) {
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
            case IGUALACION ->
                this.igualacion(opIzq, opDer);//llama al metodo igualacion
            case DIFERENCIACION ->
                this.diferenciacion(opIzq, opDer);//llama al metodo igualacion
            case MENORQUE ->
                this.menorque(opIzq, opDer);//llama al metodo igualacion
            case MENORIGUALQUE ->
                this.menorigualque(opIzq, opDer);//llama al metodo igualacion
            case MAYORQUE ->
                this.mayorque(opIzq, opDer);//llama al metodo igualacion
            case MAYOROIGUALQUE ->
                this.mayorigualque(opIzq, opDer);//llama al metodo igualacion
            default ->
                new Errores("SEMANTICO", "Operador Relacional invalido", this.linea, this.col);
        };
    }
    
    //*************************************************Igualacion**************************************
    public Object igualacion(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            //entero -------- mas casos
            case TipoDato.ENTERO -> {
                switch (tipo2) {
                    //entero == entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 == (int) op2;
                    }
                    //entero == decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 == (double) op2;
                    }
                    //entero == caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 ==  (int)(op2.toString()).charAt(0);
                    }
                    //Error
                    default -> {
                        return new Errores("SEMANTICO", "Igualacion erronea", this.linea, this.col);
                    }
                }
            }
            //decimal ------- mas casos
            case TipoDato.DECIMAL -> {
                switch (tipo2) {
                    // decima == entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 == (int) op2;
                    }
                    // decimal == decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 == (double) op2;
                    }
                    //decimal == caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 == (int)(op2.toString()).charAt(0);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Igualacion erronea", this.linea, this.col);
                    }
                }
            }
            //bolean ------- mas casos
            case TipoDato.BOOLEANO -> {
                switch (tipo2) {
                    // decima == entero = boolean
                    case TipoDato.BOOLEANO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (boolean) op1 == (boolean) op2;
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Igualacion erronea", this.linea, this.col);
                    }
                }
            }
            //caracter ------- mas casos
            case TipoDato.CARACTER -> {
                switch (tipo2) {
                    // caracter == entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) == (int) op2;
                    }
                    // caracter == decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) == (double) op2;
                    }
                    // caracter == caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) == (int)(op2.toString()).charAt(0);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Igualacion erronea", this.linea, this.col);
                    }
                }
            }
            //cadena --------------mas casos
            case TipoDato.CADENA -> {
                switch (tipo2) {
                    // caracter == entero = boolean
                    case TipoDato.CADENA -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return op1.toString().equals(op2.toString());
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Igualacion erronea", this.linea, this.col);
                    }
                }
            }
            
            // Error por si el sigono no es suma
            default -> {
                return new Errores("SEMANTICO", "Igualacion erronea", this.linea, this.col);

            }
        }
    }
    
    //*************************************************Diferenciacion**************************************
    public Object diferenciacion(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            //entero -------- mas casos
            case TipoDato.ENTERO -> {
                switch (tipo2) {
                    //entero != entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 != (int) op2;
                    }
                    //entero != decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 != (double) op2;
                    }
                    //entero != caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 !=  (int)(op2.toString()).charAt(0);
                    }
                    //Error
                    default -> {
                        return new Errores("SEMANTICO", "Diferenciacion erronea", this.linea, this.col);
                    }
                }
            }
            //decimal ------- mas casos
            case TipoDato.DECIMAL -> {
                switch (tipo2) {
                    // decima != entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 != (int) op2;
                    }
                    // decimal != decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 != (double) op2;
                    }
                    //decimal != caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 != (int)(op2.toString()).charAt(0);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Diferenciacion erronea", this.linea, this.col);
                    }
                }
            }
            //bolean ------- mas casos
            case TipoDato.BOOLEANO -> {
                switch (tipo2) {
                    // decima != entero = boolean
                    case TipoDato.BOOLEANO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (boolean) op1 != (boolean) op2;
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Diferenciacion erronea", this.linea, this.col);
                    }
                }
            }
            //caracter ------- mas casos
            case TipoDato.CARACTER -> {
                switch (tipo2) {
                    // caracter != entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) != (int) op2;
                    }
                    // caracter != decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) != (double) op2;
                    }
                    // caracter != caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) != (int)(op2.toString()).charAt(0);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Diferenciacion erronea", this.linea, this.col);
                    }
                }
            }
            //cadena --------------mas casos
            case TipoDato.CADENA -> {
                switch (tipo2) {
                    // caracter != entero = boolean
                    case TipoDato.CADENA -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return !op1.toString().equals(op2.toString());
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Diferenciacion erronea", this.linea, this.col);
                    }
                }
            }
            
            // Error por si el sigono no es suma
            default -> {
                return new Errores("SEMANTICO", "Diferenciacion erronea", this.linea, this.col);

            }
        }
    }
    
    
    //*************************************************Menorque**************************************
    public Object menorque(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            //entero -------- mas casos
            case TipoDato.ENTERO -> {
                switch (tipo2) {
                    //entero < entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 < (int) op2;
                    }
                    //entero < decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 < (double) op2;
                    }
                    //entero < caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 <  (int)(op2.toString()).charAt(0);
                    }
                    //Error
                    default -> {
                        return new Errores("SEMANTICO", "Menorque erronea", this.linea, this.col);
                    }
                }
            }
            //decimal ------- mas casos
            case TipoDato.DECIMAL -> {
                switch (tipo2) {
                    // decima < entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 < (int) op2;
                    }
                    // decimal < decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 < (double) op2;
                    }
                    //decimal < caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 < (int)(op2.toString()).charAt(0);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Menorque erronea", this.linea, this.col);
                    }
                }
            }
            //bolean ------- mas casos
            case TipoDato.BOOLEANO -> {
                switch (tipo2) {
                    // decima < entero = boolean
                    case TipoDato.BOOLEANO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return convertirBooleanAInt((boolean) op1) < convertirBooleanAInt((boolean) op2);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Menorque erronea", this.linea, this.col);
                    }
                }
            }
            //caracter ------- mas casos
            case TipoDato.CARACTER -> {
                switch (tipo2) {
                    // caracter < entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) < (int) op2;
                    }
                    // caracter < decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) < (double) op2;
                    }
                    // caracter < caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) < (int)(op2.toString()).charAt(0);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Menorque erronea", this.linea, this.col);
                    }
                }
            }
            //cadena --------------mas casos
            case TipoDato.CADENA -> {
                switch (tipo2) {
                    // caracter < entero = boolean
                    case TipoDato.CADENA -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return compararCadenasMenor(op1.toString(), op2.toString());
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "Menorque erronea", this.linea, this.col);
                    }
                }
            }
            
            // Error por si el sigono no es suma
            default -> {
                return new Errores("SEMANTICO", "Menorque erronea", this.linea, this.col);

            }
        }
    }
    
    
    //*************************************************MenorIgualque**************************************
    public Object menorigualque(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            //entero -------- mas casos
            case TipoDato.ENTERO -> {
                switch (tipo2) {
                    //entero <= entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 <= (int) op2;
                    }
                    //entero <= decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 <= (double) op2;
                    }
                    //entero <= caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 <=  (int)(op2.toString()).charAt(0);
                    }
                    //Error
                    default -> {
                        return new Errores("SEMANTICO", "MenorIgualque erronea", this.linea, this.col);
                    }
                }
            }
            //decimal ------- mas casos
            case TipoDato.DECIMAL -> {
                switch (tipo2) {
                    // decima <= entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 <= (int) op2;
                    }
                    // decimal <= decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 <= (double) op2;
                    }
                    //decimal <= caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 <= (int)(op2.toString()).charAt(0);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "MenorIgualque erronea", this.linea, this.col);
                    }
                }
            }
            //bolean ------- mas casos
            case TipoDato.BOOLEANO -> {
                switch (tipo2) {
                    // decima <= entero = boolean
                    case TipoDato.BOOLEANO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return convertirBooleanAInt((boolean) op1) <= convertirBooleanAInt((boolean) op2);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "MenorIgualque erronea", this.linea, this.col);
                    }
                }
            }
            //caracter ------- mas casos
            case TipoDato.CARACTER -> {
                switch (tipo2) {
                    // caracter <= entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) <= (int) op2;
                    }
                    // caracter <= decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) <= (double) op2;
                    }
                    // caracter <= caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) <= (int)(op2.toString()).charAt(0);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "MenorIgualque erronea", this.linea, this.col);
                    }
                }
            }
            //cadena --------------mas casos
            case TipoDato.CADENA -> {
                switch (tipo2) {
                    // caracter <= entero = boolean
                    case TipoDato.CADENA -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return compararCadenasMenorIgual(op1.toString(), op2.toString());
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "MenorIgualque erronea", this.linea, this.col);
                    }
                }
            }
            
            // Error por si el sigono no es suma
            default -> {
                return new Errores("SEMANTICO", "MenorIgualque erronea", this.linea, this.col);

            }
        }
    }
    
    
    //*************************************************MayorQue**************************************
    public Object mayorque(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            //entero -------- mas casos
            case TipoDato.ENTERO -> {
                switch (tipo2) {
                    //entero > entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 > (int) op2;
                    }
                    //entero > decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 > (double) op2;
                    }
                    //entero > caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 >  (int)(op2.toString()).charAt(0);
                    }
                    //Error
                    default -> {
                        return new Errores("SEMANTICO", "MayorQue erronea", this.linea, this.col);
                    }
                }
            }
            //decimal ------- mas casos
            case TipoDato.DECIMAL -> {
                switch (tipo2) {
                    // decima > entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 > (int) op2;
                    }
                    // decimal > decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 > (double) op2;
                    }
                    //decimal > caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 > (int)(op2.toString()).charAt(0);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "MayorQue erronea", this.linea, this.col);
                    }
                }
            }
            //bolean ------- mas casos
            case TipoDato.BOOLEANO -> {
                switch (tipo2) {
                    // decima > entero = boolean
                    case TipoDato.BOOLEANO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return convertirBooleanAInt((boolean) op1) > convertirBooleanAInt((boolean) op2);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "MayorQue erronea", this.linea, this.col);
                    }
                }
            }
            //caracter ------- mas casos
            case TipoDato.CARACTER -> {
                switch (tipo2) {
                    // caracter > entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) > (int) op2;
                    }
                    // caracter > decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) > (double) op2;
                    }
                    // caracter > caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) > (int)(op2.toString()).charAt(0);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "MayorQue erronea", this.linea, this.col);
                    }
                }
            }
            //cadena --------------mas casos
            case TipoDato.CADENA -> {
                switch (tipo2) {
                    // caracter > entero = boolean
                    case TipoDato.CADENA -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return compararCadenasMayor(op1.toString(), op2.toString());
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "MayorQue erronea", this.linea, this.col);
                    }
                }
            }
            
            // Error por si el sigono no es suma
            default -> {
                return new Errores("SEMANTICO", "MayorQue erronea", this.linea, this.col);

            }
        }
    }
    
    
    //*************************************************MayorIgualQue**************************************
    public Object mayorigualque(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            //entero -------- mas casos
            case TipoDato.ENTERO -> {
                switch (tipo2) {
                    //entero >= entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 >= (int) op2;
                    }
                    //entero >= decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 >= (double) op2;
                    }
                    //entero >= caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int) op1 >=  (int)(op2.toString()).charAt(0);
                    }
                    //Error
                    default -> {
                        return new Errores("SEMANTICO", "MayorIgualQue erronea", this.linea, this.col);
                    }
                }
            }
            //decimal ------- mas casos
            case TipoDato.DECIMAL -> {
                switch (tipo2) {
                    // decima >= entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 >= (int) op2;
                    }
                    // decimal >= decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 >= (double) op2;
                    }
                    //decimal >= caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (double) op1 >= (int)(op2.toString()).charAt(0);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "MayorIgualQue erronea", this.linea, this.col);
                    }
                }
            }
            //bolean ------- mas casos
            case TipoDato.BOOLEANO -> {
                switch (tipo2) {
                    // decima >= entero = boolean
                    case TipoDato.BOOLEANO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return convertirBooleanAInt((boolean) op1) >= convertirBooleanAInt((boolean) op2);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "MayorIgualQue erronea", this.linea, this.col);
                    }
                }
            }
            //caracter ------- mas casos
            case TipoDato.CARACTER -> {
                switch (tipo2) {
                    // caracter >= entero = boolean
                    case TipoDato.ENTERO -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) >= (int) op2;
                    }
                    // caracter >= decimal = boolean
                    case TipoDato.DECIMAL -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) >= (double) op2;
                    }
                    // caracter >= caracter = boolean
                    case TipoDato.CARACTER -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return (int)(op1.toString()).charAt(0) >= (int)(op2.toString()).charAt(0);
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "MayorIgualQue erronea", this.linea, this.col);
                    }
                }
            }
            //cadena --------------mas casos
            case TipoDato.CADENA -> {
                switch (tipo2) {
                    // caracter >= entero = boolean
                    case TipoDato.CADENA -> {
                        this.tipo.setTipo(TipoDato.BOOLEANO);
                        return compararCadenasMayorIgual(op1.toString(), op2.toString());
                    }
                    //error de tipos
                    default -> {
                        return new Errores("SEMANTICO", "MayorIgualQue erronea", this.linea, this.col);
                    }
                }
            }
            
            // Error por si el sigono no es suma
            default -> {
                return new Errores("SEMANTICO", "MayorIgualQue erronea", this.linea, this.col);

            }
        }
    }
    
    
    // conversion de boolean a int
    public static int convertirBooleanAInt(boolean valor) {
        return valor ? 1 : 0;
    }
    //camparacion de cadenas(longitud)
    public static boolean compararCadenasMenor(String cadena1, String cadena2) {
        if (cadena1.compareTo(cadena2) < 0) {
            //System.out.println(cadena1 + " es menor que " + cadena2);
            return true;
        } else if (cadena1.compareTo(cadena2) > 0) {
            //System.out.println(cadena1 + " es mayor que " + cadena2);
            return false;
        } else {
            //System.out.println(cadena1 + " es igual a " + cadena2);
            return false;
        }
    }
    //camparacion de cadenas(longitud)
    public static boolean compararCadenasMenorIgual(String cadena1, String cadena2) {
        if (cadena1.compareTo(cadena2) < 0) {
            //System.out.println(cadena1 + " es menor que " + cadena2);
            return true;
        } else if (cadena1.compareTo(cadena2) > 0) {
            //System.out.println(cadena1 + " es mayor que " + cadena2);
            return false;
        } else {
            //System.out.println(cadena1 + " es igual a " + cadena2);
            return true;
        }
    }
    //camparacion de cadenas(longitud)
    public static boolean compararCadenasMayor(String cadena1, String cadena2) {
        if (cadena1.compareTo(cadena2) > 0) {
            //System.out.println(cadena1 + " es menor que " + cadena2);
            return true;
        } else if (cadena1.compareTo(cadena2) < 0) {
            //System.out.println(cadena1 + " es mayor que " + cadena2);
            return false;
        } else {
            //System.out.println(cadena1 + " es igual a " + cadena2);
            return false;
        }
    }
    //camparacion de cadenas(longitud)
    public static boolean compararCadenasMayorIgual(String cadena1, String cadena2) {
        if (cadena1.compareTo(cadena2) > 0) {
            //System.out.println(cadena1 + " es menor que " + cadena2);
            return true;
        } else if (cadena1.compareTo(cadena2) < 0) {
            //System.out.println(cadena1 + " es mayor que " + cadena2);
            return false;
        } else {
            //System.out.println(cadena1 + " es igual a " + cadena2);
            return true;
        }
    }
    
    
    
}
