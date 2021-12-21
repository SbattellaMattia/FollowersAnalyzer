package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

/* Dato un Id di un Utente restituisce i suoi tweet
 */
public class ServiceTweet extends Service {
	
	public ServiceTweet(Long id) {
		this.Url="https://api.twitter.com/2/users/"+id+"/tweets?max_results=10";
	}
	
	public String getTweet() throws IOException {
		return Connection(Url);
	}

}
