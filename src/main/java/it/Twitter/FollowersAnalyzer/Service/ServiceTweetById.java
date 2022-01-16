package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/**
* Classe ServiceTweetById che estende {@link it.Twitter.FollowersAnalyzer.Service.Service Service}.
* 
* Dato l'<b>Id</b> di un Tweet,restituisce il Tweet stesso.
* 
* @author Sbattella Mattia
* @author Sumcutean Sara
* 
* @see it.Twitter.FollowersAnalyzer.Service.Service Service
*/
public class ServiceTweetById extends Service {
	
	/**
	 * Costruttore della classe ServiceTweetById.
	 * 
	 * @param id : Id del Tweet del quale verrà restituito il Tweet stesso, inserito nell' <b>Url</b>.
	 */
	public ServiceTweetById(Long id) {
		this.Url=PATTERN_TWEET_ID+id+ PARAMETER+PATTERN_TWEET_FIELDS;
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
	public String getTweetById() throws IOException,ConnectionException {
		return Connection(Url);
	}
}
