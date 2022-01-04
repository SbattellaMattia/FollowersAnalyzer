package it.Twitter.FollowersAnalyzer.Model;

import java.util.ArrayList;

public class User extends Super{

	private String name;
	private String username;
	private String location;
	private String description;
	private boolean protect;
	private int followersCount;
	private int followingCount;
	private String createdAt;
	private int favouritesCount;
	private boolean verified;

	private ArrayList<User> followers = new ArrayList<User>();
	private ArrayList<User> following = new ArrayList<User>();
	private ArrayList<Tweet>tweets = new ArrayList<Tweet>();



	public User(Long id) {
		super(id);
		name = getName();
		username = getUsername();
		location = getLocation();
	}


	public User(Long id, String name) {
		super(id);
		this.name = name;
	}


	public User(Long id, String name, String username) {
		super(id);
		this.name = name;
		this.username = username;

	}

	public User(Long id, String name, String username, String createdAt) {
		super(id);
		this.name = name;
		this.username = username;
		this.createdAt = createdAt;
	}
	
	
	public User(Long id, String name, String username, String createdAt, boolean verified) {
		super(id);
		this.name = name;
		this.username = username;
		this.createdAt = createdAt;
		this.verified = verified;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public ArrayList<User> getFollowers(){
		return this.followers;
	} 


	public void setFollowers(ArrayList<User> followers) {
		this.followers = followers;
	}


	public int getFollowersCount() {
		return followersCount;
	}


	public void setFollowersCount() {
		this.followersCount = followers.size();
	}

	public ArrayList<User> getFollowing(){
		return this.following;
	} 

	public void setFollowing(ArrayList<User> following) {
		this.following = following;
	}

	public int getFollowingCount() {
		return followingCount;
	}


	public void setFollowingCount() {
		this.followingCount = following.size();
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isProtect() {
		return protect;
	}


	public void setProtect(boolean protect) {
		this.protect = protect;
	}


	public String getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(String createdAt) {	     
		this.createdAt = createdAt;
	}


	public int getFavouritesCount() {
		return favouritesCount;
	}


	public void setFavouritesCount(int favouritesCount) {
		this.favouritesCount = favouritesCount;
	}


	public boolean isVerified() {
		return verified;
	}


	public void setVerified(boolean verified) {
		this.verified = verified;
	}


	public ArrayList<Tweet> getTweets() {
		return tweets;
	}


	public void setTweets(ArrayList<Tweet> tweets) {
		this.tweets = tweets;
	}

	public String UserToString() {
		return "{\"id\": \""+ getId() + "\",\"name\": \"" + getName() + "\",\"username\": \"" + getUsername() + "\",\"created_at\": \"" + getCreatedAt() + "\",\"verified\": \"" + isVerified() + "\"}";
	}

	public String FollowersArrayToString() {

			String aux = "{\"data\":[";
			for(User user : followers) aux += user.UserToString()+",";
			return aux.substring(0,(aux.length()-1))+"]}";
		}

		public String FollowingArrayToString() {

			String aux = "{\"data\":[";
			for(User user : following) aux += user.UserToString()+",";
			return aux.substring(0,(aux.length()-1))+"]}";
		}

		public String TweetToString(Tweet tweet) {
			return "Tweet [id="+ tweet.getId() + ",text=" + tweet.getText() +"]\n";
		}


		public String TweetArrayToString() {
			String aux = "";
			for(Tweet tweet : tweets) aux +=TweetToString(tweet);
			return aux;
		}

	} 