package com.main.java.form;

import java.util.ArrayList;
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
    private List<HotelOrder> hotelOrder;
    private List<FlightOrder> flightOrder;
    private List<DayTripOrder> tripOrder;
        
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
			System.out.println("\nJSON Object: " + obj);
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
	 
	            System.out.println("Mail: " + email);
	            System.out.println("Gender: " + gender);
	            System.out.println("Age: " + age);
	            System.out.println("\nInterests:");
	            Iterator<String> iterator = interests.iterator();
	            while (iterator.hasNext()) 
	            {
	                System.out.println(iterator.next());
	            }
	
	            System.out.println("\nPastOrderNumbers:");
	            Iterator<String> iterator2 = pastOrderNumbers.iterator();
	            while (iterator2.hasNext()) 
	            {
	                System.out.println(iterator2.next());
	            }	 
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
    
    
    public void SaveOrder( String orderN, List<DayTripOrder> trip, List<FlightOrder> flight, List<HotelOrder> hotel ) throws IOException{
        /* Vista breyturnar uppi í MyDocs? */  
        String homeLoc = System.getProperty("user.home") + "/readme2.txt"; 
    	JSONObject object = new JSONObject();
    	File f = new File(homeLoc);
        if(f.exists() && !f.isDirectory()) {        
	    	JSONParser parser = new JSONParser();	 
	        try {	 
	            Object obj = parser.parse(new FileReader(homeLoc));	 
	            object = (JSONObject) obj;	 	 
        	} catch (Exception e) {
            	e.printStackTrace();
        	}
        }
        //Add stuff
        object.put(orderN + "F", flight);
        object.put(orderN + "D", trip);
        object.put(orderN + "H", hotel);
        //End of Add Stuff
		// try-with-resources statement based on post comment below :)
		try (FileWriter file = new FileWriter(homeLoc)) {
			file.write(object.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
		}
    }
    public void LoadOrder(String orderNum){
        /* Lesa fæl úr MyDocs? */
        String homeLoc = System.getProperty("user.home") + "/readme2.txt";    	
        File f = new File(homeLoc);
        if(f.exists() && !f.isDirectory()) {        
	    	JSONParser parser = new JSONParser();	 
	        try {	 
	            Object obj = parser.parse(new FileReader(homeLoc));	 
	            JSONObject jsonObject = (JSONObject) obj;
	 
	            flightOrder = (List<FlightOrder>) jsonObject.get(orderNum + "F");
	            hotelOrder = (List<HotelOrder>) jsonObject.get(orderNum + "H");
	            tripOrder = (List<DayTripOrder>) jsonObject.get(orderNum + "D");
	            	 
        	} catch (Exception e) {
            	e.printStackTrace();
        	}
        }
    }

    
    
    
}