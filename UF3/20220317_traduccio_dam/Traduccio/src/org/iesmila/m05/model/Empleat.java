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
    private List<Participacio> projectes;

    public Empleat(int id, int numEmpleat, String nom, String cognom1, String cognom2, String NIF, Date dataNaix, String telefon, Adreca adreca) {
        super(id, nom, cognom1, cognom2, NIF, dataNaix, telefon, adreca);
        this.numEmpleat = numEmpleat;
        projectes = new ArrayList<>();
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
        return projectes.size();
    }

    /**
     *
     * @param index
     */
    public Projecte getProjecte(int index) {
        return projectes.get(index).getProjecte();
    }

    public List<Projecte> getProjectes() {
        List<Projecte> list = new ArrayList<>();
        for(Participacio p:projectes){
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
        if(projectes.contains(nouProjecte)) return;
        
        Participacio p = new Participacio(rol, this, nouProjecte);
        projectes.add(p);
        nouProjecte.addEmpleat(p);
    }
    
    
     void addProjecte(Participacio p) {
        if(projectes.contains(p)) return;
        projectes.add(p);
     }

    
    /**
     *
     * @param index
     */
    public Projecte removeProjecte(Projecte projDelete) {
        
        if(projectes.remove(projDelete)) {
            projDelete.removeEmpleat(this);            
        }        
    }



}
