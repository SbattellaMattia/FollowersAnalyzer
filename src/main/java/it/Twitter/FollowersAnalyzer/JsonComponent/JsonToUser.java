package it.Twitter.FollowersAnalyzer.JsonComponent;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.Twitter.FollowersAnalyzer.Exceptions.DateException;
import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;

import it.Twitter.FollowersAnalyzer.Model.User;
import it.Twitter.FollowersAnalyzer.Utils.StringToDate;

public class JsonToUser {
	StringToDate date = new StringToDate();
	
	public User parseUser(JSONObject User) throws NullDataException, DateException
	{
		if ((User.get("id"))==null)throw new NullDataException("wrong or inexistent Id");
		
		Long id = Long.parseLong((String) User.get("id"));
		String name = (String) User.get("name");    
		String username = (String) User.get("username");    
		String createdAt = date.stringToDate((String) User.get("created_at"));
		boolean verified;
		if ((User.get("verified")).equals(true)) verified = true;
		else verified = false;
	
		User user=new User(id,name,username,createdAt,verified);
		return user; 
	}

	
	
	public User parseOneUser(JSONObject User) throws NullDataException, DateException
	{
		JSONObject data = (JSONObject) User.get("data");
		if(data==null)throw new NullDataException("wrong or inexistent Id.");
		
		Long id = Long.parseLong((String) data.get("id"));    
		String name = (String) data.get("name");    
		String username = (String) data.get("username");    
		String createdAt = date.stringToDate((String) data.get("created_at"));
		boolean verified;
		if ((data.get("verified")).equals(true)) verified = true;
		else verified = false;

		User user=new User(id,name,username,createdAt,verified);
		return user;
	}



	public ArrayList<User> parseUsers(JSONObject Users) throws NullDataException, DateException
	{
		ArrayList<User> followers = new ArrayList<User>(); 
		JSONArray data = (JSONArray) Users.get("data");
		if(data == null) throw new NullDataException("no Users match");
		@SuppressWarnings("unchecked")
		Iterator<JSONObject> iterator = data.iterator();

		while (iterator.hasNext()) {
			followers.add(parseUser(iterator.next()));   
		}
		return followers;
	}

}   
