package DayTrip.klasar;

import java.util.Date;

import DayTrip.look.Booking;

public class BookingController2 {
	private int bookingNumber;
	private DatabaseConnection connection;
	private Booking bookingView;
	private int groupSize;
	
	public BookingController2() {
		bookingNumber = 0;
		connection = new DatabaseConnection();
		bookingView = new Booking();
	}
	
	public int book(Trip trip, String email, int numPeople) {
		if(trip==null) throw new IllegalArgumentException("Vantar trip");
		Date[] tripDates = trip.getDate();
		int tripID = connection.getTripID(trip.getDayTrip(), tripDates[0]);
		//Tourist tourist = getTourist();
		while(!connection.book(tripID, email, bookingNumber, numPeople))
			System.out.println("Booking failed!");
		System.out.println(bookingNumber);
		return bookingNumber++;
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
			System.out.println("Ekki l�glegt veffang, kv gunnsteinn");
			return null;
		}
	}
	
	public static void main(String[] args) {
		BookingController2 b = new BookingController2();
		b.getTourist();
	}
}
