package com.main.java.controller;

import com.main.java.persistence.DayTrip;
import com.main.java.persistence.Flight;
import com.main.java.persistence.Hotel;

import java.util.Date;
import java.util.List;

class SearchController{
    public SearchController(){
        
    }
    
    public List<T> GetHistory(){
        
    }

    public List<T> GetRecentHistory( int i ){
        
    }
    public List<Hotel> GetHotelHistory(){
        
    }
    public List<Hotel> GetFlightHistory(){
        
    }
    public List<Hotel> GetDayTripHistory(){
        
    }
    
    public List<Hotel> GetSuggestionsHotel( String loc, String[] keyword, Date dateFrom, Date dateTo ){
        List<Hotel> suggestions = null;/* ????? SearchHotels( loc, dateFrom, dateTo, keywords ) */
        return suggestions;
    }
    public List<DayTrip> GetSuggestionsDayTrip( String loc, Date date, String[] keyword ){
        List<DayTrip> suggestions = null;/* ????? SearchHotels( loc, date, keywords ) */
        return suggestions;
    }

    public List<Hotel> FindHotels( String loc, Date dateFrom, Date dateTo, Float price, String[] keywords ){
        List<Hotel> hotels = null/* ????? SearchHotels( loc, dateFrom, dateTo, price, keywords ) */;
        return hotels;
    }
    
    public List<Flight> FindFlights( String from, String to, Date dateFrom, Date dateTo, Float price ){
        List<Flight> flights = null/* ????? SearchFlights( from, to, dateFrom, dateTo, price ) */;
        return flights;
    }
    
    public List<DayTrip> FindDayTrips( String loc, Date date, Float price, String[] keywords ){
        List<DayTrip> daytrips = null/* ????? SearchDayTrips( loc, date, price, keywords ) */;
        return daytrips;
    }
    
    public List<Hotel> FindCloseHotels( String loc, Float radius ){
        List<Hotel> closeHotels = null;/* ????? HotelDistanceSearch( loc, radius );*/
        return closeHotels;
    }
    
    public List<DayTrip> FindCloseDayTrips( String loc, Float radius ){
        List<DayTrip> closeDayTrips = null;/* ????? DayTripDistanceSerach( loc, radius );*/
        return closeDayTrips;
    }
    
    public List<Flight> FindBetterFlight( String from, String to, Date dateFrom, Date dateTo, Float price ){
        List<Flight> betterFlights = null;/* ????? FlightSearch( from, to, dateFrom, dateTo, price );*/
        return betterFlights;
    }
}