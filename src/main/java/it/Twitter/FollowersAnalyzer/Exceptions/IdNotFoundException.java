package it.Twitter.FollowersAnalyzer.Exceptions;

public class IdNotFoundException extends Exception{
	
	private static final long serialVersionUID = 2L;
	
	private String Parameter;
	private String ResourceType;
	private String ResourceId;
	private String Detail;
	private String Title;
	private String Type;
	private String Value;
	
	public IdNotFoundException() {
		super();
	}
	
	public IdNotFoundException(String message) {
		super(message);
	}
	
	public IdNotFoundException (String Parameter, String ResourceType, String ResourceId, String Detail, String Title, String Type, String Value) {
	
		this.Parameter = Parameter;
		this.ResourceType = ResourceType;
		this.ResourceId = ResourceId;
		this.Detail = Detail;
		this.Title = Title;
		this.Type = Type;
		this.Value = Value;
	
	}
	
	public String IdNotFoundExceptionToString() {
		return "{\"parameter\":\"" + Parameter + "\",\"resource_type\":\"" + ResourceType + "\",\"resource_id\":\"" + ResourceId + "\",\"detail\":\"" + Detail + "\",\"title\":\"" + Title + "\",\"type\":\"" + Type + "\",\"value\":\"" + Value + "\"}";
	}
	
}
