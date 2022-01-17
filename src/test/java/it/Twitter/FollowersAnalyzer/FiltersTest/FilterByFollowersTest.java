package it.Twitter.FollowersAnalyzer.FiltersTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.Filter.FilterByFollowers;
import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Model.User;

/** Questa classe FilterByFollowersTest testa un metodo e un'eccezione della classe {@link it.Twitter.FollowersAnalyzer.Filter.FilterByFollowers FilterByFollowers}.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.Filter.FilterByFollowers FilterByFollowers
 */
class FilterByFollowersTest {

	User user=new User(0000L,"mirko","rkomi","00-00-0000");
	User user1=new User(1111L,"pippo","e non solo","00-00-0000");
	User user2=new User(2222L,"Dario","SecondDario","00-00-0000");
	User user3=new User(3333L,"Sara","SaRa4326","00-00-0000");
	User user4=new User(4444L,"Pluto","Plutone","00-00-0000");
	User user5=new User(5555L,"Mattia","Matty","00-00-0000");
	
	Tweet tweet= new Tweet(0000L,"Ciaoo");
	
	/**
	 * Metodo che inizializza i dati necessari per effettuare i test: in questo caso inserisce un tweet al profilo dell'utente, setta 4 followers e i 3 like al tweet prima citato.
	 */
	@BeforeEach
	protected void setUp() {
		(user.getTweets()).add(tweet);
		
		(user.getFollowers()).add(user1);
		(user.getFollowers()).add(user2);
		(user.getFollowers()).add(user3);
		(user.getFollowers()).add(user4);
		
		(tweet.getLikingUsers()).add(user1);
		(tweet.getLikingUsers()).add(user2);
		(tweet.getLikingUsers()).add(user5);
		//System.out.println("setUp completato");
	
	}
	
	/*	Supponiamo User abbia fatto un tweet: "tweet"
	 * 
	 *  Supponiamo inoltre che User abbia 4 followers: User1,User2,User3,User4
	 *  
	 * 	Il tweet ha 3 like da: User1,User2, User5(non follower di User)
	 * 
	 * Ci aspettiamo dunque che il filtro ci ritorni:
	 * 		con method="all":
	 * 			User1,User2,User5
	 * 		con method="followers":
	 * 			User1,User2		
	 */
	
	
	/**
	 * Test che verifica il corretto funzionamento del metodo <b>Filter</b>. La <Code>String</Code> restituita dal metodo deve rispettare i criteri dell'esempio soprastante nel caso del metodo <b>all</b>.
	 * 
	 * @throws NumberFormatException
	 * @throws NullDataException
	 * @throws WrongParameter
	 */
	@Test
	void testFilterByFollowers1() throws  NumberFormatException, NullDataException, WrongParameter {
		FilterByFollowers FollowersFilter= new FilterByFollowers();
		System.out.println(FollowersFilter.Filter(user, tweet, "all"));
	}
	
	/**
	 * Test che verifica il corretto funzionamento del metodo <b>Filter</b>. La <Code>String</Code> restituita dal metodo deve rispettare i criteri dell'esempio soprastante nel caso del metodo <b>followers</b>.
	 * 
	 * @throws NumberFormatException
	 * @throws NullDataException
	 * @throws WrongParameter
	 */
	@Test
	void testFilterByFollowers2() throws  NumberFormatException, NullDataException, WrongParameter {
		FilterByFollowers FollowersFilter= new FilterByFollowers();
		System.out.println(FollowersFilter.Filter(user, tweet, "followers"));
	}
	
	/**
	 * Test che verifica il corretto funzionamento del lancio dell'eccezione <b>WrongParameter</b> nel caso di inserimento di un parametro non valido.
	 */
	@Test
    void exceptionTesting() {
		FilterByFollowers FollowersFilter= new FilterByFollowers();
        WrongParameter exception = assertThrows(WrongParameter.class, () ->FollowersFilter.Filter(user, tweet, "xxx"));
        assertEquals("Wrong or inexistent parameter: \"xxx\" is not allowed", exception.getMessage());
    }
	
	/**
	 * Distrugge cio' che e' stato inizializzato dal metodo setUp.
	 * 
	 * @throws Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {}

}
