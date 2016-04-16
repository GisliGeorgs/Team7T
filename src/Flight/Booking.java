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
	Flight[] flights;
	/**
	 * The users to go on the flight
	 */
	User[] users;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * Constructor.
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
		int referenceNumber = 0;
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
			for(int i=0;i<flights.length;i++){
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
				
			}
			if(flights.length==2){
				sql = "insert into booking(flightid, returnflight) values (?,?)";
				pst = con.prepareStatement(sql);
				pst.setInt(1,flightIds[0]);
				pst.setInt(2, flightIds[1]);
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
				referenceNumber = rs.getInt(1);
			}
			
			for(int i=0;i<users.length;i++){
				sql="insert into user_booking(userid, booking_id) values (?,?)";
				pst = con.prepareStatement(sql);
				pst.setInt(1, users[i].getId());
				pst.setInt(2, referenceNumber);
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
		return referenceNumber;
	}
	/**
	 * Cancels the ongoing booking
	 * @return
	 */
	public int cancel(){
		return -1;
	}

}