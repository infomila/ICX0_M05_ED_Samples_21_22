package org.iesmila.m05.model;

import java.util.ArrayList;
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
    private List<Participacio> participProjectes;

    public Empleat(int id, int numEmpleat, String nom, String cognom1, String cognom2, String NIF, Date dataNaix, String telefon, Adreca adreca) {
        super(id, nom, cognom1, cognom2, NIF, dataNaix, telefon, adreca);
        this.numEmpleat = numEmpleat;
        participProjectes = new ArrayList<>();
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
        return participProjectes.size();
    }

    /**
     *
     * @param index
     */
    public Projecte getProjecte(int index) {
        return participProjectes.get(index).getProjecte();
    }
    
    public Participacio getParticipacioProjecte(int index){
        return participProjectes.get(index);
    }
    

    public List<Projecte> getProjectes() {
        List<Projecte> list = new ArrayList<>();
        for(Participacio p:participProjectes){
            list.add(p.getProjecte());
        }
        return list;
    }

    /**
     *
     * @param nouProjecte
     */
    public void addProjecte(Projecte nouProjecte, String rol) {
        
        // 0.- a pelo
        /*
        for(Participacio p:projectes){
            if(p.getProjecte().equals(nouProjecte)) return;
        }
        // 1.- lambda, versió 1
        projectes.stream().forEach(p -> {if(p.getProjecte().equals(nouProjecte)){return;}});
        
        // 2 .- lambda, versió 2
        if(projectes.stream().
                filter(p ->p.getProjecte().equals(nouProjecte)).findAny().isPresent())
            return;
        */
        //---------------------------------
        if(participProjectes.contains(nouProjecte)) return;
        
        
        if(nouProjecte==null) {throw new RuntimeException("Projecte null!!!");}
        if(rol==null || rol.length()<2) {throw new RuntimeException("Rol null o buit!!!");}
        
    
        Participacio p = new Participacio(rol, this, nouProjecte);
        participProjectes.add(p);
        nouProjecte.addEmpleat(p);

    }
    
    
     void addProjecte(Participacio p) {
        if(participProjectes.contains(p)) return;
        participProjectes.add(p);
     }

    
    /**
     *
     * @param index
     */
    public Projecte removeProjecte(Projecte projDelete) {
        
        if(participProjectes.remove(projDelete)) {
            projDelete.removeEmpleat(this);    
            return projDelete;
        }       
        return null;
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.numEmpleat;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if(obj instanceof Participacio) {
            Participacio p = (Participacio) obj;
            return this.equals(p.getEmpleat());
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleat other = (Empleat) obj;
        if (this.numEmpleat != other.numEmpleat) {
            return false;
        }
        return true;
    }




    
    
    

}
