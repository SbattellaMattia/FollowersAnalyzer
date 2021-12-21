package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

/* Dato un Id di un tweet restituisce gli Utenti che lo hanno retweettato
 */
public class ServiceRetweeted_by extends Service{
	
	public ServiceRetweeted_by(Long id) {
		this.Url="https://api.twitter.com/2/tweets/"+id+"/retweeted_by";
	}
	
	public String getFollowers() throws IOException {
		return Connection(Url);
	}

}
