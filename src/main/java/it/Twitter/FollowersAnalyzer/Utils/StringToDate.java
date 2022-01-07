package it.Twitter.FollowersAnalyzer.Utils;

import it.Twitter.FollowersAnalyzer.Exceptions.DateException;

public class StringToDate {
	private String date;

	public String stringToDate(String createdAt) throws DateException{
		date=createdAt.substring(0,10);
		String[] aux=date.split("-");
		return aux[2]+"-"+aux[1]+"-"+aux[0];
	}
}
