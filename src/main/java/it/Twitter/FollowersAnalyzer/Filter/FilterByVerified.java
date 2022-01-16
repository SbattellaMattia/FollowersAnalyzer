package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.Model.User;

/**
* Classe FilterByVerified che estende {@link it.Twitter.FollowersAnalyzer.Filter.Filter Filter}.
* 
* 
* Filtra gli Utenti verificati/non verificati.
* 
* @author Sbattella Mattia
* @author Sumcutean Sara
* 
* @see it.Twitter.FollowersAnalyzer.Filter.Filter Filter
*/
public class FilterByVerified extends Filter {

	ArrayList<User> NameFollowersVerified =new  ArrayList<User>();
	ArrayList<User> NameFollowersNotVerified =new  ArrayList<User>();

	
	
	/**
	* Metodo che filtra i Followers in base al verificato/non verificato
	* 
	* Filtra gli Utenti verificati/non verificati e li inserisce in due ArrayList diversi.
	* 
	* @param user : Utente i cui Followers verranno filtrati.
	*/
	public void Filter(User user) {

		for(User i: user.getFollowers()) {
			if (i.isVerified()) NameFollowersVerified.add(i);
			else NameFollowersNotVerified.add(i);
		}
	}

	
	/**
	 * Metodo che filtra i Followers in base al verificato/non verificato
	 * 
	 * @param method : Metodo di filtraggio: 
	 * <b>all</b>=ritorna tutti gli utenti; <b>verified</b>=ritorna solo i followers verificati;
	 * <b>not_verified</b>=ritorna solo i followers non verificati.
	 * 
	 * @throws NullDataException se il method da ricercare non restituisce nessun Utente. 
	 * @throws WrongParameter se method e' diverso da <b>all</b>, <b>verified</b> o <b>not_verified</b>.
	 * 
	 * @return <Code>String</Code>: Stringa dei Followers filtrata per verificato, convertibile in JSONObject.
	 * 
	 */
	public String FilterToString(String method) throws WrongParameter, NullDataException {
	
			if(method.equals("verified")) {
				if(NameFollowersVerified.isEmpty()) throw new NullDataException("No users match the requests.");
				return "{\"Verified followers:\": " + UserArrayToString(NameFollowersVerified) + "}";
			}
		
			if(method.equals("not_verified")) {
				if(NameFollowersNotVerified.isEmpty()) throw new NullDataException("No users match the requests.");
				return "{\"Unverified followers:\": " + UserArrayToString(NameFollowersNotVerified) + "}";
			}
		
			if(method.equals("all")) {
				if(NameFollowersVerified.isEmpty() && NameFollowersNotVerified.isEmpty()) throw new NullDataException("No users match the requests.");
				if(NameFollowersVerified.isEmpty()) return "{\"Unverified followers:\": " + UserArrayToString(NameFollowersNotVerified) + "}";
				if(NameFollowersNotVerified.isEmpty()) return "{\"Verified followers:\": " + UserArrayToString(NameFollowersVerified) + "}";
				else return "{\"Verified followers:\": " + UserArrayToString(NameFollowersVerified) + "}," + "{\"Unverified followers:\": " + UserArrayToString(NameFollowersNotVerified) + "}";
			}

		throw new WrongParameter(" \""+method+"\" is not allowed.");
	}
}
