
package refactoring.reporting;

import refactoring.Customer;
import refactoring.Rental;

/**
 *
 * @author Usuari
 */
public abstract class Report {
    
    protected Customer customer;
    
    public enum TipusReport {
        TEXT,XML,HTML
    }
    
    public static Report getReport(TipusReport tip, Customer c){
        switch(tip) {
            case HTML: return new ReportHTML(c);
            case XML: return new ReportXML(c);
            case TEXT: return new ReportText(c);
        }
        return null;
    }
    
    
    public Report(Customer c) {
        this.customer = c;
    }
    
    public String getReport(){
        
        String result = getBeginDocument();
        result += getHeader();
        result += startLines();
        for(Rental rental:customer.getRentals()) {
            result += getLinia(rental);
        }
        result += endLines();
        result += getFooter();
        result += getEndDocument();
        return result;        
    }

    protected abstract String getBeginDocument();
    protected abstract String getHeader();

    protected abstract String startLines();
    protected abstract String getLinia(Rental rental);
    protected abstract String endLines();
    
    protected abstract String getFooter();
    protected abstract String getEndDocument();
         
}
