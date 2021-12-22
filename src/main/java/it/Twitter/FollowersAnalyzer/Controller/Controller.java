package it.Twitter.FollowersAnalyzer.Controller;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.Twitter.FollowersAnalyzer.JsonComponent.JsonStringToObject;
import it.Twitter.FollowersAnalyzer.JsonComponent.StringToJson;
import it.Twitter.FollowersAnalyzer.Model.User;
import it.Twitter.FollowersAnalyzer.Service.ServiceFollowers;
import it.Twitter.FollowersAnalyzer.Service.ServiceTweet;
import it.Twitter.FollowersAnalyzer.Stats.Media;

@RestController
public class Controller {
	
	
	StringToJson json;
	
	@GetMapping(value="/followers/{id}")
	public JSONObject getFollowers(@PathVariable Long id) throws IOException, ParseException{
			ServiceFollowers service = new ServiceFollowers(id);
			json=new StringToJson(service.getFollowers());
			return json.ToJson();
    }

	
	@GetMapping(value="/tweets/{id}")
	public JSONObject getTweet(@PathVariable Long id) throws IOException, ParseException{
			ServiceTweet service = new ServiceTweet(id);
			json=new StringToJson(service.getTweet());
			return json.ToJson();
    }
	
	
	@GetMapping(value="/MediaFollowers/{id}")
	public String getMedia(@PathVariable Long id) throws IOException, ParseException{
		
			ArrayList<Long> IdFollowers = new ArrayList<Long>();
			ArrayList<Integer> NumFollower = new ArrayList<Integer>();
			
			
			ServiceFollowers service = new ServiceFollowers(id);
			JsonStringToObject JsonStringUsers=new JsonStringToObject(service.getFollowers());
			
			/*String line="";
			for(User i:JsonStringUsers.StringToUser()) {
				System.out.println(i.UserToString());
				line+=i.UserToString();
			}*/
			
			for(User i : JsonStringUsers.StringToUser()) {
				IdFollowers.add(i.getId());
			}
			
			String line="";
			for(Long i : IdFollowers) {
				line+=" "+i;
			}
			
			
			
			for(Long i: IdFollowers) {
				ServiceFollowers service2 = new ServiceFollowers(i);
				JsonStringToObject followersDellId=new JsonStringToObject(service2.getFollowers());
				NumFollower.add((followersDellId.StringToUser()).size());	
			}
			
			for(Integer i : NumFollower) {
				line+=" "+i;
			}
			Media media =new Media(NumFollower);
			
			//return media.toString();
			
			return line+"\n"+media.toString();
    }
	
	
}
