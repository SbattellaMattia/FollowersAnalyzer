package it.Twitter.FollowersAnalyzer.Stats;

import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Model.User;

public class StatsLikes {
	private int followers=0;
	private int likes=0;
	private double percentage=0;

	public StatsLikes(User user, Tweet tweet) throws NullDataException {

		followers=user.getFollowers().size();
		likes=tweet.getLikingUsers().size();
		try {
			percentage=Math.round((double)likes*100/followers*100.0)/100.0;}
		catch(ArithmeticException e) {
			throw new NullDataException("Operation failed.");}

	}

	public double getPercentage() {
		return percentage;
	}

	public String toString() {
		return "{\"Percentage of followers who liked the tweet\":[{\"percentage\": \""+ percentage + " %\"}]}";	
	}
}
