
package aparcalocomopuedas;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class ParkingTest {
    
    public ParkingTest() {
    }

    @Test
    public void testBuscaLlocLliure_ERROR() {
        assertEquals(
                Parking.ERROR,
                Parking.buscaLlocLliure(-1, 300, 
                       new int[]{0,0,0}, 
                       new int[]{400,400,400}, 
                       new boolean[]{false, false,false})
        );
        //--------------------------------------------------
        assertEquals("mida zero",
                Parking.ERROR,
                Parking.buscaLlocLliure(0, 0, 
                       new int[]{0,0,0}, 
                       new int[]{400,400,400}, 
                       new boolean[]{false, false,false})
        );
        
        assertEquals("mida negativa",
                Parking.ERROR,
                Parking.buscaLlocLliure(0, -1, 
                       new int[]{0,0,0}, 
                       new int[]{400,400,400}, 
                       new boolean[]{false, false,false})
        );
        //-------------------------------
        assertEquals("p.taula socis: buida",
                Parking.ERROR,
                Parking.buscaLlocLliure(0, 300, 
                       new int[]{}, 
                       new int[]{400,400,400}, 
                       new boolean[]{false, false,false})
        );
        assertEquals("p.taula socis: buida, resta de taules buides",
                Parking.ERROR,
                Parking.buscaLlocLliure(0, 300, 
                       new int[]{}, 
                       new int[]{}, 
                       new boolean[]{})
        );
        //-----------------------------
        assertEquals("p.taula socis: null",
                Parking.ERROR,
                Parking.buscaLlocLliure(0, 300, 
                       null, 
                       new int[]{400,400,400}, 
                       new boolean[]{false, false,false})
        );
        assertEquals("p.taula socis: null, la resta de taules null també.",
                Parking.ERROR,
                Parking.buscaLlocLliure(0, 300, 
                       null, 
                       null, 
                       null)
        );
        assertEquals("p.taula socis: soci negatiu",
                Parking.ERROR,
                Parking.buscaLlocLliure(0, 300, 
                       new int[]{0,0,-1}, 
                       new int[]{400,400,400}, 
                       new boolean[]{false, false,false})
        );
        assertEquals("p.taula socis: mida de taula diferent",
                Parking.ERROR,
                Parking.buscaLlocLliure(0, 300, 
                       new int[]{0,0,0,0}, //4 
                       new int[]{400,400,400},// 3 
                       new boolean[]{false, false,false}) //3
        );
        //-----------------------------
        assertEquals("p.taula mides:null",
                Parking.ERROR,
                Parking.buscaLlocLliure(0, 300, 
                       new int[]{0,0,0}, //3 
                       null,// 3 
                       new boolean[]{false, false,false}) //3
        );
        assertEquals("p.taula mides:buit",
                Parking.ERROR,
                Parking.buscaLlocLliure(0, 300, 
                       new int[]{0,0,0},
                       new int[]{}, //3 
                       new boolean[]{false, false,false}) //3
        );
        assertEquals("p.taula mides:zero",
                Parking.ERROR,
                Parking.buscaLlocLliure(0, 300, 
                       new int[]{0,0,0},
                       new int[]{400,400,0},
                       new boolean[]{false, false,false}) //3
        );
        assertEquals("p.taula mides:negatius",
                Parking.ERROR,
                Parking.buscaLlocLliure(0, 300, 
                       new int[]{0,0,0},
                       new int[]{400,400,-1},
                       new boolean[]{false, false,false}) //3
        );
        assertEquals("p.taula mides:longitud diferent",
                Parking.ERROR,
                Parking.buscaLlocLliure(0, 300, 
                       new int[]{0,0,0},
                       new int[]{400,400,400,400}, //4
                       new boolean[]{false, false,false}) //3
        );
        //---------------------------------------------------------
        assertEquals("p.taula ocupacions:null",
                Parking.ERROR,
                Parking.buscaLlocLliure(0, 300, 
                       new int[]{0,0,0},
                       new int[]{400,400,400},
                       null) //3
        );
        assertEquals("p.taula ocupacions:buit",
                Parking.ERROR,
                Parking.buscaLlocLliure(0, 300, 
                       new int[]{0,0,0},
                       new int[]{400,400,400},
                       new boolean[]{}) //3
        );
        assertEquals("p.taula ocupacions:longitud diferent",
                Parking.ERROR,
                Parking.buscaLlocLliure(0, 300, 
                       new int[]{0,0,0},
                       new int[]{400,400,400},
                       new boolean[]{false,false,false,false}) //4
        );
    }

    @Test
    public void testBuscaLlocLliure_LLIURE() {
        assertEquals(
                "usuari no soci troba lloc",
                4,
                Parking.buscaLlocLliure(0, 300, 
                       new int[]{    0,     12,  12,    0,    0,     0 }, 
                       new int[]{    400,  400,  400,  300,   301,   600 }, 
                       new boolean[]{true, true,false, false, false, false})
        ); 
        assertEquals(
                "usuari soci troba lloc a la seva plaça",
                7,
                Parking.buscaLlocLliure(15, 300, 
                       new int[]{    0,     12,  12,    0,    0,     15 , 15, 15}, 
                       new int[]{    400,  400,  400,  300,   301,   300 , 301, 301}, 
                       new boolean[]{true, true,false, false, false, false, true, false})
        );  
                assertEquals(
                "usuari soci troba lloc a una plaça pública",
                4,
                Parking.buscaLlocLliure(15, 300, 
                       new int[]{    0,     12,  12,    0,    0,     15 , 15}, 
                       new int[]{    400,  400,  400,  300,   301,   300 , 301}, 
                       new boolean[]{true, true,false, false, false, false, true})
        ); 
    }
    
    @Test
    public void testBuscaLlocLliure_SENSE_LLOC() {
    }
    

    
}
