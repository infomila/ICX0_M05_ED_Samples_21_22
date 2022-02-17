package refactoring;

import java.util.Iterator;
import java.util.LinkedList;

//From book: 'Refactoring' by Martin Fowler
//This is the original code before refactoring begins
public class Customer {

    private String _name;
    private LinkedList<Rental> _rentals = new LinkedList<Rental>();



    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }
    
    public Iterator<Rental> getRentals() {
        return _rentals.iterator();
    }
    
    public String statement() {
                
        Report r = Report.getReport(Report.TipusReport.TEXT);
        return r.getReport(this);        
    }
    
    
    
    
    

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : _rentals) {
            totalAmount += rental.getAmount();
        }
        return totalAmount;
    }
    public int getTotalRenterPoints() {
        int totalRenterPoints = 0;
        for (Rental rental : _rentals) {
            totalRenterPoints += rental.getRenterPoints();
        }
        return totalRenterPoints;
    }

}
