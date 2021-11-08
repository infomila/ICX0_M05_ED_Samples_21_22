package preuseients;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class TarificadorTest {

    public TarificadorTest() {
    }

    @Test
    public void testGetPreuForesDeRang() {
        testErroni(0,20, "Fora de rang de tipus de seient no controlat");
        testErroni(5,20, "Fora de rang de tipus de seient no controlat");
        testErroni(-1,20, "Fora de rang de tipus de seient no controlat");
        testErroni(1,-1, "Fora de rang d'edat");
        testErroni(1,0, "Fora de rang d'edat");
        testErroni(1,130, "Fora de rang d'edat");
    }
    
    public void testErroni(int tipusSeient, int edat, String missatge) {
        try {
            Tarificador.getPreu(tipusSeient, edat);
            // HELLO !
            fail(missatge);
        } catch (Exception ex) {
                // EI THERE !
        }
    }

    @Test
    public void testGetPreuValorsCorrectes() {

        assertEquals(0, Tarificador.getPreu(1, 2), 0.001);
        assertEquals(0, Tarificador.getPreu(1, 3), 0.001);
        assertEquals(45, Tarificador.getPreu(1, 4), 0.001);
        assertEquals(45, Tarificador.getPreu(1, 5), 0.001);
        assertEquals(45, Tarificador.getPreu(1, 7), 0.001);
        assertEquals(45, Tarificador.getPreu(1, 11), 0.001);
        assertEquals(60, Tarificador.getPreu(1, 12), 0.001);
        assertEquals(60, Tarificador.getPreu(1, 13), 0.001);
        assertEquals(60, Tarificador.getPreu(1, 25), 0.001);
        assertEquals(60, Tarificador.getPreu(1, 59), 0.001);
        assertEquals(30, Tarificador.getPreu(1, 60), 0.001);
        assertEquals(30, Tarificador.getPreu(1, 61), 0.001);
        assertEquals(30, Tarificador.getPreu(1, 70), 0.001);
        assertEquals(0, Tarificador.getPreu(2, 2), 0.001);
        assertEquals(0, Tarificador.getPreu(2, 3), 0.001);
        assertEquals(37.5, Tarificador.getPreu(2, 4), 0.001);
        assertEquals(37.5, Tarificador.getPreu(2, 5), 0.001);
        assertEquals(37.5, Tarificador.getPreu(2, 7), 0.001);
        assertEquals(37.5, Tarificador.getPreu(2, 11), 0.001);
        assertEquals(50, Tarificador.getPreu(2, 12), 0.001);
        assertEquals(50, Tarificador.getPreu(2, 13), 0.001);
        assertEquals(50, Tarificador.getPreu(2, 25), 0.001);
        assertEquals(50, Tarificador.getPreu(2, 59), 0.001);
        assertEquals(10, Tarificador.getPreu(2, 60), 0.001);
        assertEquals(10, Tarificador.getPreu(2, 61), 0.001);
        assertEquals(10, Tarificador.getPreu(2, 70), 0.001);
        assertEquals(0, Tarificador.getPreu(3, 2), 0.001);
        assertEquals(0, Tarificador.getPreu(3, 3), 0.001);
        assertEquals(30, Tarificador.getPreu(3, 4), 0.001);
        assertEquals(30, Tarificador.getPreu(3, 5), 0.001);
        assertEquals(30, Tarificador.getPreu(3, 7), 0.001);
        assertEquals(30, Tarificador.getPreu(3, 11), 0.001);
        assertEquals(40, Tarificador.getPreu(3, 12), 0.001);
        assertEquals(40, Tarificador.getPreu(3, 13), 0.001);
        assertEquals(40, Tarificador.getPreu(3, 25), 0.001);
        assertEquals(40, Tarificador.getPreu(3, 59), 0.001);
        assertEquals(8, Tarificador.getPreu(3, 60), 0.001);
        assertEquals(8, Tarificador.getPreu(3, 61), 0.001);
        assertEquals(8, Tarificador.getPreu(3, 70), 0.001);
        assertEquals(0, Tarificador.getPreu(4, 2), 0.001);
        assertEquals(0, Tarificador.getPreu(4, 3), 0.001);
        assertEquals(0, Tarificador.getPreu(4, 4), 0.001);
        assertEquals(22.5, Tarificador.getPreu(4, 5), 0.001);
        assertEquals(22.5, Tarificador.getPreu(4, 7), 0.001);
        assertEquals(22.5, Tarificador.getPreu(4, 11), 0.001);
        assertEquals(30, Tarificador.getPreu(4, 12), 0.001);
        assertEquals(30, Tarificador.getPreu(4, 13), 0.001);
        assertEquals(30, Tarificador.getPreu(4, 25), 0.001);
        assertEquals(30, Tarificador.getPreu(4, 59), 0.001);
        assertEquals(6, Tarificador.getPreu(4, 60), 0.001);
        assertEquals(6, Tarificador.getPreu(4, 61), 0.001);
        assertEquals(6, Tarificador.getPreu(4, 70), 0.001);

    }

}
