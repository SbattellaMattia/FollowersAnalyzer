package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/**
* Classe ServiceUserById che estende {@link it.Twitter.FollowersAnalyzer.Service.Service Service}.
* 
* Dato l'<b>Id</b> di un Utente, restituisce l'Utente stesso.
* 
* @author Sbattella Mattia
* @author Sumcutean Sara
* 
* @see it.Twitter.FollowersAnalyzer.Service.Service Service
*/

public class ServiceUserById extends Service {
	
	/**
	 * Costruttore della classe ServiceUserById.
	 * 
	 * @param id : Id dell'Utente del quale verrà restituito l'utente stesso, inserito nell' <b>Url</b>.
	 */
	public ServiceUserById(Long id) {
		this.Url=PATTERN_USER_ID+id+ PARAMETER+PATTERN_USER_FIELDS;
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
	public String getUser() throws IOException, ConnectionException {
		return Connection(Url);
	}

}

