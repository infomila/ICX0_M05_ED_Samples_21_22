package org.iesmila.m05.model;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Usuari
 * @version 1.0
 */
public class Empleat extends Persona {

    private int numEmpleat;
    private Empleat cap;
    private List<Projecte> elsMeusProjectes;

    public Empleat(int id, int numEmpleat, String nom, String cognom1, String cognom2, String NIF, Date dataNaix, String telefon, Adreca adreca) {
        super(id, nom, cognom1, cognom2, NIF, dataNaix, telefon, adreca);
        this.numEmpleat = numEmpleat;
    }

    public Empleat getCap() {
        return null;
    }

    /**
     *
     * @param nouCap
     */
    public void setCap(Empleat nouCap) {

    }

    public int getNumProjectes() {
        return 0;
    }

    /**
     *
     * @param index
     */
    public Projecte getProjecte(int index) {
        return null;
    }

    public Iterator<Projecte> getProjectes() {
        return null;
    }

    /**
     *
     * @param index
     */
    public Projecte removeProjecte(int index) {
        return null;
    }

    /**
     *
     * @param nouProjecte
     */
    public void addProjecte(Projecte nouProjecte) {

    }

}
