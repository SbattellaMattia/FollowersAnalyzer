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

class TestJsonObj {

	JSONObject UserJObj= new JSONObject(); 
	JSONObject TweetJObj= new JSONObject();   
	User user=new User(1234L,"Dario","SecondDario","00-00-0000",true);
	Tweet tweet=new Tweet(5678L,"Ciaooo","00-00-0000",1234L);

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



	@Test
	void StringUserToJson() throws ParseException {
		StringToJson json= new StringToJson();
		assertEquals(UserJObj ,json.ToJson(user.UserToString()));
	}
	
	@Test
	void StringTweetToJson() throws ParseException {
		StringToJson json= new StringToJson();
		assertEquals(TweetJObj ,json.ToJson(tweet.TweetToString()));
	}
	
	@AfterEach
	public void tearDown() throws Exception {}

}
