package it.Twitter.FollowersAnalyzer.Exceptions;

public class WrongParameter extends Exception{
	final static String message="Wrong or inexistent parameter";
	private static final long serialVersionUID = 5L;
	
	public WrongParameter() {
		super(message);
	}
	
	public String getError() {
		return "{\"error message\":\""+ getMessage()+"\"}";
	}
	
}
