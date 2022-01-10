package it.Twitter.FollowersAnalyzer.FiltersTest;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.Twitter.FollowersAnalyzer.Exceptions.DateException;
import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.Filter.FilterByCreation;
import it.Twitter.FollowersAnalyzer.Model.User;
import junit.framework.TestCase;

class FilterByCreationTest extends TestCase{
	
	Long id=1111L;

	String created_at1="31-12-2009";
	String created_at2="10-10-2010";
	String created_at3="01-11-2011";
	
	User user=new User(id,"mirko","rkomi","00-00-0000");
	User user1=new User(id,"pippo","e non solo",created_at1);
	User user2=new User(id,"Dario","SecondDario",created_at2);
	User user3=new User(id,"Sara","SaRa4326",created_at3);
	
	

	public FilterByCreationTest() {super("Filter test");}
	
	@BeforeEach
	protected void setUp() {
		(user.getFollowers()).add(user1);
		(user.getFollowers()).add(user2);
		(user.getFollowers()).add(user3);
		//System.out.println("setUp completato");
	
	}
	
	/*Format: passiamo l'utente, la data di inizio filtraggio, la data di fine filtraggio
	 * 
	 * verranno restituiti i followers creati tra le due date
	*/

	@Test
	public void UserToString() throws NumberFormatException, DateException, NullDataException, WrongParameter {
		FilterByCreation filter= new FilterByCreation();
		System.out.println(filter.FollowerFilter(user, "01-01-2006", "null"));
	}
	
	@Test
	public void UserToString0() throws NumberFormatException, DateException, NullDataException, WrongParameter {
		FilterByCreation filter= new FilterByCreation();
		System.out.println(filter.FollowerFilter(user, "08-10-2010", "null"));
	}
	
	@Test
	public void UserToString1() throws NumberFormatException, DateException, NullDataException, WrongParameter {
		FilterByCreation filter= new FilterByCreation();
		System.out.println(filter.FollowerFilter(user, "30-12-2009", "01-01-2010"));
	}
	
	@Test
	public void UserToString2() throws NumberFormatException, DateException, NullDataException, WrongParameter {
		FilterByCreation filter= new FilterByCreation();
		System.out.println(filter.FollowerFilter(user, "09-10-2010", "11-10-2010"));
	}
	
	@Test
	public void UserToString3() throws NumberFormatException, DateException, NullDataException, WrongParameter {
		FilterByCreation filter= new FilterByCreation();
		System.out.println(filter.FollowerFilter(user, "31-10-2011", "02-11-2011"));
	}
	
	@Test
    void exceptionTesting1() {
		FilterByCreation filter= new FilterByCreation();
        DateException exception = assertThrows(DateException.class, () ->filter.FollowerFilter(user, "00-01-2021", "null"));
        assertEquals("Wrong type of data: day<1 or day>31: 0", exception.getMessage());
    }
	
	@Test
    void exceptionTesting2() {
		FilterByCreation filter= new FilterByCreation();
        DateException exception = assertThrows(DateException.class, () ->filter.FollowerFilter(user, "31-04-2021", "null"));
        assertEquals("Wrong type of data: April, June, September, November have 30 days: 31", exception.getMessage());
    }
	
	@Test
    void exceptionTesting3() {
		FilterByCreation filter= new FilterByCreation();
		WrongParameter exception = assertThrows(WrongParameter.class, () ->filter.FollowerFilter(user, "01-01-2021", "01-01-2020"));
        assertEquals("Wrong or inexistent parameter: start year > end year : 2021-2020", exception.getMessage());
    }
	
	@Test
    void exceptionTesting4() {
		FilterByCreation filter= new FilterByCreation();
		WrongParameter exception = assertThrows(WrongParameter.class, () ->filter.FollowerFilter(user, "02-01-2021", "01-01-2021"));
        assertEquals("Wrong or inexistent parameter: start day > end day : 2-1", exception.getMessage());
    }
	 
	@Test
    void exceptionTesting5() {
		FilterByCreation filter= new FilterByCreation();
		WrongParameter exception = assertThrows(WrongParameter.class, () ->filter.FollowerFilter(user, "non sono", "una data"));
        assertEquals("Wrong or inexistent parameter: Use correct form of data: dd-mm-yyyy", exception.getMessage());
    }
	
	@Test
    void exceptionTesting6() {
		FilterByCreation filter= new FilterByCreation();
		WrongParameter exception = assertThrows(WrongParameter.class, () ->filter.FollowerFilter(user, "0l-0l-2020", "0S-0S-2020"));
        assertEquals("Wrong or inexistent parameter: Use only numbers: dd-mm-yyyy: 0l-0l-2020 0S-0S-2020", exception.getMessage());
    }
	 
	@AfterEach
	public void tearDown() throws Exception {}
}


