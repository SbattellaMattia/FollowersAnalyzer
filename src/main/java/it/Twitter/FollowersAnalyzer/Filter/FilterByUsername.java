package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Model.User;

public class FilterByUsername extends Filter {

	public String FilterFollower(User user,String username) {

		ArrayList<User> UsernameFollowers =new  ArrayList<User>();

		for(User i: user.getFollowers()) {
			if (i.getUsername().equals(username)) UsernameFollowers.add(i) ;
		}
		return UserArrayToString(UsernameFollowers);
	}

	public String FilterFollowing(User user,String username) {

		ArrayList<User> UsernameFollowing =new  ArrayList<User>();

		for(User i: user.getFollowing()) {
			if (i.getUsername().equals(username)) UsernameFollowing.add(i) ;
		}
		return UserArrayToString(UsernameFollowing);
	}
	
}
