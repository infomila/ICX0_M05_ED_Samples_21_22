package org.iesmila.ed.model;

/**
 * @author Usuari
 * @version 1.0
 * @created 17-mar�-2022 17:26:08
 */
public class Tasca {

    private int numero;
    private String descripcio;
    private Projecte projecte; //relació a 1

   public Tasca(String descripcio, Projecte projecte) {
        this.numero = numero;
        this.descripcio = descripcio;
         this.numero =  projecte.getNumeroTasques()+1;
        setProjecte(projecte);
        
    }

    public Projecte getProjecte(){
        return projecte;
    }
    
    public void setProjecte(Projecte nou) {
         if(nou!=this.projecte) { // trenquem la recusivitat
             if(this.projecte!=null )
            {                
                this.projecte.removeTasca(this);
            }

            this.projecte = nou;
             if(nou !=null ) {
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

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
    
}