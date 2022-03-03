package refactoring.printers;

import refactoring.Printer;
import refactoring.PrinterType;

/**
 *
 * @author Usuari
 */
public class RentingPrinter extends Printer {

    public RentingPrinter(String inventoryId,
            int numberOfBlackAndWhiteCopies) {
        super(inventoryId, PrinterType.RENTING_LASER_JET, 0, numberOfBlackAndWhiteCopies);

    }

    @Override
    public String getNom() {
        return "Renting";
    }

 
    public double getCostBase(){ return 0.0;}
    public double getPreuCopiaBW() { return 0.06;}
    public double getPreuCopiaColor() {throw new RuntimeException("no suporta el color");}
    
    @Override
    public boolean suportaColor() {
        return false;
    }

}
