package it.Twitter.FollowersAnalyzer.Exceptions;

public class NameNotFoundException extends Exception{
	
	private static final long serialVersionUID = 4L;

	//String message;
	
	public NameNotFoundException() {
	}
	
	public NameNotFoundException(String message) {
		super(message);
	}
	
}
