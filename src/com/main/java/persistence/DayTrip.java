package com.main.java.persistence;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DayTrip {

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    private String location;
    private GregorianCalendar date;
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
