package refactoring;

/**
 *
 * @author Usuari
 */
public class ReportXML extends Report{

    @Override
    protected String getHeader() {
        return "<customer><name>" + customer.getName() + "</name>\n";   
    }
 
    @Override
    protected String getLinia(Rental rental) {
       return "\t<rental><title>" + rental.getMovie().getTitle() + "</title>\t<amount>" + String.valueOf(rental.getAmount()) + "</amount></rental>\r\n";
    }

    @Override
    protected String getFooter() {
        String result = "<owed>" + String.valueOf(customer.getTotalAmount()) + "</owed>\n";
        result += "<points>" + String.valueOf(customer.getTotalRenterPoints()) + "</points>\n</customer>";    
        return result;
    }  
    
    
    @Override
    protected String getStartLines() {
        return "<rentals>\n";
    }

    @Override
    protected String getEndLines() {
        return "</rentals>\n";
    }
    
}
