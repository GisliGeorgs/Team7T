package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.main.java.controller.*;
import com.main.java.persistence.Hotel;
import com.main.java.persistence.HotelOrder;

public class CartControolerTest {
	
	HotelOrder test = new HotelOrder();
	CartController cart = new CartController();
	@Before
	public void setUp() throws Exception {

		test.AddHotel( new Hotel( "109", new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), 25000f, new String[]{ "Relaxing", "Adventure", "Golf" }  ));
		test.AddHotel( new Hotel( "108", new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), 11000f, new String[]{ "Extreme", "Boring", "Beachy" }  ));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateCartOrder() {
		cart.CreateCartOrder();
		//fail("Not yet implemented");
	}

}
