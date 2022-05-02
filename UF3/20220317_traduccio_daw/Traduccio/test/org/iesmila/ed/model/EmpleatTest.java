package org.iesmila.ed.model;

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
    public void testRelacioAmbProjectes() {
        
        Projecte p1 = new Projecte(1, "P1");
        Projecte p2 = new Projecte(2, "P2");
        
        Empleat maria = new Empleat(30, "Maria", "Gómez", new Date(), "11111111H", null);
        Empleat paco = new Empleat(40, "Paco", "Sorna", new Date(), "22222222H", null);
        
        String rol= "Analista";
        p1.addParticipant(maria, rol);

        assertEquals( 1, p1.getNumParticipants());
        assertEquals( 1, maria.getNumProjectes());
        assertEquals( maria , p1.getParticipant(0));
        assertEquals(  p1 , maria.getProjecte(0));
        assertEquals( rol, p1.getParticipacio(0).getRol());
        assertEquals( p1, p1.getParticipacio(0).getProjecte());
        assertEquals( maria, p1.getParticipacio(0).getEmpleat());
        //-------------------------------------------------------------
        assertEquals( maria.getParticipacio(0), p1.getParticipacio(0));
        
        String rol2 = "Programador";
        maria.addProjecte(p2, rol2);
        assertEquals( 1, p1.getNumParticipants());
        assertEquals( 2, maria.getNumProjectes());
        assertEquals( maria , p1.getParticipant(0));
        assertEquals(  p1 , maria.getProjecte(0));
        assertEquals( 1, p2.getNumParticipants());
        assertEquals( maria , p2.getParticipant(0));
        assertEquals(  p2 , maria.getProjecte(1));
        //------------------------------------------------------------
        maria.addProjecte(p2, rol2);
        assertEquals( 2, maria.getNumProjectes());
        
        //--------------------------------------------------------------
        Projecte esborrat = maria.removeProjecte(p1);
        assertEquals( p1, esborrat);
        assertEquals( 0, p1.getNumParticipants());
        assertEquals( 1, maria.getNumProjectes());
        try{
            assertEquals( maria , p1.getParticipant(0));
            fail("No hauria de funcionar !!!");
        } catch(Exception ex){}
        
        assertEquals(  p2 , maria.getProjecte(0));
        assertEquals( 1, p2.getNumParticipants());
        assertEquals( maria , p2.getParticipant(0));
        //--------------------------------------------------------------
        esborrat = maria.removeProjecte(p1);
        assertEquals( 1, maria.getNumProjectes());
        assertNull(esborrat);
    }

    
}
