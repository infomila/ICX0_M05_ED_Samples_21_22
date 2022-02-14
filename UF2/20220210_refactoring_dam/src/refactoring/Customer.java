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

		String result = "Rental Record for " + getName() + "\n";
		for(Rental rental:_rentals) {
			// show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getAmount()) + "\n";
		}		
		// add footer lines
		result += "Amount owed is " + String.valueOf(getOwedAmount()) + "\n";
		result += "You earned " + String.valueOf(getRenterPoints()) + " frequent renter points";		
		return result;
	}

        public double getOwedAmount(){
            double totalAmount = 0;
            for(Rental rental:_rentals) {
                totalAmount += rental.getAmount();
            }
            return totalAmount;
        }
        
        public int getRenterPoints(){
            int points = 0;
            for(Rental rental:_rentals) {
                points += rental.getRenterPoints();
            }
            return points;
        }

}
