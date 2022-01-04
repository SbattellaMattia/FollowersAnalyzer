package it.Twitter.FollowersAnalyzer.JsonComponent;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class StringToJson{
	
	public JSONObject ToJson(String string) throws ParseException{	
		JSONParser parser = new JSONParser();  
		JSONObject obj = (JSONObject) parser.parse(string);  
		return obj;
	}

	public JSONArray ToJsonArray(String string) throws ParseException{	
		JSONParser parser = new JSONParser();  
		JSONArray obj = (JSONArray) parser.parse(string);  
		return obj;
	}

}
