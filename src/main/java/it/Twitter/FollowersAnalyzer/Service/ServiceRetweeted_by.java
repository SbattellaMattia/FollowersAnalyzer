package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/* Dato un Id di un tweet restituisce gli Utenti che lo hanno retweettato
 */
public class ServiceRetweeted_by extends Service{
	
	public ServiceRetweeted_by(Long id) {
		this.Url=PATTERN_TWEET_ID+id+"/retweeted_by?"+PATTERN_USER_FIELDS;
	}
	
	public String getRetweeted_by() throws IOException, ConnectionException {
		return Connection(Url);
	}

}
