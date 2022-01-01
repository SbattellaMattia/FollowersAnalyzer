package it.Twitter.FollowersAnalyzer.Exceptions;

public class GeneralTypeError extends Exception{
	
private static final long serialVersionUID = 1L;
	
	private String Timestamp;
	private Integer Status;
	private String Error;
	private String Trace;
	private String Message;
	private String Path;

	
	public GeneralTypeError() {
		super();
	}
	
	public GeneralTypeError(String message) {
		super(message);
	}
	
	public GeneralTypeError (String Timestamp, Integer Status, String Error, String Trace, String Message, String Path) {
		
		this.Timestamp = Timestamp;
		this.Status = Status;
		this.Error = Error;
		this.Trace = Trace;
		this.Message = Message;
		this.Path = Path;
	
	}
	
	public String GeneralTypeErrorToString() {
		return "{\"timestamp\":\"" + Timestamp + "\",\"status\":\"" + Status + "\",\"error\":\"" + Error + "\",\"trace\":\"" + Trace + "\",\"message\":\"" + Message + "\",\"path\":\"" + Path + "\"}";
	}
	
}
