package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Model.User;

public class FilterByVerified extends Filter {
	
	public String Filter(User user) {
		
		ArrayList<User> NameFollowersVerified =new  ArrayList<User>();
		ArrayList<User> NameFollowersNotVerified =new  ArrayList<User>();
		
		for(User i: user.getFollowers()) {
			if (i.isVerified()) NameFollowersVerified.add(i);
			else NameFollowersNotVerified.add(i);
		}
		return /*"{\"Verified followers:\": \"" +*/ UserArrayToString(NameFollowersVerified) + /*"\",\"Unverified followers\": \"" +*/ UserArrayToString(NameFollowersNotVerified) ;
		
	}
}
