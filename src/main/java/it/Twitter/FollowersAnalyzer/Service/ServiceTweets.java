package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/* Dato un Id di un Utente restituisce i suoi tweets
 */
public class ServiceTweets extends Service {
	private String PATTERN_SERVICE_TWEETS="/tweets";
	
	public ServiceTweets(Long id) {
		this.Url=PATTERN_USER_ID+id+PATTERN_SERVICE_TWEETS+ PARAMETER+PATTERN_TWEET_FIELDS+AND+PATTERN_MAX_RESULTS;
	}
	
	public String getTweet() throws IOException, ConnectionException {
		return Connection(Url);
	}

}
