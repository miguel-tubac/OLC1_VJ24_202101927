
package Instrucciones;

import Abstracto.Instruccion;
import Excepciones.Errores;
import Simbolo.*;
import java.util.LinkedList;

public class Whiles extends Instruccion {
    private Instruccion condicion;
    private Instruccion bloque;
    
    public Whiles(Instruccion condicion, Instruccion bloque, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.condicion = condicion;
        this.bloque = bloque;
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
        
        while((boolean) cond){
            var cuerpo = this.bloque.interpretar(arbol, newTabla);
            if (cuerpo instanceof Errores){
                return cuerpo;
            }
            //Se valida el break
            if(cuerpo instanceof Break){
                break;
            }
            // se valida el continue
            if(cuerpo instanceof Continue){
                continue;
            }
            
            cond = this.condicion.interpretar(arbol, newTabla);
            if (cond instanceof Errores){
                return cond;
            }
            if (this.condicion.tipo.getTipo() != TipoDato.BOOLEANO){
                return new Errores("SEMANTICO", "Expresion invalida para condicion While",this.linea, this.col);
            }
        }
        
        return null;
    }
    
    
    
    
}
