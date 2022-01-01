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

	@GetMapping(value="/UserByUsername/{username}")
	public ResponseEntity<Object> getUserByUsername(@PathVariable String username) throws IOException, ParseException, IdNotFoundException, NullPointerException{

		try{
			ServiceUserByUsername service = new ServiceUserByUsername(username);
			json=new StringToJson(service.getUser());
			JsonToUser jsonUser=new JsonToUser();
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
		//public ResponseEntity<Object> getUserById(@PathVariable Long id) throws IOException, ParseException{
		public JSONObject getUserById(@PathVariable Long id) throws IOException, ParseException{

		ServiceUserById service = new ServiceUserById(id);
		json=new StringToJson(service.getUser());
		JsonToUser jsonUser=new JsonToUser();
		User user=jsonUser.parseOneUser(json.ToJson());
		json=new StringToJson(user.UserToString());

		//return new ResponseEntity<>(json.ToJson(), HttpStatus.OK);
		return json.ToJson(); 
	}


	@GetMapping(value="/Followers/{id}")
	public JSONObject getFollowers(@PathVariable Long id, @RequestParam(defaultValue = "all") String name, @RequestParam(defaultValue = "all") String username) throws IOException, ParseException{


		JsonToUser jsonUser=new JsonToUser();
		User user= jsonUser.parseUser(getUserById(id));

		ServiceFollowers service = new ServiceFollowers(id);	
		json=new StringToJson(service.getFollowers());

		/*JsonToUser jsonUser=new JsonToUser();

			for(User i: jsonUser.parseUsers(json.ToJson())) System.out.println(i.UserToString());*/

		//ServiceFollowers service = new ServiceFollowers(id);

		/*JsonToUser jsonUser=new JsonToUser();
			User user=new User(id);*/

		json=new StringToJson(service.getFollowers());

		/*try {
				user.setFollowers(jsonUser.parseUsers(json.ToJson()));
			}
			catch(ParseException e) {
				System.err.println("Errore nel parsing");
			}
			json=new StringToJson(user.AAA());*/


		user.setFollowers(jsonUser.parseUsers(json.ToJson()));

		FilterByName filterName=new FilterByName();
		FilterByUsername filterUsername=new FilterByUsername();

		if((!name.equals("all"))&& username.equals("all")) json=new StringToJson(filterName.Filter(user, name));
		if((!username.equals("all"))&& name.equals("all")) json=new StringToJson(filterUsername.Filter(user, username));
		if(username.equals("all") && name.equals("all")) json=new StringToJson(user.FollowersArrayToString());

		return json.ToJson();
	}

	@GetMapping(value="/Following/{id}")
	public JSONObject getFollowing(@PathVariable Long id) throws IOException, ParseException{
		ServiceFollowing service = new ServiceFollowing(id);	
		json=new StringToJson(service.getFollowing());
		return json.ToJson();
	}


	@GetMapping(value="/Tweets/{id}")
	public ResponseEntity<Object> getTweet(@PathVariable Long id) throws IOException, ParseException{
		//public JSONObject getTweet(@PathVariable Long id) throws IOException, ParseException{
		ServiceTweet service = new ServiceTweet(id);
		json=new StringToJson(service.getTweet());
		return new ResponseEntity<>(json.ToJson(), HttpStatus.OK);
		//return json.ToJson();
	}

	@GetMapping(value="/Retweeted_by/{id}")
	public ResponseEntity<Object> getRetweeted_by(@PathVariable Long id) throws IOException, ParseException{
		//public JSONObject getRetweeted_by(@PathVariable Long id) throws IOException, ParseException{
		ServiceRetweeted_by service = new ServiceRetweeted_by(id);
		json=new StringToJson(service.getRetweeted_by());
		return new ResponseEntity<>(json.ToJson(), HttpStatus.OK);
		//return json.ToJson();
	}


	@GetMapping(value="/LikedTweets/{id}")
	public ResponseEntity<Object> getLikedTweets(@PathVariable Long id) throws IOException, ParseException{
		//public JSONObject getLikedTweets(@PathVariable Long id) throws IOException, ParseException{
		ServiceLikedTweets service = new ServiceLikedTweets(id);
		json=new StringToJson(service.getLikedTweets());
		return new ResponseEntity<>(json.ToJson(), HttpStatus.OK);
		//return json.ToJson();
	}


	@GetMapping(value="/MediaFollowers/{id}")
	public String getMedia(@PathVariable Long id) throws IOException, ParseException{

		JsonToUser jsonUser=new JsonToUser();
		ArrayList<Long> IdFollowers = new ArrayList<Long>();
		ArrayList<Integer> NumFollower = new ArrayList<Integer>();


		for(User i : jsonUser.parseUsers(getFollowers(id,"all","all"))) {
			IdFollowers.add(i.getId());
		}

		for(Long i: IdFollowers) {
			NumFollower.add(jsonUser.parseUsers(getFollowers(i,"all","all")).size());	
		}

		String line="";
		for(Integer i : NumFollower) {
			line+=" "+i;
		}
		Media media =new Media(NumFollower);
		return line+"\n"+media.toString();
	}


	@GetMapping(value="/FollowersStats/{id}")
	public JSONObject getStats(@PathVariable Long id, @RequestParam(defaultValue = "number") String method) throws IOException, ParseException{


		JSONObject Jobj= getUserById(id);
		JsonToUser jsonUser=new JsonToUser();
		FilterByFollowersRange filter= new FilterByFollowersRange();

		User user=jsonUser.parseUser(Jobj);
		user.setFollowers(jsonUser.parseUsers(getFollowers(id,"all","all")));

		for(User i : user.getFollowers()) {
			i.setFollowers(jsonUser.parseUsers(getFollowers(i.getId(),"all","all")));	
		}

		filter.Filter(user.getFollowers());
		if(method.equals("number"))json=new StringToJson(filter.NumberToString());
		if(method.equals("%"))json=new StringToJson(filter.PerToString());
		return json.ToJson();
	}


	@GetMapping(value="/StatsRefollowers/{id}")
	public /*JSONArray*/JSONObject getRefollowers(@PathVariable Long id) throws IOException, ParseException{

		JSONObject Jobj=getUserById(id);
		JsonToUser jsonUser=new JsonToUser();
		FilterByRefollowers filter= new FilterByRefollowers();

		User user=jsonUser.parseUser(Jobj);

		user.setFollowers(jsonUser.parseUsers(getFollowers(id,"all","all")));
		user.setFollowing(jsonUser.parseUsers(getFollowing(id)));

		System.out.println(filter.Filter(user));
		json=new StringToJson(filter.Filter(user));
		return json.ToJson();
	}



	/*@GetMapping(value="/UserById/{id}")
	public JSONObject getUserById(@PathVariable Long id) throws IOException, ParseException, IdNotFoundException, EmptyStringException{
		//if (id == null) throw new EmptyStringException ("Non hai inserito l'id utente!");
		//try{
		JsonToUser jsonUser=new JsonToUser();
		User user=jsonUser.parseOneUser(json.ToJson());
		ServiceUserById service = new ServiceUserById(id);
		json=new StringToJson(service.getUser());
		return json.ToJson();

		} catch(IdNotFoundException e) {
				e.IdNotFoundExceptionToString();
				System.out.println(e);
			}
			finally {

			}
	}*/

}
