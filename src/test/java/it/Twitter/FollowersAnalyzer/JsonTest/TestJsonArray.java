package it.Twitter.FollowersAnalyzer.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.JsonComponent.StringToJson;
import it.Twitter.FollowersAnalyzer.Model.User;

/** Questa classe TestJsonArray testa un metodo della classe {@link it.Twitter.FollowersAnalyzer.JsonComponent.StringToJson StringToJson}.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.JsonComponent.StringToJson StringToJson
 */
class TestJsonArray {
	JSONObject UserJObj= new JSONObject();
	
	JSONArray UserJArray=new JSONArray();

	JSONObject UserJObj1= new JSONObject();
	JSONObject UserJObj2= new JSONObject();
	
	
	JSONObject TweetJObj= new JSONObject();
	
	User user=new User(0L);
	User user1=new User(1234L,"Dario","SecondDario","00-00-0000",true);
	User user2=new User(5678L,"Mirko","Rkomi","00-00-0000",false);

	/**
	 * Metodo che inizializza i dati necessari per effettuare i test: in questo caso setta i followers, di tipo utente, ad un utente, crea poi due JSONObject rappresentanti i due followers e popola un JsonArray con essi. Infine inserisce tutto in un JSONObject.
	 */
	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() {
		(user.getFollowers()).add(user1);
		(user.getFollowers()).add(user2);
		
		UserJObj1.put("id", "1234");
		UserJObj1.put("name", "Dario");
		UserJObj1.put("username", "SecondDario");
		UserJObj1.put("created_at", "00-00-0000");
		UserJObj1.put("verified", true);
		
		UserJObj2.put("id", "5678");
		UserJObj2.put("name", "Mirko");
		UserJObj2.put("username", "Rkomi");
		UserJObj2.put("created_at", "00-00-0000");
		UserJObj2.put("verified", false);
		
		UserJArray.add(UserJObj1);
		UserJArray.add(UserJObj2);
		
		UserJObj.put("data",UserJArray);
		//System.out.println("setUp completato");
	}

	/**
	 * Test che verifica siano uguali il JSONObject restituito dal metodo e quello creato nel setUp.
	 * 
	 * @throws ParseException
	 */
	@Test
	void StringUserArrayToJson() throws ParseException {
		StringToJson json= new StringToJson();
		assertEquals(UserJObj ,json.ToJson(user.FollowersArrayToString()));
	}
	
	/**
	 * Distrugge ciò che è stato inizializzato da metodo setUp.
	 * 
	 * @throws Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {}
	
}
