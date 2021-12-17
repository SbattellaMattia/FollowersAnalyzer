package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

public class ServiceTweet extends Service {
	private String url;
	
	public ServiceTweet(Long id) {
		this.url="https://api.twitter.com/2/users/"+id+"/tweets?max_results=10";
	}
	
	public String getTweet() throws IOException {
		return Connection(url);
	}

}
