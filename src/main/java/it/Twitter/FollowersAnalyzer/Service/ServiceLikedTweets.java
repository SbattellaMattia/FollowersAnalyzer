package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/* Dato un Id di un Utente restituisce i tweet a cui ha messo like
 */
public class ServiceLikedTweets extends Service{
	
	public ServiceLikedTweets(Long id) {
		this.Url=PATTERN_USER_ID+id+"/liked_tweets?"+PATTERN_TWEET_FIELDS/*+"&"+PATTERN_MAX_RESULTS*/;
	}
	
	public String getLikedTweets() throws IOException, ConnectionException {
		return Connection(Url);
	}

}
