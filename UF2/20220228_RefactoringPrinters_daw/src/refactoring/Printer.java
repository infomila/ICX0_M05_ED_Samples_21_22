package refactoring;

/**
 *
 * @author bernat
 */
public abstract class Printer {



    private String inventoryId;
    private PrinterType printerType;
    private int numberOfColorCopies;
    private int numberOfBlackAndWhiteCopies;

    public Printer(String inventoryId, PrinterType printerType, int numberOfColorCopies, int numberOfBlackAndWhiteCopies) {
        this.inventoryId = inventoryId;
        this.printerType = printerType;
        this.numberOfColorCopies = numberOfColorCopies;
        this.numberOfBlackAndWhiteCopies = numberOfBlackAndWhiteCopies;

        if (this.numberOfColorCopies > 0
                && (printerType == PrinterType.HP_LASERJET_VII || printerType == PrinterType.RENTING_LASER_JET)) {
            throw new RuntimeException("This printer does not support color.");
        }
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public PrinterType getPrinterType() {
        return printerType;
    }

    public int getNumberOfColorCopies() {
        return numberOfColorCopies;
    }

    public int getNumberOfBlackAndWhiteCopies() {
        return numberOfBlackAndWhiteCopies;
    }

    public double getCost(){
        double cost = getCostBase();
        cost += getPreuCopiaBW() * this.getNumberOfBlackAndWhiteCopies();
        if( teColor()){
            cost += getPreuCopiaColor() * this.numberOfColorCopies;
        }
        return cost;
    }
    
    public abstract String getName();
    public abstract boolean teColor();
    public abstract double getCostBase();
    public abstract double getPreuCopiaBW();
    public abstract double getPreuCopiaColor();
    /*
    double getCost() {
        double cost = 0;       
        if (getPrinterType() == Printer.HP_LASERJET_VII) {
     
            cost = 350.00;
            cost += 0.01 * getNumberOfBlackAndWhiteCopies();
         
        } else if (getPrinterType() == Printer.HP_OFFICEJET_5) {            
            cost = 125.00;
            cost += 0.01 * getNumberOfBlackAndWhiteCopies();
            cost += 0.07 * getNumberOfColorCopies();          
        } else {             
            cost += 0.06 * getNumberOfBlackAndWhiteCopies();
        }
        return cost;
    }

   public String getNom() {
        String nom;
        if (getPrinterType() == Printer.HP_LASERJET_VII) {
            nom="HP Laserjet VII";
         
        } else if (getPrinterType() == Printer.HP_OFFICEJET_5) {            
            nom = "HP Office 5";   
        } else {             
            nom = "Renting";
        }
        return nom;    
   }

    boolean teColor() {
       if (getPrinterType() == Printer.HP_OFFICEJET_5){
           return true;
       }
       return false;
    }*/



}
