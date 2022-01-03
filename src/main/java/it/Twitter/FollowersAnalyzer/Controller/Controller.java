package it.Twitter.FollowersAnalyzer.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.lang.NullPointerException;

import org.json.simple.JSONArray;
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
import it.Twitter.FollowersAnalyzer.Exceptions.IdNotFoundException;
import it.Twitter.FollowersAnalyzer.Exceptions.EmptyStringException;
import it.Twitter.FollowersAnalyzer.JsonComponent.JsonToError;


@RestController
public class Controller {


	StringToJson json;
	JsonToUser jsonUser=new JsonToUser();

	@GetMapping(value="/UserByUsername/{username}")
	public ResponseEntity<Object> getUserByUsername(@PathVariable String username) throws IOException, ParseException, IdNotFoundException, NullPointerException{

		try{
			ServiceUserByUsername service = new ServiceUserByUsername(username);
			json=new StringToJson(service.getUser());
			User user=jsonUser.parseOneUser(json.ToJson());
			json=new StringToJson(user.UserToString());
			return new ResponseEntity<>(json.ToJson(), HttpStatus.OK);
		} catch (IdNotFoundException e) {
			JsonToError jsonError = new JsonToError();
			e = jsonError.parseErrors(json.ToJson());
			System.out.println(e.IdNotFoundExceptionToString());
			return new ResponseEntity<>(e.IdNotFoundExceptionToString(), HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping(value="/UserById/{id}")
		public ResponseEntity<JSONObject> getUserById(@PathVariable Long id) throws IOException, ParseException{
		
		ServiceUserById service = new ServiceUserById(id);
		json=new StringToJson(service.getUser());
		User user=jsonUser.parseOneUser(json.ToJson());
		json=new StringToJson(user.UserToString());

		return new ResponseEntity<>(json.ToJson(), HttpStatus.OK);
	}


	@GetMapping(value="/Followers/{id}")
	public ResponseEntity<JSONObject> getFollowers(@PathVariable Long id, @RequestParam(defaultValue = "all") String name, @RequestParam(defaultValue = "all") String username) throws IOException, ParseException{

		User user= jsonUser.parseUser(getUserById(id).getBody());
		
		ServiceFollowers service = new ServiceFollowers(id);	
		json = new StringToJson(service.getFollowers());

		user.setFollowers(jsonUser.parseUsers(json.ToJson()));
		
		FilterByName filterName=new FilterByName();
		FilterByUsername filterUsername=new FilterByUsername();
		if((!name.equals("all"))&& username.equals("all")) json=new StringToJson(filterName.Filter(user, name));
		if((!username.equals("all"))&& name.equals("all")) json=new StringToJson(filterUsername.Filter(user, username));
		if(username.equals("all") && name.equals("all")) json=new StringToJson(user.FollowersArrayToString());
		
		return new ResponseEntity<>(json.ToJson(), HttpStatus.OK);
	}

	@GetMapping(value="/Following/{id}")
	public ResponseEntity<JSONObject> getFollowing(@PathVariable Long id) throws IOException, ParseException{
		ServiceFollowing service = new ServiceFollowing(id);	
		json=new StringToJson(service.getFollowing());
		return new ResponseEntity<>(json.ToJson(), HttpStatus.OK);
	}
	
	@GetMapping(value="/Tweets/{id}")
	public ResponseEntity<JSONObject> getTweet(@PathVariable Long id) throws IOException, ParseException{
		ServiceTweet service = new ServiceTweet(id);
		json=new StringToJson(service.getTweet());
		return new ResponseEntity<>(json.ToJson(), HttpStatus.OK);
	}
	
	@GetMapping(value="/Retweeted_by/{id}")
	public ResponseEntity<JSONObject> getRetweeted_by(@PathVariable Long id) throws IOException, ParseException{
		
		ServiceRetweeted_by service = new ServiceRetweeted_by(id);
		json=new StringToJson(service.getRetweeted_by());
		return new ResponseEntity<>(json.ToJson(), HttpStatus.OK);
		
	}


	@GetMapping(value="/LikedTweets/{id}")
	public ResponseEntity<JSONObject> getLikedTweets(@PathVariable Long id) throws IOException, ParseException{
		ServiceLikedTweets service = new ServiceLikedTweets(id);
		json=new StringToJson(service.getLikedTweets());
		return new ResponseEntity<>(json.ToJson(), HttpStatus.OK);
	}


	@GetMapping(value="/MediaFollowers/{id}")
	public ResponseEntity<JSONObject> getMedia(@PathVariable Long id) throws IOException, ParseException{

		User user=jsonUser.parseUser(getUserById(id).getBody());
		user.setFollowers(jsonUser.parseUsers(getFollowers(id,"all","all").getBody()));
		
		for(User i : user.getFollowers()) {
			i.setFollowers(jsonUser.parseUsers(getFollowers(i.getId(),"all","all").getBody()));}
		
		Media media =new Media(user);
		json=new StringToJson(media.toString());
		
		return new ResponseEntity<>(json.ToJson(), HttpStatus.OK);
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

		json=new StringToJson(filter.Filter(user));
		
		return new ResponseEntity<>(json.ToJson(), HttpStatus.OK);
	}

}
