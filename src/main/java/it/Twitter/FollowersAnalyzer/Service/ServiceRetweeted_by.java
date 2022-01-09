package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/* Dato un Id di un tweet restituisce gli Utenti che lo hanno retweettato
 */
public class ServiceRetweeted_by extends Service{
	private String PATTERN_SERVICE_RETWEETED_BY="/retweeted_by";
	
	public ServiceRetweeted_by(Long id) {
		this.Url=PATTERN_TWEET_ID+id+PATTERN_SERVICE_RETWEETED_BY+PARAMETER+PATTERN_USER_FIELDS;
	}
	
	public String getRetweeted_by() throws IOException, ConnectionException {
		return Connection(Url);
	}

}
