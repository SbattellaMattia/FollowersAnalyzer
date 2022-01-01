package it.Twitter.FollowersAnalyzer.Exceptions;

public class UsernameNotFoundException extends Exception{

	private static final long serialVersionUID = 5L;
	
	public UsernameNotFoundException() {
	}
	
	public UsernameNotFoundException(String message) {
		super(message);
	}
	
}
