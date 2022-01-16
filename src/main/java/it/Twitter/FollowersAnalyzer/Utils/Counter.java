package it.Twitter.FollowersAnalyzer.Utils;

import java.util.HashMap;
import java.util.Map;
import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Model.User;
/**
* Classe per contare le occorrenze dei like per Utente.
* 
* @author Sbattella Mattia
* @author Sumcutean Sara
* 
*/
public class Counter {

	/**
	 * Metodo counter, conta il numero di like per Utente ai Tweet di uno specifico Utente.
	 * 
	 * @param User
	 * @return <Code>String</Code>: Stringa di Utenti (in ordine Decrescente) in base al numero totale di like messi, 
	 * convertibile in <b>JSONObject</b>.
	 */
	public String counter(User User) {
		Map<User, Integer> counter = new HashMap<User, Integer>();
		
		
		for(Tweet i : User.getTweets()) {
			for(User j : i.getLikingUsers()) {
				if(counter.containsKey(j)) {
					Integer numOccurrence = counter.get(j);
					numOccurrence++;
					counter.replace(j,numOccurrence);}
				else counter.put(j,1);
			}
		}	
		return counterToString(counter);
	}

	
	/**
	 * Metodo counterToString per convertire l'<b>HashMap</b> in <Code>String</Code>.
	 * 
	 * @param Counter Rappresenta l'<b>HashMap</b> (chiave={@link User},valore=n.Like).
	 * @return <Code>String</Code>: Stringa di Utenti (in ordine Decrescente) in base al numero totale di like messi, 
	 * convertibile in <b>JSONObject</b>.
	 */
	public String counterToString(Map<User,Integer> Counter ) {
		String aux="{\"data\" :[";

		Integer maxValue=0;
		User maxKey=new User(0L);

		while(!Counter.isEmpty()) {
			for(Map.Entry<User,Integer> entry :  Counter.entrySet()) {
				
				User key = entry.getKey();
				Integer value = entry.getValue();

				if(maxValue<value) {
					maxValue=value;
					maxKey=key;
				}
			}
			aux+=maxKey.UserToString();
			aux=aux.substring(0,(aux.length()-1))+",\"LIKE OCCURRENCES\":"+maxValue+"},";
			Counter.remove(maxKey);
			maxValue=0;
		}
		return aux.substring(0,(aux.length()-1))+"]}";
	}
	
}
