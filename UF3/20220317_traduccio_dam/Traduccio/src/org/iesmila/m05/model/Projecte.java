package org.iesmila.m05.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Usuari
 * @version 1.0
 */
public class Projecte {

    private int id;
    private String nom;
    private Empleat cap;
    private List<Participacio> participants;
    private List<Tasca> tasques;

    public Projecte(int id, String nom) {
        this.id = id;
        this.nom = nom;
        tasques = new ArrayList<Tasca>();
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

    public int getNumTasques() {
        return tasques.size();
    }

    /**
     *
     * @param index
     */
    public Tasca getTasca(int index) {
        return tasques.get(index);
    }

    public Iterator<Tasca> getTasques() {
        return tasques.iterator();
    }

    /**
     *
     * @param nova
     */
    public void addTasca(Tasca nova) {
        if (!tasques.contains(nova)) { // trencar la recusivitat
            tasques.add(nova);
            nova.setProjecte(this);
        }
    }

    /**
     *
     * @param index
     */
    public Tasca removeTasca(int index) {
        Tasca t = tasques.get(index);
        removeTasca(t);
        return t;
    }

    public void removeTasca(Tasca aEsborrar) {
        if (tasques.contains(aEsborrar)) {
            tasques.remove(aEsborrar);
            aEsborrar.setProjecte(null);
        }
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
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
            Participacio p = (Participacio)obj;
            return p.getProjecte().equals(this);
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Projecte other = (Projecte) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    //---------------------------
    // mètodes de la relació amb Empleat
    public int getNumeroEmpleats(){
        return participants.size();
    }
    
    public Empleat getEmpleat(int index) {
        return participants.get(index).getEmpleat();
    }

    void addEmpleat(Empleat nouEmpleat, String rol) {
        if(participants.contains(nouEmpleat)) return;
        
        Participacio p = new Participacio(rol, nouEmpleat, this);
        participants.add(p);
        nouEmpleat.addProjecte(p);
    }
    
    void addEmpleat(Participacio p) {

    }

    void removeEmpleat(Empleat aThis) {

    }
    
    

}
