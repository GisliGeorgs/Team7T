package com.main.java.controller;

import DayTrip.klasar.*;
import Hotel.BookingController;
import Hotel.Hotel;
import Hotel.Room;
import Hotel.Booking;
import Hotel.BookingController;
import com.main.java.persistence.*;
import com.main.java.form.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CartController extends SearchController{


    public FlightOrder flightOrders;
    public DayTripOrder dayTripOrders;
    public HotelOrder hotelOrders;
    public com.main.java.form.User user;

    public CartController(){
        GetUser();
        hotelOrders = new HotelOrder();
        flightOrders = new FlightOrder();
        dayTripOrders = new DayTripOrder();
    }
    
    /**
     * Er �etta � r�ttum sta�?
     * @param from
     * @param to
     * @param dest
     * @param startLoc
     */
    public void FindTripsFromTo(Date from, Date to, String dest, String startLoc ){

    }
    /**
     * Hendir dagsfer� �r b�kuninni.
     * @param daytrip Dagsfer�in sem � a� henda.
     */
    public void RemoveDayTripFromBooking( DayTrip daytrip ){ dayTripOrders.RemoveDayTrip( daytrip ); } 
    public void RemoveHotelFromBooking( Hotel hotel ){ hotelOrders.RemoveHotel( hotel); }
    public void RemoveOutFlight( ){ flightOrders.RemoveOutFlight(); }
    public void RemoveHomeFlight(){ flightOrders.RemoveHomeFlight(); }

    /**
     * B�tir vi� dagsfer�arp�ntun � Cart-i�
     * @param daytriporder
     */
    public void AddDayTripToBooking( DayTrip daytrip ){ dayTripOrders.AddDayTrip( daytrip ); }    
    public void AddHotelToBooking( Hotel hotel, Room room ){
        hotelOrders.AddHotel( hotel, room );
    }
    public void AddFlightHomeToBooking( Flight.Flight flight ){ flightOrders.SetHomeFlight(flight); }
    public void AddFlightOutToBooking( Flight.Flight flight ){ flightOrders.SetOutFlight(flight); }

    public FlightOrder getFlightOrders() {
        return flightOrders;
    }
    public HotelOrder getHotelOrders() {
        return hotelOrders;
    }
    public DayTripOrder getDayTripOrders() {
        return dayTripOrders;
    }

    /**
     * �arf �etta?
     * @return
     */
    public String NewTrip(){
        return "";
    }
    
    /**
     * N�r � gamla b�kun.
     * @param orderId P�ntunin sem � a� s�kja.
      */
    public void GetOldTrip( String orderId ){
        if( user == null ){
        	GetUser();
        }
        hotelOrders = new HotelOrder();
        flightOrders = new FlightOrder();
        dayTripOrders = new DayTripOrder();
    }
    
    public List<Hotel> GetHotelOrder( String orderId ){
        user.LoadOrder( orderId );
    	return null;//user.GetHotelOrders;
    }
    public List<Flight.Flight> GetFlightOrder( String orderId ){
        user.LoadOrder( orderId );
        return null;//user.GetFlightOrders();
    }
    public List<DayTrip> GetDayTripOrder( String orderId ){
        user.LoadOrder( orderId );
        return null;//user.getDayTripOrders();
    }

    /**
     * Pantar allt d�ti� sem er � cart-inu
     * @return Master order id
     */
    public String CreateCartOrder( /*List<DayTripOrder> dayTripOrders, List<FlightOrder> flightOrders, List<HotelOrder> hotelOrders*/ ){
    	String orderNum = GenerateID();
        try {
        	BookHotels();
        	BookFlights();
        	// TODO setja inn r�tt
			//user.SaveOrder( orderNum, flightBookingID, hotelBookingID, DayTripBookingID );
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}      	
        return orderNum;
    }
    
    private String GenerateID(){
        String orderNum = "";
        String a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for( int i = 0; i < 9; i++ ){
        	Random rand = new Random();
        	int i2 = rand.nextInt(a.length());
        	orderNum += a.substring( i2, i2+1 );
        }
        return orderNum;    	
    }

    String flightBookingID;
    // TODO Implement me
    public void BookFlights(){
    	// TODO Flug user fyrir hverja manneskju sem er � numPeople
    	Flight.User fluguser = new Flight.User( "FirstName", "LastName", "01189998819991197253", "01189998819991197253" );
    	Flight.Booking book = new Flight.Booking( getFlightOrders().GetFlight(), new Flight.User[]{ fluguser } );
    	int id = book.confirm();
    	System.out.println("Flight Booking ID: " + id);
    	if( id != 0 ){
        	flightBookingID = Integer.toString( id );
    	}
    }
    
    String hotelBookingID;
    // TODO Finish implementing me
    public void BookHotels(){
		int length = getHotelOrders().GetHotel().size();
		BookingController booker = new BookingController();
		for( int i = 0; i < length; i++ ){
			Hotel hotel = getHotelOrders().GetHotel().get( i );
			
			// TODO Laga book contructorinn
			Booking book = new Booking( hotel, getHotelOrders().getRoom().get(i), "MyName", "my@aol.com", "MyPhone", DateToString(getHotelOrders().getDateFrom()), DateToString(getHotelOrders().getDateTo()), "MyCreditCard" );
			try {
				booker.saveBooking( book );
				// TODO Save-a b�kun
				// user.save?
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    }
    String DayTripBookingID;
    // TODO F�ra �etta � CartController CreateCartOrder
    public void BookDayTrips(){

    }
    /**
     * N�r � UserInfo.
     */
    public void GetUser(){
        user = new User();
    }
    
    private static String DateToString( Date date ){
        String res = Integer.toString( date.getYear() + 1900 );
        res += "-" + Integer.toString( date.getMonth() + 1 );
        res += "-" + Integer.toString( date.getDate() );
        return res;
    }
}