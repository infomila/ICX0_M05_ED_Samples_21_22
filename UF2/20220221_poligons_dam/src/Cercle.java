/**
 *
 * @author Usuari
 */
public class Cercle extends Forma {

    public Cercle(double mida){
        super(TipusForma.CERCLE, mida);
    }
    
    @Override
    public double getArea() {
        return  Math.PI * getMidaCostat() * getMidaCostat();
    }

    @Override
    public String getNom() {
        return "Cercle";
    }
    
}
