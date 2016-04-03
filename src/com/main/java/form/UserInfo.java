package com.main.java.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.main.java.persistence.*;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 

public class UserInfo{
    private String gender;
    private int age;
    private List<String> interests;
    private List<String> pastOrderNumbers;
    private String email;
    public HotelOrder hotelOrder;
    public FlightOrder flightOrder;
    public DayTripOrder tripOrder;
        
    public UserInfo( ){
        LoadUser();
    }
    
    public UserInfo( String email, String gender, int age, List<String> interests ){
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.interests = interests;
        this.pastOrderNumbers = new ArrayList<String>(){};
    }

    public void SaveUser() throws IOException{
    	JSONObject obj = new JSONObject();
		obj.put("Gender", gender);
		obj.put("Age", age);
		obj.put("Email", email);
 
		JSONArray jInterest = new JSONArray();
		for(int k = 0; k < interests.size(); k++)
		{
			jInterest.add(interests.get(k));
		}
		obj.put("Interests", jInterest);
 
		JSONArray jPastOrderNumbers = new JSONArray();
		for(int i = 0; i < pastOrderNumbers.size(); i++)
		{
			jPastOrderNumbers.add(pastOrderNumbers.get(i));			
		}
		obj.put("Past Order Numbers", jPastOrderNumbers);
        
        String homeLoc = System.getProperty("user.home") + "/SuperSecret.txt";
 
		// try-with-resources statement based on post comment below :)
		try (FileWriter file = new FileWriter(homeLoc)) {
			file.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			//System.out.println("\nJSON Object: " + obj);
		}
    }
    public void LoadUser(){
        String homeLoc = System.getProperty("user.home") + "/SuperSecret.txt";
    	
        File f = new File(homeLoc);
        if(f.exists() && !f.isDirectory()) {        
	    	JSONParser parser = new JSONParser();	 
	        try {
	    		System.out.println( 000 );
	 
	            Object obj = parser.parse(new FileReader(homeLoc));
	 
	            JSONObject jsonObject = (JSONObject) obj;

	    		System.out.println( 000 );
	            email = (String) jsonObject.get("Email");
	            gender = (String) jsonObject.get("Gender");
	            age = (Integer) Integer.parseInt(jsonObject.get("Age").toString());
	            interests = (JSONArray) jsonObject.get("Interests");
	            pastOrderNumbers = (JSONArray) jsonObject.get("Past Order Numbers");
	            /*
	            System.out.println("Mail: " + email);
	            System.out.println("Gender: " + gender);
	            System.out.println("Age: " + age);
	            System.out.println("\nInterests:");
	            */
	    		System.out.println( 000 );
	            Iterator<String> iterator = interests.iterator();
	           /* while (iterator.hasNext()) 
	            {

	        		System.out.println( 000 );
	                //System.out.println(iterator.next());
	            }*/

	    		System.out.println( 000 );
	            System.out.println("\nPastOrderNumbers:");
	            Iterator<String> iterator2 = pastOrderNumbers.iterator();
	            while (iterator2.hasNext()) 
	            {
	                //System.out.println(iterator2.next());
	            }	 
	    		System.out.println( 000 );
        	} catch (Exception e) {
            	e.printStackTrace();
        	}
        }
    }

    public String GetEmail(){ return email; }
    public void SetEmail( String email ){
        this.email = email;
    }

    public String GetGender(){ return gender; }
    public void SetGender( String gender ){
        this.gender = gender;
    }
    
    public int GetAge(){
        return age;
    }
    public void SetAge( int age ){
        this.age = age;
    }
    
    public List<String> GetInterests(){
        return interests;
    }
    public void SetInterests( String interest ){
        this.interests.add( interest );
    }
    
    public List<String> GetPastOrderNumbers(){
        return pastOrderNumbers;
    }
    public void SetPastOrderNumber( String order ){
        this.pastOrderNumbers.add( order );
    }
    
    
    public void SaveOrder( String orderN, DayTripOrder trip, FlightOrder flight, HotelOrder hotel ) throws IOException{
        /* Vista breyturnar uppi í MyDocs? */  
        String homeLoc = System.getProperty("user.home") + "/readme2.txt"; 
    	JSONObject object = SaveHotels(orderN, hotel);
        //Add stuff     
        
        //End of Add Stuff
		// try-with-resources statement based on post comment below :)
		try (FileWriter file = new FileWriter(homeLoc)) {
			file.write(object.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			pastOrderNumbers.add(orderN);
		}
    }
    public void LoadOrder(String orderNum){
        /* Lesa fæl úr MyDocs? */
    	hotelOrder = new HotelOrder();
        String homeLoc = System.getProperty("user.home") + "/readme2.txt";    	
        File f = new File(homeLoc);
        if(f.exists() && !f.isDirectory()) {     	 
	        try {	    
		    	JSONParser parser = new JSONParser();
	            Object obj = parser.parse(new FileReader(homeLoc));	 
	            JSONObject jsonObject = (JSONObject) obj;
	            
	            //Hotels
	            HotelOrder hotelorderMini = new HotelOrder();
	            ArrayList hotelObject = (ArrayList) jsonObject.get(orderNum + "H");
	            for(int i = 0; i < hotelObject.size(); i++){
	            	ArrayList temp = (ArrayList) hotelObject.get(i);
	            	double fff = (double) temp.get(7);
	            	float kkk = (float) fff;
	            	JSONArray hola = (JSONArray) temp.get(8);
	            	String[] arr = hola.toString().replace("},{", " ,").split(" ");
	            	GregorianCalendar greg = new GregorianCalendar(Integer.parseInt(temp.get(2).toString()), Integer.parseInt(temp.get(1).toString()), Integer.parseInt(temp.get(0).toString()));
	            	GregorianCalendar greg2 = new GregorianCalendar(Integer.parseInt(temp.get(5).toString()), Integer.parseInt(temp.get(4).toString()), Integer.parseInt(temp.get(3).toString()));
	            	Hotel hoe = new Hotel((String) temp.get(6), greg, greg2, kkk, arr);
	            	hotelOrder.AddHotel(hoe);
	            	//public Hotel( String loc,GregorianCalendar dateFrom, Calendar dateTo, Float price, String[] keywords )
	            }
	            	            	 
        	} catch (Exception e) {
            	e.printStackTrace();
        	}
        }
    }
    
    private JSONObject SaveHotels(String Ordernumr, HotelOrder hotel){    
    	JSONObject obj = new JSONObject();
        String homeLoc = System.getProperty("user.home") + "/readme2.txt"; 
    	File f = new File(homeLoc);
        if(f.exists() && !f.isDirectory()) {        
	    	JSONParser parser = new JSONParser();	 
	        try {	 
	            Object obje = parser.parse(new FileReader(homeLoc));	 
	            obj = (JSONObject) obje;	 	 
        	} catch (Exception e) {
            	e.printStackTrace();
        	}
        }
		JSONArray jHotels = new JSONArray();
		for(int k = 0; k < hotel.GetHotel().size() ; k++)
		{
			JSONArray jHotel = new JSONArray();
			jHotel.add(hotel.GetHotel().get(k).getDateFrom().MONTH);
			jHotel.add(hotel.GetHotel().get(k).getDateFrom().DATE);
			jHotel.add(hotel.GetHotel().get(k).getDateFrom().YEAR);
			jHotel.add(hotel.GetHotel().get(k).getDateTo().MONTH);
			jHotel.add(hotel.GetHotel().get(k).getDateTo().DATE);
			jHotel.add(hotel.GetHotel().get(k).getDateTo().YEAR);
			jHotel.add(hotel.GetHotel().get(k).getLocation());
			jHotel.add(hotel.GetHotel().get(k).getPrice());
			JSONArray jKeywords = new JSONArray();
			for(int i = 0; i < hotel.GetHotel().get(k).getKeywords().length; i++ ){
				jKeywords.add(hotel.GetHotel().get(k).getKeywords()[i]);
			}
			jHotel.add(jKeywords);
			jHotels.add(jHotel);
		}
		obj.put(Ordernumr + "H", jHotels);
		return obj;
    }
    
    
    
}