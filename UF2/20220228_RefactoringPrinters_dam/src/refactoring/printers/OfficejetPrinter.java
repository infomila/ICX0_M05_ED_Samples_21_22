package refactoring.printers;

import refactoring.Printer;
import refactoring.PrinterType;

/**
 *
 * @author Usuari
 */
public class OfficejetPrinter extends Printer {

    public OfficejetPrinter(String inventoryId,
            int copiesColor,
            int numberOfBlackAndWhiteCopies) {
        super(inventoryId, PrinterType.HP_OFFICEJET_5, copiesColor, numberOfBlackAndWhiteCopies);

    }

    @Override
    public String getNom() {
        return "HP Office 5";
    }

    public double getCostBase() {
        return 125.0;
    }

    public double getPreuCopiaBW() {
        return 0.01;
    }

    public double getPreuCopiaColor() {
        return 0.07;
    }

    @Override
    public boolean suportaColor() {
        return true;
    }

}
