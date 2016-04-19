package com.main.java.controller;

import DayTrip.klasar.*;
import Flight.*;
import Hotel.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SearchController{

	public SearchController(){

    }

    // TODO Sleppa?
    public static ArrayList<Hotel> GetHotelHistory( int i ){ return null; }
    public static ArrayList<Flight> GetFlightHistory( int i ){ return null; }
    public ArrayList<DayTrip> GetDayTripHistory( int i ){ return null; }
    
    public static List Search( int type, ArrayList<String> searchValues, String loc, String flightFrom, String flightTo, Date dateFrom, Date dateTo, int price, boolean roundTrip, int numPeople, boolean flex ) throws SQLException{
    	/*GregorianCalendar gregFrom = new GregorianCalendar();
    	GregorianCalendar gregTo = new GregorianCalendar();
    	gregFrom.setTime( dateFrom );
    	gregTo.setTime( dateTo );*/

        String[] keywords = searchValues.toArray( new String[0] );
        System.out.println("loc: '" + loc + "'");

    	if( type == 0 ){
    		ArrayList<Flight> res = new ArrayList<Flight>();
    		FindFlights( flightFrom, flightTo, dateFrom, dateTo, numPeople, price, flex, roundTrip );
    		System.out.println(flightsFrom.size());
    		for( int i = 0; i < flightsFrom.size(); i++ ){
    			if( i < flightsFrom.size() ){
    				System.out.println( "From " + flightsFrom.get(i).getFlightNo() );
        			res.add( flightsFrom.get(i) );
    			}
    		}
    		for( int i = 0; i < flightsFrom.size(); i++ ){
				if( i < flightsTo.size() ){
					System.out.println( "To " + flightsTo.get(i).getFlightNo() );
	    			res.add( flightsTo.get(i) );
				}
    		}
            return res;
    	}
    	else if( type == 1 ){
    		return FindHotels( dateFrom, dateTo, numPeople, loc, price, keywords );
    	}
    	else if( type == 2 ){
    		return FindDayTrips( dateFrom, dateTo, loc, price, keywords );
    	}
    	else{
    		return null;
    	} 	
    }

    //region Hótel leit

    //======================================================================================================================
    //
    //
    // Hotel[] = findHotelWithAvailableRooms( startDate, endDate, guestCount, location, minimumStars, maxPrice )
    //
    // TODO ??hafa bara FindHotels með date, date, numpeople, loc, price, keywords??
    //
    //======================================================================================================================
	/*
    public static ArrayList<Hotel> FindHotels( GregorianCalendar dateFrom, GregorianCalendar dateTo, int numPeople, String loc ){
        Hotel[] resArr = HotelSearchController.findHotelWithAvailableRooms( dateFrom, dateTo, numPeople, loc, 0, 1000000 );
        ArrayList<Hotel> res = new ArrayList<Hotel>(Arrays.asList( resArr ) );
    	return res;
    }

    public static ArrayList<Hotel> FindHotels( GregorianCalendar dateFrom, GregorianCalendar dateTo, int numPeople, String loc, Float price){
        Hotel[] resArr = HotelSearchController.findHotelWithAvailableRooms( dateFrom, dateTo, numPeople, loc, 0, price );
        ArrayList<Hotel> res = new ArrayList<Hotel>( Arrays.asList( resArr ) );
        return res;
    }

    public static ArrayList<Hotel> FindHotels( GregorianCalendar dateFrom, GregorianCalendar dateTo, int numPeople, String loc, Float price, String[] keywords  ){
        // Ná í hótel frá hotel component
        Hotel[] resArr = HotelSearchController.findHotelWithAvailableRooms( dateFrom, dateTo, numPeople, loc, 0, price );
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
	*/
    public static ArrayList<Hotel> FindHotels( Date dateFrom, Date dateTo, int numPeople, String loc, float price, String[] keywords  ) throws SQLException{
        // Ná í hótel frá hotel component
        HotelController ctrl = new HotelController();
        Hotel[] resArr = ctrl.findHotelWithAvailableRooms(  DateToString( dateFrom ), DateToString( dateTo ), (double)0, (int)price, loc );
        // Búa til lista úr þeim
        ArrayList<Hotel> mid = new ArrayList<>(Arrays.asList( resArr ) );
        // Niðurstöðu listi því
        ArrayList<Hotel> res = new ArrayList<>();
        // Við þurfum að leita að keywords í lýsingu, nafni, tags, ... í hverju hóteli
        // TODO uncommenta �etta og l�ta virka r�tt
        /*for( int i = 0; i < res.size(); i++ ){
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
        }*/
        return mid/*res*/;
    }
    //endregion

    //region Dagsferðarleit

    //======================================================================================================================
    // List<DayTrip> =search( Date date, Date date2, String name, String type, int maxsize, int maxprice, int maxlength, String location )
    //
    // TODO Fleiri dagsferðar leitir?????
    //======================================================================================================================
    /*
    public static ArrayList<DayTrip> FindDayTrips( GregorianCalendar dateFrom, GregorianCalendar dateTo, String loc ){
        // TODO má gera "" í name og type?
        ArrayList<DayTrip> res = DayTripSearchConnection.search( dateFrom, dateTo, "", "", 9999, 999999999, loc );
        return res;
    }*/
    /*
    public static ArrayList<DayTrip> FindDayTrips( GregorianCalendar dateFrom, GregorianCalendar dateTo, String loc, int price ){
        ArrayList<DayTrip> res = DayTripSearchConnection.search( dateFrom, dateTo, "", "", 9999, price, loc );
        return res;
    }*/

    // TODO þurfum sjálfir að finna daytrips með viðeigandi keywords. Daytrip geymir streng info.
    /*public static ArrayList<DayTrip> FindDayTrips( Date dateFrom, Date dateTo, String loc, String[] keywords ){
        ArrayList<DayTrip> mid = DayTripSearchConnection.search( dateFrom, dateTo, "", "", 9999, 999999999, loc );
        ArrayList<DayTrip> res = new ArrayList<>();
        for ( int i = 0; i < mid.size(); i++ ) {
            DayTrip daytrip = mid.get( i );
            for ( int j = 0; j < keywords.length; j++ ) {
                String keyword = keywords[j];
                if( daytrip.getName().equals( keyword ) ) {
                    res.add( daytrip );
                }
                else if( daytrip.getType().equals( keyword ) ){
                    res.add( daytrip );
                }
                else if(daytrip.getExtraInfo().contains( keyword ) ){
                    res.add( daytrip );
                }
            }
        }
        return res;
    }*/

    public static ArrayList<DayTrip> FindDayTrips( Date dateFrom, Date dateTo, String loc, int price, String[] keywords ){
    	DatabaseConnection ctrl = new DatabaseConnection();
    	System.out.println( loc );
    	// TODO Breyta �essu
    	System.out.println( loc.length() );
    	if( loc != null && loc != "" && loc.length() != 0 ){
    		System.out.println("loc ernull ");
    	}
    	ArrayList<DayTrip> mid = new ArrayList<DayTrip>(ctrl.search( dateFrom, dateTo, "", "", 0, price, 0, loc));
    			
        ArrayList<DayTrip> res = new ArrayList<>();
        // TODO L�ta �etta virka r�tt
        /*for ( int i = 0; i < mid.size(); i++ ) {
            DayTrip daytrip = mid.get( i );
            for ( int j = 0; j < keywords.length; j++ ) {
                String keyword = keywords[j];
                if( daytrip.getName().equals( keyword ) ) {
                    res.add( daytrip );
                }
                else if( daytrip.getType().equals( keyword ) ){
                    res.add( daytrip );
                }
                else if(daytrip.getExtraInfo().contains( keyword ) ){
                    res.add( daytrip );
                }
            }
        }*/
        // TODO Remove me
        res = mid;
        return res;
    }
    //endregion

    //region Flugleit
    //======================================================================================================================
    //
    // TODO useless? hafa bara eina search per hlut?????
    /* Eins og ég skil þetta

        Búa fyrst til user.
        Flight.User user = new Flight.User( fnafn, enafn, kortanumer, passportnumer );
        int i = user.createUser;// 1 ef gekk, -1 ef gekk ekki.

        Til að leita að flugum
        SearchCtrl search = new SearchCtrl( from, to, dateFrom, dateTo, numTickets, price, flex, roundtrip );
        Object[] res = search.search();

        res[0] = Flight[] - contains flights out
        res[1] = Flight[] - contains flights home

        Til að bóka flug
        Booking boka = new Booking( flug, user );
        flug er fengið í search,
        flug = Flight[2], Flight[0] = flug út, Flight[1] = flug heim
        user er fengið í user að ofan,
        user = User[n], Væntanlega 1 hjá okkur.

        int i = boka.confirm();// i = reference number

        searchCtrl ctrl = new searchCtrl( String from, String to, String dateFrom, String dateTo, int price, boolean flex, boolean roundTrip )


    */
    // searchCtrl ctrl = new searchCtrl( String from, String to, String dateFrom, String dateTo, int price, boolean flex, boolean roundTrip )
    //
    //======================================================================================================================
    static ArrayList<Flight> flightsFrom;
    static ArrayList<Flight> flightsTo;
    public static void FindFlights( String from, String to, Date dateFrom, Date dateTo, int numTickets, int price, boolean flex, boolean round ){
    	System.out.println( "FindFlights" );
        String datefrom = DateToString( dateFrom );
        String dateto = DateToString( dateTo );
        System.out.println(datefrom);
        System.out.println(dateto);

        searchCtrl contr = new searchCtrl( from ,to, datefrom, dateto, numTickets, price, flex, round );
        Object[] obj = contr.search();
        System.out.print( "obj 0: " + ((Flight[])obj[0]).length);
        System.out.print( "obj 1: " + ((Flight[])obj[1]).length);
        Flight[] flightFrom = (Flight[])obj[0];
        Flight[] flightTo = (Flight[])obj[1];
        flightsFrom = new ArrayList<>(Arrays.asList( flightFrom ) );
        flightsTo = new ArrayList<>(Arrays.asList( flightTo ) );
    }

    // TODO Useless?????, flex í FindFlights fyrir ofan sér um þetta.
    public static ArrayList<Flight> FindBetterFlight( Flight flight ){
        ArrayList<Flight> betterFlightsUp = null;/* ????? FlightSearch( from, to, dateFrom-2, dateTo-2, price );*/
        ArrayList<Flight> betterFlightsDown = null;/* ????? FlightSearch( from, to, dateFrom+2, dateTo+2, price );*/
        ArrayList<Flight>  betterFlights = betterFlightsUp;
        betterFlights.addAll( betterFlightsDown );
        return betterFlights;
    }

    public static ArrayList<Flight> GetFlightsFrom(){
        return flightsFrom;
    }
    public static ArrayList<Flight> GetFlightsTo(){
        return flightsTo;
    }
    //endregion

    private static String DateToString( Date date ){
        String res = Integer.toString( date.getYear() + 1900 );
        res += "-" + Integer.toString( date.getMonth() + 1 );
        res += "-" + Integer.toString( date.getDate() );
        return res;
    }
}
