package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Model.User;

public class FilterByName extends Filter {
	
public String Filter(User user,String name) {
		
		ArrayList<User> NameFollowers =new  ArrayList<User>();
		
		for(User i: user.getFollowers()) {
			if (i.getName().equals(name)) NameFollowers.add(i) ;
		}
		return UserArrayToString(NameFollowers);
	}

}
