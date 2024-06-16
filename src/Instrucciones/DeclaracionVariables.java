
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.*;


public class DeclaracionVariables extends Instruccion{
    private TipoDato mutabilidad;
    private String id;
    private OperadoresVariables tipo;

    public DeclaracionVariables(TipoDato mutabilidad, String id, OperadoresVariables tipo, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.mutabilidad = mutabilidad;
        this.id = id;
        this.tipo = tipo;
    }
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        return switch (this.tipo){
            case INT ->
                this.datoINT(this.mutabilidad, this.id, tabla);
            case DOUBLE ->
                this.datoDOUBLE(this.mutabilidad, this.id, tabla);
            case BOOL ->
                this.datoBOOL(this.mutabilidad, this.id, tabla);
            case CHAR ->
                this.datoCHAR(this.mutabilidad, this.id, tabla);
            case STRING ->
                this.datoSTRING(this.mutabilidad, this.id, tabla);
            default ->
                new Errores("Error Semantico","Asociacion no declarada", this.linea, this.col);
        };
        
    } 
    
    
    public Object datoINT(TipoDato mutabilidad, String id, TablaSimbolos tabla){
        ValorVariable valor = new ValorVariable(this.tipo, 0);
        Simbolo nuevoSimbolo = new Simbolo(new Tipo(mutabilidad), this.id, valor, this.linea, this.col);
        boolean resultado = tabla.addSimbolo(nuevoSimbolo);
        if (resultado == false){
            return new Errores("Semantico","La variable con el ID:"+this.id+" Ya fue declarada.", this.linea, this.col);
        }
        //this.tipo.setTipo(TipoDato.ENTERO);
        return true;
    }
    
    
    public Object datoDOUBLE(TipoDato mutabilidad, String id, TablaSimbolos tabla){
        ValorVariable valor = new ValorVariable(this.tipo, 0.0);
        Simbolo nuevoSimbolo = new Simbolo(new Tipo(mutabilidad), this.id, valor, this.linea, this.col);
        boolean resultado = tabla.addSimbolo(nuevoSimbolo);
        if (resultado == false){
            return new Errores("Semantico","La variable con el ID:"+this.id+" Ya fue declarada.", this.linea, this.col);
        }
        return true;
    }
    
    
    public Object datoBOOL(TipoDato mutabilidad, String id, TablaSimbolos tabla){
        ValorVariable valor = new ValorVariable(this.tipo, true);
        Simbolo nuevoSimbolo = new Simbolo(new Tipo(mutabilidad), this.id, valor, this.linea, this.col);
        boolean resultado = tabla.addSimbolo(nuevoSimbolo);
        if (resultado == false){
            return new Errores("Semantico","La variable con el ID:"+this.id+" Ya fue declarada.", this.linea, this.col);
        }
        return true;
    }
    
    
    public Object datoCHAR(TipoDato mutabilidad, String id, TablaSimbolos tabla){
        ValorVariable valor = new ValorVariable(this.tipo, '0');
        Simbolo nuevoSimbolo = new Simbolo(new Tipo(mutabilidad), this.id, valor, this.linea, this.col);
        boolean resultado = tabla.addSimbolo(nuevoSimbolo);
        if (resultado == false){
            return new Errores("Semantico","La variable con el ID:"+this.id+" Ya fue declarada.", this.linea, this.col);
        }
        return true;
    }
    
    public Object datoSTRING(TipoDato mutabilidad, String id, TablaSimbolos tabla){
        ValorVariable valor = new ValorVariable(this.tipo, "");
        Simbolo nuevoSimbolo = new Simbolo(new Tipo(mutabilidad), this.id, valor, this.linea, this.col);
        boolean resultado = tabla.addSimbolo(nuevoSimbolo);
        if (resultado == false){
            return new Errores("Semantico","La variable con el ID:"+this.id+" Ya fue declarada.", this.linea, this.col);
        }
        return true;
    }
    
    
}
