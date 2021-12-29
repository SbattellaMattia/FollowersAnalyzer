package it.Twitter.FollowersAnalyzer.JsonComponent;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import it.Twitter.FollowersAnalyzer.Model.User;
 
public class JsonToUser {
        
        JSONParser jsonParser = new JSONParser();
       
       
 
    public User parseUser(JSONObject User) 
    {
        String name = (String) User.get("name");    
        //System.out.println(name);
         
        String username = (String) User.get("username");    
        //System.out.println(username);
         
        Long id = Long.parseLong((String) User.get("id"));    
        //System.out.println(id);
        
        User user=new User(id,name,username);
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
        
        User user=new User(id,name,username);
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

