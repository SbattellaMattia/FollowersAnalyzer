package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/* Dato un Id di un Utente restituisce l'Utente stesso */

public class ServiceUserById extends Service {
	
	public ServiceUserById(Long id) {
		this.Url=PATTERN_USER_ID+id+ PARAMETER+PATTERN_USER_FIELDS;
	}

	public String getUser() throws IOException, ConnectionException {
		return Connection(Url);
	}

}

