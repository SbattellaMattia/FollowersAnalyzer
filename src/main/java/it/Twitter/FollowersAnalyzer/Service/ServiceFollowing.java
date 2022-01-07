package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/* Dato un Id di un Utente restituisce gli Utenti che segue
 */
public class ServiceFollowing extends Service{
	private String PATTERN_SERVICE_FOLLOWING="/following";
	
	public ServiceFollowing(Long id) {
		this.Url=PATTERN_USER_ID+id+PATTERN_SERVICE_FOLLOWING+PARAMETER+PATTERN_USER_FIELDS+AND+PATTERN_MAX_RESULTS;
	}
	
	public String getFollowing() throws IOException, ConnectionException {
		return Connection(Url);
	}

}