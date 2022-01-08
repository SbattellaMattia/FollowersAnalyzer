package it.Twitter.FollowersAnalyzer.Stats;

import it.Twitter.FollowersAnalyzer.Model.User;

public class StatMedia {

	private int somma=0;
	private double media=0;

	public StatMedia(User user) {

		for(User i: user.getFollowers()) {
			somma+=i.getFollowers().size();
		}
<<<<<<< HEAD

=======
>>>>>>> a6cc080405c49ed7d4226b9432c4d8559815d438
		try {
			media=Math.round((double)somma/user.getFollowers().size()*100.0)/100.0;}
		catch(ArithmeticException e) {
			System.err.println("Media non riuscita");
		}

	}

	
	public double getMedia() {
		return media;
	}


	public String toString() {
		return "{\"MediaFollowers(per utente)\":[{\"media\": \""+ media + " followers\"}]}";	
	}

}
