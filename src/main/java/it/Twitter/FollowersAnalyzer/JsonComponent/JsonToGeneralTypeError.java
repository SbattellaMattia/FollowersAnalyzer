package it.Twitter.FollowersAnalyzer.JsonComponent;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.Twitter.FollowersAnalyzer.Exceptions.GeneralTypeError;

public class JsonToGeneralTypeError {

	JSONParser jsonParser = new JSONParser();

	public GeneralTypeError parseGeneralTypeError(JSONObject GeneralTypeError) 
	{

		String Timestamp = (String) GeneralTypeError.get("timestamp");

		Integer Status = (Integer) GeneralTypeError.get("status");

		String Error = (String) GeneralTypeError.get("error");

		String Trace = (String) GeneralTypeError.get("trace");

		String Message = (String) GeneralTypeError.get("message");

		String Path = (String) GeneralTypeError.get("path");


		GeneralTypeError generalTypeError = new GeneralTypeError(Timestamp, Status, Error, Trace, Message, Path);
		return generalTypeError;
	}



	public int getStatus(JSONObject GeneralTypeError ) 
	{
		int Status = (int) GeneralTypeError.get("status");
		return Status;
	}

	public String getTrace(JSONObject GeneralTypeError) 
	{
		String Trace = (String) GeneralTypeError.get("trace");
		return Trace;
	}

}
