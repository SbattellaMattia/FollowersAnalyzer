package it.Twitter.FollowersAnalyzer.Exceptions;

/**
 * Classe WrongParameter che estende  {@link Exception}.
 * 
 * Viene lanciata quando i parametri immessi dall'utilizzatore sono errati.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 */

public class WrongParameter extends Exception{
	/**
	 * Messaggio generico che caratterizza la classe WrongParameter.
	 */
	final static String message="Wrong or inexistent parameter: ";
	private static final long serialVersionUID = 4L;
	
	/**
	 * Costruttore della classe WrongParameter.
	 * 
	 * @param mex Messaggio specifico aggiuntivo che descrive l'errore riscontrato .
	 */
	public WrongParameter(String mex) {
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
