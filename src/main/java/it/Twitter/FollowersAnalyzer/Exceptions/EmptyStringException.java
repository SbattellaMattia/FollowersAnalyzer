package it.Twitter.FollowersAnalyzer.Exceptions;

public class EmptyStringException extends Exception{
	
	private static final long serialVersionUID = 3L;
	
	public EmptyStringException() {	
	}
	
	public EmptyStringException(String message) {	
		super(message);
	}
}