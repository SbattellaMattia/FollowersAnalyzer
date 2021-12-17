package it.Twitter.FollowersAnalyzer.Controller;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.Twitter.FollowersAnalyzer.JsonComponent.JsonStringToObject;
import it.Twitter.FollowersAnalyzer.JsonComponent.StringToJson;
import it.Twitter.FollowersAnalyzer.Model.User;
import it.Twitter.FollowersAnalyzer.Service.ServiceFollowers;
import it.Twitter.FollowersAnalyzer.Service.Service;
import it.Twitter.FollowersAnalyzer.Service.ServiceTweet;

@RestController
public class Controller {
	
	
	StringToJson json;
	
	@GetMapping(value="/followers/{id}")
	public JSONObject getFollowers(@PathVariable Long id) throws IOException, ParseException{
			ServiceFollowers service = new ServiceFollowers(id);
			json=new StringToJson(service.getFollowers());
			JsonStringToObject ccc=new JsonStringToObject(service.getFollowers());
			
			for(User a:ccc.StringToUser(ccc.JsonStringToString())) {
				System.out.println(a.toString());
			}
				
			
			return json.ToJson();
    }
	
	@GetMapping(value="/tweet/{id}")
	public JSONObject getTweet(@PathVariable Long id) throws IOException, ParseException{
			ServiceTweet service = new ServiceTweet(id);
			json=new StringToJson(service.getTweet());
			return json.ToJson();
    }
	
	/*@GetMapping(value="/like/tweet/{id}")
	public JSONObject getLike(@PathVariable Long id) throws IOException, ParseException{
			json=new StringToJson(service.getTweet(id));
			return json.ToJson();
    }*/
	
	
}
