package it.Twitter.FollowersAnalyzer.JsonComponent;


import org.json.simple.JSONObject;


public class JsonToString {
	private JSONObject obj;
	
	
	public JsonToString(JSONObject obj) {
		this.obj = obj;
	}


	public String JsonToString_User() {
		Long id=(Long)obj.get("id");
		String name=(String)obj.get("name");
		String username=(String)obj.get("name");
		return "{  \r\n"
				+ "\"id\" : "+id+", \r\n"
				+ "\"name\" : \""+name+"\",  \r\n"
				+ "\"username\" : \""+username+"\",  \r\n"	
				+ "}";  
	}
	        	
	        	        	
}




