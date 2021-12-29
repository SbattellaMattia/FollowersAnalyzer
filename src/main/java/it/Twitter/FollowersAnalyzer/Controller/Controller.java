package it.Twitter.FollowersAnalyzer.Controller;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import it.Twitter.FollowersAnalyzer.Filter.FilterByFollowersRange;
import it.Twitter.FollowersAnalyzer.JsonComponent.JsonToUser;
import it.Twitter.FollowersAnalyzer.JsonComponent.StringToJson;
import it.Twitter.FollowersAnalyzer.Model.User;
import it.Twitter.FollowersAnalyzer.Service.ServiceFollowers;
import it.Twitter.FollowersAnalyzer.Service.ServiceLikedTweets;
import it.Twitter.FollowersAnalyzer.Service.ServiceRetweeted_by;
import it.Twitter.FollowersAnalyzer.Service.ServiceTweet;
import it.Twitter.FollowersAnalyzer.Service.ServiceUser;
import it.Twitter.FollowersAnalyzer.Service.ServiceUserById;
import it.Twitter.FollowersAnalyzer.Service.ServiceUserByUsername;
import it.Twitter.FollowersAnalyzer.Stats.Media;
import it.Twitter.FollowersAnalyzer.Exceptions.IdNotFoundException;
import it.Twitter.FollowersAnalyzer.Exceptions.EmptyStringException;




@RestController
public class Controller {


	StringToJson json;


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


	@GetMapping(value="/UserByUsername/{username}")
	public ResponseEntity<Object> getUserByUsername(@PathVariable String username) throws IOException, ParseException{
		ServiceUserByUsername service = new ServiceUserByUsername(username);
		json=new StringToJson(service.getUser());
		
		return new ResponseEntity<>(json.ToJson(), HttpStatus.OK);
	}

	
	public JSONObject getUserById(@PathVariable Long id) throws IOException, ParseException{
		ServiceUserById service = new ServiceUserById(id);
		json=new StringToJson(service.getUser());

		JsonToUser jsonUser=new JsonToUser();

		User user=jsonUser.parseOneUser(json.ToJson());
		//System.out.println(user.UserToString());

		//StringToJson json2=new StringToJson(user.UserToString());
		json=new StringToJson(user.UserToString());
		//return json2.ToJson();
		return json.ToJson(); 
	}


	@GetMapping(value="/Followers/{id}")
	public JSONObject getFollowers(@PathVariable Long id) throws IOException, ParseException{

		ServiceFollowers service = new ServiceFollowers(id);	//istanzia il collegamento
		json=new StringToJson(service.getFollowers());

		/*JsonToUser jsonUser=new JsonToUser();

			for(User i: jsonUser.parseUsers(json.ToJson())) System.out.println(i.UserToString());*/

		ServiceFollowers service = new ServiceFollowers(id);

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

		return json.ToJson();
	}


	@GetMapping(value="/Tweets/{id}")
	public JSONObject getTweet(@PathVariable Long id) throws IOException, ParseException{
		ServiceTweet service = new ServiceTweet(id);
		json=new StringToJson(service.getTweet());
		return json.ToJson();
	}

	@GetMapping(value="/Retweeted_by/{id}")
	public JSONObject getRetweeted_by(@PathVariable Long id) throws IOException, ParseException{
		ServiceRetweeted_by service = new ServiceRetweeted_by(id);
		json=new StringToJson(service.getRetweeted_by());
		return json.ToJson();
	}


	@GetMapping(value="/LikedTweets/{id}")
	public JSONObject getLikedTweets(@PathVariable Long id) throws IOException, ParseException{
		ServiceLikedTweets service = new ServiceLikedTweets(id);
		json=new StringToJson(service.getLikedTweets());
		return json.ToJson();
	}


	@GetMapping(value="/MediaFollowers/{id}")
	public String getMedia(@PathVariable Long id) throws IOException, ParseException{

		JsonToUser jsonUser=new JsonToUser();
		ArrayList<Long> IdFollowers = new ArrayList<Long>();
		ArrayList<Integer> NumFollower = new ArrayList<Integer>();


		for(User i : jsonUser.parseUsers(getFollowers(id))) {
			IdFollowers.add(i.getId());
		}

		for(Long i: IdFollowers) {
			NumFollower.add(jsonUser.parseUsers(getFollowers(i)).size());	
		}

		String line="";
		for(Integer i : NumFollower) {
			line+=" "+i;
		}
		Media media =new Media(NumFollower);
		return line+"\n"+media.toString();
	}


	/*@GetMapping(value="/{id}")
	public ResponseEntity<JSONObject> getUser(@PathVariable Long id) throws IOException, ParseException, IdNotFoundException{
		ServiceUser service = new ServiceUser(id);
		json = new StringToJson(service.getUser());
		return json.ToJson();
	}*/
	
	
	@GetMapping(value="/FollowersStats/{id}")
	public JSONObject getStats(@PathVariable Long id, @RequestParam(defaultValue = "number") String method) throws IOException, ParseException{
		
		JSONObject Jobj=getUserById(id);
		JsonToUser jsonUser=new JsonToUser();
		FilterByFollowersRange filter= new FilterByFollowersRange();
		
		User user=jsonUser.parseUser(Jobj);
		user.setFollowers(jsonUser.parseUsers(getFollowers(id)));
		
		for(User i : user.getFollowers()) {
			i.setFollowers(jsonUser.parseUsers(getFollowers(i.getId())));	
		}
		
		filter.Filter(user.getFollowers());
		if(method.equals("number"))json=new StringToJson(filter.NumberToString());
		if(method.equals("%"))json=new StringToJson(filter.PerToString());
		return json.ToJson();
	}


}
