package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

/* Dato un Id di un Utente restituisce gli Utenti che segue
 */
public class ServiceFollowing extends Service{
	
	public ServiceFollowing(Long id) {
		this.Url="https://api.twitter.com/2/users/"+id+"/following";
	}
	
	public String getFollowing() throws IOException {
		return Connection(Url);
	}

}