package refactoring.printers;

import refactoring.Printer;
import refactoring.PrinterType;

/**
 *
 * @author Usuari
 */
public class LaserJetPrinter extends Printer {

    public LaserJetPrinter(String inventoryId,
            int numberOfBlackAndWhiteCopies) {
        super(inventoryId, PrinterType.HP_LASERJET_VII, 0, numberOfBlackAndWhiteCopies);
    }

    
    public double getCostBase(){ return 350.0;}
    public double getPreuCopiaBW() {return 0.01;}
    public double getPreuCopiaColor() {throw new RuntimeException("Color no suportat");}
    
    @Override
    public String getName() {
        return "HP Laserjet VII";
    }

    @Override
    public boolean teColor() {
        return false;
    }

}
