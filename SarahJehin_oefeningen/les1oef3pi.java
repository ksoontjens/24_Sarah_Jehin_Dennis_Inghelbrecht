public class les1oef3pi {

	public static void main (String arg[])
	{
		pi_berekenen();
	}

	public static void pi_berekenen()
	{

		double pi = 0;
		int x;
		int noemer = 1;
		float som = 0;
		for(x=0; x<10000; x++)
		{
			if(x%2 == 0)
			{
				som += (1.0f/noemer);
			}
			else if(x%2 != 0)
			{
				som -= (1.0f/noemer);
			}
			noemer += 2;
		}

		pi = 4*(som);
		System.out.println(pi);
		
	}

}