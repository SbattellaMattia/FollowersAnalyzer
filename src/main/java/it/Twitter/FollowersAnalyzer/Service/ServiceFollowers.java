package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/**
* Classe ServiceFollowers che estende {@link it.Twitter.FollowersAnalyzer.Service.Service Service}.
* 
* Dato un Id di un Utente, restituisce gli Utenti che lo seguono.
* 
* @author Sbattella Mattia
* @author Sumcutean Sara
* 
* @see it.Twitter.FollowersAnalyzer.Service.Service Service
*/
public class ServiceFollowers extends Service{
	private String PATTERN_SERVICE_FOLLOWERS="/followers";
	
	/**
	 * Costruttore della classe ServiceFollowers.
	 * 
	 * @param id Id dell'Utente del quale verrano restituiti i Followers, inserito nell' <b>Url</b>.
	 */
	public ServiceFollowers(Long id) {
		this.Url=PATTERN_USER_ID+id+PATTERN_SERVICE_FOLLOWERS+PARAMETER+PATTERN_USER_FIELDS+AND+PATTERN_MAX_RESULTS;
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
	public String getFollowers() throws IOException,ConnectionException {
		return Connection(Url);
	}

}
