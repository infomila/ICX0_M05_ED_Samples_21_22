package refactoring;

/**
 *
 * @author Usuari
 */
public class MovieTypeNewRelease  extends MovieTypePriceCalculator {
    
    public MovieTypeNewRelease(){
        super( MovieType.NEW_RELEASE);
    }

    @Override
    public double getAmount(int daysRented) {
        return daysRented * 3;
    }

}
