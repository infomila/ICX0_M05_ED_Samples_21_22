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

    public double getCost() {
        double cost = getCostBase();
        cost += getPreuCopiaBW() * getNumberOfBlackAndWhiteCopies();
        if (suportaColor()) {
            cost += getPreuCopiaColor() * getNumberOfColorCopies();
        }
        return cost;
    }

    public abstract double getCostBase();

    public abstract double getPreuCopiaBW();

    public abstract double getPreuCopiaColor();

    public abstract String getNom();

    public abstract boolean suportaColor();

}
