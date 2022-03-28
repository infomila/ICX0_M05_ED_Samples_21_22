package org.iesmila.m05.model;

import java.util.Date;

/**
 * @author Usuari
 * @version 1.0
 */
public class Persona {

    private int id;
    private String nom;
    private String cognom1;
    private String cognom2;
    private String NIF;
    private Date dataNaix;
    private String telefon;
    private Adreca adreca;

    public Persona(int id, String nom, String cognom1, String cognom2, String NIF, Date dataNaix, String telefon, Adreca adreca) {
        this.id = id;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.NIF = NIF;
        this.dataNaix = dataNaix;
        this.telefon = telefon;
        this.adreca = adreca;
    }

    /**
     *
     * @param id
     * @param nom
     * @param cognom1
     * @param cognom2
     * @param NIF
     * @param dataNaix dataNaix
     */
    public Persona(int id, String nom, String cognom1, String cognom2, String NIF, Date dataNaix) {

    }

    /**
     *
     * @exception Throwable
     */
    public void finalize()
            throws Throwable {

    }

    /**
     * Retorna el nom complet de la persona.
     */
    public String getNomComplet() {
        return "";
    }

    public String getDescripcio() {
        return "";
    }

    public String getNom() {
        return nom;
    }

    /**
     *
     * @param newVal newVal
     */
    public void setNom(String newVal) {
        nom = newVal;
    }

    public String getCognom1() {
        return cognom1;
    }

    /**
     *
     * @param newVal newVal
     */
    public void setCognom1(String newVal) {
        cognom1 = newVal;
    }

    public String getCognom2() {
        return cognom2;
    }

    public int getId() {
        return id;
    }

    /**
     *
     * @param newVal newVal
     */
    public void setCognom2(String newVal) {
        cognom2 = newVal;
    }

    public Date getDataNaix() {
        return dataNaix;
    }

    public String getNIF() {
        return NIF;
    }

    /**
     *
     * @param newVal newVal
     */
    public void setDataNaix(Date newVal) {
        dataNaix = newVal;
    }

    public String getTelefon() {
        return telefon;
    }

    /**
     *
     * @param newVal newVal
     */
    public void setTelefon(String newVal) {
        telefon = newVal;
    }

    public Adreca getAdreca() {
        return null;
    }

    /**
     *
     * @param nova
     */
    public void setAdreca(Adreca nova) {

    }

}
