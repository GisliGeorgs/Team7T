package DayTrip.klasar;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DatabaseConnection {
	
	private String addTouristQuery;
	private String getTripIDQuery;
	private String findTouristQuery;
	private String getTouristQuery;
	private String addBookingQuery;
	private String searchTripQuery;
	private String searchFestivalQuery;
	private String getTripsQuery;
	private PreparedStatement pstatement;
	private Connection conn;
	private ResultSet rs; 
	private ResultSet tresult;
	private String currentDir;
	DateFormat formatter;

	public DatabaseConnection() {
		currentDir = System.getProperty("user.dir");
		formatter = new SimpleDateFormat("yyyy-MM-dd");
	
		try {
			Class.forName("org.sqlite.JDBC");
			// TODO Breyta Ã­ localhost dÃ³tiÃ°
			conn = DriverManager.getConnection("jdbc:sqlite:"+currentDir+"\\src\\daytrips.db");
			System.out.println("Tenging er komin ï¿½");
		} catch (Exception e) {
			System.out.println( e.getMessage() );
			System.out.println("DayTrip: Ekki nï¿½ï¿½ist tenging viï¿½ gagnagrunninn");
		}	
	}
	
	public boolean book(int tripID, String touristEmail, int bookingnumber, int groupSize) {
		//int bookings = 0;
		try {
			addBookingQuery = "INSERT INTO bookings values(?,?,?)";
			pstatement = conn.prepareStatement(addBookingQuery);
			pstatement.setString(1, touristEmail);
			pstatement.setInt(2, tripID);
			pstatement.setInt(3, bookingnumber);
			pstatement.executeUpdate();

			//rs.close();
			
			//pstatement.close();
			//conn.close();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean findTourist(String email) {
		Boolean found = false;
		try {
			findTouristQuery = "SELECT * FROM tourists WHERE email='"+email+"'";
			pstatement = conn.prepareStatement(findTouristQuery);
			rs = pstatement.executeQuery();
			while(rs.next()) {
				found = true;
			}
			rs.close();
			pstatement.close();
			//conn.close();
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("Fann ekki tï¿½ristann");
			found = false;
		}
		return found;
	}
	
	public boolean addTourist(String name, String email, String country, int age) {
		try {
			addTouristQuery = "INSERT INTO tourists values(?,?,?,?)";
			pstatement = conn.prepareStatement(addTouristQuery);
			pstatement.setString(1, email);
			pstatement.setString(2, name);
			pstatement.setString(3, country);
			pstatement.setInt(4, age);
			pstatement.executeUpdate();

			//rs.close();
			//pstatement.close();

			//conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int getTripID(String daytrip, Date tripDates) {
		int id = 0;
		try {
			getTripIDQuery = "SELECT id FROM dayTrips WHERE name='"+daytrip+"' AND startDate='"+new java.sql.Date(tripDates.getTime())+"'";
			pstatement = conn.prepareStatement(getTripIDQuery);
			rs = pstatement.executeQuery();
			while(rs.next()){
				id = rs.getInt("id");
				System.out.println(id);
			}
			rs.close();
			pstatement.close();
			//conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Virkaï¿½i ekki");
		}
		return id;
	}

	public List<Trip> getTrips(DayTrip daytrip) {
		int id = 0;
		List<Trip> trips = new ArrayList<Trip>();
		try {
			pstatement = conn.prepareStatement("SELECT id FROM dayTrips WHERE name = '" + daytrip.getName() + "'");
			rs = pstatement.executeQuery();
			while(rs.next()) {
				id = rs.getInt("id");
			}

			getTripsQuery = "SELECT * from trips where dayTrip = " + id;
			pstatement = conn.prepareStatement(getTripsQuery);
			rs = pstatement.executeQuery();
			while(rs.next()) {
				Date startDate = formatter.parse(rs.getString("startdate"));
				Date endDate = formatter.parse(rs.getString("enddate"));
				int maxSize = rs.getInt("maxsize");
				int booked = rs.getInt("bookings");
				trips.add(new Trip(daytrip.getName(), startDate, endDate, maxSize, booked));
			}
			pstatement.close();
			rs.close();
			//conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trips;
	}

	public Tourist getTourist(String email) {
		String name = null;
		String email1 = null;
		String country = null;
		int age = 0;
		try{
			getTouristQuery = "SELECT * FROM tourists WHERE email='"+email+"'";
			pstatement = conn.prepareStatement(getTouristQuery);
			rs = pstatement.executeQuery();
			while(rs.next()) {
				name = rs.getString("name");
				email1 = rs.getString("email");
				country = rs.getString("country");
				age = rs.getInt("age");
			}
			rs.close();
			pstatement.close();
			//conn.close();
			Tourist tourist = new Tourist(name, email1, country, age);
			return tourist;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Gat ekki nï¿½ï¿½ ï¿½ tï¿½ristann");
			return null;
		}
	}

	public List<DayTrip> search(Date date1, Date date2, String name, String type, int size, int price, int length, String location) {
		searchTripQuery = "SELECT * FROM dayTrips";
		if(date1 != null || date2 != null || name != null || type != null || size != 0 || price != 0 || length != 0 || location != null) {
		//System.out.println("loc: " + "'" + location + "'");
			searchTripQuery += " WHERE";
			if(date1 != null) searchTripQuery += " startDate <= '" + new java.sql.Date(date1.getTime()) + "' AND";
			if(date2 != null) searchTripQuery += " endDate >= '" + new java.sql.Date(date2.getTime()) + "' AND";
			if(name != null && name != "") searchTripQuery += " name = '" + name + "' AND";
			if(type != null && type != "") searchTripQuery += " type = '" + type + "' AND";
			if(size != 0) searchTripQuery += " size <= " + size + " AND";
			if(price != 0) searchTripQuery += " price <= " + price + " AND";
			if(length != 0) searchTripQuery += " length <= " + length + " AND";
			if(location != null && location.length() != 0) searchTripQuery += " location = '" + location + "' AND";
			System.out.println( searchTripQuery );
			searchTripQuery = searchTripQuery.substring(0, searchTripQuery.lastIndexOf(" ")) + ";";
			System.out.println(searchTripQuery);
		}
		List<DayTrip> daytrips = new ArrayList<DayTrip>();
		try {
			pstatement = conn.prepareStatement(searchTripQuery);
			rs = pstatement.executeQuery();
			while(rs.next()) {
				System.out.println("Fann DayTrip.");
				name = rs.getString("name");
				price = rs.getInt("price");
				length = rs.getInt("length");
				type = rs.getString("type");
				location = rs.getString("location");
				Date startDate = formatter.parse(rs.getString("startDate"));
				Date endDate = formatter.parse(rs.getString("endDate"));
				size = rs.getInt("size");
				String extraInfo = rs.getString("extraInfo");
				int tID = rs.getInt("travelAgency");
				pstatement = conn.prepareStatement("SELECT name FROM travelAgencies WHERE id =" + tID);
				tresult = pstatement.executeQuery();
				String travelAgency = tresult.getString("name");
				daytrips.add(new DayTrip(name, length, type, travelAgency, price, location, size, extraInfo, startDate, endDate));
			}
			rs.close();
			pstatement.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return daytrips;
	}

	public List<Festival> searchFestival(Date date1, Date date2) {
		List<Festival> festivals = new ArrayList<Festival>();
		try {
			searchFestivalQuery = "SELECT * FROM festivals WHERE startDate >='"+ new java.sql.Date(date1.getTime()) +"' AND endDate <='"+ new java.sql.Date(date2.getTime())+"';";
			System.out.println(searchFestivalQuery);
			pstatement = conn.prepareStatement(searchFestivalQuery);
			rs = pstatement.executeQuery();
			while(rs.next()) {
				System.out.println("Fann festival.");
				int length = rs.getInt("length");
				String name = rs.getString("name");
				String type = rs.getString("type");
				Date startDate = formatter.parse(rs.getString("startDate"));
				Date endDate = formatter.parse(rs.getString("endDate"));
				String location = rs.getString("location");
				int price = rs.getInt("price");
				festivals.add(new Festival(length, name, type, startDate, endDate, location, price));
			}
			rs.close();
			pstatement.close();
			//conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return festivals;
	}
    /**
	 * Finnur bókun í gagnagrunningum sem á þetta bókunarnúmer. 
	 * @param currentBooking bókunarnúmer í gagnagrunni
	 * @return Object fylki þar sem fyrra stakið er Trip og seinna stakið er Tourist.
	*/
	public Object[] getBooking(int currentBooking) {
		Object[] info = new Object[2];
		int tripID = 0;
		String touristemail = "";
		String searchBookingQuery = "SELECT * FROM bookings WHERE bookingnumber = " + currentBooking;
		try {
			pstatement = conn.prepareStatement(searchBookingQuery);	
			rs = pstatement.executeQuery();
			while(rs.next()) {
				touristemail = rs.getString("tourist");
				tripID = rs.getInt("trip");
			}
			Trip trip = getTripInfo(tripID);
			Tourist tourist = getTourist(touristemail);
			info[0] = trip;
			info[1] = tourist;
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return info;
	}
	
	/**
	 * Finnur Trip í gagnagrunninum og skila því sem Trip hlut
	 * @param tripID lykill fyrir trip í gagnagrunni
	 * @return Trip hlutur sem hefur þetta ID
	 */
	public Trip getTripInfo(int tripID) {
		int dayTripID = 0;
		Date startDate = null;
		Date endDate = null;
		int maxSize = 0;
		int booked = 0;
		String dtName = "";
		String getTripQuery = "SELECT * FROM trips WHERE id = " + tripID;		
		try {
			pstatement = conn.prepareStatement(getTripQuery);
			rs = pstatement.executeQuery();
			System.out.println("daytripgettrip");
			while(rs.next()) {
				startDate = formatter.parse(rs.getString("startdate"));
				endDate = formatter.parse(rs.getString("enddate"));
				maxSize = rs.getInt("maxsize");
				booked = rs.getInt("bookings");
				dayTripID = rs.getInt("dayTrip");
			}
			System.out.println(startDate.toString());
			getTripQuery = "SELECT name FROM dayTrips WHERE id = " + dayTripID;
			pstatement = conn.prepareStatement(getTripQuery);
			rs = pstatement.executeQuery();

			System.out.println("daytripgettrip");
			while(rs.next()) {
				dtName = rs.getString("name");
			}
		}
		catch (SQLException e) {
			System.out.println("Bokun ekki til.");
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Trip trip = new Trip(dtName, startDate, endDate, maxSize, booked);		return trip;
	}

	public static void main(String[] args) {
		DatabaseConnection connect = new DatabaseConnection();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2016);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 26);
		Date date1 = cal.getTime();
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date date2 = cal.getTime();
		java.sql.Date dat = new java.sql.Date(date2.getTime());
		System.out.println(dat);
		List<Festival> found = connect.searchFestival(date1,date2);
		System.out.println(found.get(0).getName());
		List<DayTrip> founddt = connect.search(null, null, "Geysir", null, 0, 0, 0, null);
		System.out.println(founddt.get(0).getTravelAgency());
		
	}
}
