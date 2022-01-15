package it.Twitter.FollowersAnalyzer.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/**
 * Classe <Code>astratta</Code> Service.
 * 
 * Instaura un collegamento con i server API di Twitter.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.Service.ServiceFollowers ServiceFollowers
 * @see it.Twitter.FollowersAnalyzer.Service.ServiceFollowing ServiceFollowing
 * @see it.Twitter.FollowersAnalyzer.Service.ServiceLikedTweets ServiceLikedTweets
 * @see it.Twitter.FollowersAnalyzer.Service.ServiceLikingUsers ServiceLikingUsers
 * @see it.Twitter.FollowersAnalyzer.Service.ServiceRetweeted_by ServiceRetweeted_by
 * @see it.Twitter.FollowersAnalyzer.Service.ServiceTweetById ServiceTweetById
 * @see it.Twitter.FollowersAnalyzer.Service.ServiceTweets ServiceTweets
 * @see it.Twitter.FollowersAnalyzer.Service.ServiceUserById ServiceUserById
 * @see it.Twitter.FollowersAnalyzer.Service.ServiceUserByUsername ServiceUserByUsername
 */

public abstract class Service {	
	/**
	 * Token che autorizza la richiesta ai server API di Twitter.
	 */
	private String BearerToken;
	/**
	 *Url relativo alla specifica richiesta da effettuare ai server API di Twitter.
	 */
	protected String Url;
	
	final String PATTERN_USER_ID="https://api.twitter.com/2/users/";
	final String PATTERN_TWEET_ID="https://api.twitter.com/2/tweets/";
	final String PATTERN_USER_FIELDS="user.fields=created_at,verified";
	final String PATTERN_TWEET_FIELDS="tweet.fields=created_at,author_id";
	final String PATTERN_MAX_RESULTS="max_results=10";
	final String PARAMETER="?";
	final String AND="&";
	
	/**
	 * Costruttore della classe Service: imposta il <b>BearerToken</b> per l'autorizzazione
	 */
	public Service() {
		this.BearerToken = "AAAAAAAAAAAAAAAAAAAAABIfWgEAAAAAAOF%2FgMH8TPODq1PwU9Qu0jIyJW4%3DKAuT33sk6LZuTaZR89Pyo9H0rRt6W8GYYxQNP6USsNPbNoHhb6";
		//this.BearerToken = "AAAAAAAAAAAAAAAAAAAAAMlcXQEAAAAAYb28sKQdHrua1w1PqUY2oP9OjM0%3DTQ81FuSWRLb8px1DIHkx5Knk2ZD4guUN6KZiNNPKBov6X5rpAu";
	}

	
	/**
	 * Metodo per instaurare il collegamento con il server API di Twitter
	 * 
	 * @param Url L'url della specifica rotta con la quale instaurare il collegamento.
	 * 
	 * @throws IOException
	 * @throws ConnectionException
	 * 
	 * @return <Code>String</Code>: Stringa contenente la risposta del server API di Twitter, trasformabile in <b>JSONObject</b>.
	 * 
	 */
	public String Connection(String Url) throws IOException,ConnectionException {
		String aux="";
		String line="";

		// Sending get request
		try {
			URLConnection openConnection = new URL(Url).openConnection();
			openConnection.setRequestProperty("Authorization","Bearer "+ BearerToken);
			InputStream input = openConnection.getInputStream();
			try {
				InputStreamReader reader = new InputStreamReader(input);
				BufferedReader buf = new BufferedReader(reader);
				while ( ( aux = buf.readLine() ) != null ) {
					line+= aux;
				}
			}catch (IOException e) {
				throw new ConnectionException("Input text is null or interrupted I/O operation");} 
			finally {
				input.close();}
		}catch (IOException e) {
			throw new ConnectionException("Too many request");} 

		
		return line;
	}


}


