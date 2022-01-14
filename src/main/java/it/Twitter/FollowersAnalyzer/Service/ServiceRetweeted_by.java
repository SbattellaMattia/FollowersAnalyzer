package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/**
* Classe ServiceRetweeted_by che estende {@link it.Twitter.FollowersAnalyzer.Service.Service Service}.
* 
* Dato l'Id di un Tweet, restituisce gli Utenti che lo hanno retweetato.
* 
* @author Sbattella Mattia
* @author Sumcutean Sara
* 
* @see it.Twitter.FollowersAnalyzer.Service.Service Service
*/

public class ServiceRetweeted_by extends Service{
	private String PATTERN_SERVICE_RETWEETED_BY="/retweeted_by";
	
	/**
	 * Costruttore della classe ServiceRetweeted_by.
	 * 
	 * @param id Id di un Tweet del quale verrano restituiti gli Utenti che lo hanno retweetato, inserito nell' <b>Url</b>.
	 */
	public ServiceRetweeted_by(Long id) {
		this.Url=PATTERN_TWEET_ID+id+PATTERN_SERVICE_RETWEETED_BY+PARAMETER+PATTERN_USER_FIELDS;
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
	public String getRetweeted_by() throws IOException, ConnectionException {
		return Connection(Url);
	}

}
