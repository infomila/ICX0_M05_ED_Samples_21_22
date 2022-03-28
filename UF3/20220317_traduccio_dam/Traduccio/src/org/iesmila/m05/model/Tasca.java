package org.iesmila.m05.model;

/**
 * @author Usuari
 * @version 1.0
 */
public class Tasca {

    private int numero;
    private String desc;
    private Projecte projecte;

    public Tasca( String desc, Projecte projecte) {
        this.numero = projecte.getNumTasques()+1;
        this.desc = desc;
        setProjecte(projecte);
    }

    public Projecte getProjecte() {
        return projecte;
    }

    /**
     *
     * @param p
     */
    public void setProjecte(Projecte p) {
 
        if(this.projecte!=p) { // trenquem la recursivitat 
            if(projecte!=null) {
                projecte.removeTasca(this);
            }
            this.projecte = p;

            if(this.projecte!=null){
                this.projecte.addTasca(this);
            }
        }        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    

}
