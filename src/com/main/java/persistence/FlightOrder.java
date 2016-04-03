package com.main.java.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FlightOrder extends Order{
    private List<Flight> flight;
    
    public FlightOrder(){
        
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
    
    public void CreateFlightOrder(){
            
    }
    
    public void EditFlightOrder(){
        
    }
}