package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Model.User;

public class FilterByFollowers extends Filter{

	

	public String Filter(User user,Tweet tweet,String method) throws NumberFormatException, NullDataException, WrongParameter {

		if(method.equals("all")) {
			return UserArrayToString(tweet.getLikingUsers());}
		if(method.equals("followers")) {
			ArrayList<User> likingFollowers = searchLikingFollowers(user,tweet);
			return UserArrayToString(likingFollowers);}

		else throw new WrongParameter("\""+method+"\" is not allowed.");
	}
	
	public ArrayList<User> searchLikingFollowers(User user,Tweet tweet) {
		ArrayList<User> likingFollowers = new  ArrayList<User>();
		for(User i : tweet.getLikingUsers()) {
			for(User j : user.getFollowers()) {
				if (j.getId().equals(i.getId()))likingFollowers.add(i);
			}
		}
		return likingFollowers;
	}

}
