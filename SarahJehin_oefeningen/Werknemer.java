public class Werknemer implements Betaalbaar {

	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	protected float salaris;
	private float RSZpercentage = 33.0f;
	
	public static int aantalWerknemers;

	public Werknemer(String voornaam, String achternaam, int wNummer, float salaris) {
		//this is nodig als paramaternaam en datalid naam hetzelfde zijn
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		werknemerNummer = wNummer;
		this.salaris = salaris;

		aantalWerknemers++;
	}

	public void salarisVerhogen (int percentage) {
		salaris = salaris*(1+(percentage/100.0f));
	}

	public float getSalaris () {
		return salaris;
	}

	public float getRSZ() {
		return RSZpercentage;
	}

	public void setRSZ(float RSZ) {
		RSZpercentage = RSZ;
	}

	public void betaal() {
		System.out.println("Betaal werknemer " + voornaam + " uit met " + salaris);
	}


}