
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.*;
import java.util.LinkedList;

public class DoWhile extends Instruccion {
    private LinkedList<Instruccion> instrucciones;
    private Instruccion condicion;

    public DoWhile(LinkedList<Instruccion> instrucciones, Instruccion condicion, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.instrucciones = instrucciones;
        this.condicion = condicion;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        var cond = this.condicion.interpretar(arbol, tabla);
        if (cond instanceof Errores){
            return cond;
        }
        
        //Comprovacion si la condicion es boolean
        if(this.condicion.tipo.getTipo() != TipoDato.BOOLEANO){
            return new Errores("SEMANTICO", "Expresion invalida para condicion While",this.linea, this.col);
        }
        var newTabla = new TablaSimbolos(tabla);
        
        do{
            //ejecutar instrucciones
            for (var i : this.instrucciones) {
                if (i instanceof Break) {
                    //System.out.println("Break1");
                    return null;
                }
                if (i instanceof Continue) {
                    //System.out.println("continue1");
                    break;
                }
                var resIns = i.interpretar(arbol, newTabla);
                //System.out.println("Valor res: "+resIns);
                if (resIns == TipoDato.BREAK) {
                    //System.out.println("Break2");
                    return null;
                }
                if (resIns == TipoDato.CONTINUE) {
                    //System.out.println("continue2");
                    break;
                }
            }
            
            cond = this.condicion.interpretar(arbol, newTabla);
            if (cond instanceof Errores){
                return cond;
            }
            if (this.condicion.tipo.getTipo() != TipoDato.BOOLEANO){
                return new Errores("SEMANTICO", "Expresion invalida para condicion While",this.linea, this.col);
            }
        }while((boolean) cond);
        
        
        
        return null;
    }
    
    
    
}
