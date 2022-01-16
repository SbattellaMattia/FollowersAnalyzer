package it.Twitter.FollowersAnalyzer.Stats;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.Model.User;

/**
 * Classe StatFollowersRange : contiene i metodi necessari allo sviluppo di una statistica. In particolare per la suddivisione dei followers di un utente sulla base del numero dei loro rispettivi followers.
 * 
 *
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 */
public class StatFollowersRange {
	private int LESS_10;
	private int BETWEEN_10_25;
	private int BETWEEN_25_50;
	private int BETWEEN_50_75;
	private int BETWEEN_75_100;
	private int MORE_100;
	
	private double perLESS_10;
	private double perBETWEEN_10_25;
	private double perBETWEEN_25_50;
	private double perBETWEEN_50_75;
	private double perBETWEEN_75_100;
	private double perMORE_100;
	private int tot;
	
	/**
	 * Costruttore della classe StatFollowersRange. Esegue il contaggio del numero di utenti appartenenti ad ogni fascia di numero di followers. Esegue poi il contaggio del numero di utenti appartenenti ad ogni fascia per percentuale di numero di followers. 
	 * 
	 * @param followers : <code>ArrayList</code> di followers dell'utente del quale si vuole eseguire la statistica.
	 */
	public StatFollowersRange(ArrayList<User> followers) {
		
		for(User i: followers) {
			int num=i.getFollowers().size();
			if(num<=10)this.LESS_10++;
			if(num>10 && num<=25) this.BETWEEN_10_25++;
			if(num>25 && num<=50) this.BETWEEN_25_50++;
			if(num>50 && num<=75) this.BETWEEN_50_75++;
			if(num>75 && num<=100)this.BETWEEN_75_100++;
			if(num>100) this.MORE_100++;
		}
		
		this.tot=LESS_10+BETWEEN_10_25+BETWEEN_25_50+BETWEEN_50_75+BETWEEN_75_100+MORE_100;
		this.perLESS_10=Math.round(((double)LESS_10/tot*100)*100.0)/100.0;
		this.perBETWEEN_10_25=Math.round(((double)BETWEEN_10_25/tot*100)*100.0)/100.0;
		this.perBETWEEN_25_50=Math.round(((double)BETWEEN_25_50/tot*100)*100.0)/100.0;
		this.perBETWEEN_50_75=Math.round(((double)BETWEEN_50_75/tot*100)*100.0)/100.0;
		this.perBETWEEN_75_100=Math.round(((double)BETWEEN_75_100/tot*100)*100.0)/100.0;
		this.perMORE_100=Math.round(((double)MORE_100/tot*100)*100.0)/100.0;
	}

	/**
	 * Metodo StatToString per scrivere i dati in formato <Code>String</Code>.
	 * In base al parametro inserito si otterranno due valori diversi:
	 * Con l'opzione <b>number</b> verrà restituita una <Code>String</Code> che rappresenta gli utenti appartenenti alle fasce secondo il numero di followers dell'utente in considerazione.
	 * Con l'opzione <b>percentage</b> verrà restituita una <Code>String</Code> che rappresenta gli utenti appartenenti alle fasce secondo la percentuale di numero di followers dell'utente in considerazione.
	 * 
	 * @param message : Possibilità di scelta fra le opzioni: <b>number</b> e <b>percentage</b>.
	 * @return <Code>String</Code> : Stringa convertibile in <b>JSONObject</b>.
	 * @throws WrongParameter - nel caso di inserimento di un parametro inesatto.
	 */
	public String StatToString(String message) throws WrongParameter {
		if(message.equals("number")) {
		return "{\"Number for range of followers\":[{\"LESS_10\": \"" + LESS_10 + "\",\"BETWEEN_10_25\": \"" + BETWEEN_10_25 + "\",\"BETWEEN_25_50\": \""
				+ BETWEEN_25_50 + "\",\"BETWEEN_50_75\": \"" + BETWEEN_50_75 + "\",\"BETWEEN_75_100\": \"" + BETWEEN_75_100
				+ "\",\"MORE_100\": \"" + MORE_100 + "\"}]}";}
		if(message.equals("percentage")) {
			return "{\"Percentage for range of followers\":[{\"LESS_10\": \"" + perLESS_10 + "%\",\"BETWEEN_10_25\": \"" + perBETWEEN_10_25 + "%\",\"BETWEEN_25_50\": \""
					+ perBETWEEN_25_50 + "%\",\"BETWEEN_50_75\": \"" + perBETWEEN_50_75 + "%\",\"BETWEEN_75_100\": \"" + perBETWEEN_75_100
					+ "%\",\"MORE_100\": \"" + perMORE_100 + "%\"}]}";}
		
		throw new WrongParameter("\""+message+"\" is not allowed");
	}

}
