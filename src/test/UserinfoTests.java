package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.main.java.persistence.*;
import com.main.java.form.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.main.java.form.UserInfo;

public class UserinfoTests {
	
	public UserInfo uuser;
	
    public static void main( String[] args)
    {    	
    	UserinfoTests k = new UserinfoTests();	
    	k.stuff2();
    }
    
    public void stuff()
    {
    	List<String> origList = new ArrayList<>();
        origList.add("a");
        origList.add("b");
        
    	uuser = new UserInfo("meru@meee.isadsfadsf", "hvorugkguuuuuuuuuuu", 150, origList );
    	
    	try {
			uuser.SaveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void stuff2()
    {
    	List<String> origList = new ArrayList<>();
        origList.add("a");
        origList.add("b");
        
    	uuser = new UserInfo("meru@meee.is", "hvorugkyh", 100, origList );
    	
    	uuser.LoadUser();
    }
    
    public void stuff3()
    {
    	List<Hotel> hoteltest1 = new ArrayList<Hotel>();		
		hoteltest1.add(new Hotel( "102", new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), 10000f, new String[]{ "Fun", "Old", "Golf" }  ));
    	HotelOrder hoe = new HotelOrder(hoteltest1);
		uuser.SaveOrder("9894AA", trip, flight, hoteltest1);
    }
    
}
