
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.*;

public class DeclaracionVariablesConExpresion extends Instruccion {
    private TipoDato mutabilidad;
    private String id;
    private OperadoresVariables tipo;
    private Instruccion operando;

    public DeclaracionVariablesConExpresion(TipoDato mutabilidad, String id, OperadoresVariables tipo, Instruccion operando, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.mutabilidad = mutabilidad;
        this.id = id;
        this.tipo = tipo;
        this.operando = operando;
    }
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object expresion = this.operando.interpretar(arbol, tabla);
        if(expresion instanceof Errores ){
            return expresion;
        }
        
        //si todo sale bien ingresa a esta parte
        return switch (this.tipo){
            case INT ->
                this.datoINT(this.mutabilidad, this.id, tabla, expresion);
            case DOUBLE ->
                this.datoDOUBLE(this.mutabilidad, this.id, tabla, expresion);
            case BOOL ->
                this.datoBOOL(this.mutabilidad, this.id, tabla, expresion);
            case CHAR ->
                this.datoCHAR(this.mutabilidad, this.id, tabla, expresion);
            case STRING ->
                this.datoSTRING(this.mutabilidad, this.id, tabla, expresion);
            default ->
                new Errores("SEMANTICO","Asociacion no declarada", this.linea, this.col);
        };
        
    }
    
    
    public Object datoINT(TipoDato mutabilidad, String id, TablaSimbolos tabla, Object expresion){
        var tipo1 = this.operando.tipo.getTipo();
        if (tipo1 == TipoDato.ENTERO){
            ValorVariable valor = new ValorVariable(this.tipo, ((Number) expresion).intValue());//((Number) op1).doubleValue()
            Simbolo nuevoSimbolo = new Simbolo(new Tipo(mutabilidad), this.id, valor, this.linea, this.col);
            boolean resultado = tabla.addSimbolo(nuevoSimbolo);
            if (resultado == false){
                return new Errores("SEMANTICO","La variable con el id: "+this.id+" ya fue declarada.", this.linea, this.col);
            }
            //this.tipo.setTipo(TipoDato.ENTERO);
            return true;
        }
        return new Errores("SEMANTICO","La variable con el id: "+this.id+" no puede declararse con valores de tipo: "+tipo1, this.linea, this.col);
    }
    
    
    public Object datoDOUBLE(TipoDato mutabilidad, String id, TablaSimbolos tabla, Object expresion){
        var tipo1 = this.operando.tipo.getTipo();
        if (tipo1 == TipoDato.DECIMAL){
            ValorVariable valor = new ValorVariable(this.tipo, ((Number) expresion).doubleValue());//((Number) op1).doubleValue()
            Simbolo nuevoSimbolo = new Simbolo(new Tipo(mutabilidad), this.id, valor, this.linea, this.col);
            boolean resultado = tabla.addSimbolo(nuevoSimbolo);
            if (resultado == false){
                return new Errores("SEMANTICO","La variable con el id: "+this.id+" ya fue declarada.", this.linea, this.col);
            }
            return true;
        }
        return new Errores("Semantico","La variable con el ID:"+this.id+" no puede declararse con valores de tipo: "+tipo1, this.linea, this.col);
    }
    
    
    public Object datoBOOL(TipoDato mutabilidad, String id, TablaSimbolos tabla, Object expresion){
        var tipo1 = this.operando.tipo.getTipo();
        if (tipo1 == TipoDato.BOOLEANO){
            ValorVariable valor = new ValorVariable(this.tipo, (Boolean) expresion);
            Simbolo nuevoSimbolo = new Simbolo(new Tipo(mutabilidad), this.id, valor, this.linea, this.col);
            boolean resultado = tabla.addSimbolo(nuevoSimbolo);
            if (resultado == false){
                return new Errores("SEMANTICO","La variable con el id: "+this.id+" ya fue declarada.", this.linea, this.col);
            }
            return true;
        }
        return new Errores("SEMANTICO","La variable con el id: "+this.id+" no puede declararse con valores de tipo: "+tipo1, this.linea, this.col);
    }
    
    
    public Object datoCHAR(TipoDato mutabilidad, String id, TablaSimbolos tabla, Object expresion){
        var tipo1 = this.operando.tipo.getTipo();
        if (tipo1 == TipoDato.CARACTER){
            ValorVariable valor = new ValorVariable(this.tipo,  (expresion.toString()).charAt(0));//(op2.toString()).charAt(0)
            Simbolo nuevoSimbolo = new Simbolo(new Tipo(mutabilidad), this.id, valor, this.linea, this.col);
            boolean resultado = tabla.addSimbolo(nuevoSimbolo);
            if (resultado == false){
                return new Errores("SEMANTICO","La variable con el id: "+this.id+" ya fue declarada.", this.linea, this.col);
            }
            return true;
        }
        return new Errores("SEMANTICO","La variable con el id: "+this.id+" no puede declararse con valores de tipo: "+tipo1, this.linea, this.col);
    }
    
    
    public Object datoSTRING(TipoDato mutabilidad, String id, TablaSimbolos tabla, Object expresion){
        var tipo1 = this.operando.tipo.getTipo();
        if (tipo1 == TipoDato.CADENA){
            ValorVariable valor = new ValorVariable(this.tipo, (String) expresion);
            Simbolo nuevoSimbolo = new Simbolo(new Tipo(mutabilidad), this.id, valor, this.linea, this.col);
            boolean resultado = tabla.addSimbolo(nuevoSimbolo);
            if (resultado == false){
                return new Errores("SEMANTICO","La variable con el id: "+this.id+" ya fue declarada.", this.linea, this.col);
            }
            return true;
        }
        return new Errores("SEMANTICO","La variable con el id: "+this.id+" no puede declararse con valores de tipo: "+tipo1, this.linea, this.col);
    }
    
}
