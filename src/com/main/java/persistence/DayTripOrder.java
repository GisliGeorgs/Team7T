package com.main.java.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.util.Date;

public class DayTripOrder extends Order{
    /**
     *
     */
    private List<DayTrip> dayTrip;
    
    public DayTripOrder(){
        
    }
    public DayTripOrder( List<DayTrip> dayTrip ){
    	this.dayTrip = dayTrip;
    }
    
    public List<DayTrip> GetDayTrip(){
    	return dayTrip;
    }
    public void SetDayTrip( List<DayTrip> dayTrip ){
    	this.dayTrip = dayTrip;
    }
    
    public void CreateDayTriprder(){
            
    }
    
    public void EditDayTripOrder(){
        
    }
}