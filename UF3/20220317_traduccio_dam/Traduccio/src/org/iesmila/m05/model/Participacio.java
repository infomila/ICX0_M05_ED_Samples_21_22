package org.iesmila.m05.model;

/**
 * @author Usuari
 * @version 1.0
 */
public class Participacio {

    private String rol;
    private Empleat empleat;
    private Projecte projecte;

    public Participacio(String rol, Empleat empleat, Projecte projecte) {
        this.rol = rol;
        this.empleat = empleat;
        this.projecte = projecte;
    }

    public String getRol() {
        return rol;
    }

    public Empleat getEmpleat() {
        return empleat;
    }

    public Projecte getProjecte() {
        return projecte;
    }

    
}
