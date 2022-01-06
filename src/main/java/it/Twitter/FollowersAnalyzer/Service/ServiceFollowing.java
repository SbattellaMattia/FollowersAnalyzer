package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/* Dato un Id di un Utente restituisce gli Utenti che segue
 */
public class ServiceFollowing extends Service{
	
	public ServiceFollowing(Long id) {
		this.Url=PATTERN_USER_ID+id+"/following?user.fields=created_at,verified&max_results=200";
	}
	
	public String getFollowing() throws IOException, ConnectionException {
		return Connection(Url);
	}

}