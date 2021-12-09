/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iesmila.ED.UF2.capsa_blanca;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class TheIncredibleMachineTest {

    public TheIncredibleMachineTest() {
    }

    @Test
    public void testCrunch() {
        {
            TheIncredibleMachine tim = new TheIncredibleMachine();

            tim.crunch(new int[]{-1, 11, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 1, 7, 1, 6});
            tim.crunch(new int[]{ 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 1, 7, 1, 6});
        }
        {
            TheIncredibleMachine tim = new TheIncredibleMachine();

            tim.crunch(new int[]{ 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3});
        }
    }

}
