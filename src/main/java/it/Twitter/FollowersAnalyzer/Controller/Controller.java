package it.Twitter.FollowersAnalyzer.Controller;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.Twitter.FollowersAnalyzer.JsonComponent.StringToJson;
import it.Twitter.FollowersAnalyzer.Service.ServiceImplementation;

@RestController
public class Controller {
	
	ServiceImplementation service = new ServiceImplementation();
	StringToJson json;
	
	@GetMapping(value="/followers/{id}")
	public JSONObject getFollowers(@PathVariable(required=false) Long id) throws IOException, ParseException{
		
		if(id==null) {
			json=new StringToJson(service.getFollowers((long) 270839361));
			return json.ToJson();
		}
		else {
			json=new StringToJson(service.getFollowers(id));
			return json.ToJson();		
		}
    }
}
