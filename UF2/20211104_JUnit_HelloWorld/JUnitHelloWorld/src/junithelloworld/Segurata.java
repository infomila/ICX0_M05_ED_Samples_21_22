package junithelloworld;

/**
 *
 * @author Usuari
 */
public class Segurata {
    
    
    public boolean pucEntrar(int edat, boolean colegui){
        if(edat>=18) {
            return true;
        } else {
            return colegui;
        }
    }
}
