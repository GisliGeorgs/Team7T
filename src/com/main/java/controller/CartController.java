package com.main.java.controller;

import com.main.java.persistence.*;
import com.main.java.form.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class CartController extends SearchController{

    public List<HotelOrder> hotelOrders = new ArrayList<HotelOrder>();
    public List<FlightOrder> flightOrders = new ArrayList<FlightOrder>();
    public List<DayTripOrder> dayTripOrders = new ArrayList<DayTripOrder>();
    public UserInfo user;

    public CartController(){
        user = GetUser();
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
    
    public HotelOrder GetHotelOrder( String hotelOrderId ){
        return null;
    }
    public FlightOrder GetFlightOrder( String flightOrderId ){
        return null;
    }
    public DayTripOrder GetDayTripOrder( String dayTripOrderId ){
        return null;
    }

    /**
     * Pantar allt dótið sem er í cart-inu
     * @return Master order id
     */
    public String CreateCartOrder( /*List<DayTripOrder> dayTripOrders, List<FlightOrder> flightOrders, List<HotelOrder> hotelOrders */){
        String orderId = "";
        
        // Generata random string
        // Bæta honum við í UserInfo pastOrders
        // 
        
        
    	
        user.SetPastOrderNumber( orderId );
        return "";
    }

    public void GetUser(){
        user = new UserInfo();
    }
}