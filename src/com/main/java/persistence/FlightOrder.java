package com.main.java.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FlightOrder extends Order{
    private List<Flight> flight;
    
    public FlightOrder(){
    	flight = new ArrayList<Flight>();        
    }
    public FlightOrder( List<Flight> flight ){
    	this.flight = flight;
    }
    
    public List<Flight> GetFlight(){
    	return flight;
    }
    public void SetFlight( List<Flight> flight ){
    	this.flight = flight;
    }
    public void AddFlight( Flight flight ){
    	this.flight.add( flight );
    }
    public void RemoveFlight( Flight flight ){
    	this.flight.remove( flight );
    }
    
    public void CreateFlightOrder(){
            
    }
    
    public void EditFlightOrder(){
        
    }
}