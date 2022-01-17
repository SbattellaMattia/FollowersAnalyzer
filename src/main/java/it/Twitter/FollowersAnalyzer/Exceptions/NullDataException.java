package it.Twitter.FollowersAnalyzer.Exceptions;

/**
 * Classe NullDataException che estende {@link Exception}.
 * 
 * Viene lanciata quando la ricerca effettuata non restituisce nessun output.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 */

public class NullDataException extends Exception{
	/**
	 * Messaggio generico che caratterizza la classe NullDataException.
	 */
	final static String message="Data is null: ";
	private static final long serialVersionUID = 1L;
	
	/**
	 * Costruttore della classe NullDataException.
	 * 
	 * @param mex : Messaggio specifico aggiuntivo che descrive l'errore riscontrato .
	 */
	public NullDataException(String mex) {
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
