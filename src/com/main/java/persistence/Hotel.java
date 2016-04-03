package com.main.java.persistence;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Hotel {

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public GregorianCalendar getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(GregorianCalendar dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Calendar getDateTo() {
        return dateTo;
    }

    public void setDateTo(Calendar dateTo) {
        this.dateTo = dateTo;
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
    private GregorianCalendar dateFrom;
    private Calendar dateTo;
    private Float price;
    private String[] keywords;

    public Hotel(){
    	
    }
    public Hotel( String loc,GregorianCalendar dateFrom, Calendar dateTo, Float price, String[] keywords ){
        this.location = loc;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.price = price;
        this.keywords = keywords;
    }



}
