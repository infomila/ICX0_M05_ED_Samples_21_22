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
        return getMidaCostat() * getMidaCostat() / 2.0;
    }

    @Override
    public String getNom() {
        return "Triangle";
    }
    
}
