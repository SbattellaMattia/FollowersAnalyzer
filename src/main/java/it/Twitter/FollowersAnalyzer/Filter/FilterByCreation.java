package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Exceptions.DateException;
import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.Model.User;

public class FilterByCreation extends Filter {

	public String FollowerFilter(User user,String StartDate, String EndDate) throws NumberFormatException, DateException, NullDataException, WrongParameter {

		ArrayList<User> FollowerDate = new ArrayList<User>();
		try {
			if(StartDate.length()!=10)throw new WrongParameter("Use correct form of data: dd-mm-yyyy");

			int startyear=checkYear(Integer.parseInt(StartDate.substring(6,StartDate.length())));
			int startmonth=checkMonth(Integer.parseInt(StartDate.substring(3,5)));
			int startday=checkDay(Integer.parseInt(StartDate.substring(0,2)),startmonth);


			if(EndDate.equals("null")) {
				for(User i: user.getFollowers()) {
					int UserYear=Integer.parseInt(i.getCreatedAt().substring(6,i.getCreatedAt().length()));
					int UserMonth=Integer.parseInt(i.getCreatedAt().substring(3,5));
					int UserDay=Integer.parseInt(i.getCreatedAt().substring(0,2));

					if (UserYear>startyear) {
						FollowerDate.add(i);}
					if (UserYear==startyear) {
						if (UserMonth>startmonth) {
							FollowerDate.add(i);}
						if (UserMonth==startmonth) {
							if (UserDay>startday) {
								FollowerDate.add(i);}
						}
					}

				}
			}
			else {
				if(EndDate.length()!=10)throw new WrongParameter("Use correct form of data: dd-mm-yyyy");
				int endyear=checkYear(Integer.parseInt(EndDate.substring(6,EndDate.length())));
				int endmonth=checkMonth(Integer.parseInt(EndDate.substring(3,5)));
				int endday=checkDay(Integer.parseInt(EndDate.substring(0,2)),endmonth);

				if (startyear>endyear) {
					throw new WrongParameter("start year > end year : "+startyear+"-"+endyear);}
				if (startyear==endyear) {
					if (startmonth>endmonth) {
						throw new WrongParameter("start month > end month : "+startmonth+"-"+endmonth);}
					if (startmonth==endmonth) {
						if (startday>endday) {
							throw new WrongParameter("start day > end day : "+startday+"-"+endday);}
					}
				}

				for(User i: user.getFollowers()) {
					int UserYear=Integer.parseInt(i.getCreatedAt().substring(6,i.getCreatedAt().length()));
					int UserMonth=Integer.parseInt(i.getCreatedAt().substring(3,5));
					int UserDay=Integer.parseInt(i.getCreatedAt().substring(0,2));

					if(UserYear>startyear && UserYear<endyear)FollowerDate.add(i);


					if(UserYear==startyear && UserYear==endyear) {

						if(UserMonth>startmonth && UserMonth<endmonth)FollowerDate.add(i);

						if(UserMonth==startmonth && UserMonth==endmonth){
							if(UserDay>startday && UserDay<endday)FollowerDate.add(i);}
						else {
							if(UserMonth==startmonth || UserMonth==endmonth) {
								if(UserMonth==startmonth) {
									if(UserDay>startday)FollowerDate.add(i);
								}
								if(UserMonth==endmonth) {
									if(UserDay<endday)FollowerDate.add(i);}
							}
						}
					}
					else{
						if(UserYear==startyear || UserYear==endyear) {
							if(UserYear==startyear){
								if (UserMonth>startmonth) {
									FollowerDate.add(i);}
								if(UserMonth==startmonth){
									if(UserDay>startday)FollowerDate.add(i);}
							}
							if(UserYear==endyear){
								if (UserMonth<endmonth) {
									FollowerDate.add(i);}
								if(UserMonth==endmonth){
									if(UserDay<startday)FollowerDate.add(i);}
							}
						}
					}
					


				}

			}
		}catch(NumberFormatException error) {
			throw new WrongParameter("Use only numbers: dd-mm-yyyy: "+StartDate+" "+EndDate);}

		if (FollowerDate.isEmpty()) throw new NullDataException("No users match the request");
		return UserArrayToString(FollowerDate);
	}







	public String FollowingFilter(User user,String StartDate, String EndDate) throws NumberFormatException, DateException, NullDataException, WrongParameter {
		ArrayList<User> FollowingDate = new ArrayList<User>();
		try {
			if(StartDate.length()!=10)throw new WrongParameter("Use correct form of data: dd-mm-yyyy"+StartDate);
			int startyear=checkYear(Integer.parseInt(StartDate.substring(6,StartDate.length())));
			int startmonth=checkMonth(Integer.parseInt(StartDate.substring(3,5)));
			int startday=checkDay(Integer.parseInt(StartDate.substring(0,2)),startmonth);

			if(EndDate.equals("null")) {
				for(User i: user.getFollowing()) {
					int UserYear=Integer.parseInt(i.getCreatedAt().substring(6,i.getCreatedAt().length()));
					int UserMonth=Integer.parseInt(i.getCreatedAt().substring(3,5));
					int UserDay=Integer.parseInt(i.getCreatedAt().substring(0,2));

					if (UserYear>startyear) {
						FollowingDate.add(i);}
					if (UserYear==startyear) {
						if (UserMonth>startmonth) {
							FollowingDate.add(i);}
						if (UserMonth==startmonth) {
							if (UserDay>startday) {
								FollowingDate.add(i);}
						}
					}

				}
			}
			else {
				if(EndDate.length()!=10)throw new WrongParameter("Use correct form of data: dd-mm-yyyy"+EndDate);
				int endyear=checkYear(Integer.parseInt(EndDate.substring(6,EndDate.length())));
				int endmonth=checkMonth(Integer.parseInt(EndDate.substring(3,5)));
				int endday=checkDay(Integer.parseInt(EndDate.substring(0,2)),endmonth);

				if (startyear>endyear) {
					throw new WrongParameter("start year > end year : "+startyear+"-"+endyear);}
				if (startyear==endyear) {
					if (startmonth>endmonth) {
						throw new WrongParameter("start month > end month : "+startmonth+"-"+endmonth);}
					if (startmonth==endmonth) {
						if (startday>endday) {
							throw new WrongParameter("start day > end day : "+startday+"-"+endday);}
					}
				}

				for(User i: user.getFollowing()) {
					int UserYear=Integer.parseInt(i.getCreatedAt().substring(6,i.getCreatedAt().length()));
					int UserMonth=Integer.parseInt(i.getCreatedAt().substring(3,5));
					int UserDay=Integer.parseInt(i.getCreatedAt().substring(0,2));

					if(UserYear>startyear && UserYear<endyear)FollowingDate.add(i);


					if(UserYear==startyear && UserYear==endyear) {

						if(UserMonth>startmonth && UserMonth<endmonth)FollowingDate.add(i);

						if(UserMonth==startmonth && UserMonth==endmonth){
							if(UserDay>startday && UserDay<endday)FollowingDate.add(i);}
						else {
							if(UserMonth==startmonth || UserMonth==endmonth) {
								if(UserMonth==startmonth) {
									if(UserDay>startday)FollowingDate.add(i);
								}
								if(UserMonth==endmonth) {
									if(UserDay<endday)FollowingDate.add(i);}
							}
						}
					}
					else{
						if(UserYear==startyear || UserYear==endyear) {
							if(UserYear==startyear){
								if (UserMonth>startmonth) {
									FollowingDate.add(i);}
								if(UserMonth==startmonth){
									if(UserDay>startday)FollowingDate.add(i);}
							}
							if(UserYear==endyear){
								if (UserMonth<endmonth) {
									FollowingDate.add(i);}
								if(UserMonth==endmonth){
									if(UserDay<startday)FollowingDate.add(i);}
							}
						}
					}

				}

			}
		}catch(NumberFormatException error) {
			throw new WrongParameter("Use only numbers: dd-mm-yyyy: "+StartDate+" "+EndDate);}

		if (FollowingDate.isEmpty()) throw new NullDataException("No users match the request");
		return UserArrayToString(FollowingDate);
	}



	public int checkYear(int year) throws DateException {
		if(year<2005 || year>2021 )
			throw new DateException("year<2010 or year>2021: " + year);
		return year;}

	public int checkMonth(int month) throws DateException {
		if(month<1 || month>12 )
			throw new DateException("month<1 or month>12: " + month);
		return month;}

	public int checkDay(int day, int month) throws DateException {
		if(day<1 || day>31 )
			throw new DateException("day<1 or day>31: " + day);

		if(month==2 && day>28)
			throw new DateException("February has 28 days: " + day);

		if((month==4 || month==6 || month==9 || month==11)  && day>30)
			throw new DateException("April, June, September, November have 30 days: " + day);

		return day;}

}
