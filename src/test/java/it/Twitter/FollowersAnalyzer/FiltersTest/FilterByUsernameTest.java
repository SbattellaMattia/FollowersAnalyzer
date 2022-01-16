package it.Twitter.FollowersAnalyzer.FiltersTest;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.Filter.FilterByUsername;
import it.Twitter.FollowersAnalyzer.Model.User;

/** Questa classe FilterByUsernameTest testa un metodo della classe {@link it.Twitter.FollowersAnalyzer.Filter.FilterByUsername FilterByUsername}.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.Filter.FilterByUsername FilterByUsername
 */
class FilterByUsernameTest {
	
	User user=new User(0000L,"mirko","rkomi","00-00-0000");
	User user1=new User(1111L,"pippo","e non solo","00-00-0000");
	User user2=new User(2222L,"Dario","SecondDario","00-00-0000");
	User user3=new User(3333L,"Sara","SaRa4326","00-00-0000");
	User user4=new User(4444L,"Pluto","Plutone","00-00-0000");
	User user5=new User(5555L,"Mattia","Matty","00-00-0000");
	
	/**
	 * Metodo che inizializza i dati necessari per effettuare i test: in questo caso i followers di un utente.
	 */
	@BeforeEach
	protected void setUp() {
		
		(user.getFollowers()).add(user1);
		(user.getFollowers()).add(user2);
		(user.getFollowers()).add(user3);
		(user.getFollowers()).add(user4);
		(user.getFollowers()).add(user5);
		
		//System.out.println("setUp completato");
	}
	
	
	/*	Supponiamo che User abbia 5 followers: User1,User2,User3,User4,User5
	 *  
	 * 
	 * 
	 * Ci aspettiamo dunque che il filtro ci ritorni:
	 * 		con method="all":
	 * 			User1,User2,User3,User4,User5
	 * 		con method="{username}":
	 * 			User con username={username}
	 */
	
	/**
	 * Test che verifica il corretto funzionamento del metodo <b>FilterFollower</b>. La <Code>String</Code> restituita dal metodo deve rispettare i criteri dell'esempio soprastante nel caso del metodo <b>all</b>.
	 * 
	 * @throws NumberFormatException
	 * @throws NullDataException
	 * @throws WrongParameter
	 */
	@Test
	void testFilterByUsername1() throws  NumberFormatException, NullDataException, WrongParameter {
		FilterByUsername UsernameFilter= new FilterByUsername();
		System.out.println(UsernameFilter.FilterFollower(user,"all"));
	}
	
	/**
	 * Test che verifica il corretto funzionamento del metodo <b>FilterFollower</b>. La <Code>String</Code> restituita dal metodo deve rispettare i criteri dell'esempio soprastante nel caso del metodo <b>{username}</b>.
	 * 
	 * @throws ParseException
	 * @throws NullDataException
	 * @throws WrongParameter
	 */
	@Test
	void testFilterByUsername2() throws  NumberFormatException, NullDataException, WrongParameter {
		FilterByUsername UsernameFilter= new FilterByUsername();
		System.out.println(UsernameFilter.FilterFollower(user, "e non solo"));
	}
	
	/**
	 * Distrugge ciò che è stato inizializzato da metodo setUp.
	 * 
	 * @throws Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {}

}
