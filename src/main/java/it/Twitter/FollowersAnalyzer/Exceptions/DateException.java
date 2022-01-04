package it.Twitter.FollowersAnalyzer.Exceptions;

public class DateException extends Exception {
	final static String message="Wrong type of data:";
	private static final long serialVersionUID = 6L;

	public DateException(String mex) {
		super(message+mex);
	}
	
	public String getError() {
		return "{\"error message\":\""+ getMessage()+"\"}";
	}
	
}
