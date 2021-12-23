package it.Twitter.FollowersAnalyzer.Stats;

import java.util.ArrayList;

public class Media {
	
	private int somma=0;
	private float media=0;
	
	
	public Media(ArrayList<Integer> numerofollowersxUser) {
		for (Integer i: numerofollowersxUser) somma+=i;
		try {
			this.media=somma/numerofollowersxUser.size();}
		catch(ArithmeticException e) {
			System.err.println("Media non riuscita");
		}
		
		//this.media=somma/numerofollowersxUser.size();
			
	}

	public String toString() {
		return "I followers dell'utente hanno una Media di "+ media +" followers a testa";
	}
	
	
	
	
	
	

}
