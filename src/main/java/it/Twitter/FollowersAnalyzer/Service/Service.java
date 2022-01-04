package it.Twitter.FollowersAnalyzer.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import it.Twitter.FollowersAnalyzer.Exceptions.ConnectionException;

public abstract class Service {	
	private String BearerToken;
	protected String Url;


	public Service() {
		//this.BearerToken = "AAAAAAAAAAAAAAAAAAAAABIfWgEAAAAAAOF%2FgMH8TPODq1PwU9Qu0jIyJW4%3DKAuT33sk6LZuTaZR89Pyo9H0rRt6W8GYYxQNP6USsNPbNoHhb6";
		this.BearerToken = "AAAAAAAAAAAAAAAAAAAAAMlcXQEAAAAAYb28sKQdHrua1w1PqUY2oP9OjM0%3DTQ81FuSWRLb8px1DIHkx5Knk2ZD4guUN6KZiNNPKBov6X5rpAu";
	}


	public String Connection(String Url) throws IOException {
		String aux="";
		String line="";

		// Sending get request
		try {

			URLConnection openConnection = new URL(Url).openConnection();
			openConnection.setRequestProperty("Authorization","Bearer "+ BearerToken);
			InputStream input = openConnection.getInputStream();
			try {
				InputStreamReader reader = new InputStreamReader(input);
				BufferedReader buf = new BufferedReader(reader);
				
				if (( aux = buf.readLine() ) == null) throw new ConnectionException();
				else line+= aux;
				
				while ( ( aux = buf.readLine() ) != null ) {
					line+= aux;
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());	
			} finally {
				input.close();
			}
		} catch (ConnectionException e) {
			return e.getError();
		}
		return line;
	}


}


