
package net.iesmila.ED.UF2.fabrica;

/**
 *
 * @author bernat
 */
class DiccionariFactory {

    private static boolean _esModeTest = false;
    public static void setModeTest(boolean modeTest) {
        _esModeTest = modeTest;
    }
        
    public static IDiccionariOnline getInstance() {
        if(_esModeTest) {
            return new DiccionariOnlineFake();
        } else 
        {
            return new DiccionariOnline();
        }
    }
    
}
