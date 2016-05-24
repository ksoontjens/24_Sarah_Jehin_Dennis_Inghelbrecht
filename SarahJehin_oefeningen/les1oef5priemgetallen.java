public class les1oef5priemgetallen {

	public static void main (String arg[])
	{
		priemgetallen_berekenen(100);
		//System.out.println("xx");
	}

	public static void priemgetallen_berekenen(int max_getal)
	{
		boolean priem = true;
		int getal;
		for(getal=3; getal < max_getal; getal++)
		{
			priem = true;
			//System.out.println(getal);
			float deler;
			for(deler=1.0f; deler<getal; deler++)
			{
				//System.out.println(getal + "/" + deler + " = " + getal%deler);
				if(getal%deler == 0)
				{
					//System.out.println("^ is nul");
					if(deler != 1 && deler != getal) {
						priem = false;
					}
				}
			}
			if(priem)
			{
				System.out.println(getal);
			}
			//System.out.println(priem);

		}

		
		
	}

}