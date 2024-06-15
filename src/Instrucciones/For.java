
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.*;
import java.util.LinkedList;

public class For extends Instruccion {
    private Instruccion asignacion;
    private Instruccion condicion;
    private Instruccion actualizacion;
    private Instruccion instrucciones;

    public For(Instruccion asignacion, Instruccion condicion, Instruccion actualizacion, Instruccion instrucciones, int linea, int col) {
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
        
        var res1 = this.asignacion.interpretar(arbol, nuevaTabla);
        if (res1 instanceof Errores){
            return res1;
        }
        //Se avalua la condicion
        //validar la condicion -> Booleano
        var cond = this.condicion.interpretar(arbol, nuevaTabla);
        if (cond instanceof Errores) {
            return cond;
        }
        
        if(this.condicion.tipo.getTipo() != TipoDato.BOOLEANO){
            return new Errores("SEMANTICO", "Expresion invalida para condicion del Bucle For",this.linea, this.col);
        }
        
        //System.out.println("Aqui afuera"+ this.condicion.interpretar(arbol, nuevaTabla));
        while (!(boolean) this.condicion.interpretar(arbol, nuevaTabla)) {
            //System.out.println("Aqui adentro");
            //nuevo entorno
            var newTabla2 = new TablaSimbolos(nuevaTabla);

 
            //ejecutar instrucciones
            var interpretar = this.instrucciones;
            interpretar.interpretar(arbol, newTabla2);
            System.out.println("Tipo interpretado: "+ interpretar.tipo.getTipo());
            if (interpretar.tipo.getTipo() == TipoDato.BREAK){
                return null;
            }
            
            //.interpretar(arbol, newTabla2);

            //actualizar la variable
            var act = this.actualizacion.interpretar(arbol, nuevaTabla);
            if (act instanceof Errores) {
                return act;
            }
        }
        
        return null;
    }
    
    
    
}
