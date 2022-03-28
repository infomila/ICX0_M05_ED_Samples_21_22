package org.iesmila.m05.model;

/**
 * @author Usuari
 * @version 1.0
 */
public class Adreca {

    private String liniaAdreca;
    private char CP;
    private String municipi;
    private String provincia;

    public Adreca(String liniaAdreca, char CP, String municipi, String provincia) {
        this.liniaAdreca = liniaAdreca;
        this.CP = CP;
        this.municipi = municipi;
        this.provincia = provincia;
    }

    public String getLiniaAdreca() {
        return liniaAdreca;
    }

    public void setLiniaAdreca(String liniaAdreca) {
        this.liniaAdreca = liniaAdreca;
    }

    public char getCP() {
        return CP;
    }

    public void setCP(char CP) {
        this.CP = CP;
    }

    public String getMunicipi() {
        return municipi;
    }

    public void setMunicipi(String municipi) {
        this.municipi = municipi;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

}
