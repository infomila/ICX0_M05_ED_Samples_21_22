package refactoring;

// From book: 'Refactoring' by Martin Fowler
// This is the original code before refactoring begins
public abstract class Movie {

    private String _title;
    private MovieType _priceCode;

    public Movie(String title, MovieType priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public MovieType getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(MovieType arg) {
        _priceCode = arg;
    }

    public String getTitle() {
        return _title;
    }
    public abstract double getAmount(int daysRented);
    
    /*
    double getAmount(int daysRented) {

        double rentalAmount = 0;
        //determine amounts for each line
        switch (this.getPriceCode()) {
            case REGULAR:
                rentalAmount += 2;
                if (daysRented > 2) {
                    rentalAmount += (daysRented - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                rentalAmount += daysRented * 3;
                break;
            case CHILDRENS:
                rentalAmount += 1.5;
                if (daysRented > 3) {
                    rentalAmount += (daysRented - 3) * 1.5;
                }
                break;
        }
        return rentalAmount;
    }*/

}
