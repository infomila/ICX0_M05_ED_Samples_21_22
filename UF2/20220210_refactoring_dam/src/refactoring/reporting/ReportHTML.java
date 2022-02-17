package refactoring.reporting;

import refactoring.Customer;
import refactoring.Rental;

/**
 *
 * @author Usuari
 */
public class ReportHTML extends Report {

    ReportHTML(Customer c) {
        super(c);
    }

    @Override
    protected String getHeader() {
        return "<header>Rental Record for " + customer.getName() + "</header>\n";
    }

    @Override
    protected String getLinia(Rental rental) {
        return "\t<li>" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getAmount()) + "</li>\n";
    }

    @Override
    protected String getFooter() {
        String result = "<footer>Amount owed is " + String.valueOf(customer.getOwedAmount()) + "\n";
        result += "You earned " + String.valueOf(customer.getRenterPoints()) + " frequent renter points</footer>";
        return result;
    }

    @Override
    protected String getBeginDocument() {
        return "<html><body>\n";
    }

    @Override
    protected String startLines() {
        return "<ul>";
    }

    @Override
    protected String endLines() {
        return "</ul>\n";
    }

    @Override
    protected String getEndDocument() {
        return "</body></html>\n";
    }

}
