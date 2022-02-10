/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m05uf2.capsanegra;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class PapeoAppTest {
    
    public PapeoAppTest() {
    }

    @Test
    public void testGetPreu_ERRONIS() {
        
        testError(null, null, "Null attack"); 
        //-----------------------------------------------------------------

        testError(null, new int[]{1,1}, "Cataleg null");   
        testError(new int[0], new int[]{1,1}, "Cataleg buit");   
        testError(new int[0], new int[]{1,1}, "Cataleg buit");
        testError(new int[]{1}, new int[]{1,1}, "Falten 3 camps per definir el producte");
        testError(new int[]{1,2}, new int[]{1,1}, "Falten 2 camps per definir el producte");
        testError(new int[]{1,2,3}, new int[]{1,1}, "Falta 1 camp per definir el producte");
        //-----------------------------------------------------------------
        //                  C  S ? T             C Q
        testError(new int[]{0, 2,3,1}, new int[]{1,1}, "Codi de producte >=0");
        testError(new int[]{-1,2,3,1}, new int[]{1,1}, "Codi de producte >=0");
        testError(new int[]{1,2,3,1,
                            2,2,6,2,
                            1,5,3,1}, new int[]{1,1}, "Codi de producte és PK");
        //--------------------------------------------------------------------
        //                  C  S ? T             C Q
        testError(new int[]{1,-1,3,1}, new int[]{1,1}, "Stock>=0");
        //--------------------------------------------------------------------
        //                  C  S  ? T             C Q
        testError(new int[]{1,+5, 0,1}, new int[]{1,1}, "Preu>0");
        testError(new int[]{1,+5,-1,1}, new int[]{1,1}, "Preu>0");
        //--------------------------------------------------------------------
        //                  C  S  ? T             C Q
        testError(new int[]{1,+5, 4,0}, new int[]{1,1}, "Tipus in (1,2,3)");
        testError(new int[]{1,+5, 4,4}, new int[]{1,1}, "Tipus in (1,2,3)");
        
        //--------------------------------------------------------------------
        // Comanda
        //--------------------------------------------------------------------
        //                  C  S  ? T             C Q
        testError(new int[]{1,+5, 4,1}, null, "Comanda not null");
        testError(new int[]{1,+5, 4,1}, new int[0], "Comanda Buida");
        testError(new int[]{1,+5, 4,1}, new int[]{1}, "Comanda incompleta"); 
        testError(new int[]{1,+5, 4,1}, new int[]{-1,2}, "Comanda amb codi incorrecte"); 
        testError(new int[]{1,+5, 4,1}, new int[]{2,2}, "Comanda amb codi no existent"); 
        testError(new int[]{1,+5, 4,1}, new int[]{1,0}, "Comanda unitats>0"); 
        testError(new int[]{1,+5, 4,1}, new int[]{1,-1}, "Comanda unitats>0");
    }

    public void testError(int [] cataleg, int [] comanda, String msg) {
        try {
            PapeoApp.getPreu(cataleg, comanda);
            fail(msg);
        }catch(Exception ex){}
    }
    
    @Test
    public void testGetPreu_OK_SENSE_DESCOMPTE() {
        
        //--------------------------------------------------------------------
        //                  C   S  ?  T             C Q
        assertEquals(20+6,
        PapeoApp.getPreu(new int[]{
                            11,+5, 4, 1,
                            22,+4, 3, 2,
                            33,+0, 5, 3}, new int[]{11,2,  //8
                                                    22,2,  //6
                                                    11,4,  //12
                                                    33,2}  // 0 (no té stock)
                            )
        , 0.001);
        
        
        
    }
    @Test
    public void testGetPreu_OK_DESCOMPTE_TIPUS1() {
        //--------------------------------------------------------------------
        //                  C   S  ?  T             C Q
        assertEquals(20*0.9,
        PapeoApp.getPreu(new int[]
                           {11,+5, 4, 1,
                            22,+4, 3, 2,
                            33,+0, 5, 3}, new int[]{11,2,  //20
                                                    11,4,
                                                    33,1}   
                            )
        , 0.001);        
        
    }
    @Test
    public void testGetPreu_OK_DESCOMPTE_MENU() {
        //--------------------------------------------------------------------
        //                  C   S  ?  T             C Q
        assertEquals( 34 - 2*2,
        PapeoApp.getPreu(new int[]
                           {11,+5, 4, 1,
                            22,+4, 3, 2,
                            33,+7, 5, 3}, new int[]{11,2,  //12 
                                                    22,4, //12
                                                    33,2, //10
                                                    11,1}   
                            )
        , 0.001);         
    }
     @Test
    public void testGetPreu_OK_DESCOMPTE_FAMILIAR() {
        
        //--------------------------------------------------------------------
        //                  C   S  ?  T             C Q
        assertEquals( ((16+12+25) - 4*2)*0.9,
        PapeoApp.getPreu(new int[]
                           {11,+5, 4, 1,
                            22,+4, 3, 2,
                            33,+7, 5, 3}, new int[]{11,2, //16 
                                                    22,4, //12
                                                    33,5, //25
                                                    11,2}   
                            )
        , 0.001); 
        
    }   
    @Test
    public void testGetPreu_OK_DESCOMPTE_100() {
        
    }   
    @Test
    public void testGetPreu_OK_DESCOMPTE_COMBINAT() {
        
    }   
}
