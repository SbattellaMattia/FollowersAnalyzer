package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/*Dato l'Username di un Utente restituisce l'Utente stesso*/

public class ServiceUserByUsername extends Service {
	
	public ServiceUserByUsername(String username) {
		this.Url=PATTERN_USER_ID+ "by/username/"+username+"?"+PATTERN_USER_FIELDS;
	}
	
	public String getUser() throws IOException,ConnectionException{
		return Connection(Url);
	}

}

