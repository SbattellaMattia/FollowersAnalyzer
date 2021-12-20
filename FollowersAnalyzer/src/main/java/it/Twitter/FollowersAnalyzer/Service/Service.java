package it.Twitter.FollowersAnalyzer.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import org.springframework.beans.factory.annotation.Autowired;



public class Service {	
	private String BearerToken;
	
	
	public Service() {
			this.BearerToken = "AAAAAAAAAAAAAAAAAAAAABIfWgEAAAAAAOF%2FgMH8TPODq1PwU9Qu0jIyJW4%3DKAuT33sk6LZuTaZR89Pyo9H0rRt6W8GYYxQNP6USsNPbNoHhb6";
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
				  
				while ( ( aux = buf.readLine() ) != null ) {
					line+= aux;
				}
			} catch (IOException e) {
				System.out.println(e.getClass().getCanonicalName()
				+"Errore in com.example.demo.service.DatabaseClass.java: Operazione di I/O interrotte");	
			} finally {
				input.close();
			}
		} catch (IOException e) {
			System.err.println("Erore connessione");
		}
	return line;
	}





}


