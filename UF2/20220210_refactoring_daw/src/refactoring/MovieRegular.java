package refactoring;

/**
 *
 * @author Usuari
 */
public class MovieRegular extends Movie {
    
    public MovieRegular(String title){
        super(title, MovieType.REGULAR);
    }

    @Override
    public double getAmount(int daysRented) {
        double rentalAmount = 2;
        if (daysRented > 2) {
            rentalAmount += (daysRented - 2) * 1.5;
        }
        return rentalAmount;
    }

}
