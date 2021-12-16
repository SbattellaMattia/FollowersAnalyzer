package it.Twitter.FollowersAnalyzer.Controller;

import java.io.IOException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.Twitter.FollowersAnalyzer.Service.ServiceImplementation;

@RestController
public class Controller {
	
	ServiceImplementation service = new ServiceImplementation();
	
	@GetMapping(value="/followers/{id}")
	public /*ArrayList<User>*/ String getFollowers(@PathVariable Long id) throws IOException{
		return service.getFollowers(id);
    }
}
