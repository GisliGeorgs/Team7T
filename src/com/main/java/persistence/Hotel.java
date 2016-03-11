package com.main.java.persistence;

import java.util.Date;

public class Hotel {

    private String location;
    private Date dateFrom;
    private Date dateTo;
    private Float price;
    private String[] keywords;

    public Hotel(){

    }
    public Hotel( String loc, Date dateFrom, Date dateTo, Float price, String[] keywords ){
        this.location = loc;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.price = price;
        this.keywords = keywords;
    }



}
