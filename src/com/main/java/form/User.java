package com.main.java.form;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Hotel.Hotel;
import com.main.java.persistence.*;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class User{
    private String gender;
    private int age;
    private List<String> interests;
    private List<String> pastOrderNumbers;
    private String email;
    public String hotelId;

	public String getHotelId() { return hotelId; }
	public String getFlightId() { return flightId; }
	public String getTripId() { return tripId; }

	public String flightId;
    public String tripId;
        
    public User( ){
        LoadUser();
        if( pastOrderNumbers == null ) pastOrderNumbers = new ArrayList<String>();
    }
    
    public User( String email, String gender, int age, List<String> interests ){
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.interests = interests;
        this.pastOrderNumbers = new ArrayList<String>(){};
    }
    /**
     * Saver userinn
     * @throws IOException
     */
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
		}
    }
    public void LoadUser(){
        String homeLoc = System.getProperty("user.home") + "/SuperSecret.txt";
    	
        File f = new File(homeLoc);
        if(f.exists() && !f.isDirectory()) {        
	    	JSONParser parser = new JSONParser();	 
	        try {	 
	            Object obj = parser.parse(new FileReader(homeLoc));
	 
	            JSONObject jsonObject = (JSONObject) obj;

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
	            
	            Iterator<String> iterator = interests.iterator();
	            while (iterator.hasNext()) 
	            {
	                //System.out.println(iterator.next());
	            }

	            System.out.println("\nPastOrderNumbers:");
	            Iterator<String> iterator2 = pastOrderNumbers.iterator();
	            while (iterator2.hasNext()) 
	            {
	                //System.out.println(iterator2.next());
	            }*/
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
    
    
    public void SaveOrder( String orderN, String tripKey, String flightKey, String hotelKey, String name ) throws IOException{
        /* Vista breyturnar i my docs*/  
    	//Hotel
        String homeLoc = System.getProperty("user.home") + "/readme1.txt";
    	JSONObject object = SaveHotel(orderN, hotelKey);
    	if(hotelKey != null && !hotelKey.isEmpty()){
			try (FileWriter file = new FileWriter(homeLoc)) {
				file.write(object.toJSONString());
				System.out.println("Successfully Copied (Hotel)JSON Object to File...");
			}
    	}		
		//Flight
    	if(  flightKey != null && !flightKey.isEmpty() ){
	        homeLoc = System.getProperty("user.home") + "/readme2.txt"; 
	    	object = SaveFlight(orderN, flightKey);
			try (FileWriter file = new FileWriter(homeLoc)) {
				file.write(object.toJSONString());
				System.out.println("Successfully Copied (Flight)JSON Object to File...");
			}
    	}		
		//Trip
    	if( tripKey != null && !tripKey.isEmpty()){
			homeLoc = System.getProperty("user.home") + "/readme3.txt"; 
	    	object = SaveTrip(orderN, tripKey);
			try (FileWriter file = new FileWriter(homeLoc)) {
				file.write(object.toJSONString());
				System.out.println("Successfully Copied (DayTrip)JSON Object to File...");
			}
    	}
    	System.out.println(orderN);
		pastOrderNumbers.add(orderN);
    }
    
    public void LoadOrder(String orderNum){
       LoadHotel(orderNum);        
       LoadFlight(orderNum);        
       LoadTrip(orderNum);        
    }
    
    private void LoadHotel(String orderNum)
    {
    	String homeLoc = System.getProperty("user.home") + "/readme1.txt";    	
        File f = new File(homeLoc);
        if(f.exists() && !f.isDirectory()) {     	 
	        try {	    
		    	JSONParser parser = new JSONParser();
	            Object obj = parser.parse(new FileReader(homeLoc));	 
	            JSONObject jsonObject = (JSONObject) obj;	            
	            //Hotel
	            hotelId = (String) jsonObject.get(orderNum);
	            }
	            	            	 
        	catch (Exception e) {
            	e.printStackTrace();
        	}
        }
    }
    
    private void LoadFlight(String orderNum)
    {
    	String homeLoc = System.getProperty("user.home") + "/readme2.txt";    	
        File f = new File(homeLoc);
        if(f.exists() && !f.isDirectory()) {     	 
	        try {	    
		    	JSONParser parser = new JSONParser();
	            Object obj = parser.parse(new FileReader(homeLoc));	 
	            JSONObject jsonObject = (JSONObject) obj;
	            //Flight
	            flightId = (String) jsonObject.get(orderNum);
	            }	            	            	 
        	catch (Exception e) {
            	e.printStackTrace();
        	}
        }
    }
    
    private void LoadTrip(String orderNum)
    {
    	String homeLoc = System.getProperty("user.home") + "/readme3.txt";    	
        File f = new File(homeLoc);
        if(f.exists() && !f.isDirectory()) {     	 
	        try {	    
		    	JSONParser parser = new JSONParser();
	            Object obj = parser.parse(new FileReader(homeLoc));	 
	            JSONObject jsonObject = (JSONObject) obj;
	            //Trips
	            tripId = (String) jsonObject.get(orderNum);
	            }
	            	            	 
        	catch (Exception e) {
            	e.printStackTrace();
        	}
        }
    }
    
    private JSONObject SaveHotel(String Ordernumr, String key){    
    	JSONObject obj = new JSONObject();
        String homeLoc = System.getProperty("user.home") + "/readme1.txt"; 
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
		obj.put(Ordernumr, key);
		return obj;
    }
    
    private JSONObject SaveFlight(String Ordernumr, String key){    
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
		obj.put(Ordernumr, key);
		return obj;
    }

    
    private JSONObject SaveTrip(String Ordernumr, String key){    
    	JSONObject obj = new JSONObject();
        String homeLoc = System.getProperty("user.home") + "/readme3.txt"; 
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
		obj.put(Ordernumr, key);
		return obj;
    }
    
    
}