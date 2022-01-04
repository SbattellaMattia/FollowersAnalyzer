package it.Twitter.FollowersAnalyzer.Exceptions;

public class DateException extends Exception {

	private static final long serialVersionUID = 6L;

	public DateException() { super(); }
	public DateException(String message) { super(message); }
	public DateException(String message, Throwable cause) { super(message, cause); }
	public DateException(Throwable cause) { super(cause); }
}
