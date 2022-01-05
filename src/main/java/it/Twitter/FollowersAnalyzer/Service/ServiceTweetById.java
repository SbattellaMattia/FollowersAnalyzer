package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

public class ServiceTweetById extends Service {
	
	public ServiceTweetById(Long id) {
		this.Url="https://api.twitter.com/2/tweets/"+id+"?tweet.fields=author_id,created_at";
	}

	public String getTweetById() throws IOException,ConnectionException {
		return Connection(Url);
	}
}
