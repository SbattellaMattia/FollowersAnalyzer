package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

//dato l'id di un tweet mi restituisce la lista degli utenti che hanno messo like
public class ServiceLikingUsers extends Service{

	public ServiceLikingUsers(Long id) {
		this.Url="https://api.twitter.com/2/users/"+id+"/liking_users?user.fields=created_at,verified";
	}

	public String getLikingUsers() throws IOException,ConnectionException {
		return Connection(Url);
	}
}
