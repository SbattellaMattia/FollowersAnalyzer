package it.Twitter.FollowersAnalyzer.JsonComponent;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class StringToJson{
	private String string;

	public StringToJson(String string) {
		this.string = string;
	}
	
		
public JSONObject ToJson() throws ParseException{	
	JSONParser parser = new JSONParser();  
	JSONObject obj = (JSONObject) parser.parse(string);  
	return obj;
	}


}
