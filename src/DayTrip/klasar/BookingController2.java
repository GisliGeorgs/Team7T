package DayTrip.klasar;

import java.util.Date;
import java.util.Random;

import DayTrip.look.Booking;

public class BookingController2 {
	private int bookingNumber;
	private DatabaseConnection connection;
	private Booking bookingView;
	private int groupSize;
	
	public BookingController2() {
		Random rand = new Random();
		bookingNumber = rand.nextInt(Integer.MAX_VALUE - 100000) + 1;
		connection = new DatabaseConnection();
		bookingView = new Booking();
	}
	
	public int book(Trip trip, String email, int numPeople) {
		if(trip==null) throw new IllegalArgumentException("Vantar trip");
		Date[] tripDates = trip.getDate();
		int tripID = connection.getTripID(trip.getDayTrip(), tripDates[0]);
		//Tourist tourist = getTourist();
		int i = 0;
		//boolean res = connection.book(tripID, email, bookingNumber, numPeople);
		while(!connection.book(tripID, email, bookingNumber, numPeople)){
			if( i < 3 ){
				System.out.println("Booking failed!");	
				i++;
			}
			else{
				break;
			}
		}
		return bookingNumber++;
		/*if( res ) return bookingNumber;
		else return -1;*/
		
	}
	
	public Tourist getTourist() {
		//bookingView.setVisible(true);
		String touristEmail = bookingView.getInputEmail();
		String touristName = bookingView.getInputName();
		String touristCountry = bookingView.getInputCountry();
		int touristAge = bookingView.getInputAge();
		groupSize = bookingView.getInputGroupSize();
		if(touristEmail.contains("@")) {
			Tourist tourist = new Tourist(touristName, touristEmail, touristCountry, touristAge);
			if(connection.findTourist(touristEmail)) return connection.getTourist(touristEmail);
			else {
				while(!connection.addTourist(touristName, touristEmail, touristCountry, touristAge))
					System.out.println("Tourist not added");
				return tourist;			
			}
		}
		else {
			System.out.println("Ekki lï¿½glegt veffang, kv gunnsteinn");
			return null;
		}
	}
	
	/**
	 * Nær í bókanir miðað viðeigandi bókunarnúmer.
	 * 
	 * @param currentBooking bókunarnúmer sem á að finna
	 * @return Object fylki þar sem fyrra stakið er viðeigandi Trip og það seinna er Tourist.
	 */
	public Object[] getBooking(int currentBooking) {
		if(currentBooking < 0) return null;
		
		Object[] info = connection.getBooking(currentBooking);
		System.out.println(info.length);
		return info;
	}
	
	public static void main(String[] args) {
		BookingController2 b = new BookingController2();
		b.getTourist();
	}
}
