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
    
    private class Recompte{

        public Recompte(int unitats, double costTotal) {
            this.unitats = unitats;
            this.costTotal = costTotal;
        }
        public int unitats;
        public double costTotal;
    }
    
    public String getExpensesInventory() {
        
        String  e  = "================================================\n";
                e += "       PRINTER EXPENSES INVENTORY \n";
                e += "================================================\n";
                
        int totalBWCopies = 0;
        int totalColorCopies = 0;
        double totalCost = 0;
        double laserJetCost = 0;
        double officeJetCost = 0;
        double rentingCost = 0;
        int laserJetPrinters =0, officeJetPrinters =0, rentingCostPrinters =0;
        
        
        HashMap<PrinterType, Recompte> recomptes = new HashMap<>();
        
        for(Printer p: printerList) {
            
            double cost = p.getCost();
            totalBWCopies += p.getNumberOfBlackAndWhiteCopies();
            if(p.teColor()){
                totalColorCopies += p.getNumberOfColorCopies();
            }                                  
            e += " * " + p.getInventoryId()+ ":"+p.getName()+
                    " >\t\t expenses: "+cost+
                    "€ > number of B&W copies " +p.getNumberOfBlackAndWhiteCopies() +
                    ( p.teColor()? " > number of Color copies " + p.getNumberOfColorCopies():"")+ 
                    "\n";                                
            
            PrinterType tipus = p.getPrinterType();
            Recompte r = recomptes.get(tipus);
            if(r==null) {
                r = new Recompte(0,0);
                recomptes.put(tipus, r);
            }
            r.unitats++;
            r.costTotal+= cost;
            
            totalCost += cost;
        }
        e += "------------------------------------------------\n";
        e += "              Summary \n";
        e += "------------------------------------------------\n";
        
        PrinterType []tipus = PrinterType.values();
        for(int i=0;i<tipus.length;i++) {
            PrinterType tip = tipus[i];
            e += " - "+tip.getNom()+" > \t# of printers:"+recomptes.get(tip).unitats+",\t total cost:"+recomptes.get(tip).costTotal+"€\n";
        }
        e += "------------------------------------------------\n";
        e += " TOTAL PRINTERS:"+printerList.size()+"\n";
        e += " TOTAL COST:"+(recomptes.values().stream().mapToDouble(x->x.costTotal).sum())+"€\n";
        e += "------------------------------------------------\n";
        return e;        
    }
}
