/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m05uf2.capsablanca;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class TheQuestTest {
    
    public TheQuestTest() {
    }

    @Test
    public void testStartTheQuest() {
        
        TheQuest tq = new TheQuest();
        tq.startTheQuest("", "");
        tq.startTheQuest(null, "");
        tq.startTheQuest("a", "");
        tq.startTheQuest(" a ", "");
        tq.startTheQuest("a a", "");
        tq.startTheQuest("a", null);
        tq.startTheQuest("a", "X");
        tq.startTheQuest("ka", "X");
        tq.startTheQuest("ka", "YY");
        tq.startTheQuest("ka", "-");
        tq.startTheQuest("ka", "X-");
        tq.startTheQuest("ka", "X-7");
        tq.startTheQuest("k3a410|_|", "X-7T");
        
        tq.startTheQuest("onlykthekbestsksurvive!", "XXX");
        tq.startTheQuest("onlykthekbestsksurvive!", "XXX-");
        tq.startTheQuest("0nlykth3kb3stsks|_|rviv3!", "XXX7Y");
        tq.startTheQuest("0nlykth3kb3stsks|_|rviv3!", "XXX7Y--");
        tq.startTheQuest("0nlykth3kb3stsks|_|rviv3!", "XXX7Y----");
        tq.startTheQuest("0nlykth3kb3stsks|_|rviv3!", "XXX7Y-----");
    }
}
