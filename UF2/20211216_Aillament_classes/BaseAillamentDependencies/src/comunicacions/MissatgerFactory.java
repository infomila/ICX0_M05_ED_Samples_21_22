package comunicacions;

/**
 *
 * @author bernat
 */
public class MissatgerFactory {

    private static boolean modeFake = false;

    private static IMissatger _singleton;

    public static void setModeFake(boolean m) {
        modeFake = m;
        _singleton = null;
    }
// modeFake false  --> _singleton <-- Missatger
    
    public static IMissatger getInstance() {

        if (_singleton == null) {

            if (modeFake) {
                _singleton = new MissatgerFake();
            } else {
                _singleton = new Missatger();
            }
        }
        return _singleton;
    }

}
