package it.Twitter.FollowersAnalyzer.Exceptions;

public class NullDataException extends Exception{
	final static String message="Data is null, wrong or inexistent Id";
	private static final long serialVersionUID = 2L;
	
	public NullDataException() {
		super(message);
	}
	
	public String getError() {
		return "{\"error message\":\""+ getMessage()+"\"}";
	}
	
}
