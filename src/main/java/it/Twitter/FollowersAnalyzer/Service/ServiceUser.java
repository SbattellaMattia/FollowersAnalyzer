package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;
import it.Twitter.FollowersAnalyzer.Exceptions.IdNotFoundException;

/* (1)Dato un Id di un Utente restituisce l'Utente stesso
 * (2)Dato l'Username di un Utente restituisce l'Utente stesso
 */
public class ServiceUser extends Service {
	
	public ServiceUser(Long id) {
		this.Url="https://api.twitter.com/2/users/"+id;
	}
	
	public ServiceUser(String username) {
		this.Url="https://api.twitter.com/2/users/by/username/"+username;
	}
	
	public String getUser() throws IOException, IdNotFoundException {
		return Connection(Url);
	}

}

