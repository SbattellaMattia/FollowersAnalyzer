package it.Twitter.FollowersAnalyzer.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.Twitter.FollowersAnalyzer.JsonComponent.StringToJson;
import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Model.User;

/** Questa classe TestJsonObj testa un metodo della classe {@link it.Twitter.FollowersAnalyzer.JsonComponent.StringToJson StringToJson}.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.JsonComponent.StringToJson StringToJson
 */
class TestJsonObj {

	JSONObject UserJObj= new JSONObject(); 
	JSONObject TweetJObj= new JSONObject();   
	User user=new User(1234L,"Dario","SecondDario","00-00-0000",true);
	Tweet tweet=new Tweet(5678L,"Ciaooo","00-00-0000",1234L);

	/**
	 * Metodo che inizializza i dati necessari per effettuare i test: in questo caso due JSONObject rappresentanti un utente e un tweet.
	 */
	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() {
		UserJObj.put("id", "1234");
		UserJObj.put("name", "Dario");
		UserJObj.put("username", "SecondDario");
		UserJObj.put("created_at", "00-00-0000");
		UserJObj.put("verified", true);
		
		TweetJObj.put("id", "5678");
		TweetJObj.put("text", "Ciaooo");
		TweetJObj.put("created_at", "00-00-0000");
		TweetJObj.put("author_id", "1234");
		
		//System.out.println("setUp completato");
	}


	/**
	 * Test che verifica siano uguali il JSONObject restituito dal metodo e quello creato nel setUp riferiti all'utente.
	 * 
	 * @throws ParseException
	 */
	@Test
	void StringUserToJson() throws ParseException {
		StringToJson json= new StringToJson();
		assertEquals(UserJObj ,json.ToJson(user.UserToString()));
	}
	
	/**
	 * Test che verifica siano uguali il JSONObject restituito dal metodo e quello creato nel setUp riferiti al tweet.
	 * 
	 * @throws ParseException
	 */
	@Test
	void StringTweetToJson() throws ParseException {
		StringToJson json= new StringToJson();
		assertEquals(TweetJObj ,json.ToJson(tweet.TweetToString()));
	}
	
	/**
	 * Distrugge ciò che è stato inizializzato da metodo setUp.
	 * 
	 * @throws Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {}

}
