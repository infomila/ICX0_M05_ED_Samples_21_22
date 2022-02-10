
package net.iesmila.ED.UF2.fabrica;

import java.util.HashMap;

/**
 *
 * @author bernat
 */
public class DiccionariOnlineFake implements IDiccionariOnline{

    
    /*
    
    
        String informeObtingut = l.extreuParaulesAmbDefinicio("El gos i el gat viuen a casa");
        String informeEsperat = "gos: mamifer cannid,gat: mamifer feli,casa: llar dolça llar";    
    
    
    */
    HashMap<String, String> mapa;
    public DiccionariOnlineFake(){
        mapa  = new HashMap<String, String>();
        mapa.put("gos", "mamifer cannid");
        mapa.put("gat", "mamifer feli");
        mapa.put("casa", "llar dolça llar");
    }
    
    @Override
    public TipusParaula getTipusParaula(String paraula) {
        if(mapa.containsKey(paraula)) 
            return TipusParaula.NOM;
        else return TipusParaula.CONJUNCIO;
        /*if(paraula.equals("casa") || paraula.equals("gos")|| paraula.equals("gat"))
            return TipusParaula.NOM;
        else return TipusParaula.CONJUNCIO;*/
    }
    
    @Override
    public String getDescripcio(String paraula) {
        return mapa.get(paraula);
        //if(paraula.equals("casa")) return "llar dolça llar";
    }


    
}
