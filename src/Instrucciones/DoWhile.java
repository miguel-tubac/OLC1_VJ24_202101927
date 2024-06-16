
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
        newTabla.setNombre("Do While");
        do{
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
                //Se agrega a la tabla general ya que se genera un nuevo entorno
                if (resIns instanceof Errores){
                    arbol.agregarError((Errores) resIns);
                    return resIns;
                }
                
                //System.out.println("Valor res: "+resIns);
                if (resIns == TipoDato.BREAK) {
                    //System.out.println("Break2");
                    arbol.agregarSim(newTabla);
                    return null;
                }
                if (resIns == TipoDato.CONTINUE) {
                    //System.out.println("continue2");
                    arbol.agregarSim(newTabla);
                    break;
                }
            }
            
            cond = this.condicion.interpretar(arbol, newTabla);
            if (cond instanceof Errores){
                arbol.agregarError((Errores) cond);
                return cond;
            }
            if (this.condicion.tipo.getTipo() != TipoDato.BOOLEANO){
                return new Errores("SEMANTICO", "Expresion invalida para condicion While",this.linea, this.col);
            }
        }while((boolean) cond);
        arbol.agregarSim(newTabla);
        
        
        return null;
    }
    
    
    
}
