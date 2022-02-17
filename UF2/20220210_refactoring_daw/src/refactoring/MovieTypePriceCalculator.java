
package refactoring;

/**
 *
 * @author Usuari
 */
public abstract class MovieTypePriceCalculator {
    private MovieType _priceCode;

    public MovieType getPriceCode() {
        return _priceCode;
    }

    public MovieTypePriceCalculator(MovieType _priceCode) {
        this._priceCode = _priceCode;
    }
    public abstract double getAmount(int daysRented);
}
