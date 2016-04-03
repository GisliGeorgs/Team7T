package test;

import java.io.IOException;
import java.util.ArrayList;
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
    
}
