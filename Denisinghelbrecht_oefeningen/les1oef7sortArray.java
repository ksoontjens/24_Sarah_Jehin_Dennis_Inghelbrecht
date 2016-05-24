public class les1oef7sortArray {

	public static void main (String arg[])
	{
		//dit is de oorspronkelijke array die je gaat meegeven aan de methode
		int getallen[] = {12,34,56,78,123,234,99,88};
		
		//in deze array ga je de gesorteerde waarden opslagen
		int gesorteerd[] = groot_naar_klein(getallen);

		//dan ga je met een for loopje alle waarden van de gesorteerde array overlopen om ze te printen
		int i = 0;
		for(i=0; i<gesorteerd.length; i++) {
			System.out.println(gesorteerd[i]);
		}
	}

	//Deze methode gaat het grootste getal in een array zoeken
	//Returnt een array met de index van het grootste getal + de waarde van het grootste getal
	public static int[] grootsteItem(int[] getallen) {
		
		int grootste = 0;
		int plaats = 0;
		int i = 0;		

		for(i = 0; i<getallen.length; i++) {
			if(getallen[i] > grootste) {
				grootste = getallen[i];
				plaats = i;
			}
		}

		//System.out.println("Grootste getal van de reeks is " + grootste);

		//resultaat is een array waarin je de index + de waarde van het grootste getal gaat bijhouden
		int[] resultaat;
		resultaat = new int[2];
		resultaat[0] = plaats;
		resultaat[1] = grootste;
		
		return resultaat;

	}

	//Deze methode gaat de waarden van een array sorteren van groot naar klein
	public static int[] groot_naar_klein (int[] getallen) {
		
		int[] gesorteerd;
		gesorteerd= new int[8];
		
		//je gaat de array overlopen -> aantal keer er getallen in de array zijn
		int i = 0;
		for(i=0; i<getallen.length; i++) {
			//je gaat de methode grootsteItem oproepen met de huidige array (deze geeft een resulaten array terug)
			int resultaten[] = grootsteItem(getallen);
			//je gaat het grootste getal (dat in resultaten[1] zit) opslagen in de gesorteerde array
			gesorteerd[i] = resultaten[1];
			//in de oorspronkelijke array zet je het getal op de index van het grootste getal op 0 zodat dat de volgende keer niet meer meegerekend wordt
			getallen[resultaten[0]] = 0;
		}

		return gesorteerd;
	}


}