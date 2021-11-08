/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junithelloworld;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class SegurataTest {
    
    public SegurataTest() {
    }

    @Test
    public void testPucEntrar() {
     Segurata paco = new Segurata();
     // menor 14, amic true
     assertTrue("un menor colegui ha de poder entrar",paco.pucEntrar(14, true));
     // menor 14, enemic false
     assertFalse("un menor no colegui no passa",paco.pucEntrar(14, false));
     // major 20, amic true
     assertTrue("els majors d'edat amics entren segur!",paco.pucEntrar(20, true));
     // major 20, enemic false
     assertTrue("els majors d'edat entren segur encara que no siguin amics!",paco.pucEntrar(20, false));
     // major 18,
     assertTrue("amb 18 anys has de poder entrar!",paco.pucEntrar(18, false)); 
 
    }
    
    @Test
    public void testSegurata(){
        assertEquals(2,2);
    }
    
}
