package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.main.java.form.*;

import junit.framework.Assert;

public class UserInfotest2 {
	User user;
	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSaveOrder() {
		List<String> interests = new ArrayList<String>();
		interests.add("Such");
		interests.add("and");
		interests.add("things");
		user = new User( "test@lol.is", "HVK", 0, interests );
		try {
			user.SaveUser();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String homeLoc = System.getProperty("user.home") + "/SuperSecret.txt";
    	
		boolean exists = false;
        File f = new File(homeLoc);
        if(f.exists() && !f.isDirectory()) {
        	exists = true;
        }
		Assert.assertEquals( true, exists );
	}

	@Test
	public void testLoadOrder() {
		user = new User();
		user.LoadUser();
		Assert.assertEquals( 0, user.GetAge() );
	}

}
