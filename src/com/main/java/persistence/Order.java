package com.main.java.persistence;

import java.util.Date;

public class Order{
    
    private String orderNumber;

    private Date date;
    private Date dateFrom;
    private Date dateTo;

    public String OrderNumber(){
        return orderNumber;
    }
    public void OrderNumber( String id ){
        orderNumber = id;    
    }
    public void DeleteOrder(  ){
        
    }

    public void setDate( Date d ){
        this.date = d;
    }
    public void setDate( Date from, Date to ){
        this.dateFrom = from;
        this.dateTo = to;
    }

    public Date getDateFrom(){
        return dateFrom;
    }
    public Date getDateTo(){
        return dateTo;
    }
    public Date getDate(){
        return date;
    }

}