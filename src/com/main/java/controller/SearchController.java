package com.main.java.controller;

import com.main.java.persistence.DayTrip;
import com.main.java.persistence.Flight;
import com.main.java.persistence.Hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchController{
	static List<Hotel> hoteltest1;
	public SearchController(){
		
    }

    public static List<Hotel> GetHotelHistory( int i ){
    	hoteltest1 = new ArrayList<Hotel>();
		hoteltest1.add(new Hotel());
		hoteltest1.add(new Hotel());
		hoteltest1.add(new Hotel());
        return hoteltest1;
    }
    public static List<Flight> GetFlightHistory( int i ){
        return null;
    }
    public List<DayTrip> GetDayTripHistory( int i ){
        return null;
    }
    
    public static List<Hotel> GetSuggestionsHotel( Date dateFrom, Date dateTo, String loc ){
        List<Hotel> suggestions = null;/* ????? SearchHotels( loc, dateFrom, dateTo, keywords ) */
        return suggestions;
    }

    public static List<Hotel> GetSuggestionsHotel( Date dateFrom, Date dateTo, String loc, Float price){
        List<Hotel> suggestions = null;/* ????? SearchHotels( loc, dateFrom, dateTo, keywords ) */
        return suggestions;
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