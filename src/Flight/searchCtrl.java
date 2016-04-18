import java.util.Vector;
public class searchCtrl {
	/**
	 * Departure location
	 */
	private String destFrom;
	/**
	 * Arrival location
	 */
	private String destTo;
	/**
	 * Departure date
	 */
	private String dateFrom;
	/**
	 * Arrival date if applicable
	 */
	private String dateTo;
	/**
	 * Number of tickets to book
	 */
	private int noTickets;
	/**
	 * Want flexible dates?
	 */
	private Boolean flex;
	/**
	 * Want to fly home?
	 */
	private Boolean roundTrip;
	/**
	 * The users to book
	 */
	private User[] users;
	/**
	 * Maximum price for a flight
	 */
	private int price;
	//private FlightCtrl flightctrl;
	/**
	 * Search results from user's input.
	 * searchResults[i].class == Flight[].class
	 * searchResults[0]=flights available "out"
	 * searchResults[1]=flights available "home"
	 */
	private Object[] searchResults;
	
	/**
	 * 
	 */
	private Booking booking;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String destFrom = "Keflavik";
		String destTo 	= "Dublin";
		String dateFrom = "23/3/2016";
		String dateTo	= "24/3/2016";
		int noTickets	= 5;
		Boolean flex = false;
		Boolean roundTrip = true;
		User aba = new User("Aba", "Abson","1234567890123456", "Aba123");
		User raba = new User("RAba", "RAbson"," ", "RAba123");
		User paba = new User("PAba", "PAbson"," ", "PAba123");
		User kraba = new User("KrAba", "KrAbson"," ", "KrAba123");
		User pjaba = new User("PjAba", "PjAbson"," ", "PjAba123");
		User[] crewzers = new User[]{aba,raba,paba,kraba, pjaba};*/
		
		/*searchCtrl searchctrl = new searchCtrl(destFrom, destTo, dateFrom, dateTo, noTickets, flex, roundTrip);
		if(!searchctrl.roundTrip)
			dateTo=null;
		Flight[] departingFlight = searchctrl.search(dateFrom, destFrom, destTo);
		System.out.println(departingFlight.length);
		Flight[] returnFlight = searchctrl.search(dateTo, destTo, destFrom);
		int i=(int)(departingFlight.length*Math.random());
		int j=(int)(returnFlight.length*Math.random());
		
		String[] fn=new String[noTickets];
		String[] ln=new String[noTickets];
		String[] cc=new String[noTickets];
		String[] pp=new String[noTickets];

		searchctrl.setUsers(fn, ln, cc, pp);
		if(returnFlight.length!=0)
			System.out.println("RA: "+searchctrl.flightctrl.book(new Flight[]{departingFlight[i], returnFlight[j]}));
		else
			System.out.println("RA: "+searchctrl.flightctrl.book(new Flight[]{departingFlight[i]}));*/
		//searchCtrl ctrl = new searchCtrl("1", "0", "0", "0", 0,0, true, false);
		//Flight[] fl = ctrl.search(null, null, null);
	}
	/**
	 * Contstructor
	 * @param destFrom -String
	 * @param destTo -String
	 * @param dateFrom -String
	 * @param dateTo -String YYYY-MM-D
	 * @param noTickets-int>0
	 * @param price-int>=0
	 * @param flex - boolean
	 * @param roundTrip - boolean
	 */
	public searchCtrl(String destFrom, String destTo, String dateFrom, String dateTo, int noTickets, int price, boolean flex, boolean roundTrip){
		if(destFrom==null || destTo==null || dateFrom==null||(String)(""+noTickets)==null
				||destFrom.length()==0||destTo.length()==0||dateFrom.length()==0||dateTo.length()==0
				||noTickets<=0||price<0)
			throw new IllegalArgumentException("Illegal arguments for constructor");
		if(dateTo==null)
			roundTrip=false;
		if(price==0)
			price=Integer.MAX_VALUE;
		if(dateTo!=null)
			roundTrip=true;
		this.destFrom=destFrom;
		this.destTo=destTo;
		this.dateFrom=dateFrom;
		this.dateTo=dateTo;
		this.noTickets=noTickets;
		this.flex = flex;
		this.roundTrip=roundTrip;
		this.users=new User[noTickets];
		this.price=price;
	}
	

	/**
	 * Checks if a String contains a digit
	 * @param s
	 * @return true if s contains a digit
	 */
	public static boolean isInteger(String s) {
		return s.matches(".*\\d+.*");
	}
	/**
	 * Searches for the given parameters for the constructor
	 * @return Object[0] = Flight[] - contains flights out
	 * 		   Object[1] = Flight[] - contains flights home
	 */
	public Object[] search()
	{
		/*if(date==null||destFrom==null||destTo==null
				|| date.length()==0||destFrom.length()==0||destTo.length()==0)
			throw new IllegalArgumentException("Arguments must not be empty strings or null");
		
		this.flightctrl = new FlightCtrl(this.users, destFrom, destTo, this.noTickets,100000000, date, this.flex);
		return flightctrl.generateFlights();
		*/
		
		FlightCtrl ctrl  = new FlightCtrl(this.users, this.destFrom, this.destTo, this.noTickets,this.price, this.dateFrom, this.flex);
		int n=1;
		if(this.roundTrip)
			n++;
		Object[] results = new Object[n];
		results[0]=(Flight[])ctrl.generateFlights();
		
		//System.out.println(ctrl.generateFlights().length);
		if(n!=1)
		{
			ctrl  = new FlightCtrl(this.users, this.destTo, this.destFrom, this.noTickets,this.price, this.dateTo, this.flex);
			results[1]=(Flight[])ctrl.generateFlights();
		}
		this.searchResults=results;
		return results;
	}
	/**
	 * books the given flights by integer
	 * @param indices - int[].length==(1||2)
	 * 					indices[i] < flights.length
	 * @return - Returns the referenceNumber of the confirmed booking
	 */
	public int book(int[] indices){
		if(((Flight[])this.searchResults[0]).length==0&&((Flight[])this.searchResults[1]).length==0)
			return -1;
		if(indices==null||indices.length<1||indices.length>2)
			throw new IllegalArgumentException("Argument must be of length 1 or 2");
		int[] n = new int[indices.length];
		for(int i=0;i<n.length;i++)
			n[i]=this.searchResults.length;
		
		Flight[] flights = new Flight[n.length];
		
		for(int i = 0;i<n.length;i++)
			if(indices[i]>=n[i]||indices[i]<0)
				throw new IndexOutOfBoundsException("Flight does not exist.");
			else {
				flights[i]=((Flight[])this.searchResults[i])[indices[i]];
			}
		this.booking = new Booking(flights,this.users);
		return booking.confirm();
	}
	/**
	 * Same as book(indices), but cancels
	 * @param indices - same as book(indices)
	 */
	public void cancel(int[] indices){
		if(((Flight[])this.searchResults[0]).length==0||((Flight[])this.searchResults[1]).length==0)
			return;
		int[] n = new int[indices.length];
		for(int i=0;i<n.length;i++)
			n[i]=this.searchResults.length;
		
		if(indices==null||indices.length<1||indices.length>2)
			throw new IllegalArgumentException("Argument must be of length 1 or 2");
		
		Flight[] flights = new Flight[n.length];
		
		for(int i = 0;i<n.length;i++)
			if(indices[i]>=n[i]||indices[i]<0)
				throw new IndexOutOfBoundsException("Flight does not exist.");
			else {
				flights[i]=((Flight[])this.searchResults[i])[indices[i]];
			}
		Booking booking = new Booking(flights,this.users);
		
		booking.cancel();
	}
	/**
	 * Sets this instanjces users and commits to DB if legal arguments
	 * @param lastName - array of lastnames
	 * @param firstName - array of firstnames
	 * @param card - array of creditcards. At least one must contain exactly 16 chars.
	 * @param passport - array of passports
	 */
	public void setUsers(String[] lastName, String[] firstName, String[] card, String[] passport)
	{
		for(int i = 0; i!=passport.length; i++)
		{
			if(passport[i].length()>21)
			{
				throw new IllegalArgumentException("Your passport number is too long");
			}
		}
		for(int i = 0; i!=lastName.length; i++)
		{
			if(isInteger(lastName[i]))
			{
				throw new IllegalArgumentException("Your name include an Integer");
			}
		}
		
		for(int i = 0; i!=firstName.length; i++)
		{
			if(isInteger(firstName[i]))
			{
				throw new IllegalArgumentException("Your name cannot be an Integer");
			}
		}
		for(int i = 0; i!=card.length; i++)
		{
			if(!(isInteger(card[i])))
			{
				throw new IllegalArgumentException("Your creditcard number cannot contain letters");
			}
		}
		
		boolean hasCredit=false;
		int n=lastName.length;
		if(n!=firstName.length||n!=card.length||n!=passport.length||n!=this.noTickets)
		{
			throw new IndexOutOfBoundsException("Please fill out all neccessary forms");
		}
		
		for(int i=0;i<n;i++){
			if(card[i].length()==16){
				hasCredit=true;
			}
		}

		if(hasCredit)
			for(int i=0;i<n;i++){
				this.users[i]= new User(firstName[i],lastName[i],card[i],passport[i]);
				this.users[i].createUser();
			}
		else
			throw new IllegalArgumentException("No credit card given");
	}

	public boolean getRound(){
		return this.roundTrip;
	}
	public boolean getFlex(){
		return this.flex;
	}
	public int getMoney(){
		return this.price;
	}
	public String getDepartureLocation(){
		return this.destFrom;
	}
	public String getArrivalLocation(){
		return this.destTo;
	}
	public String getDepartureDate(){
		return this.dateFrom;
	}
	public String getReturnDate(){
		return this.dateTo;
	}
}
