package it.Twitter.FollowersAnalyzer.StatsTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.Model.User;
import it.Twitter.FollowersAnalyzer.Stats.StatFollowersRange;

/** Questa classe TestFollowersRange testa alcuni metodi ed eccezioni della classe {@link it.Twitter.FollowersAnalyzer.Stats.StatFollowersRange StatFollowersRange}.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.Stats.StatFollowersRange StatFollowersRange
 */
class TestFollowersRange {
	long id=1111L;

	User user=new User(id,"mirko","rkomi","00-00-0000");
	User user1=new User(id,"pippo","e non solo","00-00-0000");
	User user2=new User(id,"Dario","SecondDario","00-00-0000");
	User user3=new User(id,"Sara","SaRa4326","00-00-0000");
	User user4=new User(id,"Pluto","Plutone","00-00-0000");
	User user5=new User(id,"Mattia","Matty","00-00-0000");

	/**
	 * Metodo che inizializza i dati necessari per effettuare i test: in questo caso un profilo utente con 5 followers e i loro rispettivi followers.
	 */
	@BeforeEach
	protected void setUp() {
		(user.getFollowers()).add(user1);
		(user.getFollowers()).add(user2);
		(user.getFollowers()).add(user3);
		(user.getFollowers()).add(user4);
		(user.getFollowers()).add(user5);

		for(int i=0; i<100;i++)(user1.getFollowers()).add(user);
		for(int i=0; i<75;i++) (user2.getFollowers()).add(user);
		for(int i=0; i<50;i++) (user3.getFollowers()).add(user);
		for(int i=0; i<25;i++) (user4.getFollowers()).add(user);
		for(int i=0; i<10;i++) (user5.getFollowers()).add(user);
		//System.out.println("setUp completato");

	}

	/*	User1=100 followers
	 *  User2=75 followers
	 *  User3=50 followers
	 *  User4=25 followers
	 *  User5=10 followers
	 */

	/*	Il conteggio viene fatto in modo che venga compreso l'estremo superiore:
	 * 
	 *  esempio: BETWEEN_25_50    utente con    25< n.followers <=50
	 *  esempio: LESS_10    	  utente con    n.followers <=10
	 *  esempio: MORE_100    	  utente con    n.followers >100
	 *  
	 */

	/**
	 * Test che verifica il corretto funzionamento del metodo di stampa secondo il parametro <b>number</b>.
	 * 
	 * @throws WrongParameter
	 */
	@Test
	void testFollowersRange1() throws WrongParameter {
		StatFollowersRange statRange= new StatFollowersRange(user.getFollowers());
		System.out.println(statRange.StatToString("number"));
	}

	/**
	 * Test che verifica il corretto funzionamento del metodo di stampa secondo il parametro <b>percentage</b>.
	 * 
	 * @throws WrongParameter
	 */
	@Test
	void testFollowersRange2() throws WrongParameter {
		StatFollowersRange statRange= new StatFollowersRange(user.getFollowers());
		System.out.println(statRange.StatToString("percentage"));
	}

	/**
	 * Test che verifica il corretto funzionamento del lancio dell'eccezione <b>WrongParameter</b> nel caso venga inserito un parametro non valido.
	 */
	@Test
	void exceptionTesting() {
		StatFollowersRange statRange= new StatFollowersRange(user.getFollowers());
		WrongParameter exception = assertThrows(WrongParameter.class, () ->statRange.StatToString("xxx"));
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
