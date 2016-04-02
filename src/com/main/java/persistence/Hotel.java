package com.main.java.persistence;

import java.util.Date;
import java.util.Calendar;

public class Hotel {

    private String location;
    private Calendar dateFrom;
    private Calendar dateTo;
    private Float price;
    private String[] keywords;

    public Hotel(){
    	
    }
    public Hotel( String loc,Calendar dateFrom, Calendar dateTo, Float price, String[] keywords ){
        this.location = loc;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.price = price;
        this.keywords = keywords;
    }



}
