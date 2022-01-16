package it.Twitter.FollowersAnalyzer.ModelTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import it.Twitter.FollowersAnalyzer.Model.User;

/** Questa classe UserTest testa alcuni metodi della classe {@link it.Twitter.FollowersAnalyzer.Model.User User}.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.Model.User User
 */
public class UserTest {

	User user=new User(1234L,"Dario","SecondDario","00-00-0000",true);
	
	/**
	 * Metodo che inizializza i dati necessari per effettuare i test.
	 */
	@BeforeEach
    void setUp() {
		//System.out.println("setUp completato");
    }

	/**
	 * Test che verifica il corretto funzionamento del metodo di stampa di un utente sotto forma di <Code>String</Code>.
	 */
    @Test
    void UserToString() {
    	System.out.println(user.UserToString());
    }
    
    /**
	 * Test che verifica l'uguaglianza fra l'id restituito dal metodo getId e quello settato all'utente di prova.
	 */
    @Test
    void UserGetId() {
    	assertEquals(1234L,user.getId());
    }

    /**
	 * Test che verifica l'uguaglianza fra l'username restituito dal metodo getUsername e quello settato all'utente di prova.
	 */
    @Test
    void UserUsername() {
    	assertEquals("SecondDario",user.getUsername());
    }
    
    /**
   	 * Distrugge ciò che è stato inizializzato da metodo setUp.
   	 * 
   	 * @throws Exception
   	 */
    @AfterEach
	public void tearDown() throws Exception {}

}
