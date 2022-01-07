package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/*Dato l'Username di un Utente restituisce l'Utente stesso*/

public class ServiceUserByUsername extends Service {
	private String PATTERN_SERVICE_BY_USERNAME="by/username/";
	
	public ServiceUserByUsername(String username) {
		this.Url=PATTERN_USER_ID+PATTERN_SERVICE_BY_USERNAME+username+PARAMETER+PATTERN_USER_FIELDS;
	}
	
	public String getUser() throws IOException,ConnectionException{
		return Connection(Url);
	}

}

