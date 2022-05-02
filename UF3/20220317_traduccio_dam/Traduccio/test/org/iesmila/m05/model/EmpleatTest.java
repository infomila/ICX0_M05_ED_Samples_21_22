/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesmila.m05.model;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class EmpleatTest {
    
    public EmpleatTest() {
    }

    @Test
    public void testRelacioProjecte() {
        
        Empleat paco = new Empleat(1,10,"Paco", "González","Gutíerrez", "1111111H", new Date(), "", null);

        Empleat maria = new Empleat(1,10,"Maria", "Gómez","Sanz", "22222222J", new Date(), "", null);        
        
        
        Projecte p1 = new Projecte(1, "P1");
        Projecte p2 = new Projecte(2, "P2");
        
        assertEquals( 0, p1.getNumeroEmpleats());
        assertEquals( 0, paco.getNumProjectes());
        String rol1 = "Programador";
        paco.addProjecte(p1, rol1);
        assertEquals( 1, paco.getNumProjectes());
        assertEquals( p1, paco.getProjecte(0));
        assertEquals( 1, p1.getNumeroEmpleats());
        assertEquals( paco , p1.getEmpleat(0));
        assertEquals(rol1,  paco.getParticipacioProjecte(0).getRol() );
        //------------------------------------------------------
        String rol2 = "Cap de projecte";
        paco.addProjecte(p2, rol2);
        assertEquals( 2, paco.getNumProjectes());
        assertEquals( p2, paco.getProjecte(1));
        assertEquals( 1, p2.getNumeroEmpleats());
        assertEquals( paco , p2.getEmpleat(0));
        assertEquals(rol2,  paco.getParticipacioProjecte(1).getRol() );
        //------------------------------------------------------
        
        try {
            paco.addProjecte(null, rol2);           
            fail("Cas de projecte null no controlat");
        }catch(Exception ex) {}
        
        assertEquals( 2, paco.getNumProjectes());
        //------------------------------------------------------
        Projecte esborrat = paco.removeProjecte(p1);
        assertEquals( p1 , esborrat);
        assertEquals( 1, paco.getNumProjectes());
        assertEquals( p2, paco.getProjecte(0));
        assertEquals( 0 , p1.getNumeroEmpleats());
        //--------------------------------------------------------
        esborrat = paco.removeProjecte(p1);
        assertNull(esborrat);
        //--------------------------------------------------------
        esborrat = paco.removeProjecte(null);
        assertNull(esborrat);
    }
    
}
