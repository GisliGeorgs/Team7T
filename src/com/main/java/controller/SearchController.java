package com.main.java.controller;

import com.main.java.persistence.DayTrip;
import com.main.java.persistence.Flight;
import com.main.java.persistence.Hotel;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SearchController{
	static List<Hotel> hoteltest1;
	static List<Flight> flighttest1;
	public SearchController(){
		
    }
	/**
	 * B�r til test hotelin sem eru notu� � testum.
	 */
	public static void/*List<Hotel>*/ TestHotels(){
		hoteltest1 = new ArrayList<Hotel>();
		
		hoteltest1.add(new Hotel( "102", new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), 10000f, new String[]{ "Fun", "Old", "Golf" }  ));
		hoteltest1.add(new Hotel( "108", new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), 20000f, new String[]{ "Fun", "Young", "Hip" }  ));
		hoteltest1.add(new Hotel( "109", new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), 25000f, new String[]{ "Relaxing", "Adventure", "Golf" }  ));
		hoteltest1.add(new Hotel( "108", new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), 11000f, new String[]{ "Extreme", "Boring", "Beachy" }  ));
		hoteltest1.add(new Hotel( "102", new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), 10000f, new String[]{ "Free Wifi", "Adventure", "Tennis" }  ));
		hoteltest1.add(new Hotel( "203", new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), 12200f, new String[]{ "Kids", "Drinking", "Relaxing" }  ));
		hoteltest1.add(new Hotel( "102", new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), 11100f, new String[]{ "Kids", "Beach", "Spa" }  ));
		hoteltest1.add(new Hotel( "109", new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), 100000f, new String[]{ "Bar", "Old", "Party" }  ));
        
	}

    public static List<Hotel> GetHotelHistory( int i ){
    	return hoteltest1	;
    }
    public static List<Flight> GetFlightHistory( int i ){
        return null;
    }
    public List<DayTrip> GetDayTripHistory( int i ){
        return null;
    }
    
    public static List<Hotel> GetSuggestionsHotel( Calendar dateFrom, Calendar dateTo, String loc ){
    	List<Hotel> ret = new ArrayList<Hotel>();
    	for( int i = 0; i < hoteltest1.size(); i++ ){
    		Hotel hotel = hoteltest1.get(i);
    		int from = hotel.getDateFrom().compareTo(dateFrom);;
    		int to = hotel.getDateTo().compareTo(dateTo);
    		int location = hotel.getLocation().compareTo(loc);
    		if( from == 0 && to == 0 && location == 0 ){
    			ret.add(hotel);
    		}
    	}
    	return ret;
    }

    public static List<Hotel> GetSuggestionsHotel( Calendar dateFrom, Calendar dateTo, String loc, Float price){
    	List<Hotel> ret = new ArrayList<Hotel>();
    	for( int i = 0; i < hoteltest1.size(); i++ ){
    		Hotel hotel = hoteltest1.get(i);
    		int from = hotel.getDateFrom().compareTo(dateFrom);;
    		int to = hotel.getDateTo().compareTo(dateTo);
    		int location = hotel.getLocation().compareTo(loc);
    		float cost = hotel.getPrice();
    		if( from == 0 && to == 0 && location == 0 && cost <= price){
    			ret.add(hotel);
    		}
    	}
    	return ret;
    }

    public static List<Hotel> GetSuggestionsHotel(  Date dateFrom, Date dateTo, String loc, Float price, String[] keywords  ){
        List<Hotel> suggestions = null;/* ????? SearchHotels( loc, dateFrom, dateTo, keywords ) */
        return suggestions;
    }

    public static List<Hotel> GetSuggestionsHotel(  Date dateFrom, Date dateTo, String loc, String[] keywords  ){
        List<Hotel> suggestions = null;/* ????? SearchHotels( loc, dateFrom, dateTo, keywords ) */
        return suggestions;
    }
    public static List<DayTrip> GetSuggestionsDayTrip( String loc, Date date, String[] keywords ){
        List<DayTrip> suggestions = null;/* ????? SearchHotels( loc, date, keywords ) */
        return suggestions;
    }

    public static List<Hotel> FindHotels( String loc, Date dateFrom, Date dateTo, Float price, String[] keywords ){
        List<Hotel> hotels = null/* ????? SearchHotels( loc, dateFrom, dateTo, price, keywords ) */;
        return hotels;
    }
    
    public static List<Flight> FindFlights( String from, String to, Date dateFrom, Date dateTo, Float price ){
        List<Flight> flights = null/* ????? SearchFlights( from, to, dateFrom, dateTo, price ) */;
        return flights;
    }
    
    public static List<DayTrip> FindDayTrips( String loc, Date date, Float price, String[] keywords ){
        List<DayTrip> daytrips = null/* ????? SearchDayTrips( loc, date, price, keywords ) */;
        return daytrips;
    }
    
    public static List<Hotel> FindCloseHotels( String loc, Float radius ){
        List<Hotel> closeHotels = null;/* ????? HotelDistanceSearch( loc, radius );*/
        return closeHotels;
    }
    
    public static List<DayTrip> FindCloseDayTrips( String loc, Float radius ){
        List<DayTrip> closeDayTrips = null;/* ????? DayTripDistanceSerach( loc, radius );*/
        return closeDayTrips;	
    }	
    
    public static List<Flight> FindBetterFlight( Flight flight ){
        List<Flight> betterFlightsUp = null;/* ????? FlightSearch( from, to, dateFrom-2, dateTo-2, price );*/
        List<Flight> betterFlightsDown = null;/* ????? FlightSearch( from, to, dateFrom+2, dateTo+2, price );*/
        List<Flight>  betterFlights = betterFlightsUp;
        betterFlights.addAll( betterFlightsDown );
        return betterFlights;
    }
}