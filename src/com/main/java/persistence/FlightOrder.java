package com.main.java.persistence;

import Flight.*;

import java.util.ArrayList;
import java.util.List;

public class FlightOrder extends Order{
    private Flight[] flight;

    public FlightOrder(){
        flight = new Flight[2];
    }
    public FlightOrder( Flight[] flight ){
        this.flight = flight;
    }

    public Flight[] GetFlight(){
        return flight;
    }
    public void SetFlight( Flight[] flight ){
        this.flight = flight;
    }
    public void SetOutFlight( Flight flight ){ this.flight[0] = flight; }
    public void SetHomeFlight( Flight flight  ){ this.flight[1] = flight; }
    public void RemoveOutFlight(){ this.flight[0] = null; }
    public void RemoveHomeFlight(){ this.flight[1] = null; }
}