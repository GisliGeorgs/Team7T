
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserInterface {
	private String[] destFrom;
	private String[] destTo;
	private String[] lastName;
	private String[] firstName;
	private String[] cardNumber;
	private String[] passport;
	private boolean round;
	private boolean flex;
	private int money;
	private String destinationFrom; //a leid ut
	private String destinationTo; //a leid heim
	private String dateFrom; //a leid ut
	private String dateTo; //a leid heim
	
	public static void main(String[] args) {
		UserInterface ui= new UserInterface();
		String[] fs=new String[] {"Pétur"};
		String[] ls=new String[] {"Pabbason"};
		String[] cc=new String[] {"4564564578914567"};
		String[] pp=new String[] {"A2198576"};
		boolean roundy=true;
		boolean flexy=true;
		int datMoney=1000000;
		String deploc="Keflavik";
		String arrloc="Zurich";
		String depdate="2016-03-24";
		String arrdate="2016-03-29";
		ui.setLastName(ls);
		ui.setFirstName(fs);
		ui.setCardNumber(cc);
		ui.setPassport(pp);
		ui.setRound(roundy);
		ui.setFlex(flexy);
		ui.setMoney(datMoney);
		ui.setDepartureLocation(deploc);
		ui.setArrivalLocation(arrloc);
		ui.setDepartureDate(depdate);
		ui.setReturnDate(arrdate);
		
		searchCtrl searchctrl = new searchCtrl(ui.getDepartureLocation(), ui.getArrivalLocation(), 
				ui.getDepartureDate(), ui.getReturnDate(), ui.getLastName().length,ui.getMoney(), ui.getFlex(), ui.getRound());
		//if(!searchctrl.getRound())
		//	dateTo=null;
		Flight[] departingFlight = (Flight[])searchctrl.search()[0];
		int n = departingFlight.length;
		if(n==0)
			System.out.println("Því miður fundust engin flug frá "+searchctrl.getDepartureLocation()+" til "+searchctrl.getArrivalLocation());
		else{
			System.out.println("Eftirfarandi flug fundust frá "+
		searchctrl.getDepartureLocation()+" til "+searchctrl.getArrivalLocation());
			System.out.println("----------------");
			for(int i=0;i<n;i++)
			{
				System.out.println("Indexnúmer flugs: "+i);
				System.out.println("ID number: "+departingFlight[i].getId());
				System.out.println("Dagsetning: "+departingFlight[i].getDeparture());
				System.out.println("Tími: "+departingFlight[i].getDepTime());
				System.out.println("Flugnúmer: "+departingFlight[i].getFlightNo());
				System.out.println("Remaining seats: "+departingFlight[i].getRemSeats());
				System.out.println("Verð: "+departingFlight[i].getPrice());
				System.out.println("Flugfélag: "+departingFlight[i].getAirline());
				System.out.println("----------------");
			}
		}
		Flight[] returnFlight= (Flight[])searchctrl.search()[1];
		int m = returnFlight.length;
		if(m==0)
			System.out.println("Því miður fundust engin flug frá "+searchctrl.getArrivalLocation()+" til "+searchctrl.getDepartureLocation()+"\n");
		else {
			System.out.println("Eftirfarandi flug fundust frá "+searchctrl.getArrivalLocation()+" til "+searchctrl.getDepartureLocation());
			System.out.println("----------------");
			for(int i=0;i<m;i++)
			{
				System.out.println("Indexnúmer flugs: "+i);
				System.out.println("ID number: "+returnFlight[i].getId());
				System.out.println("Dagsetning: "+returnFlight[i].getDeparture());
				System.out.println("Tími: "+returnFlight[i].getDepTime());
				System.out.println("Flugnúmer: "+returnFlight[i].getFlightNo());
				System.out.println("Remaining seats: "+returnFlight[i].getRemSeats());
				System.out.println("Verð: "+returnFlight[i].getPrice());
				System.out.println("Flugfélag: "+returnFlight[i].getAirline());
				System.out.println("----------------\n");
			}
		}
		searchctrl.setUsers(ui.getFirstName(), ui.getLastName(), ui.getCardNumber(), ui.getPassport());
		User[] users = new User[ui.getLastName().length];
		if(users.length>0)
			System.out.println("Passenger information");
		for(int i=0;i<users.length;i++){
			users[i]=new User(ui.getFirstName()[i], ui.getLastName()[i], ui.getCardNumber()[i], ui.getPassport()[i]);
			users[i].createUser();
			System.out.println("First name: "+ui.getFirstName()[i]);
			System.out.println("Last name: "+ui.getLastName()[i]);
			if(ui.getCardNumber()[i].length()==16)
				System.out.println("XXXX-XXXX-XXXX-"+ ui.getCardNumber()[i].substring(12));	
			System.out.println("Passport number: "+ui.getPassport()[i]);
			System.out.println("----------------\n");
		}
		
		int flightOut;
		int flightHome;
		if(n!=0){
			StdOut.print("Vinsamlegast veldu indexnumer flugs sem ter list best a, milli 0 og "+(n-1)
				+".\nSladu inn -1 til ad haetta\n");
			flightOut=StdIn.readInt();
			while(flightOut>=n)
				flightOut=StdIn.readInt();
		}
		if(m!=0){
			StdOut.print("Vinsamlegast veldu indexnumer flugs sem ther list best a, milli 0 og "+ (m-1)
				+".\nSladu inn -1 til ad haetta\n");
			flightHome=StdIn.readInt();
			while(flightHome>=m)
				flightHome=StdIn.readInt();
		}
		//FlightCtrl ctrl = new FlightCtrl(users, ui.getDepartureLocation(), ui.getArrivalLocation(), ui.getLastName().length,
		//		ui.getMoney(), ui.getDepartureDate(), ui.getFlex());
		int[] flights;
		if(n!=0&&m!=0)
			flights=new int[2];
		else if(n!=0)
			flights=new int[1];
		else flights=new int[0];
		System.out.println("legnd: "+flights.length);
		int referencenumber;
		if(flights.length==2)
			referencenumber = searchctrl.book(flights);
		else if(flights.length==1){
				referencenumber = searchctrl.book(flights);
				System.out.println(referencenumber);
		}
		else {
			searchctrl.cancel(flights);
			referencenumber = -1;
		}
		if(referencenumber == -1)
			System.out.println("\nHætt var við bókun");
		else System.out.println("\nBókun staðfest.\nBókunarnúmer þitt er "+referencenumber);
		
		StdOut.println("Viltu eyda bokun nr "+referencenumber+"?");
		if(StdIn.readInt()!=0){
			Booking booking = new Booking(referencenumber);
			for(int i = 0;i<booking.getUsers().length;i++)
			{
				System.out.println("Nafn: "+booking.getUsers()[i].getLast());
			}
			booking.cancel();
		}
	}
	
	public  UserInterface(){
		/*System.out.println("Hello, welcome to this flight kiosk!");
		System.out.println("1. will you be taking a round trip with us? Enter \"y\" for yes and \"n\" for no");
		String r=StdIn.readString();
		r="y";
		if(r.equals("y")){
			this.round=true;
		}
		else{
			this.round=false;
		}
		System.out.println("2. How many are flying?");
		int c=StdIn.readInt();
		c=1;
		this.lastName = new String[c];
		this.firstName= new String[c];
		this.cardNumber=new String[c];
		this.passport  =new String[c];
		int i;
		boolean noCard=true;
		for(i=0;i<c;i++){
			System.out.println("Please, enter the last name of person number "+(i+1));
			this.lastName[i]=StdIn.readString();
			this.lastName[i]="g";
			System.out.println("Please, enter the first name of person number "+(i+1));
			this.firstName[i]=StdIn.readString();
			this.firstName[i]="dfdf";
			if(noCard){
				System.out.println("If this is the person paying, please enter your creditcard "
						+ "\n number, else just press enter");
			}
			this.cardNumber[i]=StdIn.readString();
			this.cardNumber[i]="1234123412341234";
			if(this.cardNumber[i].compareTo("")!=0){
				noCard=false;
			}
			System.out.println("Please, enter the passport number of person number "+(i+1));
			this.passport[i]=StdIn.readString();
			this.passport[i]="A15151";
		}
		System.out.println("3. From our available departure locations, seen below, please choose "
				+ "\n the number of that location");
		try 
		{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/throun7f","postgres","admin");
			String sql = "select distinct destfrom from flight order by destfrom desc";
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			rs.last();
			int count=rs.getRow();
			rs.beforeFirst();
			int its=0;
			this.destFrom  	   = new String[count];
			while(rs.next()){
				this.destFrom[its]   = rs.getString("destfrom");
				its++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		for(i=0;i<this.destFrom.length;i++){
			System.out.println((i+1)+". "+this.destFrom[i]);
		}
		int flightFromNum = StdIn.readInt()-1;
		this.destinationFrom=this.destFrom[flightFromNum];
		System.out.println(this.destinationFrom);
		
		System.out.println("4. From our available arrival locations for your departure "
				+ "location, \n"+destinationFrom+", please choose the number of that location");
		
		try 
		{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/throun7f","postgres","admin");
			String sql = "select distinct destto from flight where destfrom=?";
			PreparedStatement pst = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pst.setString(1, this.destinationFrom);
			ResultSet rs = pst.executeQuery();
			rs.last();
			int count=rs.getRow();
			rs.beforeFirst();
			int its=0;
			this.destTo = new String[count];
			while(rs.next()){
				this.destTo[its]   = rs.getString("destto");
				its++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		for(i=0;i<this.destTo.length;i++){
			System.out.println((i+1)+". "+this.destTo[i]);
		}
		int flightToNum = StdIn.readInt()-1;
		flightToNum=0;
		this.destinationTo=this.destTo[flightToNum];
		
		System.out.println("5. How much money in ISK are you willing to pay?");
		this.money = StdIn.readInt();
		this.money=1000000;
		System.out.println("6a. Please enter, in the format DD/MM/YYYY, what date you want to fly out.");
		this.dateTo=StdIn.readString();
		this.dateTo="23/03/2016";
		if(round){
			System.out.println("6b. Since you are making a round trip please enter the date \n"
					+ "you want to fly back home.");
			this.dateFrom=StdIn.readString();
			this.dateFrom="24/03/2016";
		}
		else{
			this.dateFrom="";
		}
		System.out.println("7. Do you want flexible results? Enter \"y\" for yes and \"n\" for no");
		String f = StdIn.readString();
		f="n";
		if(f.equals("y")){
			this.flex=true;
		}
		else{
			this.flex=false;
		}*/
	}
	public String[] getLastName(){
		return this.lastName;
	}
	public String[] getFirstName(){
		return this.firstName;
	}
	public String[] getCardNumber(){
		return this.cardNumber;
	}
	public String[] getPassport(){
		return this.passport;
	}
	public boolean getRound(){
		return this.round;
	}
	public boolean getFlex(){
		return this.flex;
	}
	public int getMoney(){
		return this.money;
	}
	public String getDepartureLocation(){
		return this.destinationFrom;
	}
	public String getArrivalLocation(){
		return this.destinationTo;
	}
	public String getDepartureDate(){
		return this.dateFrom;
	}
	public String getReturnDate(){
		return this.dateTo;
	}
	public void setLastName(String[] a){
		 this.lastName=a;
	}
	public void setFirstName(String[] a){
		 this.firstName=a;
	}
	public void setCardNumber(String[] a){
		 this.cardNumber=a;
	}
	public void setPassport(String[] a){
		 this.passport=a;
	}
	public void setRound(Boolean a){
		 this.round=a;
	}
	public void setFlex(Boolean a){
		 this.flex=a;
	}
	public void setMoney(int a){
		 this.money=a;
	}
	public void setDepartureLocation(String a){
		 this.destinationFrom=a;
	}
	public void setArrivalLocation(String a){
		 this.destinationTo=a;
	}
	public void setDepartureDate(String a){
		this.dateFrom=a;
	}
	public void setReturnDate(String a){
		if(this.getRound())
			this.dateTo=a;	
	}
}