package it.Twitter.FollowersAnalyzer.JsonComponent;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import it.Twitter.FollowersAnalyzer.Exceptions.DateException;
import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Utils.StringToDate;

/**
* 
* Classe per convertire un <b>JSONObject</b> in {@link Tweet} o <b>ArrayList</b> di tipo {@link Tweet}.
* 
* @author Sbattella Mattia
* @author Sumcutean Sara
* 
*/
public class JsonToTweet {
	StringToDate date = new StringToDate();

	/**
	 * Il metodo parseTweet permette di convertire in {@link Tweet} un <b>JSONObject</b>.
	 * 
	 * @param  JsonTweet JSONObject del Tweet.
	 * 
	 * @return {@link Tweet}.
	 * 
	 * @throws NullDataException
	 * @throws DateException
	 */
	public Tweet parseTweet(JSONObject JsonTweet) throws NullDataException, DateException
	{
		if (JsonTweet.get("id")==null)throw new NullDataException("wrong or inexistent Id.");

		String text = (String) JsonTweet.get("text");    
		Long id = Long.parseLong((String) JsonTweet.get("id"));    
		String createdAt = date.stringToDate((String) JsonTweet.get("created_at"));
		Long authorId = Long.parseLong((String) JsonTweet.get("author_id"));
		Tweet tweet=new Tweet(id,text,createdAt,authorId);
		return tweet;
	}

	/**
	 * Il metodo parseOneTweet permette di convertire in {@link Tweet} un <b>JSONObject</b> 
	 * contenente un <b>JSONArray</b> con un solo elemento.
	 * 
	 * @param  JSONTweet JSONObject del Tweet.
	 * 
	 * @return {@link Tweet}.
	 * 
	 * @throws NullDataException
	 * @throws DateException
	 */
	public Tweet parseOneTweet(JSONObject JSONTweet) throws NullDataException, DateException
	{
		JSONObject data = (JSONObject) JSONTweet.get("data");
		if(data==null)throw new NullDataException("wrong or inexistent Id.");
		
		String text = (String) data.get("text");    
		Long id = Long.parseLong((String) data.get("id"));    
		String createdAt = date.stringToDate((String) data.get("created_at"));
		Long authorId = Long.parseLong((String) data.get("author_id"));
		Tweet tweet=new Tweet(id,text,createdAt,authorId);
		return tweet;
	}
	
	/**
	 * Il metodo parseTweets permette di convertire in <b>ArrayList</b> di tipo {@link Tweet}
	 * un <b>JSONObject</b> contenente un <b>JSONArray</b> con più elementi.
	 * 
	 * @param  JsonTweet JSONObject del JSONArray di Tweet.
	 * 
	 * @return <b>ArrayList</b> di tipo {@link Tweet}.
	 * 
	 * @throws NullDataException
	 * @throws DateException
	 */
	public ArrayList<Tweet> parseTweets(JSONObject JsonTweet) throws NullDataException, DateException
	{
		ArrayList<Tweet> tweets = new ArrayList<Tweet>(); 
		JSONArray data = (JSONArray) JsonTweet.get("data");
		if(data == null) throw new NullDataException("no Tweets match");
		@SuppressWarnings("unchecked")
		Iterator<JSONObject> iterator = data.iterator();

		while (iterator.hasNext()) {
			tweets.add(parseTweet(iterator.next()));
		}

		return tweets;
	}
}   

