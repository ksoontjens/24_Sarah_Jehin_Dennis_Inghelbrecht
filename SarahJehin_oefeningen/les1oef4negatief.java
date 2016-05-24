public class les1oef4negatief {

	public static void main (String arg[])
	{
		negatief_berekenen(4302);
	}

	public static void negatief_berekenen(int getal)
	{

		//omzetten naar binair en dan inverteren
		getal = ~getal;
		getal += 1;

		System.out.println(getal);
		
	}

}