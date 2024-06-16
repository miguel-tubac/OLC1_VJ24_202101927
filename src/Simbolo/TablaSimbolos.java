
package Simbolo;

import java.util.HashMap;

public class TablaSimbolos {
    private TablaSimbolos tablaAnterior;
    private HashMap<String, Object> tablaActual;
    private String nombre;

    public TablaSimbolos() {
        this.tablaActual = new HashMap<>();
        this.nombre = "";
    }

    public TablaSimbolos(TablaSimbolos tablaAnterior) {
        this.tablaAnterior = tablaAnterior;
        this.tablaActual = new HashMap<>();
        this.nombre = "";
    }

    public TablaSimbolos getTablaAnterior() {
        return tablaAnterior;
    }

    public void setTablaAnterior(TablaSimbolos tablaAnterior) {
        this.tablaAnterior = tablaAnterior;
    }

    public HashMap<String, Object> getTablaActual() {
        return tablaActual;
    }

    public void setTablaActual(HashMap<String, Object> tablaActual) {
        this.tablaActual = tablaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean addSimbolo(Simbolo nuevo) {
        if (nuevo != null && nuevo.getId() != null) {
            if (tablaActual.containsKey(nuevo.getId())) {
                System.out.println("El simbolo con id " + nuevo.getId() + " ya existe.");
                return false;
                //throw new IllegalArgumentException("El símbolo con id " + nuevo.getId() + " ya existe.");
                //return new Error();
            } else {
                tablaActual.put(nuevo.getId().toLowerCase(), nuevo);
                return true;
            }
        }
        return false;
    }

    public Simbolo buscarSimbolo(String id) {
        if (tablaActual.containsKey(id.toLowerCase())) {
            return (Simbolo) tablaActual.get(id.toLowerCase());
        } else if (tablaAnterior != null) {
            return tablaAnterior.buscarSimbolo(id.toLowerCase());
        } else {
            return null; // o lanzar una excepción si el símbolo no se encuentra
        }
        
    }
}
