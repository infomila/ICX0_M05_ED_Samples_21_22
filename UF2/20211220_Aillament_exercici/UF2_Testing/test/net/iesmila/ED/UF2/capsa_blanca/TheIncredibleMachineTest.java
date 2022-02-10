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
         TheIncredibleMachine tim = new TheIncredibleMachine();
         tim.crunch(new int[]{3, 8});
         tim.crunch(new int[]{11,-2,3, 8,8,8,8,8,8, 6, 5, 5, 5, 5, 4 ,4 ,4 ,4, 3 ,3 ,3 ,3, 2, 0, 7,1,6});
    }

}
