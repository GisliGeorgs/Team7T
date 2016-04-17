package com.main.java.persistence;

import DayTrip.klasar.*;

import java.util.ArrayList;
import java.util.List;

public class DayTripOrder extends Order{
    /**
     *
     */
    private List<DayTrip> dayTrip;
    
    public DayTripOrder(){
    	dayTrip = new ArrayList<DayTrip>();
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
    
    public void AddDayTrip( DayTrip daytrip ){
    	this.dayTrip.add( daytrip );
    }
    public void RemoveDayTrip( DayTrip daytrip){
    	this.dayTrip.remove( daytrip );
    }
    
    public void CreateDayTriprder(){
            
    }
    
    public void EditDayTripOrder(){
        
    }
}