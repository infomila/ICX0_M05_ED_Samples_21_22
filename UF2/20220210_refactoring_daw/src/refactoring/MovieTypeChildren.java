package refactoring;

/**
 *
 * @author Usuari
 */
public class MovieTypeChildren extends MovieTypePriceCalculator {

    public MovieTypeChildren() {
        super(MovieType.CHILDRENS);
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
