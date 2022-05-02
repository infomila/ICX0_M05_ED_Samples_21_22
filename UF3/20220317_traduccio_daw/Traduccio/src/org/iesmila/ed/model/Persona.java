package org.iesmila.ed.model;

import java.util.Date;

/**
 * @author Usuari
 * @version 1.0
 * @created 17-mar�-2022 17:26:08
 */
public class Persona {

    private int id;
    private String nom;
    private String cognom;
    private Date dataNaix;
    private String NIF;
    private AdrecaPostal adreca;

    public Persona(int id, String nom, String cognom, Date dataNaix, String NIF, AdrecaPostal adreca) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
        this.dataNaix = dataNaix;
        this.NIF = NIF;
        this.adreca = adreca;
    }



    public AdrecaPostal getAdrecaPostal() {
        return null;
    }

    /**
     *
     * @param nou
     */
    public void setAdrecaPostal(AdrecaPostal nou) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public Date getDataNaix() {
        return dataNaix;
    }

    public void setDataNaix(Date dataNaix) {
        this.dataNaix = dataNaix;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }


    
    

}
