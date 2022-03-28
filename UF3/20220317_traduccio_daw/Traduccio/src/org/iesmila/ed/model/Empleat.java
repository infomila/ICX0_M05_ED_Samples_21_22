package org.iesmila.ed.model;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Usuari
 * @version 1.0
 * @created 17-mar�-2022 17:26:08
 */
public class Empleat extends Persona {

	private List<Participacio> projectesOnParticipo;
	public Empleat cap;

        public Empleat(int id, String nom, String cognom, Date dataNaix, String NIF, AdrecaPostal adreca) {
            super(id,  nom,  cognom,  dataNaix,  NIF,  adreca);
        }
        public Empleat(int id, String nom, String cognom, Date dataNaix, String NIF, AdrecaPostal adreca, Empleat cap) {
            super(id,  nom,  cognom,  dataNaix,  NIF,  adreca);
            this.cap = cap;
        }

	public Empleat getCap(){
		return null;
	}

	/**
	 * 
	 * @param nouCap
	 */
	public void setCap(Empleat nouCap){

	}

	public int getNumProjectes(){
		return 0;
	}

	/**
	 * 
	 * @param index
	 */
	public Projecte getProjecte(int index){
		return this.projectesOnParticipo.get(index).getProjecte();
	}

	/**
	 * 
	 * @param nou
	 */
	public void addProjecte(Projecte nou, String rol){
            
            /*for(int i=0;i< projectesOnParticipo.size();i++) {
                if(projectesOnParticipo.get(i).getProjecte().equals(nou)) return;
            }*/
            boolean jaElTinc = projectesOnParticipo.contains(nou);
            if(!jaElTinc) {
                Participacio p = new Participacio(this, nou, rol);
                this.projectesOnParticipo.add(p);
                nou.addParticipant(p);
            }            
	}

	/**
	 * 
	 * @param index
	 */
	public Projecte removeProjecte(Projecte p) {
            
            if(projectesOnParticipo.remove(p)) {        
                p.removeParticipant(this);
            }              
	}

}