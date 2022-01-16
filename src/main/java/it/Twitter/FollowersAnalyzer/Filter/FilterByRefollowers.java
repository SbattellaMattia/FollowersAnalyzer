package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Model.User;

/**
 * Classe FilterByReollowers che estende {@link it.Twitter.FollowersAnalyzer.Filter.Filter Filter}.
 * 
 * Filtra gli utenti che ricambiano il follow.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.Filter.Filter Filter
 */
public class FilterByRefollowers extends Filter {

	
	/**
	 * Metodo che filtra in base agli utenti che ricambiano il follow.
	 * 
	 * @param user : Utente i cui Utenti devono essere filtrati.
	 * 
	 * @return <Code>String</Code>: Stringa di utenti filtrata, convertibile in JSONObject.
	 */
	public String Filter(User user) {

		ArrayList<User> Refollows =new  ArrayList<User>();

		for(User i: user.getFollowers()) {
			for(User j: user.getFollowing())if (j.getId().equals(i.getId())) Refollows.add(i) ;
		}
		return UserArrayToString(Refollows);
	}

}
