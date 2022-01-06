package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/* Dato un Id di un Utente restituisce i suoi tweet
 */
public class ServiceTweet extends Service {
	
	public ServiceTweet(Long id) {
		this.Url=PATTERN_USER_ID+id+"/tweets?"+PATTERN_TWEET_FIELDS+"&"+PATTERN_MAX_RESULTS;
	}
	
	public String getTweet() throws IOException, ConnectionException {
		return Connection(Url);
	}

}
