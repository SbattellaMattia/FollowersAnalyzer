package it.Twitter.FollowersAnalyzer.UtilsTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Model.User;
import it.Twitter.FollowersAnalyzer.Utils.Counter;

/** Questa classe TestCounter testa un metodo della classe {@link it.Twitter.FollowersAnalyzer.Utils.Counter Counter}.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.Utils.Counter Counter
 */
class TestCounter {

	User user=new User(0000L,"mirko","rkomi","00-00-0000");

	User user1=new User(1111L,"Pippo","e non solo","00-00-0000");
	User user2=new User(2222L,"Dario","SecondDario","00-00-0000");
	User user3=new User(3333L,"Sara","SaRa4326","00-00-0000");
	User user4=new User(4444L,"Pluto","Plutone","00-00-0000");
	User user5=new User(5555L,"Mattia","Matty","00-00-0000");

	Tweet tweet1=new Tweet(0000L,"Ciaooo");
	Tweet tweet2=new Tweet(0000L,"Forza Monturanese");
	Tweet tweet3=new Tweet(0000L,"Cambiamento climatico");
	Tweet tweet4=new Tweet(0000L,"Ingegneria è la miglior facoltà");


	/**
	 * Metodo che inizializza i dati necessari per effettuare i test: in questo caso 4 tweet e i rispettivi utenti che hanno messo like.
	 */
	@BeforeEach
	protected void setUp() {
		(tweet1.getLikingUsers()).add(user1);
		(tweet1.getLikingUsers()).add(user2);
		(tweet1.getLikingUsers()).add(user3);
		(tweet1.getLikingUsers()).add(user4);
		(tweet1.getLikingUsers()).add(user5);

		(tweet2.getLikingUsers()).add(user1);
		(tweet2.getLikingUsers()).add(user3);
		(tweet2.getLikingUsers()).add(user5);

		(tweet3.getLikingUsers()).add(user2);
		(tweet3.getLikingUsers()).add(user3);

		(tweet4.getLikingUsers()).add(user3);
		(tweet4.getLikingUsers()).add(user5);


		(user.getTweets()).add(tweet1);
		(user.getTweets()).add(tweet2);
		(user.getTweets()).add(tweet3);
		(user.getTweets()).add(tweet4);
		//System.out.println("setUp completato");

	}

	/*	Ipotizziamo lo Users abbia 4 tweet :
	 *  il primo con 5 like		(Pippo,Sara,Dario,Pluto,Mattia)
	 *  il secondo con 3 like	(Pippo,Sara,Mattia)
	 *  il terzo con 2 like		(Dario,Sara)
	 *  il quarto con 2 like	(Sara,Mattia)
	 *  
	 *  Sara=  4  OCCORRENZE
	 *  Mattia=3  OCCORRENZE
	 *  Pippo= 2  OCCORRENZE
	 *  Dario= 2  OCCORRENZE 
	 *  Pluto= 1  OCCORRENZE
	 *  
	 *  */

	/**
	 * Test che stampa una stringa di Utenti (in ordine decrescente) in base al numero totale di like messi. Deve corrispondere al commento soprastante.
	 * 
	 * @throws WrongParameter
	 */
	@Test
	void testFollowersRange1() throws WrongParameter {
		Counter counter= new Counter();
		System.out.println(counter.counter(user));
	}

	/**
	 * Distrugge cio' che e' stato inizializzato dal metodo setUp.
	 * 
	 * @throws Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {}
}
