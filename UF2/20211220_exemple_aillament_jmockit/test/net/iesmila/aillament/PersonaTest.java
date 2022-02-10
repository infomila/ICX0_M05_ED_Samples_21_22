package net.iesmila.aillament;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Verifications;
import net.iesmila.aillament.EmailManager;
import net.iesmila.aillament.Persona;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class PersonaTest {

    public PersonaTest() {
    }

    @Test
    public void testGetNom() {
    }

    @Test
    public void testGetCognom() {
    }

    @Test
    public void testGetNIF() {
    }

    @Mocked
    EmailManager elMeuManager;

    @Test
    public void testEnviarEmail() {

        // Bloc d'Expectations: �s un bloc de codi on enregistrem les respostes que han de donar els m�todes falsificats al test.
        new NonStrictExpectations() {
            {

                //------------------------------------------------------------------------------------
                // Sistema A): precarregar les respostes segons els par�metres
                /*
                elMeuManager.sendEmail(anyString, "ERROR", anyString);result=false;
                elMeuManager.sendEmail(anyString, anyString, anyString);result=true;

                elMeuManager.verifyEmail("EMAIL@NO_EXISTENT.COM"); result=false;
                elMeuManager.verifyEmail(anyString); result = true;
                 */
                //------------------------------------------------------------------------------------
                // Sistema B): precarregar les respostes per ordre esperat d'execuci�.
                /*
                elMeuManager.sendEmail(anyString, anyString, anyString);  returns(true, false, true);
                elMeuManager.verifyEmail(anyString); returns(true, true, false);
                 */
            }
        };
        //-------------------------------------------------------------
        // Fake API: falsificar directament els m�todes de la classe
        new MockUp<EmailManager>() {

            @Mock
            public boolean sendEmail(String email, String subject, String body) {
                System.out.println("Estic enviant un correu FALS");
                return !subject.equals("ERROR");
            }
            
            @Mock
            public boolean verifyEmail(String email) {
                System.out.println("Estic verificant un correu FALS.");
                
                if(email.equals("EMAIL@NO_EXISTENT.COM")) return false;
                
                return true;
            }
        };

        //-------------------------------------------------------------
        //-----------------------------------------------------------------------
        // normal ( email enviat amb �xit)
        //-----------------------------------------------------------------------
        Persona p = new Persona("Paco", "Pil", "1111111H", "pordios@nolohagas.com");

        boolean resultat = p.enviarEmail("Hola!", "Aix� �s un missatge");
        assertEquals(true, resultat);
        assertEquals(1, p.getEmailsEnviats());
        //-----------------------------------------------------------------------

        //-----------------------------------------------------------------------
        // Prova un cas de transmissi� incorrecta
        //-----------------------------------------------------------------------
        resultat = p.enviarEmail("ERROR", "ARA VOLEM SIMULAR UN ERROR DE TRANSMISSI�");
        assertEquals(false, resultat);
        assertEquals(1, p.getEmailsEnviats());

        //-----------------------------------------------------------------------
        // Prova un cas d'email erroni.
        //-----------------------------------------------------------------------
        Persona p2 = new Persona("Paco", "Pil", "1111111H", "EMAIL@NO_EXISTENT.COM");
        try {
            resultat = p2.enviarEmail("Hola!", "Aix� �s un missatge");
            fail("els emails erronis han de petar");
        } catch (Exception ex) {
            // passar per aqu� �s el normal
        }
        assertEquals(0, p2.getEmailsEnviats());

    }

}
