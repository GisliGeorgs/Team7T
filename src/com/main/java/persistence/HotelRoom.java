package com.main.java.persistence;

/**
 * Created by Gísli on 13/4/2016.
 */
public class HotelRoom {
    private int numberOfBeds;
    private double sizeOfRoom;
    private String typeOfBathroom;
    private int roomNumber;
    private int maxGuests;
    private String description;

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getSizeOfRoom() {
        return sizeOfRoom;
    }

    public String getTypeOfBathroom() {
        return typeOfBathroom;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public String getDescription() {
        return description;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    private double roomPrice;
}
