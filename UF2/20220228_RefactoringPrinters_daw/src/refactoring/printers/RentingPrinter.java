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


    public double getCostBase(){ return 0.0;}
    public double getPreuCopiaBW() {return 0.06;}
    public double getPreuCopiaColor() {throw new RuntimeException("Color no suportat");}
    

    
    @Override
    public String getName() {
        return "Renting";
    }

    @Override
    public boolean teColor() {
        return false;
    }

}
