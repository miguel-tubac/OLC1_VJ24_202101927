
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.*;
import java.util.LinkedList;

public class Match extends Instruccion {
    private Instruccion condicion;
    private LinkedList<Instruccion> instrucciones;
    private Instruccion condicionDefault;

    public Match(Instruccion condicion, LinkedList<Instruccion> instrucciones, Instruccion condicionDefault, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.condicion = condicion;
        this.instrucciones = instrucciones;
        this.condicionDefault = condicionDefault;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        var cond = this.condicion.interpretar(arbol, tabla);
        if (cond instanceof Errores){
            return cond;
        }
        
        if(this.instrucciones == null && this.condicionDefault == null){
            return new Errores("SEMANTICO", "Expresion match invalida, debe de poseer almenos un caso o el Default.",this.linea, this.col);
        }
        
        var newTabla = new TablaSimbolos(tabla);
        //Aca se evalua sin el dafault, sola las this.instrucciones
        if(this.instrucciones != null && this.condicionDefault == null){
            for (var casos : this.instrucciones){
                var newcasos = (Casos) casos;
                //System.out.println("Expresion a comparar: "+ newcasos.getCondicion().interpretar(arbol, newTabla));
                //System.out.println("Tipo Expresion a comparar: "+ newcasos.getCondicion().tipo.getTipo());
                var compa = newcasos.getCondicion().interpretar(arbol, newTabla);
                if (compa instanceof Errores){
                     return compa;
                }
                if(this.condicion.tipo.getTipo() == TipoDato.CADENA && newcasos.getCondicion().tipo.getTipo() == TipoDato.CADENA || 
                        this.condicion.tipo.getTipo() == TipoDato.CARACTER && newcasos.getCondicion().tipo.getTipo() == TipoDato.CARACTER ){
                    if( compa.toString().equals(cond.toString())){
                        casos.interpretar(arbol, newTabla);
                        //System.out.println("Aquissssss");
                        break;
                    } 
                }
                else{
                    //System.out.println("Cindi1: "+ (this.condicion.tipo.getTipo() == newcasos.getCondicion().tipo.getTipo()));
                    //System.out.println("Condi2: "+ (compa == cond));
                    //Aca se interpreta la condicion que se cumple dentro del match
                    if(this.condicion.tipo.getTipo() == newcasos.getCondicion().tipo.getTipo() && compa == cond){
                        casos.interpretar(arbol, newTabla);
                        //System.out.println("Aquissssss");
                        break;
                    } 
                }
            }
        }
        //Aca se evalua solo el default
        else if(this.instrucciones == null && this.condicionDefault != null){
            var casofed = this.condicionDefault.interpretar(arbol, newTabla);
            
            if (casofed instanceof Errores){
                return casofed;
            }
        }
        //Aca se avaluan los dos casos: default y casos
        else{
            boolean sientrocaso = false;
            for (var casos : this.instrucciones){
                var newcasos = (Casos) casos;
                var compa = newcasos.getCondicion().interpretar(arbol, newTabla);
                if (compa instanceof Errores){
                     return compa;
                }
                if(this.condicion.tipo.getTipo() == TipoDato.CADENA && newcasos.getCondicion().tipo.getTipo() == TipoDato.CADENA || 
                        this.condicion.tipo.getTipo() == TipoDato.CARACTER && newcasos.getCondicion().tipo.getTipo() == TipoDato.CARACTER ){
                    if( compa.toString().equals(cond.toString())){
                        casos.interpretar(arbol, newTabla);
                        sientrocaso = true;
                        //System.out.println("Aquissssss");
                        break;
                    } 
                }
                else{
                    //System.out.println("Cindi1: "+ (this.condicion.tipo.getTipo() == newcasos.getCondicion().tipo.getTipo()));
                    //System.out.println("Condi2: "+ (compa == cond));
                    //Aca se interpreta la condicion que se cumple dentro del match
                    if(this.condicion.tipo.getTipo() == newcasos.getCondicion().tipo.getTipo() && compa == cond){
                        casos.interpretar(arbol, newTabla);
                        sientrocaso = true;
                        //System.out.println("Aquissssss");
                        break;
                    } 
                }
                
            }
            if(sientrocaso == false){
                var casofed = this.condicionDefault.interpretar(arbol, newTabla);
            
                if (casofed instanceof Errores){
                    return casofed;
                }
            }
        }
        
        return null;
    }
    
    
}
