package it.Twitter.FollowersAnalyzer.Stats;

import it.Twitter.FollowersAnalyzer.Model.User;

public class StatVarianza {

	private double sommaSQ=0;
	private double media=0;
	private double varianza=0;

	public StatVarianza(User user) {
		StatMedia med = new StatMedia(user);
		media = med.getMedia();
		for(User i : user.getFollowers()) {
			sommaSQ += (i.getFollowers().size()-media)*(i.getFollowers().size()-media);
		}
		try {
			varianza = Math.round((double)sommaSQ/(user.getFollowers().size()-1)*100.0)/100.0;}
		catch(ArithmeticException e) {
			System.err.println("Varianza non riuscita");
		}
	}

	public String toString() {
		return "{\"VarianzaFollowers(per utente)\":[{\"varianza\": \""+ varianza + " followers\"}]}";	
	}
}