package refactoring.printers;

import refactoring.Printer;
import refactoring.PrinterType;

/**
 *
 * @author Usuari
 */
public class OfficeJetPrinter extends Printer {

    public OfficeJetPrinter(String inventoryId,
            int copiesColor,
            int numberOfBlackAndWhiteCopies) {
        super(inventoryId, PrinterType.HP_OFFICEJET_5, copiesColor, numberOfBlackAndWhiteCopies);
    }
 

    public double getCostBase(){ return 125.0;}
    public double getPreuCopiaBW() {return 0.01;}
    public double getPreuCopiaColor() {return 0.07;}
    

    @Override
    public String getName() {
        return "HP Office 5";
    }

    @Override
    public boolean teColor() {
        return true;
    }

}
