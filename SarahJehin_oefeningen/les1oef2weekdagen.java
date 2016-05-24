public class les1oef2weekdagen {

	public static void main (String arg[])
	{
		weekdagen();
	}

	public static void weekdagen()
	{

		int weekdag = 0;
		int x;
		for(x=0; x<=28; x++)
		{
			if(weekdag==0) System.out.print("zon"); //geen println, anders komt de volgende op een nieuw lijntje
			if(weekdag==1) System.out.print("maan"); //geen println
			if(weekdag==2) System.out.print("dins"); //geen println
			if(weekdag==3) System.out.print("woens"); //geen println
			if(weekdag==4) System.out.print("donder"); //geen println
			if(weekdag==5) System.out.print("vrij"); //geen println
			if(weekdag==6) System.out.print("zater"); //geen println
			
			weekdag++;
			if(weekdag>6) weekdag = 0; //als je de week rond bent, terug op 0 (zondag) starten
			//eerst wordt bvb dins van hierboven geprint en dan direct daarachter dag, wordt dus dinsdag, dan print je x (de dag van de maand) en dan de rest van de zin (door println komt de volgende print op een nieuwe lijn)
			System.out.println("dag " + x + " februari 2009"); //in x komt altijd de waarde van de print hierboven (geen println)
		}
	}

}