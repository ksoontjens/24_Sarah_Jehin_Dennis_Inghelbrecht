import java.lang.*;
/**
*Dit is een programma
*@author Denis Inghelbrecht
**/
public class oefening {
	
	/**
	*Dit is de main methode
	*@param args [] Dit zijn parameters die met de commandline meekomen
	**/
	public static void main(String args[])
	{
		drukaf(100);
	}
	
	/**
	*Dit is een private methode
	*@param m deze parameter geeft aan tot hoeveel de methode afdrukt
	**/
	private static void drukaf(int m) 
	{
		int a;
		for ( a=0;a<m;a++ )
		{
			System.out.println(a);
		}		
	}

}