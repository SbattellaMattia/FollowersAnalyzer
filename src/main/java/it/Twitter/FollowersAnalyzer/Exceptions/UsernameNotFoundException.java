package it.Twitter.FollowersAnalyzer.Exceptions;

public class UsernameNotFoundException extends Exception{

	private static final long serialVersionUID = 3L;
	
	public UsernameNotFoundException() {
	}
	
	public UsernameNotFoundException(String message) {
		super(message);
	}
	
}
