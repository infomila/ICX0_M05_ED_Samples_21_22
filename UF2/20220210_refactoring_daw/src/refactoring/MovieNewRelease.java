package refactoring;

/**
 *
 * @author Usuari
 */
public class MovieNewRelease extends Movie {
    
    public MovieNewRelease(String title){
        super(title, MovieType.NEW_RELEASE);
    }

    @Override
    public double getAmount(int daysRented) {
        return daysRented * 3;
    }

}
