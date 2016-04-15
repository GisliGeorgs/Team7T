package com.main.java.persistence;

import Hotel.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelOrder extends Order{
    private List<Hotel> hotel;

    /**
     *
     */
    public HotelOrder(){
    	hotel = new ArrayList<Hotel>();
    }
    public HotelOrder( List<Hotel> hotel ){
    	this.hotel = hotel;
    }
    
    public List<Hotel> GetHotel(){
    	return hotel;
    }
    
    public void SetHotel( List<Hotel> hotel ){
    	this.hotel = hotel;
    }
    public void AddHotel( Hotel hotel ){
    	this.hotel.add( hotel );
    }
    
    public void RemoveHotel( Hotel hotel ){
    	this.hotel.remove( hotel );
    }
    public void CreateHotelOrder(){
            
    }
    
    public void EditHotelOrder(){
        
    }
}