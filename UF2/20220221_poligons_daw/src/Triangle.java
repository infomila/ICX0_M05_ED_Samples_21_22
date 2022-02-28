
/**
 *
 * @author Usuari
 */
public class Triangle extends Forma {

    public Triangle(double mida){
        super(TipusForma.TRIANGLE_RECTANGLE_ISOSCELES, mida);
    }
    
    @Override
    public double getArea() {
        return this.getMidaCostat()*this.getMidaCostat()/2;
    }

    @Override
    public String getNom() {
        return "Triangle";
    }

}
