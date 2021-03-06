package Hotel;
import java.util.Date;

/**
 * Created by arnorv on 16/03/16.
 */
public class Booking {
    private int id;
    private static String phoneNr;
    private static String customerName;
    private static String email;
    private static String creditCardNr;
    private static String startDate;
    private static String endDate;
    private static Room[] rooms;
    private static Hotel hotel;
    private static int hotelId;
    private static int roomId;

    //Smiður
    public Booking() {

    }
    public Booking( Hotel hotel, Room room, String name, String email, String phone, String dateFrom, String dateTo, String creditcard ){
        this.hotel = hotel;
        this.hotelId = hotel.getId();
        this.customerName = name;
        this.phoneNr = phone;
        this.email = email;
        this.startDate  = dateFrom;
        this.endDate = dateTo;
        this.creditCardNr = creditcard;
        this.rooms = new Room[]{ room };
        this.roomId = room.getId();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){ return id;}

    public void setHotelId(int id) {this.hotelId = id;}

    public static int getHotelId() { return hotelId; }

    public static String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public static String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getCreditCardNr() {
        return creditCardNr;
    }

    public void setCreditCardNr(String creditCardNr) {
        this.creditCardNr = creditCardNr;
    }

    public static String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public static String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setRoomId(int id) {this.roomId = id;}

    public static int getRoomId() { return roomId; }

    public static Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public static Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
