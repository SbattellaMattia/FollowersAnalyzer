package it.Twitter.FollowersAnalyzer.StatsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Model.User;
import it.Twitter.FollowersAnalyzer.Stats.StatAverage;
import it.Twitter.FollowersAnalyzer.Stats.StatVariation;

class TestVariation_Average {
	long id=1111L;
	
	User user=new User(id,"mirko","rkomi","00-00-0000");
	User user1=new User(id,"pippo","e non solo","00-00-0000");
	User user2=new User(id,"Dario","SecondDario","00-00-0000");
	User user3=new User(id,"Sara","SaRa4326","00-00-0000");

	
	
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
	 *  La media sarà: 
	 *  (2+5+8)/3=  5
	 *  
	 *  La varianza sarà:
	 *  ((2-5)^2+(5-5)^2+(8-5)^2)/(3-1)=
	 *  (9+0+9)/2= 9
	 *  
	 *  */
	
	@Test
	void testVarianza() throws NullDataException {
		StatVariation statVarianza= new StatVariation(user);
		assertEquals( 9.0 ,statVarianza.getVarianza());
	}
	
	@Test
	void testMedia() throws NullDataException {
		StatAverage statMedia= new StatAverage(user);
		assertEquals(5.0 ,statMedia.getMedia());
	}

	@AfterEach
	public void tearDown() throws Exception {}
}
