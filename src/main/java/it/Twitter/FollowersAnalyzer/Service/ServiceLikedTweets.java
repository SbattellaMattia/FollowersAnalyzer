package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/* Dato un Id di un Utente restituisce i tweet a cui ha messo like
 */
public class ServiceLikedTweets extends Service{
	private String PATTERN_SERVICE_LIKED_TWEETS="/liked_tweets";
	
	public ServiceLikedTweets(Long id) {
		this.Url=PATTERN_USER_ID+id+PATTERN_SERVICE_LIKED_TWEETS+PARAMETER+PATTERN_TWEET_FIELDS+AND+PATTERN_MAX_RESULTS;
	}
	
	public String getLikedTweets() throws IOException, ConnectionException {
		return Connection(Url);
	}

}
