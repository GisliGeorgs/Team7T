package com.main.java.persistence;

public class FlightOrder extends Order{
    private Flight flight;
    
    public FlightOrder(){
        
    }
    public FlightOrder( Flight flight ){
    	this.flight = flight;
    }
    
    public Flight GetFlight(){
    	return flight;
    }
    public void SetFlight( Flight flight ){
    	this.flight = flight;
    }
    
    public void CreateFlightOrder(){
            
    }
    
    public void EditFlightOrder(){
        
    }
}