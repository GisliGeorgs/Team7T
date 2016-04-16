package Flight;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class FetchData {

	public static void main(String[] args) {
		
		JSONParser parser = new JSONParser();
		try {

			Object obj = parser.parse(new FileReader("lib/departure.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray results = (JSONArray) jsonObject.get("results");
			int n = results.size();
			try 
			{
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection( "jdbc:postgresql://ec2-54-225-103-29.compute-1.amazonaws.com:5432/d4smhu9p4oq75g?sslmode=require&user=ssslrghrzfpjnu&password=tqT0v2HZHynlHRwYxZ1fz2ZL7M");//, "ssslrghrzfpjnu", "tqT0v2HZHynlHRwYxZ1fz2ZL7M");
				//Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/throun7f","postgres","postgres");
				String date;
				String flightNo;
				String airline;
				String arrDest;
				String depDest="Keflavik";
				String depDate;
				int seatsLeft;
				int price;
				for(int i =0;i<n;i++){
					JSONObject flight = (JSONObject) results.get(i);
					seatsLeft= (int)(Math.random()*200);
					price    = (int)(Math.random()*100000+20000);
					flight   = (JSONObject) results.get(i);
					date     = (String) flight.get("date");
					flightNo = (String) flight.get("flightNumber");
					airline  = (String) flight.get("airline");
					arrDest  = (String) flight.get("to");
					depDate  = (String) flight.get("plannedArrival");
					String newdate=buildDate(date);
					String sql = "insert into \"FlightFlight\"(flightno, destfrom, destto, seatsleft, price, departuredate,departureTime, airline) values (?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, flightNo);
					pst.setString(2, depDest);
					pst.setString(3, arrDest);
					pst.setInt(4,seatsLeft);
					pst.setInt(5,price);
					//pst.setDate(6,new java.sql.Date(newdate.getTime()));
					pst.setDate(6, java.sql.Date.valueOf(newdate.toString()));
					pst.setString(7, depDate);
					pst.setString(8,airline);
					pst.executeUpdate();
				}
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		parser = new JSONParser();
		try {

			Object obj = parser.parse(new FileReader("lib/arrival.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray results = (JSONArray) jsonObject.get("results");
			int n = results.size();
			try 
			{
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection( "jdbc:postgresql://ec2-54-225-103-29.compute-1.amazonaws.com:5432/d4smhu9p4oq75g?sslmode=require&user=ssslrghrzfpjnu&password=tqT0v2HZHynlHRwYxZ1fz2ZL7M");//, "ssslrghrzfpjnu", "tqT0v2HZHynlHRwYxZ1fz2ZL7M");
				//Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/throun7f","postgres","postgres");				
				String date;
				String flightNo;
				String airline;
				String arrDest="Keflavik";
				String depDest;
				String depDate;
				int seatsLeft;
				int price;
				for(int i =0;i<n;i++){
					JSONObject flight = (JSONObject) results.get(i);
					seatsLeft= (int)(Math.random()*200);
					price    = (int)(Math.random()*100000+20000);
					flight   = (JSONObject) results.get(i);
					date     = (String) flight.get("date");
					flightNo = (String) flight.get("flightNumber");
					airline  = (String) flight.get("airline");
					depDest  = (String) flight.get("from");
					depDate  = (String) flight.get("plannedArrival");
					String newdate=buildDate(date);
					String sql = "insert into \"FlightFlight\"(flightno, destfrom, destto, seatsleft, price, departuredate,departureTime, airline) values (?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, flightNo);
					pst.setString(2, depDest);
					pst.setString(3, arrDest);
					pst.setInt(4,seatsLeft);
					pst.setInt(5,price);
					pst.setDate(6, java.sql.Date.valueOf(newdate.toString()));
					pst.setString(7, depDate);
					pst.setString(8,airline);
					pst.executeUpdate();
				}
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static String buildDate(String date){
		String month;
		String a =date.substring(date.length()-3,date.length());
		switch(a){
		case("Jan"):
			month="01";
			break;
		case("Feb"):
			month="02";
			break;
		case("Mar"):
			month="03";
			break;
		case("Apr"):
			month="04";
			break;
		case("May"):
			month="05";
			break;
		case("Jun"):
			month="06";
			break;
		case("Jul"):
			month="07";
			break;
		case("Aug"):
			month="08";
			break;
		case("Sep"):
			month="09";
			break;
		case("Oct"):
			month="10";
			break;
		case("Nov"):
			month="11";
			break;
		case("Dec"):
			month="12";
			break;
		default:
			month="01";
			break;
		}
		String day=date.substring(0,date.length()-5);
		Date newDate = new Date();
		//newDate.setDate(Integer.parseInt(day));
		//newDate.setYear(2016-1900);
		//newDate.setMonth(month);
		
		System.out.println(newDate);
		return "2016-"+month+"-"+day;
	}
}