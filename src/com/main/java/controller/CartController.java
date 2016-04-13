package com.main.java.controller;

import com.main.java.persistence.*;
import com.main.java.form.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CartController extends SearchController{
    public HotelOrder hotelOrders = new HotelOrder();
    public FlightOrder flightOrders = new FlightOrder();
    public DayTripOrder dayTripOrders = new DayTripOrder();
    public UserInfo user;

    public CartController(){
        GetUser();
        hotelOrders = new HotelOrder();
        flightOrders = new FlightOrder();
        dayTripOrders = new DayTripOrder();
    }



    /**
     * Hendir dagsfer�arp�ntun �r cartinu
     * � a� skila orderinu sem �� hentir �t?
     * @param daytrip
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
     * @param daytrip
     */
    public void AddDayTripToBooking( DayTrip daytrip ){ dayTripOrders.AddDayTrip( daytrip ); }
    public void AddHotelToBooking( Hotel hotel ){
    	hotelOrders.AddHotel( hotel );
    }
    public void AddFlightToBooking( Flight flight ){
    	flightOrders.AddFlight( flight );
    }
    
    public void GetOldTrip( String orderId ){
        GetHotelOrder( orderId );
        GetFlightOrder( orderId );
        GetDayTripOrder( orderId );
    }
    
    public void GetHotelOrder( String orderId ){
        user.LoadOrder( orderId );
        hotelOrders = user.hotelOrder;

    }
    public void GetFlightOrder( String orderId ){
        user.LoadOrder( orderId );
        flightOrders = user.flightOrder;
    }
    public void GetDayTripOrder( String orderId ){
        user.LoadOrder( orderId );
        dayTripOrders = user.tripOrder;
    }

    /**
     * Pantar allt d�ti� sem er � cart-inu
     * @return Master order id
     */
    public String CreateCartOrder( ){
        String orderNum = "";
        String a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for( int i = 0; i < 9; i++ ){
        	Random rand = new Random();
        	int i2 = rand.nextInt(a.length());
        	orderNum += a.substring( i2, i2+1 );
        }
        try {
			user.SaveOrder( orderNum, dayTripOrders, flightOrders, hotelOrders );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      	
        return orderNum;
    }

    public void GetUser(){
        user = new UserInfo();
    }
}