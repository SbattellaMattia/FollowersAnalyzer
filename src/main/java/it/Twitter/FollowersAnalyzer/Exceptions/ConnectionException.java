package it.Twitter.FollowersAnalyzer.Exceptions;

/**
 * Classe ConnectionException che estende  {@link Exception}.
 * 
 * Viene lanciata quando fallisce la connessione con il server API di Twitter.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 */

public class ConnectionException extends Exception{
	/**
	 * Messaggio generico che caratterizza la classe ConnectionException.
	 */
	final static String message="Connection failed, plese retry in few minutes.Sorry for the inconvenient. Problem: ";
	private static final long serialVersionUID = 1L;
	
	/**
	 * Costruttore della classe ConnectionException.
	 * 
	 * @param mex : Messaggio specifico aggiuntivo che descrive l'errore riscontrato .
	 */
	public ConnectionException(String mex) {
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
