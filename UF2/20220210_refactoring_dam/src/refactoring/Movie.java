package refactoring;

// From book: 'Refactoring' by Martin Fowler
// This is the original code before refactoring begins
public class Movie {

    private String _title;
    //private MovieType _priceCode;
    private MoviePriceType _priceType;

    public Movie(String title, MovieType priceCode) {
        _title = title;
        setPriceCode(priceCode);
        
    }

    public MovieType getPriceCode() {
        return _priceType.getType();
    }

    public void setPriceCode(MovieType priceCode) {
        switch(priceCode) {
            case CHILDRENS: _priceType = new MoviePriceTypeChildren(); break;
            case NEW_RELEASE:  _priceType = new MoviePriceTypeNewRelease();break;
            case REGULAR:  _priceType = new MoviePriceTypeRegular();break;
        }
    }

    public String getTitle() {
        return _title;
    }

    public double getAmount(int daysRented){
        return _priceType.getAmount(daysRented);
    }
    
    /*
    double getAmount(int daysRented) {

        double rentalAmount = 0;
        //determine amounts for each line
        switch (this.getPriceCode()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (daysRented > 2) {
                    rentalAmount += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                rentalAmount += 1.5;
                if (daysRented > 3) {
                    rentalAmount += (daysRented - 3) * 1.5;
                }
                break;
        }
        return rentalAmount;
    }*/

}
