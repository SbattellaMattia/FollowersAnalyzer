package it.Twitter.FollowersAnalyzer.JsonComponent;

import org.json.simple.JSONObject;

import it.Twitter.FollowersAnalyzer.Model.User;

public class JsonStringToObject {
	private String JsonString;
	
	
	
	public JsonStringToObject(String jsonString) {
		JsonString = jsonString;
	}


	public User JsonStringToUser(){
		String[] J = JsonString.split("{");
		for(int i=1; i<J.length;i++)
			String[] JsonUser = J[i].split("}");
			
		User user=new User((Long)obj.get("id"),(String)obj.get("name"),(String)obj.get("username"));
		return user;


	}

}
