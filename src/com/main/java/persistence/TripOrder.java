package com.main.java.persistence;

class TripOrder extends Order{
    private Date dateFrom;
    private Date dateTo;
    
    public void SetDate( Date from, Date to ){
        dateFrom = from;
        dateTo = to;
    }
    
    public Date GetDateFrom(){
        return dateFrom;
    }
    public Date GetDateTo(){
        return dateTo;
    }
}