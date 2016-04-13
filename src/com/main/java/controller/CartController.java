package com.main.java.controller;

import com.main.java.persistence.*;
import com.main.java.form.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CartController extends SearchController{
    public HotelOrder hotelOrders;
    public FlightOrder flightOrders;
    public DayTripOrder dayTripOrders;
    public UserInfo user;

    public CartController(){
        GetUser();
        hotelOrders = new HotelOrder();
        flightOrders = new FlightOrder();
        dayTripOrders = new DayTripOrder();
    }
    
    /**
     * Er þetta á réttum stað?
     * @param from
     * @param to
     * @param dest
     * @param startLoc
     */
    public void FindTripsFromTo(Date from, Date to, String dest, String startLoc ){

    }
    /**
     * Hendir dagsferð úr bókuninni.
     * @param daytriporder Dagsferðin sem á að henda.
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
     * Bætir við dagsferðarpöntun í Cart-ið
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
     * Þarf þetta?
     * @return
     */
    public String NewTrip(){
        return "";
    }
    
    /**
     * Nær í gamla bókun.
     * @param orderId Pöntunin sem á að sækja.
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
     * Pantar allt dótið sem er í cart-inu
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
     * Nær í UserInfo.
     */
    public void GetUser(){
        user = new UserInfo();
    }
}