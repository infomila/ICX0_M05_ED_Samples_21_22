package refactoring;

/**
 *
 * @author Usuari
 */
public class ReportText extends Report{

    @Override
    protected String getHeader() {
        return "Rental Record for " + customer.getName() + "\n";    }

    @Override
    protected String getLinia(Rental rental) {
       return "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getAmount()) + "\n";
    }

    @Override
    protected String getFooter() {
        String result = "Amount owed is " + String.valueOf(customer.getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(customer.getTotalRenterPoints()) + " frequent renter points";    
        return result;
    }                

    @Override
    protected String getStartLines() {
        return "";
    }

    @Override
    protected String getEndLines() {
        return "";
    }
    
}
