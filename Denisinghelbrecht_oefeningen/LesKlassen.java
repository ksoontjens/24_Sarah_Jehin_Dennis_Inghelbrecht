public class LesKlassen {

	public static void main (String args[]) {
		Werknemer jan;
		jan = new Werknemer("Jan", "Janssens", 1, 20.0f);

		Werknemer herman = new Werknemer("Herman", "Hermans", 2, 30.0f);
		Werknemer thessa = new Werknemer("Thessa", "Moerloos", 3, 2000.0f);
		Werknemer phedra = new Werknemer("Phedra", "Moerloos", 4, 1850.0f);
		PartTimeWerknemer heath = new PartTimeWerknemer("Heath", "Ledger", 5, 1500.0f, 22);
		PartTimeWerknemer brittany = new PartTimeWerknemer("Brittany", "Murphy", 6, 1200.0f, 16);
		
		jan.salarisVerhogen(10);
		herman.salarisVerhogen(10);

		heath.salarisVerhogen(2);

		System.out.println(jan.voornaam + " verdient " + jan.getSalaris());
		System.out.println(herman.voornaam + " verdient " + herman.getSalaris());
		System.out.println(thessa.voornaam + " verdient " + thessa.getSalaris());
		System.out.println(phedra.voornaam + " verdient " + phedra.getSalaris());

		System.out.println(heath.voornaam + " verdient " + heath.getSalaris() + " en heeft " + heath.urenGewerkt + " uren gewerkt.");
		System.out.println(brittany.voornaam + " verdient " + brittany.getSalaris() + " en heeft " + brittany.urenGewerkt + " uren gewerkt.");

		System.out.println("Het RSZ-percentage van Jan is " + jan.getRSZ());
		System.out.println("Het RSZ-percentage van Heath is " + heath.getRSZ());
		System.out.println("Het RSZ-percentage van Brittany is " + brittany.getRSZ());

		brittany.setRSZ(15);

		System.out.println("Het RSZ-percentage van Brittany is " + brittany.getRSZ());

		
		/***************/
		StudentWerknemer sarah = new StudentWerknemer("Sarah", "Jehin", 7, 2000.0f, 24);
		System.out.println(sarah.voornaam + " verdient " + sarah.getSalaris() + ", heeft " + sarah.urenGewerkt + " uren gewerkt. En betaalt een RSZ van " + sarah.getRSZ() + "%.");
		

		/**************/

		Factuur factuur1 = new Factuur(1, 100.0f);

		Betaalbaar[] BetDingen = new Betaalbaar[2];
		BetDingen[0] = jan;
		BetDingen[1] = factuur1;

		for(int i = 0; i<2; i++) {
			//hoewel de betaalmethode van werknemer(jan) en factuur(factuur1) verschillend zijn kan je ze beide oproepen aan de hand van de interface waar deze methode ook in zit.
			//bij BetDingen[0] gaat hij dus de betaalmethode van werknemer oproepen en bij BetDingen[1] die van Factuur
			BetDingen[i].betaal();
		}


		System.out.println("aantal werknemers = " + Werknemer.aantalWerknemers);

	}
}