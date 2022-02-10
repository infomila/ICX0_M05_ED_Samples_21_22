
package dependencyinjection;

import comunicacions.Missatger;
import comunicacions.MissatgerFake;

/**
 *
 * @author bernat
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Client c = new Client(1, "Paco", "paco@gmail.com");
        //// versió amb injecció de dependències
        //c.canviarOferta(20, new MissatgerFake());
        c.canviarOferta(20);        
    }    
}
