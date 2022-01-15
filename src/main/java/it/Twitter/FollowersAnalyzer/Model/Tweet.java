package it.Twitter.FollowersAnalyzer.Model;

import java.util.ArrayList;

/** Questa classe descrive le proprietà di ogni tweet. Estende la classe {@link it.Twitter.FollowersAnalyzer.Model.Super Super}
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.Model.Super Super
 */

public class Tweet extends Super{

	private int likes;
	private String text;
	private String createdAt;
	private Long authorId;
	private ArrayList<User> retweeted_by = new  ArrayList<User>();
	private ArrayList<User> likingUsers = new  ArrayList<User>();


	/**
	 * Costruttore della classe Tweet.
	 * 
	 * @param id : Id del tweet.
	 */
	public Tweet(Long id) {
		super(id);
	}

	
	/**
	 * Costruttore della classe Tweet.
	 * 
	 * @param id : Id del tweet.
	 * @param text : Testo del tweet.
	 */
	public Tweet(Long id, String text) {
		super(id);
		this.text=text;
	}

	
	/**
	 * Costruttore della classe Tweet.
	 * 
	 * @param id : Id del tweet.
	 * @param text : Testo del tweet.
	 * @param createdAt : Data di creazione da inserire nel formato <b>dd/MM/yyyy</b>.
	 * @param authorId : Id nel formato Long dell'utente che ha fatto il tweet.
	 */
	public Tweet(Long id, String text, String createdAt, Long authorId) {
		super(id);
		this.text=text;
		this.createdAt=createdAt;
		this.authorId=authorId;
	}

	/**
     * Metodo che restituisce la data di creazione del tweet.
     * 
     * @return <Code>createdAt</Code> : data di creazione del tweet nel formato <b>dd/MM/yyyy</b>.
     */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
     * Metodo che setta la data di creazione del tweet.
     * 
     * @param createdAt : data di creazione del tweet nel formato <b>dd/MM/yyyy</b>.
     */
	public void setCreatedAt(String createdAt) {	     
		this.createdAt = createdAt;
	}

	/**
     * Metodo che restituisce l'id dell'utente autore del tweet.
     * 
     * @return <Code>authorId</Code> : id dell'autore.
     */
	public Long getAuthorId() {
		return authorId;
	}

	/**
     * Metodo che setta l'id dell'utente autore del tweet.
     * 
     * @param createdAt : id dell'autore.
     */
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	/**
     * Metodo che restituisce il numero di likes messi al tweet.
     * 
     * @return <Code>likes</Code> : likes del tweet.
     */
	public int getLikes() {
		return likes;
	}

	/**
     * Metodo che restituisce il testo del tweet.
     * 
     * @return <Code>text</Code> : testo del tweet.
     */
	public String getText() {
		return text;
	}

	/**
     * Metodo TweetToString per scrivere i dati del tweet in formato <Code>String</Code>.
     * 
     * @return <Code>String</Code> : Stringa che rappresenta i dati del tweet convertibile in <b>JSONObject</b>.
     */
	public String TweetToString() {
		return "{\"id\": \""+ getId() + "\",\"text\": \"" + getText() + "\",\"created_at\": \""+ getCreatedAt() + "\",\"author_id\": \"" + getAuthorId() +"\"}";
	}

	/**
     * Metodo RetweetedByArrayToString per scrivere i dati degli utenti che hanno ritwittato il tweet in formato <Code>String</Code>.
     * 
     * @return <Code>String</Code> : Stringa che rappresenta gli utenti convertibile in <b>JSONObject</b>.
     */
	public String RetweetedByArrayToString() {

		String aux = "{\"data\":[";
		for(User user : retweeted_by) aux += "{\"id\": \""+ user.getId() + "\",\"name\": \"" + user.getName() + "\",\"username\": \"" + user.getUsername() + "\",\"created_at\": \"" + user.getCreatedAt() + "\",\"verified\": \"" + user.isVerified() + "\"},";
		return aux.substring(0,(aux.length()-1))+"]}";
	}

	/**
     * Metodo che restituisce l'<b>ArrayList</b> degli utenti che hanno messo like al tweet.
     * 
     * @return <Code>likingUsers</Code> : <b>ArrayList</b> degli utenti che hanno messo like al tweet.
     */
	public ArrayList<User> getLikingUsers() {
		return likingUsers;
	}

	/**
     * Metodo che setta gli utenti che hanno messo like al tweet.
     * 
     * @param likingUsers : Rappresenta l'<b>ArrayList</b> degli utenti che hanno messo like al tweet.
     */
	public void setLikingUsers(ArrayList<User> likingUsers) {
		this.likingUsers = likingUsers;
	}
	
	/**
     * Metodo che restituisce l'<b>ArrayList</b> degli utenti che hanno ritwittato il tweet.
     * 
     * @return <Code>likingUsers</Code> : <b>ArrayList</b> degli utenti che hanno ritwittato il tweet.
     */
	public ArrayList<User> getRetweeted_by() {
		return retweeted_by;
	}

	/**
     * Metodo che setta gli utenti che hanno ritwittato il tweet.
     * 
     * @param retweeted_by : Rappresenta l'<b>ArrayList</b> degli utenti che hanno ritwittato il tweet.
     */
	public void setRetweeted_by(ArrayList<User> retweeted_by) {
		this.retweeted_by = retweeted_by;
	}

	/**
     * Metodo LikingUsersArrayToString che converte l'<b>ArrayList</b> degli utenti che hanno messo like a tweet in formato <Code>String</Code>.
     * 
     * @return <Code>String</Code> : Stringa che rappresenta gli utenti che hanno messo like a tweet convertibile in <b>JSONObject</b>.
     */
	public String LikingUsersArrayToString() {

		String aux = "{\"data\":[";
		for(User user : likingUsers) aux += "{\"id\": \""+ user.getId() + "\",\"name\": \"" + user.getName() + "\",\"username\": \"" + user.getUsername() + "\",\"created_at\": \"" + user.getCreatedAt() + "\",\"verified\": \"" + user.isVerified() + "\"},";
		return aux.substring(0,(aux.length()-1))+"]}";
	}

}
