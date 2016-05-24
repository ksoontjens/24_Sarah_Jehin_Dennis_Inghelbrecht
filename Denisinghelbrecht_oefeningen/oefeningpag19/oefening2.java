import java.lang.*;
/**
*Dit is een programma
*@author Denis Inghelbrecht
**/
public class oefening2 {
	

	

	/**
	*Dit is de main methode
	*@param args [] Dit zijn parameters die met de commandline meekomen
	**/
	public static void main(String args[])
	{
	int weekdag = 0;
	for(int i = 1; i<=28; i++)
	{

		if(weekdag == 0) System.out.print("zondag "); // geen println
		if(weekdag == 1) System.out.print("maandag ");
		if(weekdag == 2) System.out.print("dindsdag ");
		if(weekdag == 3) System.out.print("woensdag ");
		if(weekdag == 4) System.out.print("donderdag ");
		if(weekdag == 5) System.out.print("vrijdag ");
		if(weekdag == 6) System.out.print("zaterdag ");
		weekdag++;
		if(weekdag>6) weekdag = 0;
		System.out.println( i + " februari 2009");
	}	
	}

}