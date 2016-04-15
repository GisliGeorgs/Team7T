package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.main.java.controller.*;
import Hotel.Hotel;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchControolerTest {
	private SearchController test1, test2;
	/*List<Hotel> hoteltest1;*/
	@Before
	public void setUp() throws Exception {
		 SearchController.TestHotels();
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testGetSuggestionsHotelDateDateString() {
		List<Hotel> test = SearchController.GetSuggestionsHotel( new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), "108");
		
		Assert.assertEquals( 2 , test.size());
		
		//fail("Not yet implemented");
	}

	@Test
	public void testGetSuggestionsHotelDateDateStringFloat() {
		List<Hotel> test = SearchController.GetSuggestionsHotel( new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), "108", 15000f);
		
		Assert.assertEquals( 1 , test.size());
	}
}