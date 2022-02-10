package refactoring;


import java.util.Iterator;
import java.util.LinkedList;

//From book: 'Refactoring' by Martin Fowler
//This is the original code before refactoring begins

public class Customer {

	private String _name;
	private LinkedList<Rental> _rentals = new LinkedList<Rental>();
	
	public Customer(String name) {
		_name = name;
	}
	
	public void addRental(Rental arg) {
		_rentals.add(arg);
	}
	
	public String getName() {
		return _name;
	}
	
	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		//Iterator<Rental> rentals = _rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";
		for(Rental rental:_rentals) {
			double rentalAmount = 0;
			Movie movie = rental.getMovie();
                        rentalAmount = rental.getAmount();// getRentalAmount(rental);
                        frequentRenterPoints += rental.getRenterPoints();
			// show figures for this rental
			result += "\t" + movie.getTitle() + "\t" + String.valueOf(rentalAmount) + "\n";
			totalAmount += rentalAmount;
		}
		
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		
		return result;
	}


}
