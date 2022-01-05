package it.Twitter.FollowersAnalyzer.JsonComponent;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.Twitter.FollowersAnalyzer.Exceptions.DateException;
import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Utils.StringToDate;

public class JsonToTweet {

	//JSONParser jsonParser = new JSONParser();
	StringToDate date = new StringToDate();

	public Tweet parseTweet(JSONObject Tweet) throws NullDataException, DateException
	{
		if (Tweet.get("id")==null)throw new NullDataException();
		
		String text = (String) Tweet.get("text");    
		//System.out.println(text);

		Long id = Long.parseLong((String) Tweet.get("id"));    
		//System.out.println(id);
		
		String createdAt = date.stringToDate((String) Tweet.get("created_at"));

		Long authorId = Long.parseLong((String) Tweet.get("author_id"));
		
		Tweet tweet=new Tweet(id,text,createdAt,authorId);
		return tweet;
	}

	public Tweet parseOneTweet(JSONObject Tweet) throws NullDataException, DateException
	{
		if(((JSONObject) Tweet.get("data")) == null) throw new NullDataException();
		
		JSONObject data = (JSONObject) Tweet.get("data");
		
		String text = (String) data.get("text");    
		//System.out.println(text);

		Long id = Long.parseLong((String) data.get("id"));    
		//System.out.println(id);
		
		String createdAt = date.stringToDate((String) data.get("created_at"));

		Long authorId = Long.parseLong((String) data.get("author_id"));
		
		Tweet tweet=new Tweet(id,text,createdAt,authorId);
		return tweet;
	}
	

	public ArrayList<Tweet> parseTweets(JSONObject Tweet) throws NullDataException, DateException
	{
		ArrayList<Tweet> tweets = new ArrayList<Tweet>(); 

		JSONArray data = (JSONArray) Tweet.get("data");
		
		//@SuppressWarnings("unchecked")
		Iterator<JSONObject> iterator = data.iterator();

		while (iterator.hasNext()) {
			tweets.add(parseTweet(iterator.next()));
		}

		return tweets;
	}
}   

