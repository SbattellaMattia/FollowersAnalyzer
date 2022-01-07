package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

public class ServiceTweetById extends Service {
	
	public ServiceTweetById(Long id) {
		this.Url=PATTERN_TWEET_ID+id+ PARAMETER+PATTERN_TWEET_FIELDS;
	}

	public String getTweetById() throws IOException,ConnectionException {
		return Connection(Url);
	}
}
