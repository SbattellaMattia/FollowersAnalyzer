package it.Twitter.FollowersAnalyzer.JsonComponent;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
import it.Twitter.FollowersAnalyzer.Model.User;
import it.Twitter.FollowersAnalyzer.Utils.StringToDate;


public class JsonToUser {

	//JSONParser jsonParser = new JSONParser();
	StringToDate date = new StringToDate();

	public User parseUser(JSONObject User) 
	{
		
		String name = (String) User.get("name");    
		//System.out.println(name);

		String username = (String) User.get("username");    
		//System.out.println(username);

		Long id = Long.parseLong((String) User.get("id"));    
		//System.out.println(id);
		
		String createdAt = date.stringToDate((String) User.get("created_at"));
		
		boolean verified = (boolean) User.get("verified");

		//User user=new User(id,name,username,createdAt);
		User user=new User(id,name,username,createdAt,verified);
		
		return user;
	}

	public User parseOneUser(JSONObject User) 
	{

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
		User user=new User(id,name,username,createdAt, verified);
		
		return user;
	}



	public ArrayList<User> parseUsers(JSONObject Users) 
	{

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
