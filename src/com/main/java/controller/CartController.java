package com.main.java.controller;

import DayTrip.DayTrip;
import Flight.Flight;
import Hotel.Hotel;
import com.main.java.persistence.*;
import com.main.java.form.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CartController extends SearchController{
    public HotelOrder hotelOrders;
    public FlightOrder flightOrders;
    public DayTripOrder dayTripOrders;
    public User user;

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
     * @param daytriporder Dagsfer�in sem � a� henda.
     */
    public void RemoveDayTripFromBooking( DayTrip daytrip ){
    	dayTripOrders.RemoveDayTrip( daytrip );
	}
    public void RemoveHotelFromBooking( Hotel hotel ){
    	hotelOrders.RemoveHotel( hotel);
    }    
    public void RemoveFlightFromBooking( Flight flight ){
    	flightOrders.RemoveFlight( flight );
    }
    
    /**
     * B�tir vi� dagsfer�arp�ntun � Cart-i�
     * @param daytriporder
     */
    public void AddDayTripToBooking( DayTrip daytrip ){
    	dayTripOrders.AddDayTrip( daytrip );
    }
    
    public void AddHotelToBooking( Hotel hotel ){
    	hotelOrders.AddHotel( hotel );
    }
    
    public void AddFlightToBooking( Flight flight ){
    	flightOrders.AddFlight( flight );
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
    public List<Flight> GetFlightOrder
    ( String orderId ){
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
        String orderNum = "";
        String a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for( int i = 0; i < 9; i++ ){
        	Random rand = new Random();
        	int i2 = rand.nextInt(a.length());
        	orderNum += a.substring( i2, i2+1 );
        }
        try {
        	System.out.println(1111111);
			user.SaveOrder( orderNum, dayTripOrders, flightOrders, hotelOrders );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      	
        return orderNum;
    }
    /**
     * N�r � UserInfo.
     */
    public void GetUser(){
        user = new User();
    }
}