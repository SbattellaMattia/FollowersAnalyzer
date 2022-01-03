package it.Twitter.FollowersAnalyzer.Utils;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringToDate {

	public String date;

	public String stringToDate(String createdAt) {

		SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

		try {
			Date date1 = dateParser.parse(createdAt);
			SimpleDateFormat d1 = new SimpleDateFormat("dd-MM-yyyy");
			date = d1.format(date1).toString();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
