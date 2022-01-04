package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Exceptions.DateException;
import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Model.User;

public class FilterByCreation extends Filter {

	public String Filter(User user,String date) throws NumberFormatException, DateException, NullDataException {
		
		int year=checkYear(Integer.parseInt(date.substring(6,date.length())));
		int month=checkMonth(Integer.parseInt(date.substring(3,5)));
		int day=checkDay(Integer.parseInt(date.substring(0,2)),month);
		
		
		ArrayList<User> FollowerDate = new ArrayList<User>();

		for(User i: user.getFollowers()) {
			int UserYear=Integer.parseInt(i.getCreatedAt().substring(6,date.length()));
			int UserMonth=Integer.parseInt(i.getCreatedAt().substring(3,5));
			int UserDay=Integer.parseInt(i.getCreatedAt().substring(0,2));
			
			if (UserYear>year) {
				FollowerDate.add(i);}
			if (UserYear==year) {
				if (UserMonth>month) {
					FollowerDate.add(i);}
				if (UserMonth==month) {
					if (UserDay>day) {
						FollowerDate.add(i);}
				}
			}
				
		}		
		
		if (FollowerDate.isEmpty()) throw new NullDataException();
		return UserArrayToString(FollowerDate);
	}

	
	public int checkYear(int year) throws DateException {
		if(year<2010 || year>2021 )
			throw new DateException("year<2010 or year>2021: " + year);
		return year;
	}
	
	public int checkMonth(int month) throws DateException {
		if(month<1 || month>12 )
			throw new DateException("month<0 or month>12: " + month);
		return month;
	}
	
	public int checkDay(int day, int month) throws DateException {
		
		if(day<1 || day>31 )
			throw new DateException("day<1 or day>31: " + day);
		
		if(month==2 && day>28)
			throw new DateException("February has 28 days: " + day);
		
		if((month==4 || month==6 || month==9 || month==11)  && day>30)
			throw new DateException("April, June, September, November have 30 days: " + day);
		
		return day;	
	}

}
