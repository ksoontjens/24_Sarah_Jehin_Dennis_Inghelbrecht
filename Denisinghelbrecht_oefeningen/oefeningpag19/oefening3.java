import java.lang.*;
/**
*Dit is een programma
*@author Denis Inghelbrecht
**/
public class oefening3 {
	
	

	/**
	*Dit is de main methode
	*@param args [] Dit zijn parameters die met de commandline meekomen
	**/
	public static void main(String args[])
	{
		float pi = 0;
		for (int i=1; i<20002; i+=4) {
			pi = pi + (1 / i);	
		}
		for (int j=3; i<20004; j+=4) {
			pi = pi - (1 / j);	
		}
		
	pi = pi * 4;

	System.out.println(pi);
	}
	

}