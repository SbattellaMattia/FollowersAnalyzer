package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.Model.User;

public class FilterByVerified extends Filter {

	ArrayList<User> NameFollowersVerified =new  ArrayList<User>();
	ArrayList<User> NameFollowersNotVerified =new  ArrayList<User>();

	public void Filter(User user) {

		for(User i: user.getFollowers()) {
			if (i.isVerified()) NameFollowersVerified.add(i);
			else NameFollowersNotVerified.add(i);
		}
	}

	public String FilterToString(String method) throws WrongParameter, NullDataException {
	
			if(method.equals("verified")) {
				if(NameFollowersVerified.isEmpty()) throw new NullDataException("No users match the requests");
				return "{\"Verified followers:\": " + UserArrayToString(NameFollowersVerified) + "}";
			}
		
			if(method.equals("not_verified")) {
				if(NameFollowersNotVerified.isEmpty()) throw new NullDataException("No users match the requests");
				return "{\"Unverified followers:\": " + UserArrayToString(NameFollowersNotVerified) + "}";
			}
		
			if(method.equals("all")) {
				if(NameFollowersVerified.isEmpty() && NameFollowersNotVerified.isEmpty()) throw new NullDataException("No users match the requests");
				if(NameFollowersVerified.isEmpty()) return "{\"Unverified followers:\": " + UserArrayToString(NameFollowersNotVerified) + "}";
				if(NameFollowersNotVerified.isEmpty()) return "{\"Verified followers:\": " + UserArrayToString(NameFollowersVerified) + "}";
				else return "{\"Verified followers:\": " + UserArrayToString(NameFollowersVerified) + "}," + "{\"Unverified followers:\": " + UserArrayToString(NameFollowersNotVerified) + "}";
			}

		throw new WrongParameter(" \""+method+"\" is not allowed");
	}
}
