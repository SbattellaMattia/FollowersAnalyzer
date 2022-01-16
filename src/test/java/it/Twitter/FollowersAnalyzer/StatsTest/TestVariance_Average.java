package it.Twitter.FollowersAnalyzer.StatsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Model.User;
import it.Twitter.FollowersAnalyzer.Stats.StatAverage;
import it.Twitter.FollowersAnalyzer.Stats.StatVariance;

/** Questa classe TestVariation_Average testa alcuni metodi delle classi {@link it.Twitter.FollowersAnalyzer.Stats.StatVariance StatVariance} e {@link it.Twitter.FollowersAnalyzer.Stats.StatAverage StatAverage}.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.Stats.StatVariance StatVarince
 * @see it.Twitter.FollowersAnalyzer.Stats.StatAverage StatAverage
 */
class TestVariance_Average {
	long id=1111L;

	User user=new User(id,"mirko","rkomi","00-00-0000");
	User user1=new User(id,"pippo","e non solo","00-00-0000");
	User user2=new User(id,"Dario","SecondDario","00-00-0000");
	User user3=new User(id,"Sara","SaRa4326","00-00-0000");


	/**
	 * Metodo che inizializza i dati necessari per effettuare i test: in questo caso un profilo utente con 3 followers e i loro rispettivi followers.
	 */
	@BeforeEach
	protected void setUp() {
		(user.getFollowers()).add(user1);
		(user.getFollowers()).add(user2);
		(user.getFollowers()).add(user3);

		for(int i=0; i<2;i++)(user1.getFollowers()).add(user);
		for(int i=0; i<5;i++) (user2.getFollowers()).add(user);
		for(int i=0; i<8;i++) (user3.getFollowers()).add(user);
		//System.out.println("setUp completato");

	}

	/*	Ipotizziamo l'Utente abbia 3 followers:
	 *  il primo con 2 followers
	 *  il secondo con 5 followers
	 *  il terzo con 8 followers
	 *  
	 *  La media sara': 
	 *  (2+5+8)/3=  5
	 *  
	 *  La varianza sara':
	 *  ((2-5)^2+(5-5)^2+(8-5)^2)/(3-1)=
	 *  (9+0+9)/2= 9
	 *  
	 *  */

	/**
	 * Test che verifica l'uguaglianza fra il valore restituito dal metodo getVarianza e quello calcolato manualmente (in questo caso uguale a 9.0).
	 * 
	 * @throws NullDataException
	 */
	@Test
	void testVarianza() throws NullDataException {
		StatVariance statVarianza= new StatVariance(user);
		assertEquals( 9.0 ,statVarianza.getVarianza());
	}

	/**
	 * Test che verifica l'uguaglianza fra il valore restituito dal metodo getMedia e quello calcolato manualmente (in questo caso uguale a 5.0).
	 * 
	 * @throws NullDataException
	 */
	@Test
	void testMedia() throws NullDataException {
		StatAverage statMedia= new StatAverage(user);
		assertEquals(5.0 ,statMedia.getMedia());
	}

	/**
	 * Distrugge cio' che e' stato inizializzato dal metodo setUp.
	 * 
	 * @throws Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {}
}
