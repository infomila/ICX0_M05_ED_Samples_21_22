package net.iesmila.aillament;

/**
 *
 * @author BERNAT
 */
public class Persona {

    private int emailsEnviats = 0;
    public boolean enviarEmail(String subject, String body) {
        EmailManager em = new EmailManager(); // aquesta és la classe de que m'he d'aïllar. 
        if (em.verifyEmail(this.email)) {
            boolean success = em.sendEmail(email, subject, body);
            if(success) {emailsEnviats++;}
            return success;
        }
        throw new RuntimeException("invalid email");
    }

    private String nom, cognom, NIF, email;

    public Persona(String nom, String cognom, String NIF, String email) {
        this.nom = nom;
        this.cognom = cognom;
        this.NIF = NIF;
        this.email = email;
    }

    
    public int getEmailsEnviats(){
        return emailsEnviats;
    }
    
    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getNIF() {
        return NIF;
    }

    public String getEmail() {
        return email;
    }

}
