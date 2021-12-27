package it.Twitter.FollowersAnalyzer.Controller;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.Twitter.FollowersAnalyzer.JsonComponent.JsonToUser;
import it.Twitter.FollowersAnalyzer.JsonComponent.StringToJson;
import it.Twitter.FollowersAnalyzer.Model.User;
import it.Twitter.FollowersAnalyzer.Service.ServiceFollowers;
import it.Twitter.FollowersAnalyzer.Service.ServiceRetweeted_by;
import it.Twitter.FollowersAnalyzer.Service.ServiceTweet;
import it.Twitter.FollowersAnalyzer.Service.ServiceUserById;
import it.Twitter.FollowersAnalyzer.Service.ServiceUserByUsername;
import it.Twitter.FollowersAnalyzer.Stats.Media;

@RestController
public class Controller {
	
	
	StringToJson json;
	
	
	@GetMapping(value="/UserById/{id}")
	public JSONObject getUserById(@PathVariable Long id) throws IOException, ParseException{
			ServiceUserById service = new ServiceUserById(id);
			json=new StringToJson(service.getUser());
			return json.ToJson();
    }
	
	@GetMapping(value="/UserByUsername/{username}")
	public JSONObject getUserByUsername(@PathVariable String username) throws IOException, ParseException{
			ServiceUserByUsername service = new ServiceUserByUsername(username);
			json=new StringToJson(service.getUser());
			return json.ToJson();
    }
	
	
	
	@GetMapping(value="/Followers/{id}")
	public JSONObject getFollowers(@PathVariable Long id) throws IOException, ParseException{
			ServiceFollowers service = new ServiceFollowers(id);
			json=new StringToJson(service.getFollowers());
			
			/*JsonToUser jsonUser=new JsonToUser();
			
			for(User i: jsonUser.parseUsers(json.ToJson())) System.out.println(i.UserToString());*/
	
			return json.ToJson();
    }

	
	@GetMapping(value="/Tweets/{id}")
	public JSONObject getTweet(@PathVariable Long id) throws IOException, ParseException{
			ServiceTweet service = new ServiceTweet(id);
			json=new StringToJson(service.getTweet());
			return json.ToJson();
    }
	
	@GetMapping(value="/Retweeted_by/{id}")
	public JSONObject getRetweeted_by(@PathVariable Long id) throws IOException, ParseException{
			ServiceRetweeted_by service = new ServiceRetweeted_by(id);
			json=new StringToJson(service.getRetweeted_by());
			return json.ToJson();
    }
	
	
	@GetMapping(value="/MediaFollowers/{id}")
	public String getMedia(@PathVariable Long id) throws IOException, ParseException{
		
			JsonToUser jsonUser=new JsonToUser();
			ArrayList<Long> IdFollowers = new ArrayList<Long>();
			ArrayList<Integer> NumFollower = new ArrayList<Integer>();
			
			
			for(User i : jsonUser.parseUsers(getFollowers(id))) {
				IdFollowers.add(i.getId());
			}
			
			for(Long i: IdFollowers) {
				NumFollower.add(jsonUser.parseUsers(getFollowers(i)).size());	
			}
			
			String line="";
			for(Integer i : NumFollower) {
				line+=" "+i;
			}
			Media media =new Media(NumFollower);
			return line+"\n"+media.toString();
    }
	
	
}
