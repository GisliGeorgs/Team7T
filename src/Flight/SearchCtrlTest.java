import org.junit.*;
import static org.junit.Assert.*;

public class SearchCtrlTest{
	private searchCtrl ctrl1;
	private searchCtrl ctrl2;
	public static void main(String[] args){

	}
	@Before
	public void setup(){
		String destFrom="Keflavik", destTo="Zurich", dateFrom="2016-03-24", dateTo = "2016-03-24";
		int noTickets=2,price=0;
		boolean flex=false, roundTrip=true;
		ctrl1 = new searchCtrl(destFrom, destTo, dateFrom, dateTo, noTickets, price, flex, roundTrip);
		destFrom="Keflavik";
		destTo="Zurich";
		dateFrom="23. Mar";
		dateTo =  "2. Apr";
		noTickets=2;
		price=0;
		ctrl2 = new searchCtrl(destFrom, destTo, dateFrom, dateTo, noTickets, price, flex, roundTrip);	
	}
	@After
	public void tearDown(){
		ctrl1=null;
		ctrl2=null;
	}
	
	// Matti gerði (athuga hvort það sé að throwa fyrir lögleg tilfelli líka!!!!!!)
	
	@Test(expected=IllegalArgumentException.class)
	public void setUsers_test_IntegerNames()
	{
		ctrl1.setUsers(
				new String[]{"Matti14", "Petur9"}, 
				new String[]{"Johnson", "Agustsson"}, 
				new String[]{"123","1234567890123456"}, 
				new String[]{"A2198576","A3215315"});
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void setUsers_test_Passport2Long()
	{
		ctrl1.setUsers(
				new String[]{"Matti", "Petur"}, 
				new String[]{"Johnson", "Agustsson"}, 
				new String[]{"123","4589456645671234"}, 
				new String[]{"A2198576","A321531456789098765456789009876545678909876545"});
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void setUsers_test_creditcardContainsLetters()
	{
		ctrl1.setUsers(
				new String[]{"Matti", "Petur"}, 
				new String[]{"Johnson", "Agustsson"}, 
				new String[]{"12IU3","4589456MK645671234"}, 
				new String[]{"A2198576","A3215315"});
	}
	
	// Matti gerði ekki
	
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void setUsers_test_differentLengths()
	{
		ctrl1.setUsers(
				new String[]{"Matti", "Petur"}, 
				new String[]{"Johnson"}, 
				new String[]{"123",}, 
				new String[]{});
	}
	@Test
	public void setUsers_test_legal()
	throws IllegalArgumentException
	{
		ctrl1.setUsers(
				new String[]{"Matti", "Petur"}, 
				new String[]{"Johnson", "Agustsson"}, 
				new String[]{"123","4589456645671234"}, 
				new String[]{"A2198576","A3215315"});
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setUsers_test_CC_throws(){
		ctrl1.setUsers(
				new String[]{"Matti", "Petur"},
				new String[]{"Johnson","Jackson"}, 
				new String[]{"123","456789"}, 
				new String[]{"321", "654"});
	}
	
	@Test
	public void setUsers_test_CC_legal() throws IllegalArgumentException{
		ctrl1.setUsers(
				new String[]{"Matti", "Petur"},
				new String[]{"Johnson","Jackson"}, 
				new String[]{"123","4567456745674567"}, 
				new String[]{"321", "654"});
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setUsers_test_noname(){
		ctrl1.setUsers(
				new String[]{"Matti", ""},
				new String[]{"Johnson","Jackson"}, 
				new String[]{"123","456789"}, 
				new String[]{"321", "654"});
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void search_hasNull(){
		String destFrom="",destTo="",dateFrom="",dateTo="";
		int price=0,noTickets=1;
		boolean flex=false,roundTrip=true;
		searchCtrl ctrl1 = new searchCtrl(destFrom, destTo, dateFrom, dateTo, noTickets, price, flex, roundTrip);	
	}
	
	@Test
	public void search_typeNotString_legal()
			throws IllegalArgumentException{
		ctrl1.search();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void searchCtrl_constructor_test1(){
		new searchCtrl("","kef","dfd","fdf",1,1,true, true);
	}
	@Test(expected=IllegalArgumentException.class)
	public void searchCtrl_constructor_test2(){
		new searchCtrl("dfd",null,"dfd","fdf",1,1,true, true);
	}
	@Test(expected=IllegalArgumentException.class)
	public void searchCtrl_constructor_test3(){
		new searchCtrl("sds","kef","","fdf",1,1,true, true);
	}
	@Test(expected=IllegalArgumentException.class)
	public void searchCtrl_constructor_test4(){
		new searchCtrl("","kef","dfd",null,1,1,true, true);
	}
	@Test(expected=IllegalArgumentException.class)
	public void searchCtrl_constructor_test5(){
		new searchCtrl("dfd",null,"dfd","fdf",0,50000,true, true);
	}
	@Test(expected=IllegalArgumentException.class)
	public void searchCtrl_constructor_test6(){
		new searchCtrl("","kef","dfd","fdf",1,-10000,true, true);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void book_illegal_test1(){
		ctrl1.search();
		ctrl1.book(new int[]{});
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void book_illegal_test2(){
		ctrl1.search();
		ctrl1.book(new int[]{1,2,3});
	}
	
	@Test
	public void book_legal()
	throws IllegalArgumentException{
		ctrl1.setUsers(
				new String[]{"Matti", "Petur"},
				new String[]{"Johnson","Jackson"}, 
				new String[]{"123","4567456745674567"}, 
				new String[]{"321", "654"});
		ctrl1.search();
		ctrl1.book(new int[]{0,0});
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cancel_illegal_test1(){
		ctrl1.search();
		ctrl1.book(new int[]{});
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cancel_illegal_test2(){
		ctrl1.search();
		ctrl1.cancel(new int[]{1,2,3});
	}
	
	@Test
	public void cancel_legal()
	throws IllegalArgumentException{
		ctrl1.setUsers(
				new String[]{"Matti", "Petur"},
				new String[]{"Johnson","Jackson"}, 
				new String[]{"123","4567456745674567"}, 
				new String[]{"321", "654"});
		ctrl1.search();
		ctrl1.cancel(new int[]{0,0});
	}
}