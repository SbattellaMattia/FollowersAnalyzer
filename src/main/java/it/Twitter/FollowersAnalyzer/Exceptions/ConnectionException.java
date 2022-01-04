package it.Twitter.FollowersAnalyzer.Exceptions;

public class ConnectionException extends Exception{
	final static String message="Connection failed, plese retry in few minutes.\n If the problem continue, plese contact us.\nSorry for the inconvenient.";
	private static final long serialVersionUID = 5L;
	
	public ConnectionException() {
		super(message);
	}
	
	public String getError() {
		return "{\"error message\":\""+ getMessage()+"\"}";
	}
	
}
