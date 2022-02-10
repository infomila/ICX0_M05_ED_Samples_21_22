package net.iesmila.ED.UF2.fabrica;

import org.junit.Test;
import static org.junit.Assert.*;


public class LectorTest {
    
    public LectorTest() {
    }

    /**
     * Test of extreuParaulesAmbDefinicio method, of class Lector.
     */
    @Test
    public void testInformeText() {
        
        // Activem el mode test a la fàbrica
        DiccionariFactory.setModeTest(true);
        
        Lector l = new Lector();
        String informeObtingut = l.extreuParaulesAmbDefinicio("El gos i el gat viuen a casa");
        String informeEsperat = "gos: mamifer cannid,gat: mamifer feli,casa: llar dolça llar";
        
        System.out.println("O:"+informeObtingut);
        System.out.println("E:"+informeEsperat);
        
        assertEquals(informeEsperat, informeObtingut );
        
        // Desactivem el mode test a la fàbrica
        DiccionariFactory.setModeTest(false);
     }
}
