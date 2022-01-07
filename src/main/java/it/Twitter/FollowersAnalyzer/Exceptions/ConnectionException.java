package it.Twitter.FollowersAnalyzer.Exceptions;

public class ConnectionException extends Exception{
	final static String message="Connection failed, plese retry in few minutes.Sorry for the inconvenient. Problem: ";
	private static final long serialVersionUID = 1L;
	
	public ConnectionException(String mex) {
		super(message+mex);
	}
	
	public String getError() {
		return "{\"error message\":\""+ getMessage()+"\"}";
	}
	
}
