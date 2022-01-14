package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/**
* Classe ServiceFollowing che estende {@link it.Twitter.FollowersAnalyzer.Service.Service Service}.
* 
*  Dato l'<b>Id</b> di un Utente, restituisce gli Utenti che segue.
* 
* @author Sbattella Mattia
* @author Sumcutean Sara
* 
* @see it.Twitter.FollowersAnalyzer.Service.Service Service
*/
public class ServiceFollowing extends Service{
	private String PATTERN_SERVICE_FOLLOWING="/following";
	
	/**
	 * Costruttore della classe ServiceFollowing.
	 * 
	 * @param id Id dell'Utente del quale verrano restituiti gli Utenti seguiti, inserito nell' <b>Url</b>.
	 */
	
	public ServiceFollowing(Long id) {
		this.Url=PATTERN_USER_ID+id+PATTERN_SERVICE_FOLLOWING+PARAMETER+PATTERN_USER_FIELDS+AND+PATTERN_MAX_RESULTS;
	}
	
	/**
	 * Metodo per ottenere i dati dal server API di Twitter.
	 * 
	 * @throws IOException
	 * @throws ConnectionException
	 * 
	 * @return <Code>String</Code>: Stringa contenente la risposta del server API di Twitter, trasformabile in <b>JSONObject</b>.
	 * 
	 */
	public String getFollowing() throws IOException, ConnectionException {
		return Connection(Url);
	}

}