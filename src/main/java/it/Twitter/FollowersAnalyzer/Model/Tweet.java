package it.Twitter.FollowersAnalyzer.Model;

import java.util.ArrayList;

public class Tweet extends Super{

	private int likes;
	private String text;
	private ArrayList<User> Retweeted_by = new  ArrayList<User>();
	
	public ArrayList<User> getRetweeted_by() {
		return Retweeted_by;
	}

	public void setRetweeted_by(ArrayList<User> retweeted_by) {
		Retweeted_by = retweeted_by;
	}

	public Tweet(Long id) {
		super(id);
	}
	
	public Tweet(Long id, String text) {
		super(id);
		this.text=text;
	}

	public int getLikes() {
		return likes;
	}

	public String getText() {
		return text;
	}
	

	public String RetweetedByArrayToString() {

			String aux = "{\"data\":[";
			for(User user : Retweeted_by) aux += "{\"id\": \""+ user.getId() + "\",\"name\": \"" + user.getName() + "\",\"username\": \"" + user.getUsername() + "\",\"created_at\": \"" + user.getCreatedAt() + "\",\"verified\": \"" + user.isVerified() + "\"},";
			return aux.substring(0,(aux.length()-1))+"]}";
		}
	
}