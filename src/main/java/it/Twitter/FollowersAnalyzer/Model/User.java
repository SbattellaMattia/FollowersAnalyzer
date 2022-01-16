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

	/**
	 * Metodo che restituisce l'username dell'utente.
	 * 
	 * @return <Code>username</Code> : username dell'utente.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Metodo che setta l'username dell'utente.
	 * 
	 * @param username : username dell'utente.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Metodo che restituisce l'<b>ArrayList</b> di followers dell'utente.
	 * 
	 * @return <Code>followers</Code> : <b>ArrayList</b> di followers dell'utente.
	 */
	public ArrayList<User> getFollowers(){
		return this.followers;
	} 

	/**
	 * Metodo che setta i followers dell'utente.
	 * 
	 * @param followers :  Rappresenta l'<b>ArrayList</b> di followers dell'utente.
	 */
	public void setFollowers(ArrayList<User> followers) {
		this.followers = followers;
	}

	/**
	 * Metodo che restituisce il numero di followers dell'utente.
	 * 
	 * @return <Code>followersCount</Code> : numero di followers dell'utente.
	 */
	public int getFollowersCount() {
		return followersCount;
	}

	/**
	 * Metodo che setta il numero di followers dell'utente.
	 * 
	 * @param followersCount :  Rappresenta il numero di followers dell'utente.
	 */
	public void setFollowersCount() {
		this.followersCount = followers.size();
	}

	/**
	 * Metodo che restituisce l'<b>ArrayList</b> degli utenti seguiti dall'utente.
	 * 
	 * @return <Code>following</Code> : <b>ArrayList</b> di utenti seguiti dall'utente.
	 */
	public ArrayList<User> getFollowing(){
		return this.following;
	} 

	/**
	 * Metodo che setta gli utenti seguiti dall'utente.
	 * 
	 * @param following :  Rappresenta l'<b>ArrayList</b> degli utenti seguiti dall'utente.
	 */
	public void setFollowing(ArrayList<User> following) {
		this.following = following;
	}

	/**
	 * Metodo che restituisce il numero di utenti seguiti dall'utente.
	 * 
	 * @return <Code>followingCount</Code> : numero di utenti seguiti dall'utente.
	 */
	public int getFollowingCount() {
		return followingCount;
	}

	/**
	 * Metodo che setta il numero di utenti seguiti dall'utente.
	 * 
	 * @param followingCount :  Rappresenta il numero di utenti seguiti dall'utente.
	 */
	public void setFollowingCount() {
		this.followingCount = following.size();
	}

	/**
	 * Metodo che restituisce la località associata all'account dell'utente.
	 * 
	 * @return <Code>location</Code> : località associata all'account dell'utente.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Metodo che setta la località associata all'account dell'utente.
	 * 
	 * @param location : località associata all'account dell'utente.
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Metodo che restituisce la descrizione associata all'account dell'utente.
	 * 
	 * @return <Code>description</Code> : descrizione associata all'account dell'utente.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metodo che setta la descrizione associata all'account dell'utente.
	 * 
	 * @param description : descrizione associata all'account dell'utente.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Metodo che restituisce un valore booleano in base a se il profilo dell'utente è protetto o meno.
	 * 
	 * @return <Code>protect</Code> : valore booleano che descrive se il profilo dell'utente è protetto o meno.
	 */
	public boolean isProtect() {
		return protect;
	}

	/**
	 * Metodo che setta un valore booleano in base a se il profilo dell'utente è protetto o meno.
	 * 
	 * @param protect : valore booleano che descrive se il profilo dell'utente è protetto o meno.
	 */
	public void setProtect(boolean protect) {
		this.protect = protect;
	}

	/**
	 * Metodo che restituisce la data di creazione dell'account dell'utente.
	 * 
	 * @return <Code>createdAt</Code> : data di creazione dell'account dell'utente nel formato <b>dd/MM/yyyy</b>.
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * Metodo che setta la data di creazione dell'account dell'utente.
	 * 
	 * @param createdAt : data di creazione dell'account dell'utente nel formato <b>dd/MM/yyyy</b>.
	 */
	public void setCreatedAt(String createdAt) {	     
		this.createdAt = createdAt;
	}

	/**
	 * Metodo che restituisce un valore booleano in base a se il profilo dell'utente è verificato o meno.
	 * 
	 * @return <Code>verified</Code> : valore booleano che descrive se il profilo dell'utente è verificato o meno.
	 */
	public boolean isVerified() {
		return verified;
	}

	/**
	 * Metodo che setta un valore booleano in base a se il profilo dell'utente è verificato o meno.
	 * 
	 * @param verified : valore booleano che descrive se il profilo dell'utente è verificato o meno.
	 */
	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	/**
	 * Metodo che restituisce l'<b>ArrayList</b> dei tweet dell'utente.
	 * 
	 * @return <Code>tweets</Code> : <b>ArrayList</b> di tweet dell'utente.
	 */
	public ArrayList<Tweet> getTweets() {
		return tweets;
	}

	/**
	 * Metodo che setta i tweet dell'utente.
	 * 
	 * @param tweets :  Rappresenta l'<b>ArrayList</b> dei tweet dell'utente.
	 */
	public void setTweets(ArrayList<Tweet> tweets) {
		this.tweets = tweets;
	}

	/**
	 * Metodo che restituisce l'<b>ArrayList</b> dei tweet a cui l'utente ha messo like.
	 * 
	 * @return <Code>likedTweets</Code> : <b>ArrayList</b> di tweet a cui l'utente ha messo like.
	 */
	public ArrayList<Tweet> getLikedTweets() {
		return likedTweets;
	}

	/**
	 * Metodo che setta i tweet a cui l'utente ha messo like.
	 * 
	 * @param likedTweets :  Rappresenta l'<b>ArrayList</b> dei tweet a cui l'utente ha messo like.
	 */
	public void setLikedTweets(ArrayList<Tweet> likedTweets) {
		this.likedTweets = likedTweets;
	}

	/**
	 * Metodo UserToString per scrivere i dati dell'utente in formato <Code>String</Code>.
	 * 
	 * @return <Code>String</Code> : Stringa che rappresenta i dati dell'utente convertibile in <b>JSONObject</b>.
	 */
	public String UserToString() {
		return "{\"id\": \""+ getId() + "\",\"name\": \"" + getName() + "\",\"username\": \"" + getUsername() + "\",\"created_at\": \"" + getCreatedAt() + "\",\"verified\": " + isVerified() + "}";
	}

	/**
     * Metodo FollowersArrayToString per scrivere l'elenco dei followers dell'utente in formato <Code>String</Code>.
     * 
     * @return <Code>String</Code> : Stringa che rappresenta i followers convertibile in <b>JSONObject</b>.
     */
	public String FollowersArrayToString() {
		String aux = "{\"data\":[";
		for(User user : followers) aux += user.UserToString()+",";
		return aux.substring(0,(aux.length()-1))+"]}";
	}

	/**
     * Metodo FollowingArrayToString per scrivere l'elenco degli utenti seguiti dall'utente in formato <Code>String</Code>.
     * 
     * @return <Code>String</Code> : Stringa che rappresenta gli utenti seguiti convertibile in <b>JSONObject</b>.
     */
	public String FollowingArrayToString() {
		String aux = "{\"data\":[";
		for(User user : following) aux += user.UserToString()+",";
		return aux.substring(0,(aux.length()-1))+"]}";
	}

	/**
     * Metodo TweetArrayToString per scrivere l'elenco dei tweet dell'utente in formato <Code>String</Code>.
     * 
     * @return <Code>String</Code> : Stringa che rappresenta l'elenco dei tweet convertibile in <b>JSONObject</b>.
     */
	public String TweetArrayToString() {
		String aux = "{\"data\":[";
		for(Tweet tweet : tweets) aux += tweet.TweetToString()+",";
		return aux.substring(0,(aux.length()-1))+"]}";
	}

	/**
     * Metodo LikedTweetArrayToString per scrivere l'elenco dei tweet ai quali l'utente ha messo like in formato <Code>String</Code>.
     * 
     * @return <Code>String</Code> : Stringa che rappresenta l'elenco dei tweet convertibile in <b>JSONObject</b>.
     */
	public String LikedTweetArrayToString() {
		String aux = "{\"data\":[";
		for(Tweet tweet : likedTweets) aux += tweet.TweetToString()+",";
		return aux.substring(0,(aux.length()-1))+"]}";
	}

} 