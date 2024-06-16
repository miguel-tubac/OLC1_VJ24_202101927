
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.*;
import java.util.LinkedList;

public class Whiles extends Instruccion {
    private Instruccion condicion;
    private LinkedList<Instruccion> instrucciones;
    
    public Whiles(Instruccion condicion, LinkedList<Instruccion> instrucciones, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.condicion = condicion;
        this.instrucciones = instrucciones;
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
        newTabla.setNombre("While");
        while((boolean) cond){
            //ejecutar instrucciones
            for (var i : this.instrucciones) {
                if (i instanceof Break) {
                    arbol.agregarSim(newTabla);
                    //System.out.println("Break1");
                    return null;
                }
                if (i instanceof Continue) {
                    arbol.agregarSim(newTabla);
                    //System.out.println("continue1");
                    break;
                }
                var resIns = i.interpretar(arbol, newTabla);
                if (resIns instanceof Errores){
                    arbol.agregarError((Errores) resIns);
                    return resIns;
                }
                //System.out.println("Valor res: "+resIns);
                if (resIns == TipoDato.BREAK) {
                    arbol.agregarSim(newTabla);
                    //System.out.println("Break2");
                    return null;
                }
                if (resIns == TipoDato.CONTINUE) {
                    arbol.agregarSim(newTabla);
                    //System.out.println("continue2");
                    break;
                }
            }
            
            cond = this.condicion.interpretar(arbol, newTabla);
            if (cond instanceof Errores){
                arbol.agregarError((Errores) cond);
                return cond;
            }
            if (this.condicion.tipo.getTipo() != TipoDato.BOOLEANO){
                return new Errores("SEMANTICO", "Expresion invalida para condicion While: "+cond,this.linea, this.col);
            }
        }
        arbol.agregarSim(newTabla);
        
        return null;
    }
    
    
    
    
}
