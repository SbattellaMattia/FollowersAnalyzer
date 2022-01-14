package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/**
* Classe ServiceLikingUsers che estende {@link it.Twitter.FollowersAnalyzer.Service.Service Service}.
* 
* Dato l'Id di un Tweet, restituisce gli Utenti che hanno messo like.
* 
* @author Sbattella Mattia
* @author Sumcutean Sara
* 
* @see it.Twitter.FollowersAnalyzer.Service.Service Service
*/

public class ServiceLikingUsers extends Service{
	private String PATTERN_SERVICE_LIKING_USERS="/liking_users";

	/**
	 * Costruttore della classe ServiceLikingUsers.
	 * 
	 * @param id Id del Tweet del quale verrano restituiti gli Utenti che hanno messo like, inserito nell' <b>Url</b>.
	 */
	public ServiceLikingUsers(Long id) {
		this.Url=PATTERN_TWEET_ID+id+PATTERN_SERVICE_LIKING_USERS+PARAMETER+PATTERN_USER_FIELDS;
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
	public String getLikingUsers() throws IOException,ConnectionException {
		return Connection(Url);
	}
}
