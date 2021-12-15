package it.Twitter.FollowersAnalyzer.Service;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.Twitter.FollowersAnalyzer.Model.User;

public class JsonTObj {
	
	public ArrayList<User> FollowersList =new ArrayList<User>();
	
	public ArrayList<User> toArray(JSONArray jFollowers) {
		
		/*
		object.put("id", user.getId());
		object.put("name", user.getName());
		object.put("username", user.getUsername());
		*/
		try {     
		FollowersList = (ArrayList<User>)jFollowers;}
		catch(Exception e) {}
		
		if (jFollowers != null) { 
		   for (int i=0;i<jFollowers.size();i++){ 
		    FollowersList.add((User) jFollowers.get(i));
		   } 
		} 
		return FollowersList;
	}	
}
