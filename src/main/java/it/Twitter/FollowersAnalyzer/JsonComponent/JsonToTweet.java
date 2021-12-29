package it.Twitter.FollowersAnalyzer.JsonComponent;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Model.User;
 
public class JsonToTweet {
        
        JSONParser jsonParser = new JSONParser();
       
       
 
    public Tweet parseTweet(JSONObject Tweet) 
    {
        String text = (String) Tweet.get("text");    
        //System.out.println(text);
         
        Long id = Long.parseLong((String) Tweet.get("id"));    
        //System.out.println(id);
        
        Tweet tweet=new Tweet(id,text);
        return tweet;
    }

    
    public ArrayList<Tweet> parseUsers(JSONObject Tweet) 
    {
    	
    	ArrayList<Tweet> tweets = new ArrayList<Tweet>(); 
    	
    	JSONArray data = (JSONArray) Tweet.get("data");
        Iterator<JSONObject> iterator = data.iterator();
        
        while (iterator.hasNext()) {
            tweets.add(parseTweet(iterator.next()));
        }
        
        return tweets;
    }
}   

