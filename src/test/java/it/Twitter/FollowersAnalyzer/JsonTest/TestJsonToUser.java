package it.Twitter.FollowersAnalyzer.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.Twitter.FollowersAnalyzer.Exceptions.DateException;
import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.JsonComponent.JsonToUser;
import it.Twitter.FollowersAnalyzer.Model.User;

class TestJsonToUser {

	JSONObject UserJObj= new JSONObject();   
	User user=new User(1234L,"Dario","SecondDario","00-00-0000",true);

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


	@Test
	void StringUserToJson() throws ParseException, NullDataException, DateException {
		JsonToUser json= new JsonToUser();
		assertEquals(user.UserToString(), json.parseUser(UserJObj).UserToString());
	}

	@AfterEach
	public void tearDown() throws Exception {}

}
