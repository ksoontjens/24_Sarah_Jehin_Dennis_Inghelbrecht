public class Factuur implements Betaalbaar {

	public int factuurNummer = 0;
	public float factuurBedrag = 0;
	

	public Factuur(int factuurNummer, float factuurBedrag) {
		this.factuurNummer = factuurNummer;
		this.factuurBedrag = factuurBedrag;
	}

	public void betaal() {
		System.out.println("Betaal factuur van " + factuurBedrag + " met nummer " + factuurNummer);
	}

}