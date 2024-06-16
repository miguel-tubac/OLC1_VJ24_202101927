
package Expresiones;

import Abstracto.Instruccion;
import Simbolo.*;
import Excepciones.Errores;
import Instrucciones.OperadoresVariables;
import Instrucciones.ValorVariable;

public class AccesoALaVariable extends Instruccion {
    private String id;
    //private Tipo tipo;
    
    public AccesoALaVariable(String id, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.id = id;
        //this.tipo = tipo;
    }
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Simbolo simbolo = tabla.buscarSimbolo(id); // Buscar el símbolo en la tabla de símbolos

        if (simbolo != null) { // Si el símbolo existe
            ValorVariable valor = (ValorVariable) simbolo.getValor();
            OperadoresVariables operador =  valor.getTipo();
            return switch(operador){
                case INT ->
                    this.acceso_A_INT(valor);
                case DOUBLE ->
                    this.acceso_A_DOUBLE(valor);
                case BOOL ->
                    this.acceso_A_BOOLEAN(valor);
                case CHAR ->
                    this.acceso_A_CHAR(valor);
                case STRING ->
                    this.acceso_A_STRING(valor);
                default ->
                    new Errores("SEMANTICO","Operador desconocido en Acceso A La Variable", this.linea, this.col);
            };
          
        } 
        
        // Si el símbolo no existe, retornar un error
        return new Errores("SEMANTICO", "La Variable " + id + " no ha sido declarada", this.linea, this.col);
    }
    
    public Object acceso_A_INT(ValorVariable valor){
        this.tipo.setTipo(TipoDato.ENTERO);//Se actualiza el tipo
        return valor.getValor(); // Retornar el valor del símbolo
    }      
    
    public Object acceso_A_DOUBLE(ValorVariable valor){
        this.tipo.setTipo(TipoDato.DECIMAL);
        return valor.getValorDouble(); // Retornar el valor del símbolo
    }
    
    public Object acceso_A_BOOLEAN(ValorVariable valor){
        this.tipo.setTipo(TipoDato.BOOLEANO);
        return valor.isValorBoolean(); // Retornar el valor del símbolo
    }
    
    public Object acceso_A_CHAR(ValorVariable valor){
        this.tipo.setTipo(TipoDato.CARACTER);
        return valor.getValorChar(); // Retornar el valor del símbolo
    }
    
    public Object acceso_A_STRING(ValorVariable valor){
        this.tipo.setTipo(TipoDato.CADENA);
        return valor.getValorString(); // Retornar el valor del símbolo
    }
}
