package it.Twitter.FollowersAnalyzer.Filter;

import java.util.ArrayList;

import it.Twitter.FollowersAnalyzer.Exceptions.DateException;
import it.Twitter.FollowersAnalyzer.Exceptions.NullDataException;
import it.Twitter.FollowersAnalyzer.Exceptions.WrongParameter;
import it.Twitter.FollowersAnalyzer.Model.User;


/**
 * Classe FilterByCreation che estende {@link it.Twitter.FollowersAnalyzer.Filter.Filter Filter}.
 * 
 * 
 * Filtra i Followers/Following di un utente a seconda della data di creazione dell'account.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.Filter.Filter Filter
 */


public class FilterByCreation extends Filter {

	
	/**
	 * Metodo per filtrare i Followers
	 * 
	 * @param User : Utente i cui Followers dovranno essere filtrati.
	 * @param StartDate : Data di inizio filtraggio.
	 * @param EndDate Data : di fine filtraggio.
	 * 
	 * @throws NumberFormatException se la data ha caratteri oltre a cifre.
	 * @throws DateException se la data inserita non e' valida (es. mm=13).
	 * @throws NullDataException se nessun utente e' tra le due date.
	 * @throws WrongParameter se <b>StartDate</b> e' maggiore di <b>EndDate</b> o se il formato "dd-mm-yyyy" e' errato.
	 * 
	 * @return <Code>String</Code>: Stringa di utenti filtrata, convertibile in JSONObject.
	 */
	public String FollowerFilter(User User,String StartDate, String EndDate) throws NumberFormatException, DateException, NullDataException, WrongParameter {

		ArrayList<User> FollowerDate = new ArrayList<User>();
		try {
			if(StartDate.length()!=10)throw new WrongParameter("Use correct form of data: dd-mm-yyyy");

			int startyear=checkYear(Integer.parseInt(StartDate.substring(6,StartDate.length())));
			int startmonth=checkMonth(Integer.parseInt(StartDate.substring(3,5)));
			int startday=checkDay(Integer.parseInt(StartDate.substring(0,2)),startmonth);


			if(EndDate.equals("null")) {
				for(User i: User.getFollowers()) {
					int UserYear=Integer.parseInt(i.getCreatedAt().substring(6,i.getCreatedAt().length()));
					int UserMonth=Integer.parseInt(i.getCreatedAt().substring(3,5));
					int UserDay=Integer.parseInt(i.getCreatedAt().substring(0,2));

					if (UserYear>startyear) {
						FollowerDate.add(i);}
					if (UserYear==startyear) {
						if (UserMonth>startmonth) {
							FollowerDate.add(i);}
						if (UserMonth==startmonth) {
							if (UserDay>startday) {
								FollowerDate.add(i);}
						}
					}

				}
			}
			else {
				if(EndDate.length()!=10)throw new WrongParameter("Use correct form of data: dd-mm-yyyy");
				int endyear=checkYear(Integer.parseInt(EndDate.substring(6,EndDate.length())));
				int endmonth=checkMonth(Integer.parseInt(EndDate.substring(3,5)));
				int endday=checkDay(Integer.parseInt(EndDate.substring(0,2)),endmonth);

				if (startyear>endyear) {
					throw new WrongParameter("start year > end year : "+startyear+"-"+endyear);}
				if (startyear==endyear) {
					if (startmonth>endmonth) {
						throw new WrongParameter("start month > end month : "+startmonth+"-"+endmonth);}
					if (startmonth==endmonth) {
						if (startday>endday) {
							throw new WrongParameter("start day > end day : "+startday+"-"+endday);}
					}
				}

				for(User i: User.getFollowers()) {
					int UserYear=Integer.parseInt(i.getCreatedAt().substring(6,i.getCreatedAt().length()));
					int UserMonth=Integer.parseInt(i.getCreatedAt().substring(3,5));
					int UserDay=Integer.parseInt(i.getCreatedAt().substring(0,2));

					if(UserYear>startyear && UserYear<endyear)FollowerDate.add(i);


					if(UserYear==startyear && UserYear==endyear) {

						if(UserMonth>startmonth && UserMonth<endmonth)FollowerDate.add(i);

						if(UserMonth==startmonth && UserMonth==endmonth){
							if(UserDay>startday && UserDay<endday)FollowerDate.add(i);}
						else {
							if(UserMonth==startmonth || UserMonth==endmonth) {
								if(UserMonth==startmonth) {
									if(UserDay>startday)FollowerDate.add(i);
								}
								if(UserMonth==endmonth) {
									if(UserDay<endday)FollowerDate.add(i);}
							}
						}
					}
					else{
						if(UserYear==startyear || UserYear==endyear) {
							if(UserYear==startyear){
								if (UserMonth>startmonth) {
									FollowerDate.add(i);}
								if(UserMonth==startmonth){
									if(UserDay>startday)FollowerDate.add(i);}
							}
							if(UserYear==endyear){
								if (UserMonth<endmonth) {
									FollowerDate.add(i);}
								if(UserMonth==endmonth){
									if(UserDay<endday)FollowerDate.add(i);}
							}
						}
					}
					


				}

			}
		}catch(NumberFormatException error) {
			throw new WrongParameter("Use only numbers: dd-mm-yyyy: "+StartDate+" "+EndDate);}

		if (FollowerDate.isEmpty()) throw new NullDataException("No users match the request");
		return UserArrayToString(FollowerDate);
	}






	/**
	 * Metodo per filtrare gli Utenti seguiti.
	 * 
	 * @param User : Utente i cui Utenti seguiti dovranno essere filtrati.
	 * @param StartDate : Data di inizio filtraggio.
	 * @param EndDate : Data di fine filtraggio.
	 * 
	 * @throws NumberFormatException se la data ha caratteri oltre a cifre.
	 * @throws DateException se la data inserita non e' valida (es. mm=13).
	 * @throws NullDataException se nessun utente e' tra le due date.
	 * @throws WrongParameter se <b>StartDate</b> e' maggiore di <b>EndDate</b> o se il formato "dd-mm-yyyy" e' errato.
	 * 
	 * @return <Code>String</Code>: Stringa di Utenti filtrata, convertibile in JSONObject.
	 */
	public String FollowingFilter(User User,String StartDate, String EndDate) throws NumberFormatException, DateException, NullDataException, WrongParameter {
		ArrayList<User> FollowingDate = new ArrayList<User>();
		try {
			if(StartDate.length()!=10)throw new WrongParameter("Use correct form of data: dd-mm-yyyy"+StartDate);
			int startyear=checkYear(Integer.parseInt(StartDate.substring(6,StartDate.length())));
			int startmonth=checkMonth(Integer.parseInt(StartDate.substring(3,5)));
			int startday=checkDay(Integer.parseInt(StartDate.substring(0,2)),startmonth);

			if(EndDate.equals("null")) {
				for(User i: User.getFollowing()) {
					int UserYear=Integer.parseInt(i.getCreatedAt().substring(6,i.getCreatedAt().length()));
					int UserMonth=Integer.parseInt(i.getCreatedAt().substring(3,5));
					int UserDay=Integer.parseInt(i.getCreatedAt().substring(0,2));

					if (UserYear>startyear) {
						FollowingDate.add(i);}
					if (UserYear==startyear) {
						if (UserMonth>startmonth) {
							FollowingDate.add(i);}
						if (UserMonth==startmonth) {
							if (UserDay>startday) {
								FollowingDate.add(i);}
						}
					}

				}
			}
			else {
				if(EndDate.length()!=10)throw new WrongParameter("Use correct form of data: dd-mm-yyyy"+EndDate);
				int endyear=checkYear(Integer.parseInt(EndDate.substring(6,EndDate.length())));
				int endmonth=checkMonth(Integer.parseInt(EndDate.substring(3,5)));
				int endday=checkDay(Integer.parseInt(EndDate.substring(0,2)),endmonth);

				if (startyear>endyear) {
					throw new WrongParameter("start year > end year : "+startyear+"-"+endyear);}
				if (startyear==endyear) {
					if (startmonth>endmonth) {
						throw new WrongParameter("start month > end month : "+startmonth+"-"+endmonth);}
					if (startmonth==endmonth) {
						if (startday>endday) {
							throw new WrongParameter("start day > end day : "+startday+"-"+endday);}
					}
				}

				for(User i: User.getFollowing()) {
					int UserYear=Integer.parseInt(i.getCreatedAt().substring(6,i.getCreatedAt().length()));
					int UserMonth=Integer.parseInt(i.getCreatedAt().substring(3,5));
					int UserDay=Integer.parseInt(i.getCreatedAt().substring(0,2));

					if(UserYear>startyear && UserYear<endyear)FollowingDate.add(i);


					if(UserYear==startyear && UserYear==endyear) {

						if(UserMonth>startmonth && UserMonth<endmonth)FollowingDate.add(i);

						if(UserMonth==startmonth && UserMonth==endmonth){
							if(UserDay>startday && UserDay<endday)FollowingDate.add(i);}
						else {
							if(UserMonth==startmonth || UserMonth==endmonth) {
								if(UserMonth==startmonth) {
									if(UserDay>startday)FollowingDate.add(i);
								}
								if(UserMonth==endmonth) {
									if(UserDay<endday)FollowingDate.add(i);}
							}
						}
					}
					else{
						if(UserYear==startyear || UserYear==endyear) {
							if(UserYear==startyear){
								if (UserMonth>startmonth) {
									FollowingDate.add(i);}
								if(UserMonth==startmonth){
									if(UserDay>startday)FollowingDate.add(i);}
							}
							if(UserYear==endyear){
								if (UserMonth<endmonth) {
									FollowingDate.add(i);}
								if(UserMonth==endmonth){
									if(UserDay<endday)FollowingDate.add(i);}
							}
						}
					}

				}

			}
		}catch(NumberFormatException error) {
			throw new WrongParameter("Use only numbers: dd-mm-yyyy: "+StartDate+" "+EndDate);}

		if (FollowingDate.isEmpty()) throw new NullDataException("No users match the request");
		return UserArrayToString(FollowingDate);
	}


	/**
	 * Metodo per verificare che l'anno immesso sia corretto.
	 * 
	 * @param year : Anno da controllare.
	 *
	 * @throws DateException se l'anno inserito e' minore di 2006 o maggiore di 2021.
	 * 
	 * @return <Code>Int</Code>: Anno immesso (se corretto).
	 */
	public int checkYear(int year) throws DateException {
		if(year<2006 || year>2021 )
			throw new DateException("year<2006 or year>2021: " + year);
		return year;}

	/**
	 * Metodo per verificare che il mese immesso sia corretto.
	 * 
	 * @param month : Mese da controllare.
	 *
	 * @throws DateException se il mese inserito e' minore di 1 o maggiore di 12.
	 * 
	 * @return <Code>Int</Code>: Mese immesso (se corretto).
	 */
	public int checkMonth(int month) throws DateException {
		if(month<1 || month>12 )
			throw new DateException("month<1 or month>12: " + month);
		return month;}

	/**
	 * Metodo per verificare che il giorno immesso sia corretto.
	 * 
	 * @param day : Giorno da controllare.
	 * @param month : Determina il numero di giorni possibili.
	 *
	 * @throws DateException se il giorno inserito e' minore di 1 o maggiore di 28/ maggiore di 30/ maggiore di 31 in base al mese immesso.
	 * 
	 * @return <Code>Int</Code>: Giorno immesso (se corretto).
	 */
	public int checkDay(int day, int month) throws DateException {
		if(day<1 || day>31 )
			throw new DateException("day<1 or day>31: " + day);

		if(month==2 && day>28)
			throw new DateException("February has 28 days: " + day);

		if((month==4 || month==6 || month==9 || month==11)  && day>30)
			throw new DateException("April, June, September, November have 30 days: " + day);

		return day;}

}
