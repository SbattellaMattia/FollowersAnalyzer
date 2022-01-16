package it.Twitter.FollowersAnalyzer.Service;

import java.io.IOException;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

/**
* Classe ServiceLikedTweets che estende {@link it.Twitter.FollowersAnalyzer.Service.Service Service}.
* 
* Dato l'<b>Id</b> di un Utente, restituisce i Tweet a cui ha messo like.
* 
* @author Sbattella Mattia
* @author Sumcutean Sara
* 
* @see it.Twitter.FollowersAnalyzer.Service.Service Service
*/

public class ServiceLikedTweets extends Service{
	private String PATTERN_SERVICE_LIKED_TWEETS="/liked_tweets";
	
	/**
	 * Costruttore della classe ServiceLikedTweets.
	 * 
	 * @param id : Id dell'Utente del quale verrano restituiti i Tweet a cui ha messo like, inserito nell' <b>Url</b>.
	 */
	public ServiceLikedTweets(Long id) {
		this.Url=PATTERN_USER_ID+id+PATTERN_SERVICE_LIKED_TWEETS+PARAMETER+PATTERN_TWEET_FIELDS+AND+PATTERN_MAX_RESULTS;
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
	public String getLikedTweets() throws IOException, ConnectionException {
		return Connection(Url);
	}

}
