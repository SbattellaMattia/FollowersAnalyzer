package it.Twitter.FollowersAnalyzer.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import org.springframework.beans.factory.annotation.Autowired;



public class ServiceImplementation implements Service {	
	private String BearerToken;
	
	
	public ServiceImplementation() {
			this.BearerToken = "AAAAAAAAAAAAAAAAAAAAABIfWgEAAAAAAOF%2FgMH8TPODq1PwU9Qu0jIyJW4%3DKAuT33sk6LZuTaZR89Pyo9H0rRt6W8GYYxQNP6USsNPbNoHhb6";
	}


	
	
@Autowired	
@Override	
public String getFollowers(Long id) throws IOException {
		String aux="";
		String line="";
		
		// Sending get request
        String url="https://api.twitter.com/2/users/"+id+"/followers";
		try {
			
			URLConnection openConnection = new URL(url).openConnection();
			openConnection.setRequestProperty("Authorization","Bearer "+ BearerToken);
			openConnection.addRequestProperty("max_results","5");
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


