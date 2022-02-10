/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencyinjection;

import comunicacions.MissatgerFactory;
import comunicacions.MissatgerFake;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author bernat
 */
public class ClientTest {
    
    public ClientTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of canviarOferta method, of class Client.
     */
    @Test

    public void testCanviarOferta() throws Exception {
        System.out.println("canviarOferta");
                
        //// versió amb injecció de dependències
        /*
        Client c = new Client(1, "Paco", "paco@gmail.com");        
        c.canviarOferta(20, new MissatgerFake());
        assertEquals(20, c.getDescompte(), 0.0001);
        */
        
        // Versió amb fabrica
        MissatgerFactory.setModeFake(true);
        
        Client c = new Client(1, "Paco", "paco@gmail.com");
        c.canviarOferta(20);
        assertEquals(20, c.getDescompte(), 0.0001);
        
        
        MissatgerFactory.setModeFake(false);
    }
    
    
}
