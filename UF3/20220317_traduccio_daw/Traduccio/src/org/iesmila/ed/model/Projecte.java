package org.iesmila.ed.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Usuari
 * @version 1.0
 * @created 17-mar�-2022 17:26:08
 */
public class Projecte {

    private int numero;
    private String nom;
    private List<Empleat> participants;
    private Empleat cap_de_projecte;
    private List<Tasca> tasques;

    public Projecte(int numero, String nom) {
        this.numero = numero;
        this.nom = nom;
        tasques = new ArrayList<Tasca>();
    }

    public void setCap(Empleat nouCap) {
        this.cap_de_projecte = nouCap;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Empleat getCap() {
        return cap_de_projecte;
    }
    //-------------------------------------------
    // gestió de la llista de tasques

    public int getNumeroTasques() {
        return tasques.size();
    }

    public Tasca getTasca(int index) {
        return tasques.get(index);
    }

    public Iterator<Tasca> getTasques() {
        return tasques.iterator();
    }

    public void addTasca(Tasca nova) {
        if(!tasques.contains(nova)) {
            tasques.add(nova);
            nova.setProjecte(this);
        }
    }

    public Tasca removeTasca(int index) {
        return tasques.remove(index);
    }
    
    public Tasca removeTasca(Tasca tascaAEsborrar) {
         if(tasques.contains(tascaAEsborrar)){
             tasques.remove(tascaAEsborrar);
            tascaAEsborrar.setProjecte(null);
        }
        return tascaAEsborrar;
    }
}
