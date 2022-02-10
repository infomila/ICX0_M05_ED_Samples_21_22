package m05uf2.capsanegra;

import java.util.ArrayList;
import m05uf2.capsablanca.PapeoAppImp;

/**
 *
 * @author bernat
 */
public class PapeoApp {


    public static double getPreu(int[] cataleg, int[] comanda) {
        return PapeoAppImp.getPreu(cataleg, comanda);
    }

}
