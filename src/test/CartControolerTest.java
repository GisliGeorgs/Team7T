package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.main.java.controller.*;
import com.main.java.form.UserInfo;
import com.main.java.persistence.Hotel;
import com.main.java.persistence.HotelOrder;

import junit.framework.Assert;

public class CartControolerTest {
	
	UserInfo user;
	HotelOrder test = new HotelOrder();
	CartController cart;// = new CartController();
	@Before
	public void setUp() throws Exception {
		user = new UserInfo();
		cart = new CartController();
	    cart.AddHotelToBooking( new Hotel( "109", new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), 25000f, new String[]{ "Relaxing", "Adventure", "Golf" }  ));
		cart.AddHotelToBooking( new Hotel( "108", new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), 11000f, new String[]{ "Extreme", "Boring", "Beachy" }  ));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateCartOrder() {
		String testt = cart.CreateCartOrder();		
		Assert.assertEquals( true,  cart.user.GetPastOrderNumbers().contains(testt));
		//fail("Not yet implemented");
	}
	
	@Test
	public void testAddHotelToBooking(){
		cart.AddHotelToBooking( new Hotel( "102", new GregorianCalendar( 2016, Calendar.MARCH, 6 ), new GregorianCalendar( 2016, Calendar.MARCH, 15), 400f, new String[]{ "Toff", "POPP", "Lockathon" } ));
		String testt = cart.CreateCartOrder();		
		Assert.assertEquals( true,  cart.user.GetPastOrderNumbers().contains(testt));
	}

}
