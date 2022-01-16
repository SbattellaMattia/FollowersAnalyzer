package it.Twitter.FollowersAnalyzer.JsonComponent;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
* Classe per convertire una <Code>String</Code> in JSONObject o JSONArray.
* 
* @author Sbattella Mattia
* @author Sumcutean Sara
* 
*/
public class StringToJson{
	
	/**
	 * Metodo che converte una <Code>String</Code> in <b>JSONObject</b>.
	 * @param String Stringa da convertire in <b>JSONObject</b>.
	 * 
	 * @return <b>JSONObject</b>.
	 * 
	 * @throws ParseException se fosse impossibile fare il parsing.
	 */
	public JSONObject ToJson(String String) throws ParseException{	
		JSONParser parser = new JSONParser();  
		JSONObject obj = (JSONObject) parser.parse(String);  
		return obj;
	}

	/**
	 * Metodo che converte una <Code>String</Code> in <b>JSONArray</b>.
	 * @param String Stringa da convertire in <b>JSONArray</b>.
	 * 
	 * @return <b>JSONArray</b>.
	 * 
	 * @throws ParseException se fosse impossibile fare il parsing.
	 */
	public JSONArray ToJsonArray(String String) throws ParseException{	
		JSONParser parser = new JSONParser();  
		JSONArray obj = (JSONArray) parser.parse(String);  
		return obj;
	}

}
