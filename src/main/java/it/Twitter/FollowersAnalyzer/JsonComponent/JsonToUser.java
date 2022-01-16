package it.Twitter.FollowersAnalyzer.JsonComponent;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.Twitter.FollowersAnalyzer.Exceptions.DateException;
import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;

import it.Twitter.FollowersAnalyzer.Model.User;
import it.Twitter.FollowersAnalyzer.Utils.StringToDate;

/** 
* Classe per convertire un <b>JSONObject</b> in {@link User} o <b>ArrayList</b> di tipo {@link User}.
* 
* @author Sbattella Mattia
* @author Sumcutean Sara
* 
*/
public class JsonToUser {
	StringToDate date = new StringToDate();
	
	/**
	 * Il metodo parseUser permette di convertire in {@link User} un <b>JSONObject</b>.
	 * 
	 * @param  JsonUser : JSONObject dell'Utente.
	 * 
	 * @return {@link User}.
	 * 
	 * @throws NullDataException
	 * @throws DateException
	 */
	public User parseUser(JSONObject JsonUser) throws NullDataException, DateException
	{
		if ((JsonUser.get("id"))==null)throw new NullDataException("wrong or inexistent Id");
		
		Long id = Long.parseLong((String) JsonUser.get("id"));
		String name = (String) JsonUser.get("name");    
		String username = (String) JsonUser.get("username");    
		String createdAt = date.stringToDate((String) JsonUser.get("created_at"));
		boolean verified;
		if ((JsonUser.get("verified")).equals(true)) verified = true;
		else verified = false;
	
		User user=new User(id,name,username,createdAt,verified);
		return user; 
	}

	/**
	 * Il metodo parseOneUser permette di convertire in {@link User} un <b>JSONObject</b> 
	 * contenente un <b>JSONArray</b> con un solo elemento.
	 * 
	 * @param  JsonUser : JSONObject dell'Utente.
	 * 
	 * @return {@link User}.
	 * 
	 * @throws NullDataException
	 * @throws DateException
	 */
	public User parseOneUser(JSONObject JsonUser) throws NullDataException, DateException
	{
		JSONObject data = (JSONObject) JsonUser.get("data");
		if(data==null)throw new NullDataException("wrong or inexistent Id.");
		
		Long id = Long.parseLong((String) data.get("id"));    
		String name = (String) data.get("name");    
		String username = (String) data.get("username");    
		String createdAt = date.stringToDate((String) data.get("created_at"));
		boolean verified;
		if ((data.get("verified")).equals(true)) verified = true;
		else verified = false;

		User user=new User(id,name,username,createdAt,verified);
		return user;
	}


	/**
	 * Il metodo parseUsers permette di convertire in <b>ArrayList</b> di tipo {@link User}
	 * un <b>JSONObject</b> contenente un <b>JSONArray</b> con più elementi.
	 * 
	 * @param  JsonUsers : JSONObject del JSONArray di Utenti.
	 * 
	 * @return <b>ArrayList</b> di tipo {@link User}.
	 * 
	 * @throws NullDataException
	 * @throws DateException
	 */
	public ArrayList<User> parseUsers(JSONObject JsonUsers) throws NullDataException, DateException
	{
		ArrayList<User> followers = new ArrayList<User>(); 
		JSONArray data = (JSONArray) JsonUsers.get("data");
		if(data == null) throw new NullDataException("no Users match");
		@SuppressWarnings("unchecked")
		Iterator<JSONObject> iterator = data.iterator();

		while (iterator.hasNext()) {
			followers.add(parseUser(iterator.next()));   
		}
		return followers;
	}

}   
