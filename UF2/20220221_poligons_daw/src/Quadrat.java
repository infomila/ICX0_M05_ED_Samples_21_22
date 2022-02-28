
/**
 *
 * @author Usuari
 */
public class Quadrat extends Forma {

    public Quadrat(double mida){
        super(TipusForma.QUADRAT, mida);
    }
    
    @Override
    public double getArea() {
        return this.getMidaCostat()*this.getMidaCostat();
    }

    @Override
    public String getNom() {
        return "Quadrat";
    }

}
