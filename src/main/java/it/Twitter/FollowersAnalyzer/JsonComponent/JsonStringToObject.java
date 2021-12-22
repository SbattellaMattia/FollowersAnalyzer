package it.Twitter.FollowersAnalyzer.JsonComponent;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Model.User;

public class JsonStringToObject {
	private String JsonString;
	
	
	
	public JsonStringToObject(String jsonString) {
		JsonString = jsonString;
	}

	
	public String JsonStringToString(){
		char JsonArray[]=JsonString.toCharArray();
		
		String string="";
		for(char i:JsonArray)if(i!='"'&& i!='{'&& i!='}'&&
				   				i!=']'&& i!='[')string+=i;
		
		//System.out.println(string);
		string=string.substring(5);
		//System.out.println(string);
		return string;
	}
	
	
	
	
	public ArrayList<User> StringToUser(){
		ArrayList<User> Users = new ArrayList<User>();
		String Array[]=JsonStringToString().split(",");
		Long id=0L;
		String name="";
		String username="";
		int cont=0;
		
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
				//System.out.println(user.UserToString());
				Users.add(user);
				cont=0;
			}
			
			
		}
		return Users;
	}
	
	
	public ArrayList<Tweet> StringToTweet(){
		ArrayList<Tweet> Tweets = new ArrayList<Tweet>();
		String Array[]=JsonStringToString().split(",");
		Long id=0L;
		String text="";
		int cont=0;
		
		/*for(String z: Array) {
		System.out.println(z);}*/
		
		for(String i: Array) {
			
			//Provato lo switch
			String Array2[]=i.split(":");
			
			if (Array2[0].equals("id")){
				id=Long.parseLong(Array2[1]);
				cont++;	
			}
			if (Array2[0].equals("text")){
				text=Array2[1];
				cont++;	
			}
			
			if(cont==2) {
				Tweet tweet=new Tweet(id,text);
				Tweets.add(tweet);
				cont=0;
			}
			
			
		}
		
		return Tweets;
	}

		
}
	