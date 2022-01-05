package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Model.User;

public class FilterByFollowers extends Filter{

	private ArrayList<User> likingFollowers = new  ArrayList<User>();

	public String Filter(User user,Tweet tweet,String method) throws NumberFormatException, NullDataException, WrongParameter {

		if(method.equals("all")) {
			return UserArrayToString(tweet.getLikingUsers());}
		if(method.equals("followers")) {
			searchLikingFollowers(user,tweet,method);
			return UserArrayToString(likingFollowers);}

		else throw new WrongParameter(" \""+method+"\" is not allowed");
	}
	
	public void searchLikingFollowers(User user,Tweet tweet,String method) {
		for(User i : tweet.getLikingUsers()) {
			for(User j : user.getFollowers()) {
				if (j.getId().equals(i.getId())) likingFollowers.add(i);
			}
		}
	}

}
