package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Model.User;

/**
 * Classe FilterByUsername che estende {@link it.Twitter.FollowersAnalyzer.Filter.Filter Filter}.
 * 
 * 
 * Filtra solo gli Utenti con l'username inserito.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.Filter.Filter Filter
 */
public class FilterByUsername extends Filter {
	
	/**
	 * Metodo che filtra i Followers in base all'username passato come parametro, li inserisce 
	 * nell'ArrayList <b>UsernameFollowers</b>.
	 * 
	 * @param user Utente i cui followers dovranno essere filtrati.
	 * @param username Username dei followers da ricercare. 
	 * <b>all</b>=ritorna tutti gli utenti; <b>{username}</b>=ritorna solo i followers con l'username inserito.
	 * 
	 * @throws NullDataException se UsernameFollowers risulta vuoto (nessun Utente con <b>{username}</b> trovato). 
	 * 
	 * @return <Code>String</Code>: Lista dei Followers filtrata per Username, convertibile in JSONObject.
	 * 
	 */
	public String FilterFollower(User user,String username) throws NullDataException {
		ArrayList<User> UsernameFollowers =new  ArrayList<User>();

		if(username.equals("all")) {
			for(User i: user.getFollowers()) {
				UsernameFollowers.add(i) ;}
		}
		else {
			for(User i: user.getFollowers()) {
				if (i.getUsername().equals(username)) UsernameFollowers.add(i);}
		}
		if(UsernameFollowers.isEmpty()) throw new NullDataException(username+" not found");
		return UserArrayToString(UsernameFollowers);
	}

	/**
	 * Metodo che filtra i following in base all'username passato come parametro, li inserisce nell'ArrayList <b>UsernameFollowing</b>.
	 * 
	 * @param user Utente i cui Following dovranno essere filtrati.
	 * @param username Username dei following da ricercare. 
	 * <b>all</b>=ritorna tutti gli utenti; <b>{username}</b>=ritorna solo i following con l'username inserito.
	 * 
	 * @throws NullDataException se UsernameFollowing risulta vuoto (nessun Utente con <b>{username}</b> trovato). 
	 * 
	 * @return <Code>String</Code>: Lista dei Following filtrata per Username, convertibile in JSONObject.
	 * 
	 */
	public String FilterFollowing(User user,String username) throws NullDataException {
		
		ArrayList<User> UsernameFollowing =new  ArrayList<User>();
		
		if(username.equals("all")) {
			for(User i: user.getFollowing()) {
				UsernameFollowing.add(i) ;}
		}
		else {
			for(User i: user.getFollowing()) {
				if (i.getUsername().equals(username)) UsernameFollowing.add(i);}
		}
		if(UsernameFollowing.isEmpty()) throw new NullDataException(username+" not found");
		return UserArrayToString(UsernameFollowing);
	}
	
	
	/**
	 * Metodo che filtra gli Utenti che hanno Retweettato un Tweet in base all'username passato come parametro, li inserisce nell'ArrayList <b>UsernameRetweeted</b>.
	 * 
	 * @param tweet Tweet che è stato Retweettato.
	 * @param username Username da ricercare degli Utenti che hanno Retweettato il Tweet. 
	 * <b>all</b>=ritorna tutti gli Utenti; <b>{username}</b>=ritorna solo gli Utenti che hanno Retweettato un Tweet con l'username inserito.
	 * 
	 * @throws NullDataException se UsernameRetweeted risulta vuoto (nessun Utente con <b>{username}</b> trovato). 
	 * 
	 * @return <Code>String</Code>: Lista degli Utenti che hanno Retweettato il Tweet, filtrata per Username, convertibile in JSONObject.
	 * 
	 */
	public String FilterRetweeted(Tweet tweet,String username) throws NullDataException {
		ArrayList<User> UsernameRetweeted =new  ArrayList<User>();
		
		if(username.equals("all")) {
			for(User i: tweet.getRetweeted_by()) {
				UsernameRetweeted.add(i) ;}
		}
		else {
			for(User i:tweet.getRetweeted_by()) {
				if (i.getUsername().equals(username)) UsernameRetweeted.add(i);}
		}
		if(UsernameRetweeted.isEmpty()) throw new NullDataException(username+" not found");
		return UserArrayToString(UsernameRetweeted);
	}
	
}
