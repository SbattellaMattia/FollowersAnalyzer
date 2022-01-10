package it.Twitter.FollowersAnalyzer.Model;

import java.util.ArrayList;

public class Tweet extends Super{

	private int likes;
	private String text;
	private String createdAt;
	private Long authorId;
	private ArrayList<User> retweeted_by = new  ArrayList<User>();
	private ArrayList<User> likingUsers = new  ArrayList<User>();


	public Tweet(Long id) {
		super(id);
	}

	public Tweet(Long id, String text) {
		super(id);
		this.text=text;
	}

	public Tweet(Long id, String text, String createdAt, Long authorId) {
		super(id);
		this.text=text;
		this.createdAt=createdAt;
		this.authorId=authorId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {	     
		this.createdAt = createdAt;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public int getLikes() {
		return likes;
	}

	public String getText() {
		return text;
	}

	public String TweetToString() {
		return "{\"id\": \""+ getId() + "\",\"text\": \"" + getText() + "\",\"created_at\": \""+ getCreatedAt() + "\",\"author_id\": \"" + getAuthorId() +"\"}";
	}

	public String RetweetedByArrayToString() {

		String aux = "{\"data\":[";
		for(User user : retweeted_by) aux += "{\"id\": \""+ user.getId() + "\",\"name\": \"" + user.getName() + "\",\"username\": \"" + user.getUsername() + "\",\"created_at\": \"" + user.getCreatedAt() + "\",\"verified\": \"" + user.isVerified() + "\"},";
		return aux.substring(0,(aux.length()-1))+"]}";
	}


	public ArrayList<User> getLikingUsers() {
		return likingUsers;
	}


	public void setLikingUsers(ArrayList<User> likingUsers) {
		this.likingUsers = likingUsers;
	}
	
	public ArrayList<User> getRetweeted_by() {
		return retweeted_by;
	}

	public void setRetweeted_by(ArrayList<User> retweeted_by) {
		this.retweeted_by = retweeted_by;
	}


	public String LikingUsersArrayToString() {

		String aux = "{\"data\":[";
		for(User user : likingUsers) aux += "{\"id\": \""+ user.getId() + "\",\"name\": \"" + user.getName() + "\",\"username\": \"" + user.getUsername() + "\",\"created_at\": \"" + user.getCreatedAt() + "\",\"verified\": \"" + user.isVerified() + "\"},";
		return aux.substring(0,(aux.length()-1))+"]}";
	}

}
