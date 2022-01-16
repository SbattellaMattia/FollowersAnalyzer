package it.Twitter.FollowersAnalyzer.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.Twitter.FollowersAnalyzer.Exceptions.DateException;
import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.JsonComponent.JsonToUser;
import it.Twitter.FollowersAnalyzer.Model.User;

/** Questa classe TestJsonToUser testa un metodo della classe {@link it.Twitter.FollowersAnalyzer.JsonComponent.JsonToUser JsonToUser}.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.JsonComponent.JsonToUser JsonToUser
 */
class TestJsonToUser {

	JSONObject UserJObj= new JSONObject();   
	User user=new User(1234L,"Dario","SecondDario","00-00-0000",true);

	/**
	 * Metodo che inizializza i dati necessari per effettuare i test: in questo caso un JSONObject rappresentante un utente.
	 */
	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() {
		UserJObj.put("id", "1234");
		UserJObj.put("name", "Dario");
		UserJObj.put("username", "SecondDario");
		UserJObj.put("created_at", "0000-00-00");
		UserJObj.put("verified", true);
		//System.out.println("setUp completato");
	}

	/**
	 * Test che verifica il corretto funzionamento del metodo parseUser confrontando il risultato con quello settato in precedenza.
	 * 
	 * @throws ParseException
	 * @throws NullDataException
	 * @throws DateException
	 */
	@Test
	void StringUserToJson() throws ParseException, NullDataException, DateException {
		JsonToUser json= new JsonToUser();
		assertEquals(user.UserToString(), json.parseUser(UserJObj).UserToString());
	}

	/**
	 * Distrugge ciò che è stato inizializzato da metodo setUp.
	 * 
	 * @throws Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {}

}
