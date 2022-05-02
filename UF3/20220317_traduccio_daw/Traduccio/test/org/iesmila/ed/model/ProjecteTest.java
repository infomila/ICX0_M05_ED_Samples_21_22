/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesmila.ed.model;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class ProjecteTest {
    
    public ProjecteTest() {
    }

    
    @Test
    public void testConstructor(){
        Projecte p = new Projecte(1, "Primer");
        assertEquals(1, p.getNumero());
        assertEquals("Primer", p.getNom());
        
        Tasca t1 = new Tasca("feina 1", p);
        assertEquals( 1, t1.getNumero());
        assertEquals( p, t1.getProjecte());
        
        assertEquals(1,  p.getNumeroTasques());
        assertEquals(t1 , p.getTasca(0));
        //--------------------------
        Projecte p2 = new Projecte(2, "Segon");
        Tasca t2 = new Tasca("tasca 2", p2);
        assertEquals(t2 , p2.getTasca(0));
        
        p.addTasca(t2);
        assertEquals( t2, p.getTasca(1));
        assertEquals( p, t2.getProjecte());
        assertEquals( 0, p2.getNumeroTasques());
        assertEquals( 2, p.getNumeroTasques());
        //----------------------------------------------
        
        t2.setProjecte(p2);
        assertEquals( t2, p2.getTasca(0));
        assertEquals( p2, t2.getProjecte());       
        assertEquals( 1, p.getNumeroTasques());
        //------------------------------------------------
        System.out.println("XXXX");
        p.removeTasca(t1);
        assertEquals( 0, p.getNumeroTasques());
        assertNull( t1.getProjecte());
                
        
    }
     
    @Test
    public void testParticipants() {
        
        Projecte p1 = new Projecte(1, "P1");
        Projecte p2 = new Projecte(2, "P2");
        
        Empleat Maria = new Empleat(30, "Maria", "Gómez", new Date(), "11111111H", null);
        Empleat Paco = new Empleat(40, "Paco", "Sorna", new Date(), "22222222H", null);
        
        p1.addParticipant(Maria, "Analista");
        assertEquals( 1, p1.getNumParticipants());
        assertEquals( 1, Maria.getNumProjectes());
        assertEquals( Maria , p1.getParticipant(0));
        assertEquals(  p1 , Maria.getProjecte(0));
        assertEquals( "Analista", p1.getParticipacio(0).getRol());
        assertEquals( p1, p1.getParticipacio(0).getProjecte());
        assertEquals( Maria, p1.getParticipacio(0).getEmpleat());
        //-------------------------------------------------------------
        assertEquals( Maria.getParticipacio(0), p1.getParticipacio(0)); 
        p2.addParticipant(Maria, "Programador");
        assertEquals( 1, p1.getNumParticipants());
        assertEquals( 2, Maria.getNumProjectes());
        assertEquals( Maria , p1.getParticipant(0));
        assertEquals(  p1 , Maria.getProjecte(0));
        assertEquals( 1, p2.getNumParticipants());
        assertEquals( Maria , p2.getParticipant(0));
        assertEquals(  p2 , Maria.getProjecte(1));
        //--------------------------------------------------------------
        p1.removeParticipant(Maria);
        assertEquals( 0, p1.getNumParticipants());
        assertEquals( 1, Maria.getNumProjectes());
        try{
            assertEquals( Maria , p1.getParticipant(0));
            fail("No hauria de funcionar !!!");
        } catch(Exception ex){}
        
        assertEquals(  p2 , Maria.getProjecte(0));
        assertEquals( 1, p2.getNumParticipants());
        assertEquals( Maria , p2.getParticipant(0));
        //--------------------------------------------------------------
 
        
    }

 
    
}
