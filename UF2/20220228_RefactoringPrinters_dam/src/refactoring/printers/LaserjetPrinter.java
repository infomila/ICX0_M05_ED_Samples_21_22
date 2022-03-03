package refactoring.printers;

import refactoring.Printer;
import refactoring.PrinterType;

/**
 *
 * @author Usuari
 */
public class LaserjetPrinter extends Printer {

    public LaserjetPrinter(String inventoryId,
            int numberOfBlackAndWhiteCopies) {
        super(inventoryId, PrinterType.HP_LASERJET_VII, 0, numberOfBlackAndWhiteCopies);

    }

    @Override
    public String getNom() {
        return "HP Laserjet VII";
    }

    public double getCostBase(){ return 350.0;}
    public double getPreuCopiaBW() { return 0.01;}
    public double getPreuCopiaColor() {throw new RuntimeException("no suporta el color");}
        
    
    @Override
    public boolean suportaColor() {
        return false;
    }

}
