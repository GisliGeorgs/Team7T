package com.main.java.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FlightOrder extends Order{
    private List<Flight> flight;
    
    public FlightOrder(){
        
    }
<<<<<<< HEAD
    public FlightOrder( Flight flight ){
=======
    public FlightOrder( List<Flight> flight ){
>>>>>>> f0a1fcd77b780d0b7960fb348f21e30e5918ffc2
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