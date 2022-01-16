package it.Twitter.FollowersAnalyzer.FiltersTest;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.Twitter.FollowersAnalyzer.Exceptions.DateException;
import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.Filter.FilterByCreation;
import it.Twitter.FollowersAnalyzer.Model.User;
import junit.framework.TestCase;

/** Questa classe TestJsonArray testa i metodi della classe {@link it.Twitter.FollowersAnalyzer.Filter.FilterByCreation FilterByCreation}.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.Filter.FilterByCreation FilterByCreation
 */
class FilterByCreationTest extends TestCase{
	
	Long id=1111L;

	String created_at1="31-12-2009";
	String created_at2="10-10-2010";
	String created_at3="01-11-2011";
	
	User user=new User(id,"mirko","rkomi","00-00-0000");
	User user1=new User(id,"pippo","e non solo",created_at1);
	User user2=new User(id,"Dario","SecondDario",created_at2);
	User user3=new User(id,"Sara","SaRa4326",created_at3);

	
	/**
	 * Metodo che inizializza i dati necessari per effettuare i test: in questo caso setta i followers di un utente con le rispettive date di creazione.
	 */
	@BeforeEach
	protected void setUp() {
		(user.getFollowers()).add(user1);
		(user.getFollowers()).add(user2);
		(user.getFollowers()).add(user3);
		//System.out.println("setUp completato");
	
	}
	
	/*Format: passiamo l'utente, la data di inizio filtraggio, la data di fine filtraggio
	 * 
	 * verranno restituiti i followers creati tra le due date*/
	
	
	/**
	 * Test che verifica se gli Utenti restituiti dopo il filtraggio siano quelli con data di creazione compresa tra <b>StartDate</b> e <b>EndDate</b>.
	 */
	@Test
	public void UserToString() throws NumberFormatException, DateException, NullDataException, WrongParameter {
		FilterByCreation filter= new FilterByCreation();
		System.out.println(filter.FollowerFilter(user, "01-01-2007", "null"));
	}
	
	/**
	 * Test che verifica se gli Utenti restituiti dopo il filtraggio siano quelli con data di creazione compresa tra <b>StartDate</b> e <b>EndDate</b>.
	 */
	@Test
	public void UserToString0() throws NumberFormatException, DateException, NullDataException, WrongParameter {
		FilterByCreation filter= new FilterByCreation();
		System.out.println(filter.FollowerFilter(user, "08-10-2010", "null"));
	}
	
	/**
	 * Test che verifica se gli Utenti restituiti dopo il filtraggio siano quelli con data di creazione compresa tra <b>StartDate</b> e <b>EndDate</b>.
	 */
	@Test
	public void UserToString1() throws NumberFormatException, DateException, NullDataException, WrongParameter {
		FilterByCreation filter= new FilterByCreation();
		System.out.println(filter.FollowerFilter(user, "30-12-2009", "01-01-2010"));
	}
	
	/**
	 * Test che verifica se gli Utenti restituiti dopo il filtraggio siano quelli con data di creazione compresa tra <b>StartDate</b> e <b>EndDate</b>.
	 */
	@Test
	public void UserToString2() throws NumberFormatException, DateException, NullDataException, WrongParameter {
		FilterByCreation filter= new FilterByCreation();
		System.out.println(filter.FollowerFilter(user, "09-10-2010", "11-10-2010"));
	}
	
	/**
	 * Test che verifica se gli Utenti restituiti dopo il filtraggio siano quelli con data di creazione compresa tra <b>StartDate</b> e <b>EndDate</b>.
	 */
	@Test
	public void UserToString3() throws NumberFormatException, DateException, NullDataException, WrongParameter {
		FilterByCreation filter= new FilterByCreation();
		System.out.println(filter.FollowerFilter(user, "31-10-2011", "02-11-2011"));
	}
	
	/**
	 * Test che verifica la correttezza dell'eccezione lanciata se venisse immesso un giorno<1 o un giorno>31.
	 */
	@Test
    void exceptionTesting1() {
		FilterByCreation filter= new FilterByCreation();
        DateException exception = assertThrows(DateException.class, () ->filter.FollowerFilter(user, "00-01-2021", "null"));
        assertEquals("Wrong type of data: day<1 or day>31: 0", exception.getMessage());
    }
	
	/**
	 * Test che verifica la correttezza dell'eccezione lanciata se venisse immesso un un giorno>30 nei mesi che hanno 30 giorni.
	 */
	@Test
    void exceptionTesting2() {
		FilterByCreation filter= new FilterByCreation();
        DateException exception = assertThrows(DateException.class, () ->filter.FollowerFilter(user, "31-04-2021", "null"));
        assertEquals("Wrong type of data: April, June, September, November have 30 days: 31", exception.getMessage());
    }
	
	/**
	 * Test che verifica la correttezza dell'eccezione lanciata se venisse immesso una <b>StartDate</b> > <b>EndDate</b>.
	 * In particolare viene testato l'anno.
	 */
	@Test
    void exceptionTesting3() {
		FilterByCreation filter= new FilterByCreation();
		WrongParameter exception = assertThrows(WrongParameter.class, () ->filter.FollowerFilter(user, "01-01-2021", "01-01-2020"));
        assertEquals("Wrong or inexistent parameter: start year > end year : 2021-2020", exception.getMessage());
    }
	
	/**
	 * Test che verifica la correttezza dell'eccezione lanciata se venisse immesso una <b>StartDate</b> > <b>EndDate</b>.
	 * In particolare viene testato il giorno.
	 */
	@Test
    void exceptionTesting4() {
		FilterByCreation filter= new FilterByCreation();
		WrongParameter exception = assertThrows(WrongParameter.class, () ->filter.FollowerFilter(user, "02-01-2021", "01-01-2021"));
        assertEquals("Wrong or inexistent parameter: start day > end day : 2-1", exception.getMessage());
    }
	 
	/**
	 * Test che verifica la correttezza dell'eccezione lanciata se venisse immessa una data del tipo non corretto.
	 */
	@Test
    void exceptionTesting5() {
		FilterByCreation filter= new FilterByCreation();
		WrongParameter exception = assertThrows(WrongParameter.class, () ->filter.FollowerFilter(user, "non sono", "una data"));
        assertEquals("Wrong or inexistent parameter: Use correct form of data: dd-mm-yyyy", exception.getMessage());
    }
	
	/**
	 * Test che verifica la correttezza dell'eccezione lanciata se venisse immessa una data del tipo corretto, ma con errori di scrittura.
	 */
	@Test
    void exceptionTesting6() {
		FilterByCreation filter= new FilterByCreation();
		WrongParameter exception = assertThrows(WrongParameter.class, () ->filter.FollowerFilter(user, "0l-0l-2020", "0S-0S-2020"));
        assertEquals("Wrong or inexistent parameter: Use only numbers: dd-mm-yyyy: 0l-0l-2020 0S-0S-2020", exception.getMessage());
    }
	 
	/**
	 * Distrugge ciò che è stato inizializzato da metodo setUp.
	 * 
	 * @throws Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {}
}


