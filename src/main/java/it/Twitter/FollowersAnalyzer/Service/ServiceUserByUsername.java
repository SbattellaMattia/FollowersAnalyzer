package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/*Dato l'Username di un Utente restituisce l'Utente stesso*/

public class ServiceUserByUsername extends Service {
	
	public ServiceUserByUsername(String username) {
		this.Url="https://api.twitter.com/2/users/by/username/"+username+"?user.fields=created_at,verified";
	}
	
	public String getUser() throws IOException,ConnectionException{
		return Connection(Url);
	}

}

