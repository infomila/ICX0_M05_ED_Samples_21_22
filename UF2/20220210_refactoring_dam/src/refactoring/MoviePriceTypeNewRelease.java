package refactoring;

/**
 *
 * @author Usuari
 */
public class MoviePriceTypeNewRelease extends MoviePriceType {

    public MoviePriceTypeNewRelease(){
        super(MovieType.NEW_RELEASE);
    }
    
    @Override
    public double getAmount(int daysRented) {
        return daysRented * 3;
    }

}
