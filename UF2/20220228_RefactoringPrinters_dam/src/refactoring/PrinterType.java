package refactoring;

/**
 *
 * @author Usuari
 */
public enum PrinterType {
    HP_LASERJET_VII("HP Laserjet VII") ,
    HP_OFFICEJET_5("HP Office 5"),
    RENTING_LASER_JET("Renting");
    
    String nom;
    PrinterType(String nom)
    {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    
}
