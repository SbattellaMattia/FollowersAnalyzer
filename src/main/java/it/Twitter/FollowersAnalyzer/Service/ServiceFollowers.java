package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/* Dato un Id di un Utente restituisce gli Utenti che lo seguono
 */
public class ServiceFollowers extends Service{
	
	public ServiceFollowers(Long id) {
		this.Url=PATTERN_USER_ID+id+"/followers?"+PATTERN_USER_FIELDS+"&"+PATTERN_MAX_RESULTS;
	}
	
	public String getFollowers() throws IOException,ConnectionException {
		return Connection(Url);
	}

}
