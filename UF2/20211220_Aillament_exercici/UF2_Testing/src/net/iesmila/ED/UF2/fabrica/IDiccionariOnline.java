package net.iesmila.ED.UF2.fabrica;

/**
 *
 * @author bernat
 */
public interface IDiccionariOnline {

    String getDescripcio(String paraula);

    /**
     * donada una paraula en retorna el tipus ( nom, adjectiu, verb...)
     */
    TipusParaula getTipusParaula(String paraula);
    
}
