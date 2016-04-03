package com.main.java.persistence;

import java.util.Date;

public class DayTripOrder extends Order{
    /**
     *
     */
    private DayTrip dayTrip;
    
    public DayTripOrder(){
        
    }
    public DayTripOrder( DayTrip dayTrip ){
    	this.dayTrip = dayTrip;
    }
    
    public DayTrip GetDayTrip(){
    	return dayTrip;
    }
    public void SetDayTrip( DayTrip dayTrip ){
    	this.dayTrip = dayTrip;
    }
    
    public void CreateDayTriprder(){
            
    }
    
    public void EditDayTripOrder(){
        
    }
}