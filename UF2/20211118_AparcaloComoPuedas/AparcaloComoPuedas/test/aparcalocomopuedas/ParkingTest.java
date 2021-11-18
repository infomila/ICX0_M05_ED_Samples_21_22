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
    public void testBuscaLlocLliure_ERRORS() {
        
        assertEquals(
                "client amb codi negatiu",
                Parking.ERROR,
                Parking.buscaLlocLliure(                
                    -1, //*
                    400, 
                    new int[]{0,0,0}, 
                    new int[]{500,500,500}, 
                    new boolean[]{false, false,false})
        );
        //-------------------------------------------------
        assertEquals(
                "longitud cotxe: zero",
                Parking.ERROR,
                Parking.buscaLlocLliure(                
                    0, 
                    0, //*
                    new int[]{0,0,0}, 
                    new int[]{500,500,500}, 
                    new boolean[]{false, false,false})
        );
        assertEquals(
                "longitud cotxe: negatiu",
                Parking.ERROR,
                Parking.buscaLlocLliure(                
                    0, 
                    -1, //*
                    new int[]{0,0,0}, 
                    new int[]{500,500,500}, 
                    new boolean[]{false, false,false})
        );
        //--------------------------------------------------
         assertEquals(
                "taula codis client: negatiu",
                Parking.ERROR,
                Parking.buscaLlocLliure(                
                    0, 
                    400, 
                    new int[]{0,0,-1}, //*
                    new int[]{500,500,500}, 
                    new boolean[]{false, false,false})
        );
         assertEquals(
                "taula codis client: taula buida",
                Parking.ERROR,
                Parking.buscaLlocLliure(                
                    0, 
                    400, 
                    new int[]{}, //*
                    new int[]{500,500,500}, 
                    new boolean[]{false, false,false})
        );
         assertEquals(
                "taula codis client: taula nul·la",
                Parking.ERROR,
                Parking.buscaLlocLliure(                
                    0, 
                    400, 
                    null, //*
                    new int[]{500,500,500}, 
                    new boolean[]{false, false,false})
        );
         assertEquals(
                "taula codis client: taula diferent mida",
                Parking.ERROR,
                Parking.buscaLlocLliure(                
                    0, 
                    400, 
                    new int[]{0, 0, 0, 0}, //*
                    new int[]{500,500,500}, 
                    new boolean[]{false, false,false})
        );
         //-----------------------------------------------
         assertEquals(
                "taula de longituds: zero",
                Parking.ERROR,
                Parking.buscaLlocLliure(                
                    0, 
                    400, 
                    new int[]{0, 0, 0}, 
                    new int[]{500,500,0}, //*
                    new boolean[]{false, false,false})
        );
         assertEquals(
                "taula de longituds: negatiu",
                Parking.ERROR,
                Parking.buscaLlocLliure(                
                    0, 
                    400, 
                    new int[]{0, 0, 0}, 
                    new int[]{500,500,-1}, //*
                    new boolean[]{false, false,false})
        );
         assertEquals(
                "taula de longituds: longitud diferent",
                Parking.ERROR,
                Parking.buscaLlocLliure(                
                    0, 
                    400, 
                    new int[]{0, 0, 0}, 
                    new int[]{500,500,500,500}, //*
                    new boolean[]{false, false,false})
        );
         assertEquals(
                "taula de longituds: taula buida",
                Parking.ERROR,
                Parking.buscaLlocLliure(                
                    0, 
                    400, 
                    new int[]{0, 0, 0}, 
                    new int[]{}, //*
                    new boolean[]{false, false,false})
        );
         assertEquals(
                "taula de longituds: taula null",
                Parking.ERROR,
                Parking.buscaLlocLliure(                
                    0, 
                    400, 
                    new int[]{0, 0, 0}, 
                    null, //*
                    new boolean[]{false, false,false})
        );
        //---------------------------------------------------------
        assertEquals(
                "taula d'ocupació: longitud diferent",
                Parking.ERROR,
                Parking.buscaLlocLliure(                
                    0, 
                    400, 
                    new int[]{0, 0, 0}, 
                    new int[]{500,500,500}, 
                    new boolean[]{false, false,false, false})//*
        );
        assertEquals(
                "taula d'ocupació: taula buida",
                Parking.ERROR,
                Parking.buscaLlocLliure(                
                    0, 
                    400, 
                    new int[]{0, 0, 0}, 
                    new int[]{500,500,500}, 
                    new boolean[]{})//*
        );
        assertEquals(
                "taula d'ocupació: taula nul·la",
                Parking.ERROR,
                Parking.buscaLlocLliure(                
                    0, 
                    400, 
                    new int[]{0, 0, 0}, 
                    new int[]{500,500,500,500}, 
                    null)//*
        );
        //-------------------------
        assertEquals(
                "taula d'ocupació: taula nul·la",
                Parking.ERROR,
                Parking.buscaLlocLliure(                
                    0, 
                    400, 
                    null, 
                    null, 
                    null)//*
        );
    }
    
    @Test
    public void testBuscaLlocLliure_LLOC_ASSIGNAT() {
                assertEquals(
                "usuari no soci troba plaça",
                7,
                Parking.buscaLlocLliure(                
                    0, //*
                    400, 
                    new int[]    {   15,  15,    15,    15, 0,    0,    0,          0, 0}, 
                    new int[]    {  500, 500,    400,  400, 500,  400,  400,      401, 402}, 
                    new boolean[]{false, true, false,  true, true, false, true, false, false})
                );
        assertEquals(
                "usuari soci troba plaça a una plaça seva",
                5,
                Parking.buscaLlocLliure(                
                    15, //*
                    400, 
                    new int[]    {   0,     12,   15,     15,    15,   15 }, 
                    new int[]    { 500,    500,  500,   400,   400,   401 }, 
                    new boolean[]{false, false, true,  false,  true, false})
                );
        
        assertEquals(
                "usuari soci troba plaça a una plaça pública, les seves estan plenes",
                0,
                Parking.buscaLlocLliure(                
                    15, //*
                    400, 
                    new int[]    {   0,     12,   15,     15,    15 }, 
                    new int[]    { 500,    500,  500,   400,   400 }, 
                    new boolean[]{false, false, true,  false,  true})
                );        
    }
    
    
    @Test
    public void testBuscaLlocLliure_SENSE_LLOC() {
    }



}
