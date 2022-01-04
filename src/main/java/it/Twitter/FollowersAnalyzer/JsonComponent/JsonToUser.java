package it.Twitter.FollowersAnalyzer.JsonComponent;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
//import org.json.simple.parser.JSONParser;
import it.Twitter.FollowersAnalyzer.Model.User;
import it.Twitter.FollowersAnalyzer.Utils.StringToDate;


public class JsonToUser {
	StringToDate date = new StringToDate();
	//JSONParser jsonParser = new JSONParser();

	public User parseUser(JSONObject User) throws NullDataException
	{

		if (User.get("id")==null)throw new NullDataException();
		
		Long id = Long.parseLong((String) User.get("id"));    
		//System.out.println(id);

		
		String name = (String) User.get("name");    
		//System.out.println(name);

		String username = (String) User.get("username");    
		//System.out.println(username);

		String createdAt = date.stringToDate((String) User.get("created_at"));
		
		boolean verified;
		if ((User.get("verified")).equals("true")) verified = true;
		else verified = false;
	

		//User user=new User(id,name,username,createdAt);
		User user=new User(id,name,username,createdAt,verified);

		return user; 
	}

	public User parseOneUser(JSONObject User) throws NullDataException
	{

		if(((JSONObject) User.get("data")) == null) throw new NullDataException();
		

		JSONObject data = (JSONObject) User.get("data");
		
		String name = (String) data.get("name");    
		//System.out.println(name);

		String username = (String) data.get("username");    
		//System.out.println(username);

		Long id = Long.parseLong((String) data.get("id"));    
		//System.out.println(id);

		String createdAt = date.stringToDate((String) data.get("created_at"));
		
		boolean verified = (boolean)data.get("verified");
		

		//User user=new User(id,name,username,createdAt);
		User user=new User(id,name,username,createdAt,verified);
		
		return user;
	}



	public ArrayList<User> parseUsers(JSONObject Users) throws NullDataException
	{
		if(((JSONArray) Users.get("data")) == null) throw new NullDataException();
		
		ArrayList<User> followers = new ArrayList<User>(); 
		JSONArray data = (JSONArray) Users.get("data");

		@SuppressWarnings("unchecked")
		Iterator<JSONObject> iterator = data.iterator();

		while (iterator.hasNext()) {
			//System.out.println(parseUser(iterator.next()).UserToString());
			followers.add(parseUser(iterator.next()));   
		}
		return followers;
	}

}   
