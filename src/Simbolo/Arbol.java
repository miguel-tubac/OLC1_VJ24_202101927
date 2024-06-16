
package Simbolo;

import Abstracto.Instruccion;
import Excepciones.Errores;
import java.util.LinkedList;

public class Arbol {
    private LinkedList<Instruccion> instrucciones;
    private String consola;
    private TablaSimbolos tablaGlobal;
    private LinkedList<Errores> errores;
    private LinkedList<TablaSimbolos> simbolos;

    public Arbol(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
        this.consola = "";
        this.tablaGlobal = new TablaSimbolos();
        this.errores = new LinkedList<>();
        this.simbolos = new LinkedList<>();
    }

    public LinkedList<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public TablaSimbolos getTablaGlobal() {
        return tablaGlobal;
    }

    public void setTablaGlobal(TablaSimbolos tablaGlobal) {
        this.tablaGlobal = tablaGlobal;
    }

    public LinkedList<Errores> getErrores() {
        return errores;
    }
    
    public LinkedList<TablaSimbolos> getSimb() {
        return simbolos;
    }

    public void setErrores(LinkedList<Errores> errores) {
        this.errores = errores;
    }

    public void Print(String valor) {
        this.consola += valor + "\n";
    }
    
    public boolean agregarSimboloGlobal(Simbolo simbolo) {
        if (this.tablaGlobal.addSimbolo(simbolo)) {
            return true;
        } else {
            //this.errores.add(new Errores("SEMANTICO", "El símbolo con id " + simbolo.getId() + " ya existe en la tabla global.", 0, 0));
            return false;
        }
    }
    
    public void agregarError(Errores error) {
        this.errores.add(error);
    }
    
    public void agregarSim(TablaSimbolos simbolo) {
        this.simbolos.add(simbolo);
    }
    
}
