package org.iesmila.ed.model;

import java.util.Objects;

/**
 *
 * @author Usuari
 */
public class Participacio {
    private Empleat mEmpleat;
    private Projecte mProjecte;
    private String rol;

    public Participacio(Empleat mEmpleat, Projecte mProjecte, String rol) {
        this.mEmpleat = mEmpleat;
        this.mProjecte = mProjecte;
        this.rol = rol;
    }

    public Empleat getEmpleat() {
        return mEmpleat;
    }

    public Projecte getProjecte() {
        return mProjecte;
    }

    public String getRol() {
        return rol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        if(obj instanceof Projecte) {
            return Objects.equals(this.mProjecte, obj);
        }
        if(obj instanceof Empleat) {
            return Objects.equals(this.mEmpleat, obj);
        }
        
        final Participacio other = (Participacio) obj;
        if (!Objects.equals(this.mEmpleat, other.mEmpleat)) {
            return false;
        }
        if (!Objects.equals(this.mProjecte, other.mProjecte)) {
            return false;
        }
        return true;
    }
    
    
    
}
