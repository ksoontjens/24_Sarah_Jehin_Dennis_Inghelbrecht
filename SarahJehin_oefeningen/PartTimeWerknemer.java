public class PartTimeWerknemer extends Werknemer {

	int urenGewerkt;

	public PartTimeWerknemer(String voornaam, String achternaam, int wNummer, float salaris, int urenGw) {
		//super is om constructor van superklasse aan te roepen
		super(voornaam, achternaam, wNummer, salaris); //moet op eerste lijn !!!!
		urenGewerkt = urenGw;
	}

	public void salarisVerhogen(int percentage) {
		//mogen max 5% opslag krijgen
		if(percentage > 5) {
			System.err.println("Fout: PartTimeWerknemers kunnen maximum 5% opslag verdienen");
		}
		else {
			super.salarisVerhogen(percentage);
		}
	}


}