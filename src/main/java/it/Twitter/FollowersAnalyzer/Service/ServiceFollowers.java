package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/* Dato un Id di un Utente restituisce gli Utenti che lo seguono
 */
public class ServiceFollowers extends Service{
	
	public ServiceFollowers(Long id) {
		this.Url="https://api.twitter.com/2/users/"+id+"/followers?user.fields=created_at&max_results=200";
	}
	
	public String getFollowers() throws IOException,ConnectionException {
		return Connection(Url);
	}

}
