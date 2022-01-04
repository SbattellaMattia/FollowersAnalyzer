package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/* Dato un Id di un Utente restituisce i tweet a cui ha messo like
 */
public class ServiceLikedTweets extends Service{
	
	public ServiceLikedTweets(Long id) {
		this.Url="https://api.twitter.com/2/users/"+id+"/liked_tweets";
	}
	
	public String getLikedTweets() throws IOException, ConnectionException {
		return Connection(Url);
	}

}
