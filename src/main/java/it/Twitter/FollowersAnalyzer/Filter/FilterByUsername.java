package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Model.User;

public class FilterByUsername extends Filter {

	public String FilterFollower(User user,String username) throws WrongParameter {
		ArrayList<User> UsernameFollowers =new  ArrayList<User>();

		if(username.equals("all")) {
			for(User i: user.getFollowers()) {
				UsernameFollowers.add(i) ;}
		}
		else {
			for(User i: user.getFollowers()) {
				if (i.getUsername().equals(username)) UsernameFollowers.add(i);}
		}
		if(UsernameFollowers.isEmpty()) throw new WrongParameter(username+" not found");
		return UserArrayToString(UsernameFollowers);
	}

	
	public String FilterFollowing(User user,String username) throws WrongParameter {
		ArrayList<User> UsernameFollowing =new  ArrayList<User>();
		
		if(username.equals("all")) {
			for(User i: user.getFollowing()) {
				UsernameFollowing.add(i) ;}
		}
		else {
			for(User i: user.getFollowing()) {
				if (i.getUsername().equals(username)) UsernameFollowing.add(i);}
		}
		if(UsernameFollowing.isEmpty()) throw new WrongParameter(username+" not found");
		return UserArrayToString(UsernameFollowing);
	}
	
	
	public String FilterRetweeted(Tweet tweet,String username) throws WrongParameter {
		ArrayList<User> UsernameRetweeted =new  ArrayList<User>();
		
		if(username.equals("all")) {
			for(User i: tweet.getRetweeted_by()) {
				UsernameRetweeted.add(i) ;}
		}
		else {
			for(User i:tweet.getRetweeted_by()) {
				if (i.getUsername().equals(username)) UsernameRetweeted.add(i);}
		}
		if(UsernameRetweeted.isEmpty()) throw new WrongParameter(username+" not found");
		return UserArrayToString(UsernameRetweeted);
	}
	
}
