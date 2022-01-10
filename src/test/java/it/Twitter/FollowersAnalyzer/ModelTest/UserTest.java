package it.Twitter.FollowersAnalyzer.ModelTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import it.Twitter.FollowersAnalyzer.Model.User;

public class UserTest {

	User user=new User(1234L,"Dario","SecondDario","00-00-0000",true);
	
	@BeforeEach
    void setUp() {
		//System.out.println("setUp completato");
    }

    @Test
    void UserToString() {
    	System.out.println(user.UserToString());
    }
    
    @Test
    void UserGetId() {
    	assertEquals(1234L,user.getId());
    }

    @Test
    void UserUsername() {
    	assertEquals("SecondDario",user.getUsername());
    }
    
    @AfterEach
	public void tearDown() throws Exception {}

}
