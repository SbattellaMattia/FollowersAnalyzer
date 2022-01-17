package it.Twitter.FollowersAnalyzer.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.Twitter.FollowersAnalyzer.Exceptions.DateException;
import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.JsonComponent.JsonToUser;
import it.Twitter.FollowersAnalyzer.Model.User;

/** Questa classe TestJsonToUser testa un metodo della classe {@link it.Twitter.FollowersAnalyzer.JsonComponent.JsonToUser JsonToUser}.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.JsonComponent.JsonToUser JsonToUser
 */
class TestJsonToUserArray {

	JSONObject UserJObj= new JSONObject();
	
	JSONArray UserJArray=new JSONArray();

	JSONObject UserJObj1= new JSONObject();
	JSONObject UserJObj2= new JSONObject();
	
	
	JSONObject TweetJObj= new JSONObject();
	
	User user=new User(0L);
	User user1=new User(1234L,"Dario","SecondDario","00-00-0000",true);
	User user2=new User(5678L,"Mirko","Rkomi","00-00-0000",false);
	
	/**
	 * Metodo che inizializza i dati necessari per effettuare i test: in questo caso setta i due followers di tipo utente all'utente, crea poi due JSONObject rappresentanti un utente, li inserisce in un JsonArray e il tutto in un JSONObject.
	 */
	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() {
		(user.getFollowers()).add(user1);
		(user.getFollowers()).add(user2);
		
		UserJObj1.put("id", "1234");
		UserJObj1.put("name", "Dario");
		UserJObj1.put("username", "SecondDario");
		UserJObj1.put("created_at", "0000-00-00");
		UserJObj1.put("verified", true);
		
		UserJObj2.put("id", "5678");
		UserJObj2.put("name", "Mirko");
		UserJObj2.put("username", "Rkomi");
		UserJObj2.put("created_at", "0000-00-00");
		UserJObj2.put("verified", false);
		
		UserJArray.add(UserJObj1);
		UserJArray.add(UserJObj2);
		
		UserJObj.put("data",UserJArray);
	}

	/**
	 * Test che verifica il corretto funzionamento del metodo parseUsers accertando che il risultato ottenuto sia uguale a quello settato in precedenza.
	 * 
	 * @throws ParseException
	 * @throws NullDataException
	 * @throws DateException
	 */
	@Test
	void StringUserToJson() throws ParseException, NullDataException, DateException {
		JsonToUser json= new JsonToUser();
		User user2=new User(0L);
		user2.setFollowers(json.parseUsers(UserJObj));
		//System.out.println(user.FollowersArrayToString());
		//System.out.println(user2.FollowersArrayToString());
		assertEquals(user.FollowersArrayToString(),user2.FollowersArrayToString() );
	}

	/**
	 * Distrugge cio' che e' stato inizializzato dal metodo setUp.
	 * 
	 * @throws Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {}

}
