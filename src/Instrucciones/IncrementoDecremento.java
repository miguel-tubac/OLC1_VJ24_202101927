
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.*;

public class IncrementoDecremento extends Instruccion {
    public String id;
    public String signo;

    public IncrementoDecremento(String id, String signo, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.id = id;
        this.signo = signo;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        //variable exista
        var variable = tabla.buscarSimbolo(this.id);
        if (variable == null) {
            return new Errores("Semantico", "La Variable " + this.id + " no ha sido declarada", this.linea, this.col);
        }
        
        
        //validamos si es de tipo int o double
        //System.out.println("Tipo: "+ variable.getTipo().getTipo());
        if(variable.getTipo().getTipo() == TipoDato.CONST){
            return new Errores("Semantico", "La Variable " + this.id + " es de tipo CONST y no puede Incrementar o Decrementar", this.linea, this.col);
        }
        
        ValorVariable valor = (ValorVariable) variable.getValor();
        if(valor.getTipo() == OperadoresVariables.INT){
            int numero = valor.getValor();
            if(this.signo.equals("++")){
                valor.setValor(++numero);
            }
            else if(this.signo.equals("--")){
                valor.setValor(--numero);
            }
        }
        else if(valor.getTipo() == OperadoresVariables.DOUBLE){
            double numero = valor.getValorDouble();
            if(this.signo.equals("++")){
                valor.setValorDouble(++numero);
            }
            else if(this.signo.equals("--")){
                valor.setValorDouble(--numero);
            }
        }
        else{
            return new Errores("Semantico", "La Variable " + this.id + " no es de tipo INT o DOUBLE.", this.linea, this.col);
        }
        return true;
    }
    
    
}
