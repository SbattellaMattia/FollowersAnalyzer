package it.Twitter.FollowersAnalyzer.Exceptions;

/**
 * Classe DateException che estende  {@link Exception}.
 * 
 * Viene lanciata quando la data inserita non è del formato corretto.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 *  @see it.Twitter.FollowersAnalyzer.Filter.FilterByCreation FilterByCreation
 */

public class DateException extends Exception {
	/**
	 * Messaggio generico che caratterizza la classe DateException.
	 */
	final static String message="Wrong type of data: ";
	private static final long serialVersionUID = 3L;
	
	/**
	 * Costruttore della classe DateException.
	 * 
	 * @param mex : Messaggio specifico aggiuntivo che descrive l'errore riscontrato .
	 */
	public DateException(String mex) {
		super(message+mex);
	}
	
	/**
	 * Metodo per ritornare l'errore in una stringa convertibile in JSONObject.
	 * 
	 * @return <Code>String</Code>: contenente il messaggio generico concatenato al messaggio specifico.
	 */
	public String getError() {
		return "{\"error message\":\""+ getMessage()+"\"}";
	}
	
}
