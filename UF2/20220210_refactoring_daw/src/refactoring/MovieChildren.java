package refactoring;

/**
 *
 * @author Usuari
 */
public class MovieChildren extends Movie {

    public MovieChildren(String title) {
        super(title, MovieType.CHILDRENS);
    }

    @Override
    public double getAmount(int daysRented) {
        double rentalAmount = 1.5;
        if (daysRented > 3) {
            rentalAmount += (daysRented - 3) * 1.5;
        }
        return rentalAmount;
    }

}
