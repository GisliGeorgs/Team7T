package com.main.java.persistence;

import Hotel.Hotel;
import Hotel.Room;

import java.util.ArrayList;
import java.util.List;

public class HotelOrder extends Order{
    private List<Hotel> hotel;
    private List<Room> room;

    public List<Room> getRoom() {
		return room;
	}
	/**
     *
     */
    public HotelOrder(){
        hotel = new ArrayList<Hotel>();
        room = new ArrayList<Room>();
    }
    public HotelOrder( List<Hotel> hotel, List<Room> room ){
    	this.hotel = hotel;
        this.room = room;
    }
    
    public List<Hotel> GetHotel(){
    	return hotel;
    }
    
    public void SetHotel( List<Hotel> hotel ){
    	this.hotel = hotel;
    }
    public void AddHotel( Hotel hotel, Room room ){
    	this.hotel.add( hotel );
        this.room.add( room );
    }
    
    public void RemoveHotel( Hotel hotel ){
        int i = this.hotel.indexOf( hotel );
        this.hotel.remove( hotel );
        this.room.remove( i );
    }


    // TODO pointless?
    public void CreateHotelOrder(){
            
    }
    
    public void EditHotelOrder(){
        
    }
}