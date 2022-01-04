package it.Twitter.FollowersAnalyzer.JsonComponent;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.Twitter.FollowersAnalyzer.Exceptions.IdNotFoundException;


public class JsonToError {

	JSONParser jsonParser = new JSONParser();


	public IdNotFoundException parseError(JSONObject IdNotFoundexception) 
	{

		String Parameter = (String) IdNotFoundexception.get("parameter");

		String ResourceType = (String) IdNotFoundexception.get("resource_type");

		String ResourceId = (String) IdNotFoundexception.get("resource_id");

		String Detail = (String) IdNotFoundexception.get("detail");

		String Title = (String) IdNotFoundexception.get("title");

		String Type = (String) IdNotFoundexception.get("type");

		String Value = (String) IdNotFoundexception.get("value");


		IdNotFoundException idNotFoundException = new IdNotFoundException(Parameter, ResourceType, ResourceId, Detail, Title, Type, Value);
		return idNotFoundException;
	}
	
	public IdNotFoundException parseErrors (JSONObject IdNotFoundExceptions) {

		IdNotFoundException primo = new IdNotFoundException();

		JSONArray data = (JSONArray) IdNotFoundExceptions.get("errors");

		@SuppressWarnings("unchecked")
		Iterator<JSONObject> iterator = data.iterator();

		while (iterator.hasNext()) {
			primo = parseError(iterator.next());   
		}
		return primo;
	}
}
