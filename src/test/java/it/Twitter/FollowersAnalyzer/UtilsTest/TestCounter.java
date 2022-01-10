package it.Twitter.FollowersAnalyzer.UtilsTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Model.User;
import it.Twitter.FollowersAnalyzer.Utils.Counter;

class TestCounter {
	long id=1111L;
	
	User user=new User(id,"mirko","rkomi","00-00-0000");
	
	User user1=new User(id,"Pippo","e non solo","00-00-0000");
	User user2=new User(id,"Dario","SecondDario","00-00-0000");
	User user3=new User(id,"Sara","SaRa4326","00-00-0000");
	User user4=new User(id,"Pluto","Plutone","00-00-0000");
	User user5=new User(id,"Mattia","Matty","00-00-0000");

	Tweet tweet1=new Tweet(id,"Ciaooo");
	Tweet tweet2=new Tweet(id,"Forza Monturanese");
	Tweet tweet3=new Tweet(id,"Cambiamento climatico");
	Tweet tweet4=new Tweet(id,"Ingegneria è la miglior facoltà");
	
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
	 *  Pippo= 2  OCCORRENZE
	 *  Sara=  4  OCCORRENZE
	 *  Dario= 2  OCCORRENZE
	 *  Mattia=3  OCCORRENZE
	 *  Pluto= 1  OCCORRENZE
	 *  
	 *  */
	
	@Test
	void testFollowersRange1() throws WrongParameter {
		Counter counter= new Counter();
		System.out.println(counter.counter(user));
	}
	

	@AfterEach
	public void tearDown() throws Exception {}
}
