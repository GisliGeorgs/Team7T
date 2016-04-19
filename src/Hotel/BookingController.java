package Hotel;
import java.util.ArrayList;
import java.sql.*;

/**
 * Created by thordis on 16/03/16.
 */
public class BookingController {
    private Booking[] bookings;
    private dbHelper dbh;
    //klasi sem s�r um tenginu vi� gagnagrunn

    public BookingController() {
        dbh = new dbHelper();
    }

    //leitar a� b�kun eftir id og skilar henni sem fylki.

    /**
     * Finnur b�kun eftir id n�meri
     * @param id
     * @return Booking me� r�ttum uppl�singum
     * @throws SQLException
     */
    public Booking getBooking(int id) throws SQLException {
        Object[] params = {id};
        ResultSet dbresults = dbh.runQuery("SELECT * FROM booking WHERE id = ?", params);
        String[] results = new String[9];
        while(dbresults.next()) {
            for(int j=1; j<=9; j++) {
                results[j-1] = dbresults.getString(j);
            }
        }
        Booking book = createBooking(results);
        return book;
    }

    /**
     * Finnur b�kun eftir id n�meri
     * @param id strengur sem er parsa�ur yfir � int
     * @return Booking me� �llum r�ttum uppl�singum
     * @throws SQLException
     */
    public Booking getBooking(String id) throws SQLException {
        return getBooking(Integer.parseInt(id));
    }

    /**
     * Ey�ir b�kun eftir id
     * @param id
     */
    public void deleteBooking(int id) {
        Object[] params = {(Integer) id};
        dbh.runQuery("DELETE FROM booking WHERE id=?", params);
    }
    /**
     * Finnur allar b�kanir sem eru skr��ir � �kve�inn vi�skiptavin
     * @param customerName
     * @return Booking fylki me� b�kunum vi�skiptavinar
     * @throws SQLException
     */
    public Booking[] getBookingsByCustomer(String customerName) throws SQLException {
        Object[] params = {customerName};
        ResultSet results = dbh.runQuery("SELECT * FROM booking WHERE customername=?", params);
        ArrayList<String[]> resultList = new ArrayList<String[]>();

        int columnCount = results.getMetaData().getColumnCount();

        while(results.next()) {
            String[] row = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                row[i] = results.getString(i + 1);
            }
            resultList.add(row);
        }

        int size = resultList.size();
        Booking[] bookings = new Booking[size];
        for (int j = 0; j < size; j++) {
            String[] row = resultList.get(j);
            Booking book = createBooking(row);
            bookings[j] = book;
        }
        return bookings;
    }


    /**
     * Finnur allar b�kanir eins h�tels
     * @param hotel
     * @return Booking fylki me� b�kunum eins h�tels
     * @throws SQLException
     */
    public Booking[] getBookings(Hotel hotel) throws SQLException {
        Object[] params = {hotel.getId()};
        ResultSet results = dbh.runQuery("SELECT * FROM booking WHERE hotelid=?", params);
        ArrayList<String[]> resultList = new ArrayList<String[]>();

        int columnCount = results.getMetaData().getColumnCount();

        while(results.next()) {
            String[] row = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                row[i] = results.getString(i + 1);
            }
            resultList.add(row);
        }

        int size = resultList.size();
        Booking[] bookings = new Booking[size];
        for (int j = 0; j < size; j++) {
            String[] row = resultList.get(j);
            Booking book = createBooking(row);
            bookings[j] = book;
        }
        return bookings;
    }
    // vistar n�ja b�kun, �arf a� taka inn allar uppl�singar um b�kunina, sbr dbh.runQuery
    // ef herbergi� er �egar b�ka�, skilar a�fer�in null. Annars skilar h�n b�kunarhlut sem inniheldur
    // allar r�ttar uppl�singar.

    /**
     * Vistar b�kun � gagnagrunni
     * @param booking
     * @return Booking hlut sem hefur allar r�ttar uppl�singar. Ef herbergi� er n� �egar b�ka�, skilar a�fer�in null
     * @throws Exception
     */
    public Booking saveBooking(Booking booking) throws Exception {
        java.sql.Date start = java.sql.Date.valueOf(booking.getStartDate());
        java.sql.Date end = java.sql.Date.valueOf(booking.getEndDate());
        Object[] param = {booking.getHotelId(), booking.getRoomId(), start, end, start, end};
        //Object[] param = {1};
        ResultSet result = dbh.runQuery("SELECT * FROM booking WHERE hotelid = ? AND roomid = ? "
                +"AND ((startdate BETWEEN ? AND ?) OR (enddate BETWEEN ? AND ?))", param);
        while(result.next()) {
            if(result.getString(1)!=null) {
                System.out.println("�etta herbergi er n� �egar b�ka�");
                return null;
            }
        }
        System.out.println( "Hér er ég" );
        Object[] params = {booking.getHotelId(), booking.getRoomId(), booking.getPhoneNr(), booking.getCustomerName(),
                booking.getEmail(), booking.getCreditCardNr(), java.sql.Date.valueOf(booking.getStartDate()),
                java.sql.Date.valueOf(booking.getEndDate())};
        dbh.runQuery("INSERT INTO booking(hotelid, roomid, phonenumber, customername, " +
                "email, creditcardnumber, startdate, enddate) " +
                "VALUES (?,?,?,?,?,?,?,?)", params);

        System.out.println( "Ekki er ég" );

        Object[] par = {booking.getHotelId(), booking.getRoomId(), java.sql.Date.valueOf(booking.getStartDate())};
        ResultSet dbresults = dbh.runQuery("SELECT id FROM booking WHERE hotelid = ? AND roomid = ? AND startdate = ?", par);
        while(dbresults.next()) {
            booking.setId(dbresults.getInt(1));
        }
        return booking;
    }

    private Booking createBooking(String[] row) {
        Booking book = new Booking();
        book.setId(Integer.parseInt(row[0]));
        book.setHotelId(Integer.parseInt(row[1]));
        book.setRoomId(Integer.parseInt(row[2]));
        book.setPhoneNr(row[3]);
        book.setCustomerName(row[4]);
        book.setEmail(row[5]);
        book.setCreditCardNr(row[6]);
        book.setStartDate(row[7]);
        book.setStartDate(row[8]);
        return book;
    }
}