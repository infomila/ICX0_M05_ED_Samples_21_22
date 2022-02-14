package refactoring;

/**
 *
 * @author Usuari
 */
public abstract class MoviePriceType {

    private MovieType type;

    public MoviePriceType(MovieType type) {
        this.type = type;
    }

    public MovieType getType() {
        return type;
    }

    public abstract double getAmount(int daysRented);
}
