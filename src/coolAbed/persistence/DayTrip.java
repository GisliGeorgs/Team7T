package com.main.java.persistence;

import java.util.Date;

public class DayTrip {
    private String location;
    private Date date;
    private Float price;
    private String[] keywords;

    public DayTrip(){

    }
    public DayTrip( String loc, Date date, Float price, String[] keywords ){
        this.location = loc;
        this.date = date;
        this.price = price;
        this.keywords = keywords;
    }
}
