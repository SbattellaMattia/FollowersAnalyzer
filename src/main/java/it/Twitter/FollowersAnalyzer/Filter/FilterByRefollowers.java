package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Model.User;

public class FilterByRefollowers extends Filter {

	public String Filter(User user) {

		ArrayList<User> Refollows =new  ArrayList<User>();

		for(User i: user.getFollowers()) {
			for(User j: user.getFollowing())if (j.getId().equals(i.getId())) Refollows.add(i) ;
		}
		return UserArrayToString(Refollows);
	}

}
