package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/**
* Classe ServiceTweets che estende {@link it.Twitter.FollowersAnalyzer.Service.Service Service}.
* 
* Dato l'<b>Id</b> di un Utente, restituisce i suoi Tweets.
* 
* @author Sbattella Mattia
* @author Sumcutean Sara
* 
* @see it.Twitter.FollowersAnalyzer.Service.Service Service
*/

public class ServiceTweets extends Service {
	private String PATTERN_SERVICE_TWEETS="/tweets";
	
	/**
	 * Costruttore della classe ServiceTweets.
	 * 
	 * @param id Id dell'Utente del quale verrano restituiti i Tweets effettuati, inserito nell' <b>Url</b>.
	 */
	public ServiceTweets(Long id) {
		this.Url=PATTERN_USER_ID+id+PATTERN_SERVICE_TWEETS+ PARAMETER+PATTERN_TWEET_FIELDS+AND+PATTERN_MAX_RESULTS;
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
	public String getTweet() throws IOException, ConnectionException {
		return Connection(Url);
	}

}
