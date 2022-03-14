package org.milaifonanals.ed.model;

/**
 * @author Usuari
 * @version 1.0
 * @created 07-març-2022 19:21:19
 */
public class Persona {

	private int id;
	private String nom;
	private String cognom1;
	private String cognom2;
	private String NIF;
	private Date dataNaix;
	private String telefon;

	public Persona(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param id
	 * @param nom
	 * @param cognom1
	 * @param cognom2
	 * @param NIF
	 * @param dataNaix
	 */
	public Persona(int id, String nom, String cognom1, String cognom2, String NIF, Date dataNaix){

	}

	/**
	 * Retorna el nom complet de la persona.
	 */
	public String getNomComplet(){
		return "";
	}

	public String getDescripcio(){
		return "BLah";
	}

	public String getNom(){
		return nom;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNom(String newVal){
		nom = newVal;
	}

	public String getCognom1(){
		return cognom1;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCognom1(String newVal){
		cognom1 = newVal;
	}

	public String getCognom2(){
		return cognom2;
	}

	public int getId(){
		return id;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCognom2(String newVal){
		cognom2 = newVal;
	}

	public Date getDataNaix(){
		return dataNaix;
	}

	public String getNIF(){
		return NIF;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDataNaix(Date newVal){
		dataNaix = newVal;
	}

	public String getTelefon(){
		return telefon;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTelefon(String newVal){
		telefon = newVal;
	}

}