package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

//dato l'id di un tweet mi restituisce la lista degli utenti che hanno messo like
public class ServiceLikingUsers extends Service{
	private String PATTERN_SERVICE_LIKING_USERS="/liking_users";

	public ServiceLikingUsers(Long id) {
		this.Url=PATTERN_TWEET_ID+id+PATTERN_SERVICE_LIKING_USERS+PARAMETER+PATTERN_USER_FIELDS;
	}

	public String getLikingUsers() throws IOException,ConnectionException {
		return Connection(Url);
	}
}
