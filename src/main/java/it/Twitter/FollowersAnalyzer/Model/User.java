package it.Twitter.FollowersAnalyzer.Model;

import java.util.ArrayList;

/** Questa classe descrive le proprietà di ogni Utente Twitter. Estende la classe {@link it.Twitter.FollowersAnalyzer.Model.Super Super}
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.Model.Super Super
 */

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
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayList<Tweet> likedTweets = new ArrayList<Tweet>();


	/**
	 * Costruttore della classe User.
	 * 
	 * @param id : Id dell'Utente.
	 */
	public User(Long id) {
		super(id);
		name = getName();
		username = getUsername();
		location = getLocation();
	}

	/**
	 * Costruttore della classe User.
	 * 
	 * @param id : Id dell'Utente.
	 * @param name : Nome dell'utente.
	 */
	public User(Long id, String name) {
		super(id);
		this.name = name;
	}

	/**
	 * Costruttore della classe User.
	 * 
	 * @param id : Id dell'Utente.
	 * @param name : Nome dell'utente.
	 * @param username : Username dell'utente.
	 */
	public User(Long id, String name, String username) {
		super(id);
		this.name = name;
		this.username = username;

	}

	/**
	 * Costruttore della classe User.
	 * 
	 * @param id : Id dell'Utente.
	 * @param name : Nome dell'utente.
	 * @param username : Username dell'utente.
	 * @param createdAt : Data di creazione dell'utente da inserire nel formato <b>dd/MM/yyyy</b>.
	 */
	public User(Long id, String name, String username, String createdAt) {
		super(id);
		this.name = name;
		this.username = username;
		this.createdAt = createdAt;
	}
	
	/**
	 * Costruttore della classe User.
	 * 
	 * @param id : Id dell'Utente.
	 * @param name : Nome dell'utente.
	 * @param username : Username dell'utente.
	 * @param createdAt : Data di creazione dell'utente da inserire nel formato <b>dd/MM/yyyy</b>.
	 * @param verified : Valore booleano che indica il verificato del profilo utente.
	 */
	public User(Long id, String name, String username, String createdAt, boolean verified) {
		super(id);
		this.name = name;
		this.username = username;
		this.createdAt = createdAt;
		this.verified = verified;
	}

	/**
     * Metodo che restituisce il nome dell'utente.
     * 
     * @return <Code>name</Code> : nome dell'utente.
     */
	public String getName() {
		return name;
	}

	/**
     * Metodo che setta il nome dell'utente.
     * 
     * @param name : nome dell'utente.
     */
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
	
	public ArrayList<Tweet> getLikedTweets() {
		return likedTweets;
	}

	
	public void setLikedTweets(ArrayList<Tweet> likedTweets) {
		this.likedTweets = likedTweets;
	}
	
	
	public String UserToString() {
		return "{\"id\": \""+ getId() + "\",\"name\": \"" + getName() + "\",\"username\": \"" + getUsername() + "\",\"created_at\": \"" + getCreatedAt() + "\",\"verified\": " + isVerified() + "}";
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
			return "{\"id\": \""+ tweet.getId() + "\",\"text\": \"" + tweet.getText() + "\",\"created_at\": \""+ tweet.getCreatedAt() + "\",\"author_id\": \"" + tweet.getAuthorId() +"\"}";
		}

		public String TweetArrayToString() {
			String aux = "{\"data\":[";
			for(Tweet tweet : tweets) aux += TweetToString(tweet)+",";
			return aux.substring(0,(aux.length()-1))+"]}";
		}
		
		public String LikedTweetArrayToString() {
			String aux = "{\"data\":[";
			for(Tweet tweet : likedTweets) aux += TweetToString(tweet)+",";
			return aux.substring(0,(aux.length()-1))+"]}";
		}

	} 