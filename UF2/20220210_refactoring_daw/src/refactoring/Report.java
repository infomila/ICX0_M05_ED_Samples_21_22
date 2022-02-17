
package refactoring;
import java.util.Iterator;
        
/**
 *
 * @author Usuari
 */
public abstract class Report {
    
    public enum TipusReport {
        TEXT, XML
    }
    
    public static Report getReport(TipusReport t) {
        switch(t){
            case TEXT: return new ReportText();
            case XML: return new ReportXML();
        }
        return null;
    }
    
    Customer customer;
    public String getReport(Customer c){
        this.customer = c;
        
        String report = getHeader();
        Iterator<Rental> it = c.getRentals();
        report += getStartLines();
        while(it.hasNext()){
            Rental r = it.next();
            report += getLinia(r);                
        }
        report += getEndLines();
        report += getFooter();
        return report;
    }

    protected abstract String getHeader() ;
    protected abstract String getStartLines();
    protected abstract  String getLinia(Rental r);
    protected abstract String getEndLines();
    protected abstract  String getFooter();
    
}
