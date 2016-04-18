package Flight;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Booking {
	/**
	 * The flights to book
	 */
	private Flight[] flights;
	/**
	 * The users to go on the flight
	 */
	User[] users;
	public static void main(String[] args) {

	}
	/**
	 * Constructor for creating new bookings.
	 * @param currentFlights - Array of Flight. 1<=length<=2
	 * @param currentUsers - Array of User. 1<=length
	 */
	public Booking(Flight[] currentFlights, User[] currentUsers){
		this.flights = currentFlights;
		this.users = currentUsers;
	}
	/**
	 * Confirms the booking and commits to database.
	 * @return - Returns the referenceNumber for this Booking
	 */
	public int confirm(){
		if(this.referenceNumber != -1)
			return this.referenceNumber;
		try 
		{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/throun7f","postgres","admin");
			ResultSet rs;
			Statement st = con.createStatement();
			int[] flightIds = new int[flights.length];
			PreparedStatement pst;
			String sql;
			for(int i=0;i<users.length;i++)
				users[i].createUser();
			/*for(int i=0;i<flights.length;i++){
				sql = "select id from flight where flightno=? and departuredate = ?";
				pst= con.prepareStatement(sql);
				pst.setString(1, this.flights[i].getFlightNo() );
				pst.setString(2, this.flights[i].getDeparture());
				//System.out.println(pst.toString());
				rs = pst.executeQuery();
				int flightId =-1;
				if(rs.next()){
					flightId = Integer.parseInt(rs.getString("id"));
				}
				if(flightId==-1)//rs.next()||
					throw new Exception("Database is inconsistent");
				flightIds[i]=flightId;
			}*/
			if(flights.length==2){
				sql = "insert into booking(flightid, returnflight) values (?,?); "
						+ " UPDATE  flight set seatsleft = seatsleft - ?"
						+ " WHERE id in (?,?)";
				pst = con.prepareStatement(sql);
				pst.setInt(1,flights[0].getId());
				pst.setInt(2, flights[1].getId());
				pst.setInt(3, users.length);
				pst.setInt(4,flights[0].getId());
				pst.setInt(5, flights[1].getId());
			}
			else {
				sql = "insert into booking(flightid) values (?)";
				pst = con.prepareStatement(sql);
				pst.setInt(1,flightIds[0]);
			}
			pst.executeUpdate();
			String query = "select currval('booking_id_seq')";
			rs = st.executeQuery(query);
			if ( rs.next() )
			{
				this.referenceNumber = rs.getInt(1);
			}
			if(this.referenceNumber!=-1)
				for(int i=0;i<users.length;i++){
					sql="insert into user_booking(userid, booking_id) values (?,?)";
					pst = con.prepareStatement(sql);
					pst.setInt(1, users[i].getId());
					pst.setInt(2, this.referenceNumber);
					pst.executeUpdate();
				}
			st.close();
			pst.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return this.referenceNumber;
	}
	/**
	 * Cancels the ongoing booking
	 * @return
	 */
	public void cancel(){
		if(this.referenceNumber == -1){
			this.users=null;
			this.flights=null;
			return;
		}
		
		try{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/throun7f","postgres","admin");
			PreparedStatement pst;
			//ResultSet rs;
			String sql;
			if(this.flights.length==2){
				sql  = "delete from booking where id = ?; ";
				pst = con.prepareStatement(sql);
				pst.setInt(1, this.referenceNumber);
				pst.executeUpdate();
				
				System.out.println(pst.toString());
				
				sql = " UPDATE flight SET seatsleft = seatsleft + ? WHERE id in (?,?)";
				pst = con.prepareStatement(sql);
				pst.setInt(1, this.users.length);
				pst.setInt(2, this.flights[0].getId());
				pst.setInt(3, this.flights[1].getId());
				pst.executeUpdate();			
				System.out.println(pst.toString());
			}
			else{
				sql  = "delete from booking where id = ? ";
				pst = con.prepareStatement(sql);
				pst.setInt(1, this.referenceNumber);
				pst.executeUpdate();
				System.out.println(pst.toString());
				
				sql = " UPDATE flight SET seatsleft = seatsleft + ? WHERE id in (?)";
				pst = con.prepareStatement(sql);
				pst.setInt(1, this.users.length);
				pst.setInt(2, this.flights[0].getId());
				pst.executeUpdate();
				System.out.println(pst.toString());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public Flight[] getFlights()
	{
		return this.flights;
	}
	public User[] getUsers(){
		return this.users;
	}
}