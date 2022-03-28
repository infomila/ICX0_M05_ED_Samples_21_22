/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesmila.m05.model;

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
    public void testRelacio_1_N_Projecte_Tasca() {
        
        Projecte p1 = new Projecte(1, "Projecte 1");
        assertEquals( 1, p1.getId());
        assertEquals("Projecte 1", p1.getNom());
        //---------------------------------------
        Tasca t1 = new Tasca( "Tasca 1",p1);
        
        assertEquals("Tasca 1", t1.getDesc());
        assertEquals(p1, t1.getProjecte());
        //---------------------------------------
        assertEquals( 1, p1.getNumTasques());
        assertEquals( t1, p1.getTasca(0));
        //---------------------------------------
        Tasca t2 = new Tasca( "Tasca 2",p1);
        assertEquals( 2, p1.getNumTasques());
        assertEquals( t2, p1.getTasca(1));
        
        //-----------------
        Projecte p2 = new Projecte(2, "Projecte 2");
        p2.addTasca(t2);
        assertEquals( 1, p2.getNumTasques());
        assertEquals( t2, p2.getTasca(0));
        assertEquals( p2, t2.getProjecte());
        assertEquals( 1, p1.getNumTasques());
        //----------------------------------------------
        
        t2.setProjecte(p1);
        assertEquals(  p1 , t2.getProjecte());
        assertEquals( 2, p1.getNumTasques());
        assertEquals( 0 , p2.getNumTasques());
        
        //-----------------------------------------------
        p1.removeTasca(t2);
        assertEquals( 1, p1.getNumTasques());
        assertNull(t2.getProjecte());
        
        //-----------------------------------------------
        p1.removeTasca(0); // esborro la t1 per índex
        assertEquals( 0, p1.getNumTasques());
        assertNull(t1.getProjecte());
        //-------------------------------------------------
        
        
    }
    
}
