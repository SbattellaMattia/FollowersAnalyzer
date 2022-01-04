package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

/* Dato un Id di un Utente restituisce l'Utente stesso */

public class ServiceUserById extends Service {
	
	public ServiceUserById(Long id) {
		this.Url="https://api.twitter.com/2/users/"+id+"?user.fields=created_at,verified";
	}

	public String getUser() throws IOException {
		return Connection(Url);
	}

}

