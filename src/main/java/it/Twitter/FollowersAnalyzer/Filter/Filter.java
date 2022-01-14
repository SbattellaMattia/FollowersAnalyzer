package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Model.User;

/**
 * Classe <Code> astratta </Code> Filter.
 * 
 * Converte l'ArrayList di Utenti in una <Code> String </Code> compatibile per essere convertita in JSONObject.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.Filter.FilterByCreation FilterByCreation
 * @see it.Twitter.FollowersAnalyzer.Filter.FilterByFollowers FilterByFollowers
 * @see it.Twitter.FollowersAnalyzer.Filter.FilterByRefollowers FilterByRefollowers
 * @see it.Twitter.FollowersAnalyzer.Filter.FilterByUsername FilterByUsername
 * @see it.Twitter.FollowersAnalyzer.Filter.FilterByVerified FilterByVerified
 */
public abstract class Filter {

	/**
	 * Metodo per convertire i followers in <Code>String</Code>.
	 * 
	 * @param Users ArrayList di Utenti che devono essere convertiti in stringa.
	 * 
	 * @return <Code>String</Code>: Lista di utenti, convertibile in JSONObject.
	 */
	public String UserArrayToString(ArrayList<User> Users) {

		String aux = "{\"data\":[";
		for(User user : Users) aux += user.UserToString()+",";
		return aux.substring(0,(aux.length()-1))+"]}";
	}

}
