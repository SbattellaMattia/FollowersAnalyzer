package it.Twitter.FollowersAnalyzer.Stats;

import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Model.User;

public class StatVariation {

	private double sommaSQ=0;
	private double media=0;
	private double varianza=0;

	public StatVariation(User user) throws NullDataException {
		StatAverage med = new StatAverage(user);
		media = med.getMedia();
		for(User i : user.getFollowers()) {
			sommaSQ += (i.getFollowers().size()-media)*(i.getFollowers().size()-media);
		}
		try {
			varianza = Math.round((double)sommaSQ/(user.getFollowers().size()-1)*100.0)/100.0;}
		catch(ArithmeticException e) {
			throw new NullDataException("variance failed.");
		}
	}
	
	
	public double getVarianza() {
		return varianza;
	}

	public void setVarianza(double varianza) {
		this.varianza = varianza;
	}



	public String toString() {
		return "{\"Followers variance(per user)\":[{\"variance\": \""+ varianza + " followers\"}]}";	
	}
}