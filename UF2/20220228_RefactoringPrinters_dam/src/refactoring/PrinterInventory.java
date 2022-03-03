package refactoring;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author bernat
 */
public class PrinterInventory {

    ArrayList<Printer> printerList;

    public PrinterInventory() {
        printerList = new ArrayList<Printer>();
    }

    public void addPrinter(Printer p) {
        printerList.add(p);
    }

    private class Recompte {

        int numeroImpresores;
        double costTotal;

        public Recompte() {
            numeroImpresores = 0;
            costTotal = 0;
        }
    }

    public String getExpensesInventory() {

        String e = "================================================\n";
        e += "       PRINTER EXPENSES INVENTORY \n";
        e += "================================================\n";

        HashMap<PrinterType, Recompte> recomptes = new HashMap<>();

        for (Printer p : printerList) {

            double cost = p.getCost();

            e += " * " + p.getInventoryId() + ":" + p.getNom() + " >\t\t expenses: " + cost
                    + "€ > number of B&W copies " + p.getNumberOfBlackAndWhiteCopies()
                    + (p.suportaColor() ? " > number of Color copies " + p.getNumberOfColorCopies() : "")
                    + "\n";

            PrinterType tipus = p.getPrinterType();
            Recompte r = recomptes.get(tipus);
            if (r == null) {
                r = new Recompte();
                recomptes.put(tipus, r);
            }
            r.costTotal += cost;
            r.numeroImpresores++;

        }
        e += "------------------------------------------------\n";
        e += "              Summary \n";
        e += "------------------------------------------------\n";
        PrinterType tipus[] = PrinterType.values();
        for (int i = 0; i < tipus.length; i++) {
            PrinterType tip = tipus[i];
            e += " - " + tip.getNom() + " > \t# of printers:" + recomptes.get(tip).numeroImpresores
                    + ",\t total cost:" + recomptes.get(tip).costTotal + "€\n";
        }
        e += "------------------------------------------------\n";
        e += " TOTAL PRINTERS:" + printerList.size() + "\n";
        e += " TOTAL COST:" + getCostTotal() + "€\n";
        e += "------------------------------------------------\n";
        return e;
    }

    private double getCostTotal() {
        
        return printerList.stream().mapToDouble(x->x.getCost()).sum();
        
     /*   double costTotal = 0;
        for (Printer p : printerList) {
            costTotal += p.getCost();
        }
        return costTotal;*/
    }

}
