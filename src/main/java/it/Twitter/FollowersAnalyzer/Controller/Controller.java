package it.Twitter.FollowersAnalyzer.Controller;

import java.io.IOException;
import java.lang.NullPointerException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.Twitter.FollowersAnalyzer.Filter.FilterByCreation;
import it.Twitter.FollowersAnalyzer.Filter.FilterByFollowers;
import it.Twitter.FollowersAnalyzer.Filter.FilterByRefollowers;
import it.Twitter.FollowersAnalyzer.Filter.FilterByUsername;
import it.Twitter.FollowersAnalyzer.Filter.FilterByVerified;
import it.Twitter.FollowersAnalyzer.JsonComponent.JsonToUser;
import it.Twitter.FollowersAnalyzer.JsonComponent.StringToJson;
import it.Twitter.FollowersAnalyzer.Model.Tweet;
import it.Twitter.FollowersAnalyzer.Model.User;
import it.Twitter.FollowersAnalyzer.Service.ServiceFollowers;
import it.Twitter.FollowersAnalyzer.Service.ServiceFollowing;
import it.Twitter.FollowersAnalyzer.Service.ServiceLikedTweets;
import it.Twitter.FollowersAnalyzer.Service.ServiceLikingUsers;
import it.Twitter.FollowersAnalyzer.Service.ServiceRetweeted_by;
import it.Twitter.FollowersAnalyzer.Service.ServiceTweetById;
import it.Twitter.FollowersAnalyzer.Service.ServiceTweets;
import it.Twitter.FollowersAnalyzer.Service.ServiceUserById;
import it.Twitter.FollowersAnalyzer.Service.ServiceUserByUsername;
import it.Twitter.FollowersAnalyzer.Stats.StatFollowersRange;
import it.Twitter.FollowersAnalyzer.Stats.StatAverage;
import it.Twitter.FollowersAnalyzer.Stats.StatVariation;
import it.Twitter.FollowersAnalyzer.Stats.StatsLikes;
import it.Twitter.FollowersAnalyzer.Utils.Counter;
import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;
import it.Twitter.FollowersAnalyzer.Exceptions.DateException;
import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;

import it.Twitter.FollowersAnalyzer.JsonComponent.JsonToTweet;

/**
 * Questa classe gestisce tutte le chiamate al server che il client può fare.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 */

@RestController
public class Controller {

	StringToJson json=new StringToJson();
	JsonToUser jsonUser=new JsonToUser();
	JsonToTweet jsonTweet=new JsonToTweet();
	
	FilterByUsername filterByUsername=new FilterByUsername();
	FilterByCreation filterByCreation= new FilterByCreation();
	FilterByFollowers filterByFollowers = new FilterByFollowers();
	FilterByRefollowers filterByRefollowers= new FilterByRefollowers();
	FilterByVerified filterByVerified= new FilterByVerified();
	
	
	
	/**
	 * Rotta di tipo GET che restituisce i dati di un determinato utente.
	 * 
	 * @param id Id utente da inserire.
	 * @return JSONObject contenente i dati dell'utente ricercato.
	 * @throws IOException
	 * @throws ParseException
	 * @throws NullDataException 
	 * @throws ConnectionException Se il collegamento con l'API di twitter non va a buon fine.
	 */
	
	@GetMapping(value="/UserById/{id}")
	public ResponseEntity<JSONObject> getUserById(@PathVariable Long id)throws IOException, ParseException, NullDataException, ConnectionException, DateException{
		try{
			ServiceUserById service = new ServiceUserById(id);
			User user=jsonUser.parseOneUser(json.ToJson(service.getUser()));
			return new ResponseEntity<>(json.ToJson(user.UserToString()), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
	}

	@GetMapping(value="/UserByUsername/{username}")
	public ResponseEntity<JSONObject> getUserByUsername(@PathVariable String username) throws IOException, ParseException,  NullPointerException, ConnectionException, DateException{
		try {
			ServiceUserByUsername service = new ServiceUserByUsername(username);
			User user=jsonUser.parseOneUser(json.ToJson(service.getUser()));
			return new ResponseEntity<>(json.ToJson(user.UserToString()), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}	
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
	}


	
	@GetMapping(value="/Followers/{id}")
	public ResponseEntity<JSONObject> getFollowers(@PathVariable Long id, @RequestParam(defaultValue = "all") String username)throws IOException, ParseException, NullDataException, ConnectionException, DateException, WrongParameter{
		try {
			User user= jsonUser.parseUser(getUserById(id).getBody());
			ServiceFollowers service = new ServiceFollowers(id);
			user.setFollowers(jsonUser.parseUsers(json.ToJson(service.getFollowers())));
			return new ResponseEntity<>(json.ToJson(filterByUsername.FilterFollower(user, username)), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
	}
	
	@GetMapping(value="/Filter/FollowersByCreation/{id}")
	public ResponseEntity<JSONObject> getFollowerFilterDate(@PathVariable Long id, @RequestParam(defaultValue = "21-03-2006") String StartDate,@RequestParam(defaultValue = "null") String EndDate) throws IOException, ParseException, ConnectionException, NullDataException, NumberFormatException, DateException{
		
		try {
			User user= jsonUser.parseUser(getUserById(id).getBody());
			ServiceFollowers service = new ServiceFollowers(id);
			user.setFollowers(jsonUser.parseUsers(json.ToJson(service.getFollowers())));
			return new ResponseEntity<>(json.ToJson(filterByCreation.FollowerFilter(user, StartDate, EndDate)), HttpStatus.OK);}
		catch (ConnectionException error) {
				return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (WrongParameter error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (DateException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
	}

	@GetMapping(value="/Following/{id}")
	public ResponseEntity<JSONObject> getFollowing(@PathVariable Long id, @RequestParam(defaultValue = "all") String username)throws IOException, ParseException, NullDataException, ConnectionException, DateException{
		try{
			User user= jsonUser.parseUser(getUserById(id).getBody());
			ServiceFollowing service = new ServiceFollowing(id);	
			user.setFollowing(jsonUser.parseUsers(json.ToJson(service.getFollowing())));
			return new ResponseEntity<>(json.ToJson(filterByUsername.FilterFollowing(user, username)), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
	}
	
	@GetMapping(value="/Filter/FollowingByCreation/{id}")
	public ResponseEntity<JSONObject> getFollowingFilterDate(@PathVariable Long id, @RequestParam(defaultValue = "21-03-2006") String StartDate,@RequestParam(defaultValue = "null") String EndDate) throws IOException, ParseException, ConnectionException, WrongParameter, NullDataException, NumberFormatException, DateException{
		try{
			User user= jsonUser.parseUser(getUserById(id).getBody());
			ServiceFollowing service = new ServiceFollowing(id);	
			user.setFollowing(jsonUser.parseUsers(json.ToJson(service.getFollowing())));
			return new ResponseEntity<>(json.ToJson(filterByCreation.FollowingFilter(user, StartDate, EndDate)), HttpStatus.OK);}

		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (WrongParameter error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
	}

	
	

	@GetMapping(value="/Filter/VerifiedFollowers/{id}")
	public ResponseEntity<JSONObject> getVerifiedFollowers(@PathVariable Long id, @RequestParam(defaultValue = "verified") String method) throws IOException, ParseException, ConnectionException, WrongParameter, NullDataException, DateException{
		try{
			User user=jsonUser.parseUser(getUserById(id).getBody());
			user.setFollowers(jsonUser.parseUsers(getFollowers(id,"all").getBody()));
			filterByVerified.Filter(user);
			return new ResponseEntity<>(json.ToJson(filterByVerified.FilterToString(method)), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}	
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (WrongParameter error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
	}

	
	@GetMapping(value="/Filter/Refollowers/{id}")
	public ResponseEntity<JSONObject> getRefollowers(@PathVariable Long id) throws IOException, ParseException, NullDataException, ConnectionException, DateException, WrongParameter{
		try {
			User user=jsonUser.parseUser(getUserById(id).getBody());
			user.setFollowers(jsonUser.parseUsers(getFollowers(id,"all").getBody()));
			user.setFollowing(jsonUser.parseUsers(getFollowing(id,"all").getBody()));
			return new ResponseEntity<>(json.ToJson(filterByRefollowers.Filter(user)), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}

	}
	
	

	@GetMapping(value="/TweetById/{id}")
	public ResponseEntity<JSONObject> getTweetById(@PathVariable Long id)throws IOException, ParseException, NullDataException, ConnectionException, DateException{
		try{
			ServiceTweetById service = new ServiceTweetById(id);
			Tweet tweet=jsonTweet.parseOneTweet(json.ToJson(service.getTweetById()));
			return new ResponseEntity<>(json.ToJson(tweet.TweetToString()), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
	}
	
	
	@GetMapping(value="/User/Tweets/{id}")
	public ResponseEntity<JSONObject> getTweets(@PathVariable Long id) throws IOException, ParseException, NullDataException, ConnectionException, DateException{
		try{
			User user = jsonUser.parseUser(getUserById(id).getBody());
			ServiceTweets service = new ServiceTweets(id);
			user.setTweets(jsonTweet.parseTweets(json.ToJson(service.getTweet())));  
			return new ResponseEntity<>(json.ToJson(user.TweetArrayToString()), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}	
		catch(NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}

	}

	
	//tweet a cui l'utente il cui id è passato come parametro, ha messo like.
		@GetMapping(value="/User/LikedTweets/{id}")
		public ResponseEntity<JSONObject> getLikedTweets(@PathVariable Long id)throws IOException, ParseException, NullDataException, ConnectionException, DateException{
			try{
				ServiceLikedTweets service = new ServiceLikedTweets(id);
				User user = jsonUser.parseUser(getUserById(id).getBody());
				user.setLikedTweets(jsonTweet.parseTweets(json.ToJson(service.getLikedTweets())));
				
				System.out.println(user.LikedTweetArrayToString());
				return new ResponseEntity<>(json.ToJson(user.LikedTweetArrayToString()), HttpStatus.OK);}

			catch (ConnectionException error) {
				return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
			catch (NullDataException error) {
				return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		}
	
		
	@GetMapping(value="/Tweet/Retweeted_by/{id}")
	public ResponseEntity<JSONObject> getRetweeted_by(@PathVariable Long id,@RequestParam(defaultValue = "all") String username) throws IOException, ParseException, NullDataException, ConnectionException, DateException, WrongParameter{
		try {
			ServiceRetweeted_by service = new ServiceRetweeted_by(id);
			Tweet tweet=jsonTweet.parseTweet(getTweetById(id).getBody());
			tweet.setRetweeted_by(jsonUser.parseUsers(json.ToJson(service.getRetweeted_by())));
			return new ResponseEntity<>(json.ToJson(filterByUsername.FilterRetweeted(tweet, username)), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
	}

	

	@GetMapping(value="/FollowersStats/Media/{id}")

	public ResponseEntity<JSONObject> getMedia(@PathVariable Long id) throws IOException, ParseException, NullDataException, ConnectionException, DateException, WrongParameter{
		try {
			User user=jsonUser.parseUser(getUserById(id).getBody());
			user.setFollowers(jsonUser.parseUsers(getFollowers(id,"all").getBody()));
			for(User i : user.getFollowers()) {
				i.setFollowers(jsonUser.parseUsers(getFollowers(i.getId(),"all").getBody()));}
			StatAverage media =new StatAverage(user);
			return new ResponseEntity<>(json.ToJson(media.toString()), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}

	}


	@GetMapping(value="/FollowersStats/Range/{id}")
	public ResponseEntity<JSONObject> getStats(@PathVariable Long id, @RequestParam(defaultValue = "number") String method) throws IOException, ParseException, NullDataException, ConnectionException, DateException{
		try {
			User user=jsonUser.parseUser(getUserById(id).getBody());
			user.setFollowers(jsonUser.parseUsers(getFollowers(id,"all").getBody()));
			for(User i : user.getFollowers()) {
				i.setFollowers(jsonUser.parseUsers(getFollowers(i.getId(),"all").getBody()));}
			StatFollowersRange StatFollowersRange= new StatFollowersRange(user.getFollowers());
			return new ResponseEntity<>(json.ToJson(StatFollowersRange.StatToString(method)), HttpStatus.OK);}
		catch (WrongParameter error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}	

	}

	//restituisce gli utenti che hanno messo like ad un tweet il cui id è passato come parametro
	@GetMapping(value="/Tweet/LikingUsers/{id}")
	public ResponseEntity<JSONObject> getLikes(@PathVariable Long id,@RequestParam(defaultValue = "all") String method) throws IOException, ParseException, NullDataException, ConnectionException, WrongParameter, DateException{
		try {
			ServiceLikingUsers service = new ServiceLikingUsers(id);
			Tweet tweet=jsonTweet.parseTweet(getTweetById(id).getBody());
			tweet.setLikingUsers(jsonUser.parseUsers(json.ToJson(service.getLikingUsers())));
			User user= jsonUser.parseUser(getUserById(tweet.getAuthorId()).getBody());
			user.setFollowers(jsonUser.parseUsers(getFollowers(user.getId(),"all").getBody()));
			return new ResponseEntity<>(json.ToJson(filterByFollowers.Filter(user,tweet,method)), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
	}
	
	
	@GetMapping(value="/FollowersStats/Activity/{id}")
	public ResponseEntity<JSONObject> getBestUser(@PathVariable Long id,@RequestParam(defaultValue = "all") String method) throws IOException, ParseException, NullDataException, ConnectionException, WrongParameter, DateException{
		try {
			User user = jsonUser.parseUser(getUserById(id).getBody());
			user.setTweets(jsonTweet.parseTweets(getTweets(id).getBody()));
			for(Tweet i : user.getTweets()) {
				i.setLikingUsers(jsonUser.parseUsers(getLikes(i.getId(),method).getBody()));}
			Counter counter=new Counter();
			return new ResponseEntity<>(json.ToJson(counter.counter(user)), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
	}
	
	
	@GetMapping(value="/FollowersStats/Varianza/{id}")
	public ResponseEntity<JSONObject> getVarianza(@PathVariable Long id) throws IOException, ParseException, NullDataException, ConnectionException, DateException, WrongParameter{
		try {
			User user=jsonUser.parseUser(getUserById(id).getBody());
			user.setFollowers(jsonUser.parseUsers(getFollowers(id,"all").getBody()));
			for(User i : user.getFollowers()) {
				i.setFollowers(jsonUser.parseUsers(getFollowers(i.getId(),"all").getBody()));}
			StatVariation varianza =new StatVariation(user);
			return new ResponseEntity<>(json.ToJson(varianza.toString()), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}

	}
	
	
	@GetMapping(value="/FollowersStats/LikesPercentage/{id}")
	public ResponseEntity<JSONObject> getLikesPercentage(@PathVariable Long id) throws IOException, ParseException, NullDataException, ConnectionException, WrongParameter, DateException{
		try {
			Tweet tweet=jsonTweet.parseTweet(getTweetById(id).getBody());
			User user= jsonUser.parseUser(getUserById(tweet.getAuthorId()).getBody());
			tweet.setLikingUsers(jsonUser.parseUsers(getLikes(id,"followers").getBody()));
			user.setFollowers(jsonUser.parseUsers(getFollowers(user.getId(),"all").getBody()));
			StatsLikes stat=new StatsLikes(user, tweet);
			return new ResponseEntity<>(json.ToJson(stat.toString()), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
	}
	
	
}