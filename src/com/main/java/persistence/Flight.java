package com.main.java.persistence;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Flight {

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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

    private String from;
    private String to;
    private Date dateFrom;
    private Date dateTo;
    private Float price;

    public Flight(){

    }
    
}
