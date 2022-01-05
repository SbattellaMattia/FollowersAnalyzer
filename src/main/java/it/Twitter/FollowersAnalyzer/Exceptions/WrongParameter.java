package it.Twitter.FollowersAnalyzer.Exceptions;

public class WrongParameter extends Exception{
<<<<<<< HEAD
	final static String message="Wrong or inexistent parameter:";
	private static final long serialVersionUID = 5L;
=======
	final static String message="Wrong or inexistent parameter";
	private static final long serialVersionUID = 4L;
>>>>>>> 26f31777036d97520dc337dc8ed7bbf1daa09788
	
	public WrongParameter(String mex) {
		super(message+mex);
	}
	
	public String getError() {
		return "{\"error message\":\""+ getMessage()+"\"}";
	}
	
}
