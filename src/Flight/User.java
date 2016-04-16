import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class User {
	/**
	 * First name of the user
	 */
	private String firstName;
	/**
	 * Last name of the user
	 */
	private String lastName;
	/**
	 * Credit card number
	 */
	private String card;
	/**
	 * Passport number
	 */
	private String passport;
	/**
	 * unique id number (hlaupandi tala fengin úr DB)
	 */
	private int id;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Before: The arguments must be non-null Strings with at least one character
	 *         Credit card can be null or have zero length
	 * After: An instance of User with it's variables initialized, id=0
	 * Constructor for User. Initializes the instance variables
	 * @param firstName - String
	 * @param lastName - String
	 * @param card - String
	 * @param passport - String
	 */
	public User(String firstName, String lastName, String card, String passport){
		if(firstName.length()==0|| lastName.length()==0||passport.length()==0)
			throw new IllegalArgumentException("Name and passport must not be empty");
		this.firstName=firstName;
		this.lastName=lastName;
		this.card=card;
		this.passport=passport;
		this.id=0;
	}
	/**
	 * Usage:	ref = createUser();
	 * Before:  The instance variables must have been initialized
	 * After:	This instance's User is now in the database, only once.
	 * 			Users are distinguished by their passport number.
	 * @return - Returns the user_id of this instance's User, acquired from the database. 
	 */
	public int createUser()
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/throun7f","postgres","admin");
			String sql= "select id from \"user\" where passport=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, this.passport);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				this.id=(Integer.parseInt(rs.getString("id")));
				return Integer.parseInt(rs.getString("id"));
			}
			sql = "insert into \"user\"(firstname, lastname, card, passport) values (?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, this.firstName);
			pst.setString(2, this.lastName);
			pst.setString(3, this.card);
			pst.setString(4, this.passport);
			pst.executeUpdate();
			this.id = 1;
			return this.id;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}

	public void setFirst(String name)
	{
		this.firstName=name;
	}
	public void setLast(String name){
		this.lastName=name;
	}
	public void setCard(String card){
		this.card=card;
	}
	public void setPassport(String passport){
		this.passport=passport;
	}

	public String getFirst()
	{
		return this.firstName;
	}
	public String getLast(){
		return this.lastName;
	}
	public String getCard(){
		return this.card;
	}
	public String getPassport(){
		return this.passport;
	}
	public int getId()
	{
		return this.id;
	}
}
