package refactoring.reporting;

import refactoring.Customer;
import refactoring.Rental;

/**
 *
 * @author Usuari
 */
public class ReportXML extends Report {

    ReportXML(Customer c) {
        super(c);
    }

    @Override
    protected String getHeader() {
        return "<name>Rental Record for " + customer.getName() + "</name>\n";
    }

    @Override
    protected String getLinia(Rental rental) {
        return "\t<rental><title>" + rental.getMovie().getTitle() + "</title>\t<amount>" + String.valueOf(rental.getAmount()) + "</amount></rental>\n";
    }

    @Override
    protected String getFooter() {
        String result = "<footer><owed>" + String.valueOf(customer.getOwedAmount()) + "</owed>\n";
        result += "<points>" + String.valueOf(customer.getRenterPoints()) + " </points></footer>";
        return result;
    }

    @Override
    protected String getBeginDocument() {
        return "<customer>\n";
    }

    @Override
    protected String startLines() {
        return "<rentals>";
    }

    @Override
    protected String endLines() {
        return "</rentals>\n";
    }

    @Override
    protected String getEndDocument() {
        return "</customer>\n";
    }

}
