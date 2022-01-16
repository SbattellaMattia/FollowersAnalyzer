package it.Twitter.FollowersAnalyzer.Stats;

import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Model.User;

/**
 * Classe StatsLikes : contiene i metodi necessari allo sviluppo di una statistica. In particolare per il calcolo della percentuale di followers che hanno messo like al tweet di un utente rispetto al totale di followers dell'utente.
 *
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 */
public class StatsLikes {
	private int followers=0;
	private int likes=0;
	private double percentage=0;

	/**
	 * Costruttore della classe StatsLikes. Esegue il calcolo della percentuale di followers che hanno messo like al tweet di un utente rispetto al totale di followers dell'utente.
	 * Lancia un'<Code>ArithmeticException</Code> nel caso il calcolo non vada a buon fine. 
	 * 
	 * @param user : Utente sul quale si vuole eseguire la statistica.
	 * @param tweet : Tweet del quale si vuole eseguire la statistica.
	 * @throws NullDataException
	 */
	public StatsLikes(User user, Tweet tweet) throws NullDataException {
		followers=user.getFollowers().size();
		likes=tweet.getLikingUsers().size();
		try {
			percentage=Math.round((double)likes*100/followers*100.0)/100.0;}
		catch(ArithmeticException e) {
			throw new NullDataException("Operation failed.");}
	}

	/**
	 * Metodo che restituisce la percentuale calcolata.
	 * 
	 * @return <Code>percentage</Code> : valore della percentuale.
	 */
	public double getPercentage() {
		return percentage;
	}

	/**
	 * Metodo toString per scrivere i dati della percentuale in formato <Code>String</Code>.
	 * 
	 * @return <Code>String</Code> : Stringa che rappresenta la percentuale; convertibile in <b>JSONObject</b>.
	 */
	public String toString() {
		return "{\"Percentage of followers who liked the tweet\":[{\"percentage\": \""+ percentage + " %\"}]}";	
	}
}
