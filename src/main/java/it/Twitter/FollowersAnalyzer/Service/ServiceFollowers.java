package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

public class ServiceFollowers extends Service{
	private String url;
	
	public ServiceFollowers(Long id) {
		this.url="https://api.twitter.com/2/users/"+id+"/followers?user.fields=created_at&max_results=2";
	}
	
	
	
	public String getFollowers() throws IOException {
		return Connection(url);
	}

}
