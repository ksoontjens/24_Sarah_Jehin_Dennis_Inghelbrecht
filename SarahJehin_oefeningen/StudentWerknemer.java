public class StudentWerknemer extends PartTimeWerknemer {


	public StudentWerknemer(String voornaam, String achternaam, int wNummer, float salaris, int urenGw) {
		//super is om constructor van superklasse aan te roepen
		super(voornaam, achternaam, wNummer, salaris, urenGw); //moet op eerste lijn !!
		//studenten betalen minder RSZ, dus gaan we voor hen de RSZ aanpassen
		setRSZ(5.0f);
	}

	


}