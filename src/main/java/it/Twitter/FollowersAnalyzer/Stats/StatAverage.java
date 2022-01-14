package it.Twitter.FollowersAnalyzer.Stats;

import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Model.User;

public class StatAverage {

	private int somma=0;
	private double media=0;

	public StatAverage(User user) throws NullDataException {

		for(User i: user.getFollowers()) {
			somma+=i.getFollowers().size();}
		try {
			media=Math.round((double)somma/user.getFollowers().size()*100.0)/100.0;}
		catch(ArithmeticException e) {
			throw new NullDataException("Average failed.");}

	}

	public double getMedia() {
		return media;
	}


	public String toString() {
		return "{\"Average Followers(per user)\":[{\"average\": \""+ media + " followers\"}]}";	
	}

}
