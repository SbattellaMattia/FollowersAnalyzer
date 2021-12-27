package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

/*Dato l'Username di un Utente restituisce l'Utente stesso*/

public class ServiceUserByUsername extends Service {
	
	public ServiceUserByUsername(String username) {
		this.Url="https://api.twitter.com/2/users/by/username/"+username;
	}
	
	public String getUser() throws IOException {
		return Connection(Url);
	}

}

