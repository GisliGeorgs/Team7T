package Hotel;

import DayTrip.DayTrip;

import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Hotel {

    // TODO Fá klasan beint frá hinum hópnum
    //private Review[] reviews;
    private String name;
    private String address;
    private String type;

    private String phoneNumber;
    private String description;
    private double starCount;
    private double rating;
    private HotelRoom[] room;
    private int numerOfRooms;
    private String[] tags;
    private double avgPrice;
    private GregorianCalendar checkoutTime;
    private ArrayList<DayTrip> dayTours;


    /*public Review[] getReviews() {
        return reviews;
    }*/

    /*public void setReviews(Review[] reviews) {
        this.reviews = reviews;
    }*/

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public double getStarCount() {
        return starCount;
    }

    public void setStarCount(double starCount) {
        this.starCount = starCount;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public HotelRoom[] getRoom() {
        return room;
    }

    public int getNumerOfRooms() {
        return numerOfRooms;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public GregorianCalendar getCheckoutTime() {
        return checkoutTime;
    }

    public ArrayList<DayTrip> getDayTours() {
        return dayTours;
    }


}
