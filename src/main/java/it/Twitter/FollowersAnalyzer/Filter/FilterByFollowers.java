package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Model.User;


/**
 * Classe FilterByFollowers che estende {@link it.Twitter.FollowersAnalyzer.Filter.Filter Filter}.
 * 
 * 
 * Tra gli Utenti che hanno messo like ad un tweet filtra quelli che sono followers.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.Filter.Filter Filter
 */
public class FilterByFollowers extends Filter{

	/**
	 * Metodo che filtra in base al method inserito.
	 * 
	 * @param user Utente i cui followers dovranno essere filtrati.
	 * @param tweet Tweet con gli Uenti che gli hanno messo like.
	 * @param method Metodo di filtraggio: 
	 * <b>all</b>=ritorna tutti gli utenti; <b>followers</b>=ritorna solo i followers.
	 * 
	 * @throws WrongParameter se method è diverso da "all" o "followers".
	 * 
	 * @return <Code>String</Code>: Lista di utenti filtrata, convertibile in JSONObject.
	 */
	public String Filter(User user,Tweet tweet,String method) throws WrongParameter {

		if(method.equals("all")) {
			return UserArrayToString(tweet.getLikingUsers());}
		if(method.equals("followers")) {

			ArrayList<User> likingFollowers = searchLikingFollowers(user,tweet);
			return UserArrayToString(likingFollowers);}

		else throw new WrongParameter("\""+method+"\" is not allowed.");
	}
	
	/**
	 * Metodo per filtrare i followers.
	 * Confronta l'id dei Followers di un utente con l'id degli Utenti che hanno messo like al Tweet.
	 * Se sono uguali li aggiunge all'ArrayList di <b>likingFollowers</b>.
	 * 
	 * @param user Utente i cui followers dovranno essere filtrati.
	 * @param tweet Tweet con gli Uenti che gli hanno messo like.
	 * 
	 * 
	 * @return <Code>ArrayList</Code> : <b>likingFollowers</b> 
	 */
	public ArrayList<User> searchLikingFollowers(User user,Tweet tweet) {
		ArrayList<User> likingFollowers = new  ArrayList<User>();
		for(User i : tweet.getLikingUsers()) {
			for(User j : user.getFollowers()) {
				if (j.getId().equals(i.getId()))likingFollowers.add(i);
			}
		}
		return likingFollowers;
	}

}
