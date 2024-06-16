
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.*;
import java.util.LinkedList;

public class For extends Instruccion {
    private Instruccion asignacion;
    private Instruccion condicion;
    private Instruccion actualizacion;
    private LinkedList<Instruccion> instrucciones;

    public For(Instruccion asignacion, Instruccion condicion, Instruccion actualizacion, LinkedList<Instruccion> instrucciones, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.asignacion = asignacion;
        this.condicion = condicion;
        this.actualizacion = actualizacion;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        //nuevo entorno 
        var nuevaTabla = new TablaSimbolos(tabla);
        nuevaTabla.setNombre("Condiciones For");
        //arbol.agregarSim(nuevaTabla);
        var res1 = this.asignacion.interpretar(arbol, nuevaTabla);
        if (res1 instanceof Errores){
            arbol.agregarError((Errores) res1);
            return res1;
        }
        //Se avalua la condicion
        //validar la condicion -> Booleano
        var cond = this.condicion.interpretar(arbol, nuevaTabla);
        if (cond instanceof Errores) {
            arbol.agregarError((Errores) cond);
            return cond;
        }
        
        if(this.condicion.tipo.getTipo() != TipoDato.BOOLEANO){
            return new Errores("SEMANTICO", "Expresion invalida para condicion del Bucle For",this.linea, this.col);
        }
        arbol.agregarSim(nuevaTabla);
        
        //System.out.println("Aqui afuera"+ this.condicion.interpretar(arbol, nuevaTabla));
        while ((boolean) this.condicion.interpretar(arbol, nuevaTabla)) {
            //System.out.println("Aqui adentro");
            //nuevo entorno
            var newTabla2 = new TablaSimbolos(nuevaTabla);
            newTabla2.setNombre("Cuerpo For");
            
            //ejecutar instrucciones
            for (var i : this.instrucciones) {
                if (i instanceof Break) {
                    //System.out.println("Break1");
                    arbol.agregarSim(newTabla2);
                    return null;
                }
                if (i instanceof Continue) {
                    //System.out.println("continue1");
                    arbol.agregarSim(newTabla2);
                    break;
                }
                var resIns = i.interpretar(arbol, newTabla2);
                
                /*if(resIns instanceof Errores){
                    arbol.agregarError((Errores) resIns);
                    return resIns;
                }*/
                //System.out.println("Valor res: "+resIns);
                if (resIns == TipoDato.BREAK) {
                    //System.out.println("Break2");
                    arbol.agregarSim(newTabla2);
                    return null;
                }
                if (resIns == TipoDato.CONTINUE) {
                    //System.out.println("continue2");
                    arbol.agregarSim(newTabla2);
                    break;
                }
            }
 
            //actualizar la variable
            
            var act = this.actualizacion.interpretar(arbol, nuevaTabla);
            if (act instanceof Errores) {
                arbol.agregarError((Errores) act);
                return act;
            }
            arbol.agregarSim(newTabla2);
        }
        
        
        return null;
    }
    
    
    
}
