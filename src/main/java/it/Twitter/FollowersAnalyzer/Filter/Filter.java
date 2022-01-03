package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Model.User;

public abstract class Filter {

	public String UserArrayToString(ArrayList<User> followers) {

		String aux = "{\"data\":[";
		for(User user : followers) aux += user.UserToString()+",";
		return aux.substring(0,(aux.length()-1))+"]}";
	}

}
