package refactoring.reporting;

import refactoring.Customer;
import refactoring.Rental;

/**
 *
 * @author Usuari
 */
public class ReportText extends Report {
    
    ReportText(Customer c){
        super(c);
    }

    @Override
    protected String getHeader() {
        return "Rental Record for " + customer.getName() + "\n";
    }

    @Override
    protected String getLinia(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getAmount()) + "\n";
    }

    @Override
    protected String getFooter() {
        String result = "Amount owed is " + String.valueOf(customer.getOwedAmount()) + "\n" ;
        result += "You earned " + String.valueOf(customer.getRenterPoints()) + " frequent renter points" ;
        return result ;    
    }

    @Override
    protected String getBeginDocument() {
        return "";
    }

    @Override
    protected String startLines() {
        return "";
    }

    @Override
    protected String endLines() {
        return "";
    }

    @Override
    protected String getEndDocument() {
        return "";
    }
 

}
