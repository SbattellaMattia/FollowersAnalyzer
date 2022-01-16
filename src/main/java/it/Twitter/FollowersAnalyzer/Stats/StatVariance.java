package it.Twitter.FollowersAnalyzer.Stats;

import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Model.User;

/**
 * Classe StatVariation : contiene i metodi necessari allo sviluppo di una statistica. In particolare per il calcolo della varianza del numero di followers, dei followers dell'utente in considerazione.
 *
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 */
public class StatVariance {

	private double sommaSQ=0;
	private double media=0;
	private double varianza=0;

	/**
	 * Costruttore della classe StatVariation. Esegue il calcolo della varianza di followers, dei followers dell'utente passato come parametro.
	 * Lancia un'<Code>ArithmeticException</Code> nel caso il calcolo non vada a buon fine. 
	 * 
	 * @param user : Utente sul quale si vuole eseguire la statistica riguardante la varianza.
	 * @throws NullDataException
	 */
	public StatVariance(User user) throws NullDataException {
		StatAverage med = new StatAverage(user);
		media = med.getMedia();
		for(User i : user.getFollowers()) {
			sommaSQ += (i.getFollowers().size()-media)*(i.getFollowers().size()-media);
		}
		try {
			varianza = Math.round((double)sommaSQ/(user.getFollowers().size()-1)*100.0)/100.0;}
		catch(ArithmeticException e) {
			throw new NullDataException("variance failed.");
		}
	}

	/**
	 * Metodo che restituisce la varianza calcolata.
	 * 
	 * @return <Code>varianza</Code> : valore della varianza.
	 */
	public double getVarianza() {
		return varianza;
	}

	/**
	 * Metodo che setta il valore della varianza.
	 * 
	 * @param varianza : valore della varianza.
	 */
	public void setVarianza(double varianza) {
		this.varianza = varianza;
	}

	/**
	 * Metodo toString per scrivere i dati della varianza in formato <Code>String</Code>.
	 * 
	 * @return <Code>String</Code> : Stringa che rappresenta la varianza; convertibile in <b>JSONObject</b>.
	 */
	public String toString() {
		return "{\"Followers variance(per user)\":[{\"variance\": \""+ varianza + " followers\"}]}";	
	}
}