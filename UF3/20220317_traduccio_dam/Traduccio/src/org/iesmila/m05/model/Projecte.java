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
    private List<Empleat> participants;
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

}
