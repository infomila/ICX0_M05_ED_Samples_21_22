package net.iesmila.ED.UF2.fabrica;

import java.util.Hashtable;

public class DiccionariOnline implements IDiccionariOnline   {
    
    /**
     * donada una paraula en retorna el tipus ( nom, adjectiu, verb...)
     */
 
    @Override
    public TipusParaula getTipusParaula(String paraula) {
        throw new RuntimeException("No em puc connectar a Internet durant el test.");
    }
    
 
    @Override
    public String getDescripcio(String paraula) {
        throw new RuntimeException("No em puc connectar a Internet durant el test.");
    }
}
