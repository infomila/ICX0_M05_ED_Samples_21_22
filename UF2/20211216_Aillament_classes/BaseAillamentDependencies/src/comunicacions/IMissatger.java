package comunicacions;

/**
 *
 * @author bernat
 */
public interface IMissatger {

    void enviarEmail(String adresa, String subject, String missatge) throws Exception;
    
}
