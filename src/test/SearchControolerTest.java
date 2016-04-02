package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.main.java.controller.*;
import com.main.java.persistence.Hotel;

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
	public void testSearchController() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testGetHotelHistory() {
		Assert.assertEquals(3,SearchController.GetHotelHistory(3).size());
		
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testGetSuggestionsHotelDateDateString() {
		List<Hotel> test = SearchController.GetSuggestionsHotel( new GregorianCalendar(2016, Calendar.FEBRUARY, 10), new GregorianCalendar(2016, Calendar.FEBRUARY, 20), "108");
		Assert.assertEquals( 2 , test.size() );
		//fail("Not yet implemented");
	}

	@Test
	public void testGetSuggestionsHotelDateDateStringFloat() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSuggestionsHotelDateDateStringFloatStringArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSuggestionsHotelDateDateStringStringArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindHotels() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindCloseHotels() {
		fail("Not yet implemented");
	}

}
