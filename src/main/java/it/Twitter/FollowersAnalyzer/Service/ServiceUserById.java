package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/* Dato un Id di un Utente restituisce l'Utente stesso */

public class ServiceUserById extends Service {
	
	public ServiceUserById(Long id) {
		this.Url="https://api.twitter.com/2/users/"+id+"?user.fields=created_at,verified";
	}

	public String getUser() throws IOException, ConnectionException {
		return Connection(Url);
	}

}

