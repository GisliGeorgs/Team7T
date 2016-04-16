
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FlightCtrl {
	
	public static void main(String[] args){
		/*User demoUser = new User("atli","sigurgeirsson","12346","12565");
		FlightCtrl flctrl = new FlightCtrl(new User[]{demoUser,demoUser},"Keflavik","Dublin",2,231510,"23/3/2016",false);
		Flight[] flights = flctrl.generateFlights();
		flctrl.sortByNum(3,1,0,flights.length-1);
		for(int i=0;i<flights.length;i++){
			System.out.println(flights[i].getRemSeats());
		}*/
	}
	/**
	 * The flights for given parameters
	 */
	private Flight[] flight;
	/**
	 * The users to book on a selected flight
	 */
	User[] users;
	/**
	 * Constructor
	 * @param currentUsers - User[]
	 * @param destFrom - String
	 * @param destTo - String
	 * @param noTickets - String
	 * @param price - int
	 * @param departureDate - boolean
	 * @param flex - boolean
	 */
	public FlightCtrl(User[] currentUsers, String destFrom, String destTo, int noTickets, int price, String departureDate, boolean flex){
		this.users=currentUsers;
		try 
		{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/throun7f","postgres","admin");
			String sql;
			PreparedStatement pst;
			if(!flex){
				sql= "SELECT * FROM flight"
						+ " WHERE destfrom=?"
						+ " AND destto=?"
						+ " AND seatsleft>=?"
						+ " AND price<=?"
						+ " AND departuredate = ? "
						+ " ORDER BY departuredate ASC, departuretime ASC, price ASC";
				pst = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				pst.setString(1, destFrom);
				pst.setString(2, destTo);
				pst.setInt(3, noTickets);
				pst.setInt(4, price);
				pst.setDate(5, java.sql.Date.valueOf(departureDate));
			}
			else{
				sql= "SELECT * FROM flight "
						+ " WHERE destfrom=?"
						+ " AND destto=?"
						+ " AND seatsleft>=? "
						+ " AND price<=?"
						+ " AND DATE_PART('day', ?::timestamp - departuredate::timestamp) between -5 and 5 "
						+ " ORDER BY departuredate ASC, departuretime, PRICE ASC";
				pst = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				pst.setString(1, destFrom);
				pst.setString(2, destTo);
				pst.setInt(3, noTickets);
				pst.setInt(4, price);
				pst.setDate(5, java.sql.Date.valueOf(departureDate));
			}
			//System.out.println(pst.toString());
			
			ResultSet rs = pst.executeQuery();
			rs.last();
			int count=rs.getRow();
			rs.beforeFirst();
			this.flight=new Flight[count];
			int its=0;
			String flightno;
			String airline;
			String departureTime;
			while(rs.next()){
				flightno   = rs.getString("flightno");
				destFrom   = rs.getString("destfrom");
				destTo     = rs.getString("destto");
				noTickets  = rs.getInt("seatsleft");
				price      = rs.getInt("price");
				departureDate  = rs.getDate("departuredate").toString();
				departureTime = rs.getString("departuretime");
				airline    = rs.getString("airline");
				flight[its]=new Flight(flightno,destFrom,destTo,noTickets,price,departureDate,departureTime,airline);
				its++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * @return Returns the flights that match the given parameters
	 */
	public Flight[] generateFlights(){
		return this.flight;
	}
	/**
	 * Deprecated.
	 * @param flights
	 * @param confirm
	 * @return
	 */
	public int book(Flight[] flights, boolean confirm){
		///int referencenumber;
		Booking booking = new Booking(flights,this.users);
		if(!confirm)
			return booking.cancel();	
		return booking.confirm();
	}
	/**
	 * Sorts the flights by whatever parameter
	 * @param sortBy - int. Parameter to sort by (=3 or =4)
	 * @param direction - int. Sort ascending (= 0) or descending(otherwise)
	 * @param lowerIndex - int
	 * @param higherIndex - int
	 */
	public  void sortByNum(int sortBy, int direction, int lowerIndex, int higherIndex){
		int i = lowerIndex;
        int j = higherIndex;
        int pivot = this.flight[(lowerIndex+(higherIndex-lowerIndex)/2)].getIntAttribute(sortBy);
        while (i <= j) {
        	if(direction==0){
        		while (this.flight[i].getIntAttribute(sortBy) < pivot) {
        			i++;
        		}
        		while (this.flight[j].getIntAttribute(sortBy) > pivot) {
        			j--;
        		}
        	}
        	else{
        		while (this.flight[i].getIntAttribute(sortBy) > pivot) {
        			i++;
        		}
        		while (this.flight[j].getIntAttribute(sortBy) < pivot) {
        			j--;
        		}
        	}
            if (i <= j) {
                exchangeFlights(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            sortByNum(sortBy,direction,lowerIndex, j);
        if (i < higherIndex)
            sortByNum(sortBy,direction,i,higherIndex);
	}
	/**
	 * See sortByNum
	 * @param sortBy {0,1,2,5,6}
	 * @param direction
	 * @param lowerIndex
	 * @param higherIndex
	 */
	public  void sortByString(int sortBy, int direction, int lowerIndex, int higherIndex){
		int i = lowerIndex;
        int j = higherIndex;
        String pivot = this.flight[(lowerIndex+(higherIndex-lowerIndex)/2)].getStringAttribute(sortBy);
        while (i <= j) {
        	if(direction==0){
        		while (this.flight[i].getStringAttribute(sortBy).compareTo(pivot)<0) {
        			i++;
        		}
        		while (this.flight[j].getStringAttribute(sortBy).compareTo(pivot)>0) {
        			j--;
        		}
        	}
        	else{
        		while (this.flight[i].getStringAttribute(sortBy).compareTo(pivot)>0) {
        			i++;
        		}
        		while (this.flight[j].getStringAttribute(sortBy).compareTo(pivot)<0) {
        			j--;
        		}
        	}
            if (i <= j) {
                exchangeFlights(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            sortByString(sortBy,direction,lowerIndex, j);
        if (i < higherIndex)
            sortByString(sortBy,direction,i,higherIndex);
	}
	/**
	 * Before: i,j < flight.length
	 * Afater: We have swapped flights i and j
	 * @param i
	 * @param j
	 */
	public void exchangeFlights(int i, int j) {
	        Flight temp = this.flight[i];
	        this.flight[i] = this.flight[j];
	        this.flight[j] = temp;
	}
}