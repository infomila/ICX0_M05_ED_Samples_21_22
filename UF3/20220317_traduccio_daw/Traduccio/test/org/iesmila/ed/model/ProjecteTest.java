/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesmila.ed.model;

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
    public void testSetCap() {
    }

    @Test
    public void testGetNumero() {
    }

    @Test
    public void testSetNumero() {
    }

    @Test
    public void testGetNom() {
    }

    @Test
    public void testSetNom() {
    }

    @Test
    public void testGetCap() {
    }

    @Test
    public void testGetNumeroTasques() {
    }

    @Test
    public void testGetTasca() {
    }

    @Test
    public void testGetTasques() {
    }

    @Test
    public void testAddTasca() {
    }

    @Test
    public void testRemoveTasca() {
    }
    
}
