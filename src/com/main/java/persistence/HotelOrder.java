package com.main.java.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HotelOrder extends Order{
    private List<Hotel> hotel;

    /**
     *
     */
    public HotelOrder(){

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
    
    public void CreateHotelOrder(){
            
    }
    
    public void EditHotelOrder(){
        
    }
}