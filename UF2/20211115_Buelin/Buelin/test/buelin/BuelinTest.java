
package buelin;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class BuelinTest {
    
    public BuelinTest() {
    }

    @Test
    public void testGetSobrecostPerEquipatge_SENSE_SOBRECOST() {
        
        Buelin b = new Buelin();
        
        // Buit
        assertEquals( 0,
            b.getSobrecostPerEquipatge(null, 0, null, false),
            0.001);
        // Només equipatge de mà
        assertEquals( 0,
            b.getSobrecostPerEquipatge(new int[]{30,30,30}, 20, new int[]{10,10}, false),
            0.001);
        assertEquals( 0,
            b.getSobrecostPerEquipatge(new int[]{15,15,15}, 10, new int[]{10,10}, false),
            0.001);
        //Només maletes
        assertEquals( 0,
            b.getSobrecostPerEquipatge(null, 0, new int[]{20}, false),
            0.001);
                assertEquals( 0,
            b.getSobrecostPerEquipatge(null, 0, new int[]{15}, false),
            0.001);
                assertEquals( 0,
            b.getSobrecostPerEquipatge(null, 0, new int[]{20,20}, false),
            0.001);
                        assertEquals( 0,
            b.getSobrecostPerEquipatge(null, 0, new int[]{15,15}, false),
            0.001);
        // COMBO
                               
        assertEquals( 0,
            b.getSobrecostPerEquipatge(new int[]{30,30,30}, 20, new int[]{20,20}, false),
            0.001);
            
            assertEquals( 0,
            b.getSobrecostPerEquipatge(new int[]{30,30,30}, 20, new int[]{20,20}, true),
            0.001);
    }

    @Test
    public void testGetSobrecostPerEquipatge_AMB_SOBRECOST() {
                        
        Buelin b = new Buelin();

        // Només equipatge de mà
        assertEquals( 20,
            b.getSobrecostPerEquipatge(new int[]{30,30,30}, 21, new int[]{10,10}, false),
            0.001);
        assertEquals( 60,
            b.getSobrecostPerEquipatge(new int[]{31,15,15}, 10, new int[]{10,10}, false),
            0.001);
        assertEquals( 60,
            b.getSobrecostPerEquipatge(new int[]{15,31,15}, 10, new int[]{10,10}, false),
            0.001);
        assertEquals( 60,
            b.getSobrecostPerEquipatge(new int[]{15,15,31}, 10, new int[]{10,10}, false),
            0.001);
        assertEquals( 80,
            b.getSobrecostPerEquipatge(new int[]{15,15,31}, 21, new int[]{10,10}, false),
            0.001);
        
        //Només maletes
        assertEquals( 20,
            b.getSobrecostPerEquipatge(null, 0, new int[]{21}, false),
            0.001);
        assertEquals( 20,
            b.getSobrecostPerEquipatge(null, 0, new int[]{20,21}, false),
            0.001);
        assertEquals( 40,
            b.getSobrecostPerEquipatge(null, 0, new int[]{21,21}, false),
            0.001);
        assertEquals( 100,
            b.getSobrecostPerEquipatge(null, 0, new int[]{15,15,10}, false),
            0.001);
        assertEquals( 140,
            b.getSobrecostPerEquipatge(null, 0, new int[]{21,21,10}, false),
            0.001); 
        assertEquals( 310,
            b.getSobrecostPerEquipatge(null, 0, new int[]{10,10,10,21}, false),
            0.001); 
        // COMBO                               
        assertEquals( 390,
            b.getSobrecostPerEquipatge(new int[]{15,15,31}, 21,  new int[]{10,10,10,21}, false),
            0.001); 
        
        assertEquals( 392,
            b.getSobrecostPerEquipatge(new int[]{15,15,31}, 21,  new int[]{10,10,10,21}, true),
            0.001);   
        
    }
    
    @Test
    public void testGetSobrecostPerEquipatge_ERRORS() {
        testError("midaEquipatgeMaCm", new int[]{-10,10,10} , 10, new int[]{10});
        testError("midaEquipatgeMaCm", new int[]{10,-10,10} , 10, new  int[]{10});
        testError("midaEquipatgeMaCm", new int[]{10,10,-10} , 10, new  int[]{10});
        testError("midaEquipatgeMaCm", new int[]{0,10,10} , 10, new  int[]{10});
        testError("midaEquipatgeMaCm", new int[]{10,0,10} , 10, new  int[]{10});
        testError("midaEquipatgeMaCm", new int[]{10,10,0} , 10, new  int[]{10});
        testError("midaEquipatgeMaCm", new int[]{10,10} , 10, new  int[]{10});
        testError("midaEquipatgeMaCm", new int[]{10} , 10, new  int[]{10});
        testError("midaEquipatgeMaCm", new int[]{} , 10, new  int[]{10});
        testError("midaEquipatgeMaCm", new int[]{10,10,10,10} , 10, new  int[]{10});
        //--------------------------------------------------------------------------------
        testError("pesEquipatgeMa", new int[]{10,10,10} , 0, new  int[]{10});
        testError("pesEquipatgeMa", new int[]{10,10,10} , -1, new  int[]{10});
        //--------------------------------------------------------------------------------
        testError("pesMaletes", new int[]{10,10,10} , 10, new  int[]{0});
        testError("pesMaletes", new int[]{10,10,10} , 10, new  int[]{-1});
        testError("pesMaletes", new int[]{10,10,10} , 10, new  int[]{10,0});
        testError("pesMaletes", new int[]{10,10,10} , 10, new  int[]{10,-1});
        
    }

    private void testError(String camp, int midaEquipatgeMaCm[],
            int pesEquipatgeMa,
            int pesMaletes[]) {
        Buelin b = new Buelin();
        try {
            b.getSobrecostPerEquipatge(midaEquipatgeMaCm, pesEquipatgeMa, pesMaletes, true);
            //
            fail("Dades errònies en el camp "+camp+" no controlades");
        } catch(Exception ex){
            //arribar aquí és el que esperem
        }
    }

}
