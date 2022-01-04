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
import it.Twitter.FollowersAnalyzer.JsonComponent.JsonToUser;
import it.Twitter.FollowersAnalyzer.JsonComponent.StringToJson;
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
import it.Twitter.FollowersAnalyzer.JsonComponent.JsonToError;


@RestController
public class Controller {

	JsonToError error=new JsonToError() ;
	StringToJson json=new StringToJson();
	JsonToUser jsonUser=new JsonToUser();
	FilterByName filterName=new FilterByName();
	FilterByUsername filterUsername=new FilterByUsername();


	@GetMapping(value="/UserByUsername/{username}")
	public ResponseEntity<JSONObject> getUserByUsername(@PathVariable String username) throws IOException, ParseException,  NullPointerException, ConnectionException{
		try {
			try{
				ServiceUserByUsername service = new ServiceUserByUsername(username);
				User user=jsonUser.parseOneUser(json.ToJson(service.getUser()));
				return new ResponseEntity<>(json.ToJson(user.UserToString()), HttpStatus.OK);
			}catch (ConnectionException error) {
				return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);
			}	
		}catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping(value="/UserById/{id}")
		public ResponseEntity<JSONObject> getUserById(@PathVariable Long id) throws IOException, ParseException, NullDataException{

		try{
			ServiceUserById service = new ServiceUserById(id);
			User user=jsonUser.parseOneUser(json.ToJson(service.getUser()));
			return new ResponseEntity<>(json.ToJson(user.UserToString()), HttpStatus.OK);
		}catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping(value="/Followers/{id}")
	public ResponseEntity<JSONObject> getFollowers(@PathVariable Long id, @RequestParam(defaultValue = "all") String name, @RequestParam(defaultValue = "all") String username) throws IOException, ParseException,ConnectionException{
		try {
			try {
				User user= jsonUser.parseUser(getUserById(id).getBody());
				ServiceFollowers service = new ServiceFollowers(id);
				
				user.setFollowers(jsonUser.parseUsers(json.ToJson(service.getFollowers())));
				
				if((!name.equals("all"))&& username.equals("all")) return new ResponseEntity<>(json.ToJson(filterName.Filter(user, name)), HttpStatus.OK);
				if((!username.equals("all"))&& name.equals("all")) return new ResponseEntity<>(json.ToJson(filterUsername.Filter(user, username)), HttpStatus.OK);
				else return new ResponseEntity<>(json.ToJson(user.FollowersArrayToString()), HttpStatus.OK);

			}catch (ConnectionException error) {
				return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);}
		}catch (NullDataException error) {
			return new ResponseEntity<>(json.ToJson(error.getError()), HttpStatus.BAD_REQUEST);
		}

		
		
			
	}

	@GetMapping(value="/Following/{id}")
	public ResponseEntity<JSONObject> getFollowing(@PathVariable Long id) throws IOException, ParseException{
		ServiceFollowing service = new ServiceFollowing(id);	
		return new ResponseEntity<>(json.ToJson(service.getFollowing()), HttpStatus.OK);
	}
	
	@GetMapping(value="/Tweets/{id}")
	public ResponseEntity<JSONObject> getTweet(@PathVariable Long id) throws IOException, ParseException{
		ServiceTweet service = new ServiceTweet(id);
		return new ResponseEntity<>(json.ToJson(service.getTweet()), HttpStatus.OK);
	}
	
	@GetMapping(value="/Retweeted_by/{id}")
	public ResponseEntity<JSONObject> getRetweeted_by(@PathVariable Long id) throws IOException, ParseException{
		ServiceRetweeted_by service = new ServiceRetweeted_by(id);
		return new ResponseEntity<>(json.ToJson(service.getRetweeted_by()), HttpStatus.OK);
	}


	@GetMapping(value="/LikedTweets/{id}")
	public ResponseEntity<JSONObject> getLikedTweets(@PathVariable Long id) throws IOException, ParseException{
		ServiceLikedTweets service = new ServiceLikedTweets(id);
		return new ResponseEntity<>(json.ToJson(service.getLikedTweets()), HttpStatus.OK);
	}


	@GetMapping(value="/MediaFollowers/{id}")
	public ResponseEntity<JSONObject> getMedia(@PathVariable Long id) throws IOException, ParseException, NullDataException{

		User user=jsonUser.parseUser(getUserById(id).getBody());
		user.setFollowers(jsonUser.parseUsers(getFollowers(id,"all","all").getBody()));
		
		for(User i : user.getFollowers()) {
			i.setFollowers(jsonUser.parseUsers(getFollowers(i.getId(),"all","all").getBody()));}
		
		Media media =new Media(user);
		return new ResponseEntity<>(json.ToJson(media.toString()), HttpStatus.OK);
	}


	@GetMapping(value="/FollowersStats/{id}")
	public ResponseEntity<JSONObject> getStats(@PathVariable Long id, @RequestParam(defaultValue = "number") String method) throws IOException, ParseException{

		FilterByFollowersRange filter= new FilterByFollowersRange();

		User user=jsonUser.parseUser(getUserById(id).getBody());
		user.setFollowers(jsonUser.parseUsers(getFollowers(id,"all","all").getBody()));

		for(User i : user.getFollowers()) {
			i.setFollowers(jsonUser.parseUsers(getFollowers(i.getId(),"all","all").getBody()));	
		}

		filter.Filter(user.getFollowers());
		if(method.equals("number"))json=new StringToJson(filter.NumberToString());
		if(method.equals("%"))json=new StringToJson(filter.PerToString());
		
		return new ResponseEntity<>(json.ToJson(), HttpStatus.OK);
	}


	@GetMapping(value="/StatsRefollowers/{id}")
	public ResponseEntity<JSONObject> getRefollowers(@PathVariable Long id) throws IOException, ParseException{
		FilterByRefollowers filter= new FilterByRefollowers();
		
		User user=jsonUser.parseUser(getUserById(id).getBody());
		
		user.setFollowers(jsonUser.parseUsers(getFollowers(id,"all","all").getBody()));
		user.setFollowing(jsonUser.parseUsers(getFollowing(id).getBody()));

		
		return new ResponseEntity<>(json.ToJson(filter.Filter(user)), HttpStatus.OK);
	}

}
