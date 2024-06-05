
package Interprete.entorno;


import Interprete.Expresion;

import java.util.HashMap;
import java.util.Map;

public class Entorno {
    private String nombre;
    private Entorno anterior;
    private Map<String, Simbolo> tablaSim;
    private Map<String, Object> tablaFunc;

    public Entorno(String nombre, Entorno anterior) {
        this.nombre = nombre;
        this.anterior = anterior;
        this.tablaSim = new HashMap<>();
        this.tablaFunc = new HashMap<>();
    }

    public void addSimbolo(String nombre, Object valor, String tipo, String tipoVar, int fila, int columna) {
        if (tablaSim.containsKey(nombre)) {
            System.out.println("Semantico: Variable ya declarada");
            return;
        }
        tablaSim.put(nombre, new Simbolo(nombre, valor, tipo, tipoVar, fila, columna));
    }

    public Simbolo getSimbolo(String nombre) {
        Entorno ent = this;
        while (ent != null) {
            if (!ent.tablaSim.containsKey(nombre)) {
                ent = ent.anterior;
            } else {
                return ent.tablaSim.get(nombre);
            }
        }
        return new Simbolo("ERROR", "ERROR", "ERROR", "ERROR", 0, 0);
    }

    public void editarSimbolo(String nombre, Object nuevoValor, int fila, int columna) {
        if (tablaSim.containsKey(nombre)) {
            Simbolo simbolo = tablaSim.get(nombre);
            simbolo.setValor(nuevoValor);
            simbolo.setFila(fila);
            simbolo.setColumna(columna);
        } else {
            System.out.println("Error Semantico: variable no existe en la asignacion.");
        }
    }

    public void addFuncion(String nombre, Object instrucciones, int fila, int columna) {
        if (tablaFunc.containsKey(nombre)) {
            System.out.println("Semantico: Funcion o metodo ya declarada");
            return;
        }
        tablaFunc.put(nombre, instrucciones);
    }

    public Object getFuncion(String nombre) {
        Entorno ent = this;
        while (ent != null) {
            if (!ent.tablaFunc.containsKey(nombre)) {
                ent = ent.anterior;
            } else {
                return ent.tablaFunc.get(nombre);
            }
        }
        return null;
    }
}