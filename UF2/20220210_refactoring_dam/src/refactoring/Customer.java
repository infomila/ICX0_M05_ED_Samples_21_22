package refactoring;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import refactoring.reporting.Report;
import refactoring.reporting.ReportHTML;
import refactoring.reporting.ReportText;
import refactoring.reporting.ReportXML;

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

    public List<Rental> getRentals() {
        return Collections.unmodifiableList(_rentals);
    }

    public String statement() {
        Report r = Report.getReport(Report.TipusReport.TEXT, this);
        return r.getReport();
    }

    public double getOwedAmount() {
        double totalAmount = 0;
        for (Rental rental : _rentals) {
            totalAmount += rental.getAmount();
        }
        return totalAmount;
    }

    public int getRenterPoints() {
        int points = 0;
        for (Rental rental : _rentals) {
            points += rental.getRenterPoints();
        }
        return points;
    }

}
