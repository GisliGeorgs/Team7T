package com.main.java.controller;

import com.main.java.persistence.DayTrip;
import com.main.java.persistence.Flight;
import com.main.java.persistence.Hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class SearchController{

	public SearchController(){
		
    }

    // TODO ?????
    public static ArrayList<Hotel> GetHotelHistory( int i ){ return null; }
    public static ArrayList<Flight> GetFlightHistory( int i ){
        return null;
    }
    public ArrayList<DayTrip> GetDayTripHistory( int i ){
        return null;
    }

    //region Hótel leit
    // TODO Pointless eins og er, allar staðsetningar eru strengir.
    public static ArrayList<Hotel> FindCloseHotels( String loc, Float radius ){
        ArrayList<Hotel> closeHotels = null;/* ????? HotelDistanceSearch( loc, radius );*/
        return closeHotels;
    }
    // TODO pointless?
    public static ArrayList<Hotel> FindHotels( String loc, GregorianCalendar dateFrom, GregorianCalendar dateTo, Float price, String[] keywords ){
        ArrayList<Hotel> hotels = null/* ????? SearchHotels( loc, dateFrom, dateTo, price, keywords ) */;
        return hotels;
    }

    public static ArrayList<Hotel> GetSuggestionsHotel( GregorianCalendar dateFrom, GregorianCalendar dateTo, int numPeople, String loc ){
        Hotel[] resArr = HotelController.findHotelWithAvailableRooms( dateFrom, dateTo, numPeople, loc, 0, 1000000 );
        ArrayList<Hotel> res = new ArrayList<Hotel>(Arrays.asList( resArr ) );
    	return res;
    }

    public static ArrayList<Hotel> GetSuggestionsHotel( GregorianCalendar dateFrom, GregorianCalendar dateTo, int numPeople, String loc, Float price){
        Hotel[] resArr = HotelController.findHotelWithAvailableRooms( dateFrom, dateTo, numPeople, loc, 0, price );
        ArrayList<Hotel> res = new ArrayList<Hotel>( Arrays.asList( resArr ) );
        return res;
    }

    public static ArrayList<Hotel> GetSuggestionsHotel( GregorianCalendar dateFrom, GregorianCalendar dateTo, int numPeople, String loc, Float price, String[] keywords  ){
        // Ná í hótel frá hotel component
        Hotel[] resArr = HotelController.findHotelWithAvailableRooms( dateFrom, dateTo, numPeople, loc, 0, price );
        // Búa til lista úr þeim
        ArrayList<Hotel> mid = new ArrayList<Hotel>(Arrays.asList( resArr ) );
        // Niðurstöðu listi því
        ArrayList<Hotel> res = new ArrayList<Hotel>();
        // Við þurfum að leita að keywords í lýsingu, nafni, tags, ... í hverju hóteli
        for( int i = 0; i < res.size(); i++ ){
            for( int j = 0; j < keywords.length; j++ ){
                if( res.get(i).getName().contains( keywords[i] )){
                    res.add( res.get(i) );
                }
                else if( res.get(i).getDescription().contains( keywords[j] )){
                    res.add( res.get(i) );
                }
                else if( Arrays.asList( res.get(i).getTags() ).contains( keywords[j] ) ){
                    res.add( res.get( i ) );
                }

            }
        }
        return res;
    }

    public static ArrayList<Hotel> GetSuggestionsHotel( GregorianCalendar dateFrom, GregorianCalendar dateTo, int numPeople, String loc, String[] keywords  ){
        // Ná í hótel frá hotel component
        Hotel[] resArr = HotelController.findHotelWithAvailableRooms( dateFrom, dateTo, numPeople, loc, 0, 1000000 );
        // Búa til lista úr þeim
        ArrayList<Hotel> mid = new ArrayList<>(Arrays.asList( resArr ) );
        // Niðurstöðu listi því
        ArrayList<Hotel> res = new ArrayList<>();
        // Við þurfum að leita að keywords í lýsingu, nafni, tags, ... í hverju hóteli
        for( int i = 0; i < res.size(); i++ ){
            for( int j = 0; j < keywords.length; j++ ){
                if( res.get(i).getName().contains( keywords[i] )){
                    res.add( res.get(i) );
                }
                else if( res.get(i).getDescription().contains( keywords[j] )){
                    res.add( res.get(i) );
                }
                else if( Arrays.asList( res.get(i).getTags()).contains( keywords[j] ) ){
                    res.add( res.get( i ) );
                }

            }
        }
        return res;
    }
    //endregion

    //region Dagsferðarleit
    public static ArrayList<DayTrip> FindDayTrips( String loc, GregorianCalendar date, Float price, String[] keywords ){
        ArrayList<DayTrip> daytrips = null/* ????? SearchDayTrips( loc, date, price, keywords ) */;
        return daytrips;
    }
    public static ArrayList<DayTrip> GetSuggestionsDayTrip( String loc, GregorianCalendar date, String[] keywords ){
        ArrayList<DayTrip> suggestions = null;/* ????? SearchHotels( loc, date, keywords ) */
        return suggestions;
    }
    //endregion

    //region Flugleit
    public static ArrayList<Flight> FindFlights( String from, String to, GregorianCalendar dateFrom, GregorianCalendar dateTo, Float price ){
        ArrayList<Flight> flights = null/* ????? SearchFlights( from, to, dateFrom, dateTo, price ) */;
        return flights;
    }
    public static ArrayList<DayTrip> FindCloseDayTrips( String loc, Float radius ){
        ArrayList<DayTrip> closeDayTrips = null;/* ????? DayTripDistanceSerach( loc, radius );*/
        return closeDayTrips;
    }
    
    public static ArrayList<Flight> FindBetterFlight( Flight flight ){
        ArrayList<Flight> betterFlightsUp = null;/* ????? FlightSearch( from, to, dateFrom-2, dateTo-2, price );*/
        ArrayList<Flight> betterFlightsDown = null;/* ????? FlightSearch( from, to, dateFrom+2, dateTo+2, price );*/
        ArrayList<Flight>  betterFlights = betterFlightsUp;
        betterFlights.addAll( betterFlightsDown );
        return betterFlights;
    }
    //endregion
}