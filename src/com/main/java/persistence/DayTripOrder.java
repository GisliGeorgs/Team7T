package com.main.java.persistence;

import DayTrip.klasar.*;

import java.util.ArrayList;
import java.util.List;

public class DayTripOrder extends Order{
    private List<DayTrip> dayTrip;
    private List<Trip> trips;

    public DayTripOrder(){
    	dayTrip = new ArrayList<DayTrip>();
        trips = new ArrayList<Trip>();
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

    public void AddTrip( Trip trip ){
        this.trips.add( trip );
    }
    public void RemoveTrip( Trip trip ){
        this.trips.remove( trip );
    }
    public List<Trip> getTrips(){
        return trips;
    }

}