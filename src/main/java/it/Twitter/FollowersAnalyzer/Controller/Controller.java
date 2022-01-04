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
import it.Twitter.FollowersAnalyzer.Filter.FilterByFollowersRange;
import it.Twitter.FollowersAnalyzer.Filter.FilterByName;
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
import it.Twitter.FollowersAnalyzer.Service.ServiceRetweeted_by;
import it.Twitter.FollowersAnalyzer.Service.ServiceTweet;
import it.Twitter.FollowersAnalyzer.Service.ServiceUserById;
import it.Twitter.FollowersAnalyzer.Service.ServiceUserByUsername;
import it.Twitter.FollowersAnalyzer.Stats.Media;
import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;
import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.JsonComponent.JsonToError;
import it.Twitter.FollowersAnalyzer.JsonComponent.JsonToTweet;


@RestController
public class Controller {

	JsonToError error=new JsonToError() ;
	StringToJson json=new StringToJson();
	JsonToUser jsonUser=new JsonToUser();
	JsonToTweet jsonTweet=new JsonToTweet();
	FilterByName filterName=new FilterByName();
	FilterByUsername filterUsername=new FilterByUsername();


	@GetMapping(value="/UserByUsername/{username}")
	public ResponseEntity<JSONObject> getUserByUsername(@PathVariable String username) throws IOException, ParseException,  NullPointerException, ConnectionException{
		try {
			ServiceUserByUsername service = new ServiceUserByUsername(username);
			User user=jsonUser.parseOneUser(json.ToJson(service.getUser()));
			return new ResponseEntity<>(json.ToJson(user.UserToString()), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}	
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
	}


	@GetMapping(value="/UserById/{id}")
		public ResponseEntity<JSONObject> getUserById(@PathVariable Long id)throws IOException, ParseException, NullDataException, ConnectionException{

		try{
			ServiceUserById service = new ServiceUserById(id);
			User user=jsonUser.parseOneUser(json.ToJson(service.getUser()));
			return new ResponseEntity<>(json.ToJson(user.UserToString()), HttpStatus.OK);
		}catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping(value="/Followers/{id}")
	public ResponseEntity<JSONObject> getFollowers(@PathVariable Long id, @RequestParam(defaultValue = "all") String name, @RequestParam(defaultValue = "all") String username)throws IOException, ParseException, NullDataException, ConnectionException{
		try {
			User user= jsonUser.parseUser(getUserById(id).getBody());
			ServiceFollowers service = new ServiceFollowers(id);

			user.setFollowers(jsonUser.parseUsers(json.ToJson(service.getFollowers())));

			if((!name.equals("all"))&& username.equals("all")) return new ResponseEntity<>(json.ToJson(filterName.Filter(user, name)), HttpStatus.OK);
			if((!username.equals("all"))&& name.equals("all")) return new ResponseEntity<>(json.ToJson(filterUsername.Filter(user, username)), HttpStatus.OK);
			else return new ResponseEntity<>(json.ToJson(user.FollowersArrayToString()), HttpStatus.OK);

		}catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);
		}
	}

	
	@GetMapping(value="/Following/{id}")

	public ResponseEntity<JSONObject> getFollowing(@PathVariable Long id)throws IOException, ParseException, NullDataException, ConnectionException{

		ServiceFollowing service = new ServiceFollowing(id);	
		return new ResponseEntity<>(json.ToJson(service.getFollowing()), HttpStatus.OK);
	}


	@GetMapping(value="/Tweets/{id}")

	public ResponseEntity<JSONObject> getTweet(@PathVariable Long id) throws IOException, ParseException, NullDataException, ConnectionException{
		try{
			User user = jsonUser.parseUser(getUserById(id).getBody());
			ServiceTweet service = new ServiceTweet(id);
			user.setTweets(jsonTweet.parseTweets(json.ToJson(service.getTweet())));  
			return new ResponseEntity<>(json.ToJson(user.TweetArrayToString()), HttpStatus.OK);}
		
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}	
		catch(NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}

	}

	@GetMapping(value="/Retweeted_by/{id}")
	public ResponseEntity<JSONObject> getRetweeted_by(@PathVariable Long id,@RequestParam(defaultValue = "all") String username) throws IOException, ParseException, NullDataException, ConnectionException{
		try {
			ServiceRetweeted_by service = new ServiceRetweeted_by(id);
			Tweet tweet=new Tweet(id);
			tweet.setRetweeted_by(jsonUser.parseUsers(json.ToJson(service.getRetweeted_by())));
			return new ResponseEntity<>(json.ToJson(tweet.RetweetedByArrayToString()), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
	}

	@GetMapping(value="/LikedTweets/{id}")
	public ResponseEntity<JSONObject> getLikedTweets(@PathVariable Long id)throws IOException, ParseException, NullDataException, ConnectionException{
		ServiceLikedTweets service = new ServiceLikedTweets(id);
		return new ResponseEntity<>(json.ToJson(service.getLikedTweets()), HttpStatus.OK);
	}


	@GetMapping(value="/MediaFollowers/{id}")

	public ResponseEntity<JSONObject> getMedia(@PathVariable Long id) throws IOException, ParseException, NullDataException, ConnectionException{
		try {
			User user=jsonUser.parseUser(getUserById(id).getBody());
			user.setFollowers(jsonUser.parseUsers(getFollowers(id,"all","all").getBody()));
			for(User i : user.getFollowers()) {
				i.setFollowers(jsonUser.parseUsers(getFollowers(i.getId(),"all","all").getBody()));}
			Media media =new Media(user);
			return new ResponseEntity<>(json.ToJson(media.toString()), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}

	}


	@GetMapping(value="/FollowersStats/{id}")
	public ResponseEntity<JSONObject> getStats(@PathVariable Long id, @RequestParam(defaultValue = "number") String method) throws IOException, ParseException, NullDataException, ConnectionException{
		FilterByFollowersRange filter= new FilterByFollowersRange();

		try {
			User user=jsonUser.parseUser(getUserById(id).getBody());
			user.setFollowers(jsonUser.parseUsers(getFollowers(id,"all","all").getBody()));
			for(User i : user.getFollowers()) {
				i.setFollowers(jsonUser.parseUsers(getFollowers(i.getId(),"all","all").getBody()));}
			filter.Filter(user.getFollowers());
			return new ResponseEntity<>(json.ToJson(filter.FilterToString(method)), HttpStatus.OK);}
		catch (WrongParameter error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}	

	}


	@GetMapping(value="/StatsRefollowers/{id}")
	public ResponseEntity<JSONObject> getRefollowers(@PathVariable Long id) throws IOException, ParseException, NullDataException, ConnectionException{
		FilterByRefollowers filter= new FilterByRefollowers();

		try {
			User user=jsonUser.parseUser(getUserById(id).getBody());
			user.setFollowers(jsonUser.parseUsers(getFollowers(id,"all","all").getBody()));
			user.setFollowing(jsonUser.parseUsers(getFollowing(id).getBody()));
			return new ResponseEntity<>(json.ToJson(filter.Filter(user)), HttpStatus.OK);}
		catch (ConnectionException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}

	}

	@GetMapping(value="/VerifiedFollowers/{id}")
	public ResponseEntity<JSONObject> getVerifiedFollowers(@PathVariable Long id, @RequestParam(defaultValue = "verified") String method) throws IOException, ParseException, ConnectionException, WrongParameter, NullDataException{
		
		try{
			FilterByVerified filter= new FilterByVerified();
			User user=jsonUser.parseUser(getUserById(id).getBody());
			user.setFollowers(jsonUser.parseUsers(getFollowers(id,"all","all").getBody()));
			filter.Filter(user);
			return new ResponseEntity<>(json.ToJson(filter.FilterToString(method)), HttpStatus.OK);}
		catch (ConnectionException error) {
				return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}	
		catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		catch (WrongParameter error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		}

}
