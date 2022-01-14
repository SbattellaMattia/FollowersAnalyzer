package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/**
* Classe ServiceUserByUsername che estende {@link it.Twitter.FollowersAnalyzer.Service.Service Service}.
* 
* Dato l'Username di un Utente restituisce l'Utente stesso.
* 
* @author Sbattella Mattia
* @author Sumcutean Sara
* 
* @see it.Twitter.FollowersAnalyzer.Service.Service Service
*/

public class ServiceUserByUsername extends Service {
	private String PATTERN_SERVICE_BY_USERNAME="by/username/";
	
	/**
	 * Costruttore della classe ServiceUserByUsername.
	 * 
	 * @param username Username dell'Utente del quale verrà restituito l'Utente stesso, inserito nell' <b>Url</b>.
	 */
	public ServiceUserByUsername(String username) {
		this.Url=PATTERN_USER_ID+PATTERN_SERVICE_BY_USERNAME+username+PARAMETER+PATTERN_USER_FIELDS;
	}
	
	/**
	 * Metodo per ottenere i dati dal server API di Twitter.
	 * 
	 * @throws IOException
	 * @throws ConnectionException
	 * 
	 * @return <Code>String</Code>: Stringa contenente la risposta del server API di Twitter, trasformabile in JSONObject.
	 * 
	 */
	public String getUser() throws IOException,ConnectionException{
		return Connection(Url);
	}

}

