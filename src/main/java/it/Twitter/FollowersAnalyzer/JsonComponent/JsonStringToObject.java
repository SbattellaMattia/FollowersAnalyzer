package it.Twitter.FollowersAnalyzer.JsonComponent;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Model.User;

public class JsonStringToObject {
	private String JsonString;
	
	
	
	public JsonStringToObject(String jsonString) {
		JsonString = jsonString;
	}

	
	public String JsonStringToString(){
		JsonString=JsonString.substring(10,(JsonString.length()-1));
		char JsonArray[]=JsonString.toCharArray();
		
		
		String string="";
		for(char i:JsonArray)if(JsonArray[i]!='"'||JsonArray[i]!='{'||JsonArray[i]!='}'||
				   				JsonArray[i]!=']'||JsonArray[i]!='[')string+=i;
		
		return string;
	}
	
	public ArrayList<User> StringToUser(String string){
		//System.out.println("AAAAAAAAAAA"+string);
		ArrayList<User> Users = new ArrayList<User>();
		String Array[]=string.split(",");
		Long id=0L;
		String name="";
		String username="";
		int cont=0;
		
		for(String z: Array) {
		System.out.println(z);}
		
		for(String i: Array) {
			
			//Provato lo switch
			String Array2[]=i.split(":");
			
			if (Array2[0].equals("id")){
				id=Long.parseLong(Array2[1]);
				cont++;	
			}
			if (Array2[0].equals("name")){
				name=Array2[1];
				cont++;	
			}
			if (Array2[0].equals("username")){
				username=Array2[1];
				cont++;	
			}
			
			if(cont==3) {
				User user=new User(id,name,username);
				Users.add(user);
				cont=0;
			}
			
			
		}
		
		return Users;
	}

	

		
}
	
	
	
	
	
	
	
