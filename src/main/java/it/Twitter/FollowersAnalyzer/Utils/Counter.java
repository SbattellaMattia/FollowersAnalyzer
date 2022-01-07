package it.Twitter.FollowersAnalyzer.Utils;

import java.util.HashMap;
import java.util.Map;

import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Model.User;

public class Counter {

	
	public String counter(User user) {
		Map<User, Integer> counter = new HashMap<User, Integer>();
		for(Tweet i : user.getTweets()) {
			for(User j : i.getLikingUsers()) {
				if(counter.containsKey(j)) {
					Integer numOccurrence = counter.get(j);
					counter.replace(j, numOccurrence++);}
				else counter.put(j,1);
			}
		}
		return counterToString(counter);
	}

	
	public String counterToString(Map<User,Integer> counter ) {
		String aux="{\"data\" :[";
		for (Map.Entry<User,Integer> entry : counter.entrySet()) {
			User key = entry.getKey();
			Integer value = entry.getValue();
			aux+=key.UserToString();
			aux=aux.substring(0,(aux.length()-1))+",\"LIKE OCCURRENCES\":"+value+"},";
		}
		return aux.substring(0,(aux.length()-1))+"]}";
	}

	
}
