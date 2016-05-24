/**
*
* Dit is een programma
* @author Sarah Jehin
*
*/

public class EersteProg {

	/**
	* Dit is de main methode
	* @param arg[] Dit zijn parameters die met de commandline meekomen
	*/
	public static void main (String arg [])
	{
		//System.out.println("Hello World");
		drukaf(100);
	}

	/**
	* Deze methode drukt getallen af tot m
	* @param m Deze parameter geeft aan tot welke waarde je gaat afdrukken
	* als onderstaande methode private zou staan ipv public, dan kan je ze niet zien in Javadoc html bestand
	*/
	public static void drukaf(int m) 
	{
		int a;
		for(a=0; a<m; a++) 
		{
			System.out.println(a);
		}

		System.out.println(~10);
	}

}