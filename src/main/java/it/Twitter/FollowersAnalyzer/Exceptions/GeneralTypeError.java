package it.Twitter.FollowersAnalyzer.Exceptions;

import org.json.simple.JSONObject;

import it.Twitter.FollowersAnalyzer.JsonComponent.JsonToGeneralTypeError;

public class GeneralTypeError extends Exception{
final static String message="Id non trovato";
private static final long serialVersionUID = 1L;

JsonToGeneralTypeError err=new JsonToGeneralTypeError();
	
	private String Timestamp;
	private Integer Status;
	private String Error;
	private String Trace;
	private String Message;
	private String Path;

	
	public GeneralTypeError() {
		super();
	}
	
	public GeneralTypeError(JSONObject job) {
		super(message);
		this.Trace=err.getTrace(job);
		this.Status=err.getStatus(job);
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
