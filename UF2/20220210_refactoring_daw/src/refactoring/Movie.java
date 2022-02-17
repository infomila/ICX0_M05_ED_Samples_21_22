package refactoring;

// From book: 'Refactoring' by Martin Fowler
// This is the original code before refactoring begins
public class Movie {

    private String _title;
    //private MovieType _priceCode;
    private MovieTypePriceCalculator priceCalculator; 

    public Movie(String title, MovieType priceCode) {
        _title = title;
        setPriceCode( priceCode );
    }

    public MovieType getPriceCode() {
        return priceCalculator.getPriceCode();
    }

    public void setPriceCode(MovieType priceCode) {
        switch(priceCode) {
            case REGULAR: priceCalculator = new MovieTypeRegular();break;
            case CHILDRENS: priceCalculator = new MovieTypeChildren();break;
            case NEW_RELEASE: priceCalculator = new MovieTypeNewRelease();break;
        }
    }

    public String getTitle() {
        return _title;
    }
    public double getAmount(int daysRented){
        return priceCalculator.getAmount(daysRented);
    }
    
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
