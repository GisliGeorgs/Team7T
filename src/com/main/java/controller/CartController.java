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

    }
    
    public Order GetOldTrip( String orderId ){

    }
    
    public HotelOrder GetHotelOrder( String hotelOrderId ){
        
    }
    public FlightOrder GetFlightOrder( String flightOrderId ){
        
    }
    public DayTripOrder GetDayTripOrder( String dayTripOrderId ){
        
    }

    public UserInfo GetUser(){
        user = new UserInfo();
    }
}