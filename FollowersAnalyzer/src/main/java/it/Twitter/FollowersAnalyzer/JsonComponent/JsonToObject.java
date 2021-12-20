package it.Twitter.FollowersAnalyzer.JsonComponent;

import org.json.simple.JSONObject;

import it.Twitter.FollowersAnalyzer.Model.User;

public class JsonToObject {
private String obj;
	
	//Costruttore di tipo utente
	public JsonToObject(JSONObject obj) {
		JsonToString string=new JsonToString(obj); 
		this.obj =string.JsonToString_User();
	}
	
	
	
	public User JsonToUser(){
		
		User user=new User((Long)obj.get("id"),(String)obj.get("name"),(String)obj.get("username"));
		return user;
	}
}
