package it.Twitter.FollowersAnalyzer.Stats;

import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Model.User;

/**
 * Classe StatAverage : contiene i metodi necessari allo sviluppo di una statistica. In particolare per il calcolo della media del numero di followers, dei followers dell'utente in considerazione.
 *
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 */

public class StatAverage {

	private int somma=0;
	private double media=0;

	/**
	 * Costruttore della classe StatAverage. Esegue il calcolo della media di followers, dei followers dell'utente passato come parametro.
	 * Lancia un'<Code>ArithmeticException</Code> nel caso il calcolo non vada a buon fine.
	 * 
	 * @param user : Utente sul quale si vuole eseguire la statistica riguardante la media.
	 * @throws NullDataException
	 */
	public StatAverage(User user) throws NullDataException {

		for(User i: user.getFollowers()) {
			somma+=i.getFollowers().size();}
		try {
			media=Math.round((double)somma/user.getFollowers().size()*100.0)/100.0;}
		catch(ArithmeticException e) {
			throw new NullDataException("Average failed.");}

	}

	/**
	 * Metodo che restituisce la media calcolata.
	 * 
	 * @return <Code>media</Code> : valore della media.
	 */
	public double getMedia() {
		return media;
	}

	/**
	 * Metodo toString per scrivere i dati della media in formato <Code>String</Code>.
	 * 
	 * @return <Code>String</Code> : Stringa che rappresenta la media; convertibile in <b>JSONObject</b>.
	 */
	public String toString() {
		return "{\"Average Followers(per user)\":[{\"average\": \""+ media + " followers\"}]}";	
	}

}
