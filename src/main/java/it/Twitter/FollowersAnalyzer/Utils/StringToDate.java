package it.Twitter.FollowersAnalyzer.Utils;

import java.util.Date;

import it.Twitter.FollowersAnalyzer.Exceptions.DateException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringToDate {

	public String date;

	public String stringToDate(String createdAt) throws DateException{
		/*
		SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

		try {
			Date date1 = dateParser.parse(createdAt);
			SimpleDateFormat d1 = new SimpleDateFormat("dd-MM-yyyy");
			date = d1.format(date1).toString();
			return date;
		} catch (ParseException e) {
			throw new DateException(" date parsing error!");
		}*/
		
		date=createdAt.substring(0,10);
		String[] aux=date.split("-");
		return aux[2]+"-"+aux[1]+"-"+aux[0];
		
	}
}
