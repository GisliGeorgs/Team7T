package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import DayTrip.DayTrip;
import Flight.Flight;
import Hotel.Hotel;
import com.main.java.persistence.*;

import java.util.GregorianCalendar;

import com.main.java.form.User;

public class UserinfoTests {
	
	public User uuser;
	/*
    public static void main( String[] args)
    {    	
    	UserinfoTests k = new UserinfoTests();	
    	k.stuff3();
    }
    
    public void stuff1()
    {
    	List<String> origList = new ArrayList<>();
        origList.add("a");
        origList.add("b");
        
    	uuser = new User("meru@meee.isadsfadsbnkf", "hvorugkguuuuuuuuuuu", 150, origList );
    	
    	try {
			uuser.SaveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void stuff2()
    {
    	List<String> origList = new ArrayList<>();
        origList.add("a");
        origList.add("b");
        
    	uuser = new User("meru@meee.is", "hvorugkyh", 100, origList );
    	
    	uuser.LoadUser();
    }
    
    public void stuff3()
    {
		List<String> origList = new ArrayList<>();
        origList.add("a");
        origList.add("b");
        
    	uuser = new User("meru@meee.isadsfadsf", "hvorugkguuuuuuuuuuu", 150, origList );
    	
    	List<Hotel> hoteltest1 = new ArrayList<Hotel>();
		hoteltest1.add(new Hotel( "102", new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), 10000f, new String[]{ "Fun", "Old", "Golf" }  ));
		hoteltest1.add(new Hotel( "102", new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), 10000f, new String[]{ "Fun", "Old", "Golf" }  ));
	    HotelOrder hoe = new HotelOrder(hoteltest1);
    	
    	List<Flight> flighttest1 = new ArrayList<Flight>();
    	flighttest1.add(new Flight());
    	FlightOrder fly = new FlightOrder(flighttest1);
    	
    	List<DayTrip> daytriptest1 = new ArrayList<DayTrip>();
    	daytriptest1.add(new DayTrip());
    	DayTripOrder die = new DayTripOrder(daytriptest1);
    	
		try {
			uuser.SaveOrder("9894AA", die, fly, hoe);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uuser.LoadOrder("9894AA");
		System.out.println("Stuff3: " + uuser.hotelOrder.GetHotel().size());
    }*/
    
}
