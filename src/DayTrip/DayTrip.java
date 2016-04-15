package DayTrip;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DayTrip {


    private String name;

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public String getType() {
        return type;
    }

    /*public TravelAgency getAgency() {
        return agency;
    }*/

    public int getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    public int getSize() {
        return size;
    }

    public double getRating() {
        return rating;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    /*public List<Trip> getTrips() {
        return trips;
    }*/

    public Date[] getDate() {
        return date;
    }

    public int getRateCounter() {
        return rateCounter;
    }

    private int length;
    private String type;
    //private TravelAgency agency;
    private int price;
    private String location;
    private int size;
    private double rating;
    private String extraInfo;
    //private List<Trip> trips;
    private Date[] date;
    private int rateCounter;


    public DayTrip(){

    }

}
