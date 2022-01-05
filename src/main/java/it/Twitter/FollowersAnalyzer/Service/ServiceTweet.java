package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/* Dato un Id di un Utente restituisce i suoi tweet
 */
public class ServiceTweet extends Service {
	
	public ServiceTweet(Long id) {
		//this.Url="https://api.twitter.com/2/users/"+id+"/tweets?max_results=10";
		this.Url="://api.twitter.com/2/users/:id/tweets?max_results=10&tweet.fields=author_id,created_at";
	}
	
	public String getTweet() throws IOException, ConnectionException {
		return Connection(Url);
	}

}
