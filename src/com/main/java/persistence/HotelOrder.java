package com.main.java.persistence;

public class HotelOrder extends Order{
    private Hotel hotel;

    /**
     *
     */
    public HotelOrder(){

    }
    public HotelOrder( Hotel hotel ){
    	this.hotel = hotel;
    }
    
    public Hotel GetHotel(){
    	return hotel;
    }
    
    public void SetHotel( Hotel hotel ){
    	this.hotel = hotel;
    }
    
    public void CreateHotelOrder(){
            
    }
    
    public void EditHotelOrder(){
        
    }
}