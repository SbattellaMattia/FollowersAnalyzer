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
					numOccurrence++;
					counter.replace(j,numOccurrence);}
				else counter.put(j,1);
			}
		}	
		return counterToString(counter);
	}

	
	public String counterToString(Map<User,Integer> counter ) {
		String aux="{\"data\" :[";

		Integer maxValue=0;
		User maxKey=new User(0L);

		while(!counter.isEmpty()) {
			for(Map.Entry<User,Integer> entry :  counter.entrySet()) {
				
				User key = entry.getKey();
				Integer value = entry.getValue();

				if(maxValue<value) {
					maxValue=value;
					maxKey=key;
				}
			}
			aux+=maxKey.UserToString();
			aux=aux.substring(0,(aux.length()-1))+",\"LIKE OCCURRENCES\":"+maxValue+"},";
			counter.remove(maxKey);
			maxValue=0;
		}
		return aux.substring(0,(aux.length()-1))+"]}";
	}
	
}
