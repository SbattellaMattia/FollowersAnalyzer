package it.Twitter.FollowersAnalyzer.ModelTest;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import it.Twitter.FollowersAnalyzer.FollowersAnalyzerApplication;
import it.Twitter.FollowersAnalyzer.Model.User;

public class UserTest extends FollowersAnalyzerApplication{
	Long id=1111L;
	User user;
	
	@BeforeEach
    void setUp() {
        user=new User(id);
    }

    @Test
    void UserToString() {
    	System.out.println(user.UserToString());
    }

}
