
public class Flight {
	/**
	 * identical id number of flight
	 */
	private int id;
	/**
	 * Flight number
	 */
	private String flightNo;
	/**
	 * Departure location
	 */
	private String destFrom;
	/**
	 * Arrival location
	 */
	private String destTo;
	/**
	 * Number of seats left on this Flight
	 */
	private int remSeats;
	/**
	 * Price
	 */
	private int price;
	/**
	 * Departure date
	 */
	private String departure;
	/**
	 * Airline
	 */
	private String airline;
	/**
	 * Departure time
	 */
	private String departureTime;
	/**
	  * Constructor for Flight. No argument can be null or have zero length
	 * @param flightNumber
	 * @param depdest
	 * @param arrdest
	 * @param availSeats
	 * @param pricing
	 * @param departureDate
	 * @param departureTime
	 * @param airlineName
	 */
	public Flight(int id, String flightNumber, String depdest, String arrdest, int availSeats, int pricing, String departureDate,String departureTime, String airlineName){
		this.id=id;
		this.flightNo=flightNumber;
		this.destFrom=depdest;
		this.destTo=arrdest;
		this.remSeats=availSeats;
		this.price=pricing;
		this.remSeats=availSeats;
		this.price=pricing;
		this.departure=departureDate;
		this.airline=airlineName;
		this.departureTime = departureTime;
	}
	public int getId(){
		return this.id;
	}
	/**
	 * @return - Returns the flight number of this instance's Flight
	 */
	public String getFlightNo(){
		return this.flightNo;
	}
	/**
	 * @return - Returns the location of departure of this instance's Flight
	 */
	public String getdestFrom(){
		return this.destFrom;
	}
	/**
	 * @return - Returns the location of arrival of this instance's Flight
	 */
	public String getdestTo(){
		return this.destTo;
	}
	/**
	 * @return - Returns the remaining seats of this instance's Flight
	 */
	public int getRemSeats(){
		return this.remSeats;
	}
	/**
	 * @return - Returns the price of this instance's Flight
	 */
	public int getPrice(){
		return this.price;
	}
	/**
	 * @return - Returns the departure date of this instance's Flight
	 */
	public String getDeparture(){
		return this.departure;
	}
	public String getDepTime(){
		return this.departureTime;
	}
	/**
	 * @return - Returns the airline of this instance's Flight
	 */
	public String getAirline(){
		return this.airline;
	}
	/**
	 * Used to sort through Flights by different parameters
	 * @param i
	 * @return - Returns the desired attribute
	 */
	public String getStringAttribute(int i){
		if(i==0){
			return this.flightNo;
		}
		if(i==1){
			return this.destFrom;
		}
		if(i==2){
			return this.destTo;
		}
		if(i==5){
			return this.departure;
		}
		if(i==6){
			return this.airline;
		}
		else{
			return ""; 
		}
	}
	/**
	 * Used to sort through Flights by different parameters
	 * @param i
	 * @return - Returns the desired attribute
	 */
	public int getIntAttribute(int i){
		if(i==3){
			return this.remSeats;
		}
		if(i==4){
			return this.price;
		}
		else{
			return -1;
		}
	}

}