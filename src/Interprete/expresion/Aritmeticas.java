
package Interprete.expresion;

import Interprete.Expresion;
import Interprete.entorno.Entorno;

public class Aritmeticas extends Expresion {
    private Expresion expIzq;
    private String operador;
    private Expresion expDer;

    public Aritmeticas(Expresion expIzq, String operador, Expresion expDer, int fila, int columna) {
        super("ERROR", "ERROR", fila, columna);
        this.expIzq = expIzq;
        this.operador = operador;
        this.expDer = expDer;
    }

    @Override
    public Expresion interpretar(Entorno entorno) {
        Expresion izq = expIzq.interpretar(entorno);
        Expresion der = expDer.interpretar(entorno);

        if (operador.equals("+")) {
            if (izq.tipo.equals("INT") && der.tipo.equals("INT")) {
                this.tipo = "INT";
                this.valor = (Integer) izq.valor + (Integer) der.valor;
                return this;
            }
        }
        return this;
    }
}
