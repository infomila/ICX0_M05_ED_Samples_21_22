
package comunicacions;

/**
 *
 * @author bernat
 */
public class MissatgerFake implements IMissatger{

    @Override
    public void enviarEmail(String adresa, String subject, String missatge) throws Exception {
        System.out.println("Estic fent veure que envio un correu.");
    }
    
}
