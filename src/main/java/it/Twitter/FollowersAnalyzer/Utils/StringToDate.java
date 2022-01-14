package it.Twitter.FollowersAnalyzer.Utils;

/** 
* Classe per convertire la <Code>String</Code> del created_at che ritorna il server API di Twetter
* in una <Code>String</Code> data che è conforme allo schema impostato "dd-mm-yyyy".
* 
* @author Sbattella Mattia
* @author Sumcutean Sara
* 
*/
public class StringToDate {
	private String date;

	/**
	 * Metodo per la conversione da <Code>String</Code> del created_at che ritorna il server API di Twetter
	 * in una <Code>String</Code> data che è conforme allo schema impostato "dd-mm-yyyy".
	 * 
	 * @param createdAt del tipo "yyyy-mm-dd "day of the week" hh:mm:ss".
	 * 
	 * @return <Code>String</Code> "dd-mm-yyyy".
	 */
	public String stringToDate(String createdAt){
		date=createdAt.substring(0,10);
		String[] aux=date.split("-");
		return aux[2]+"-"+aux[1]+"-"+aux[0];
	}
}
