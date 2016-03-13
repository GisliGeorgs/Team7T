package com.main.java.controller;

import com.main.java.persistence.*;
import com.main.java.form.*;
import java.util.Date;

class CartController extends SearchController{

    public HotelOrder hotelOrder;
    public FlightOrder flightOrder;
    public DayTripOrder dayTripOrder;
    public UserInfo user;

    public CartController(){
        user = GetUser();
    }
    
    public void FindTripsFromTo(Date from, Date to, String dest, String startLoc ){

    }
    
    public void RemoveHotelFromBooking( String hotelOrderId ){

    }
    
    public void RemoveFlightFromBooking( String flightOrderId ){
    }
        
    public void RemoveDayTripFromBooking( String dayTripOrderId ){
        
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

    public UserInfo GetUser(){
        return new UserInfo();
    }
}