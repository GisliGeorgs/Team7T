package com.main.java.controller;

import com.main.java.persistence.*;
import com.main.java.form.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

class CartController extends SearchController{
    public List<HotelOrder> hotelOrders = new ArrayList<HotelOrder>();
    public List<FlightOrder> flightOrders = new ArrayList<FlightOrder>();
    public List<DayTripOrder> dayTripOrders = new ArrayList<DayTripOrder>();
    public UserInfo user;

    public CartController(){
        GetUser();
    }
    
    public void FindTripsFromTo(Date from, Date to, String dest, String startLoc ){

    }
    /**
     * Hendir dagsferðarpöntun úr cartinu
     * Á að skila orderinu sem þú hentir út?
     * @param daytriporder
     */
    public void RemoveDayTripFromBooking( DayTripOrder daytriporder ){
    	dayTripOrders.remove( daytriporder );
	}
    public void RemoveHotelFromBooking( HotelOrder hotelorder ){
    	
    }    
    public void RemoveFlightFromBooking( FlightOrder flightorder ){
    }
    
    /**
     * Bætir við dagsferðarpöntun í Cart-ið
     * @param daytriporder
     */
    public void AddDayTripToBooking( DayTripOrder daytriporder ){
    	dayTripOrders.add( daytriporder );
    }
    
    public void AddHotelToBooking( HotelOrder hotelorder ){
    	
    }
    
    public void AddFlightToBooking( FlightOrder flightorder ){
    	
    }
    
    public String NewTrip(){
        return "";
    }
    
    public Order GetOldTrip( String orderId ){
        return null;
    }
    
    public List<HotelOrder> GetHotelOrder( String orderId ){
        user.LoadOrder( orderId );
    	return user.GetHotelOrders;
    }
    public List<FlightOrder> GetFlightOrder( String orderId ){
        user.LoadOrder( orderId );
        return user.GetFlightOrders();
    }
    public List<DayTripOrder> GetDayTripOrder( String orderId ){
        user.LoadOrder( orderId );
        return user.getDayTripOrders()
    }

    /**
     * Pantar allt dótið sem er í cart-inu
     * @return Master order id
     */
    public String CreateCartOrder( /*List<DayTripOrder> dayTripOrders, List<FlightOrder> flightOrders, List<HotelOrder> hotelOrders */){
        String orderNum = "";
        String a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for( int i = 0; i < 9; i++ ){
        	Random rand = new Random();
        	int i2 = rand.nextInt(a.length());
        	orderNum += a.substring( i2, i2+1 );
        }
        
        user.SaveOrder( orderNum, dayTripOrders, flightOrders, hotelOrders );      	
        return orderNum;
    }

    public void GetUser(){
        user = new UserInfo();
    }
}