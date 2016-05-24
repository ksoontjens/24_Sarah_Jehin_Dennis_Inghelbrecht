import java.lang.*;
/**
*Dit is een programma
*@author Denis Inghelbrecht
**/
public class oefening5 {
	
	

	/**
	*Dit is de main methode
	*@param args [] Dit zijn parameters die met de commandline meekomen
	**/
	public static void main(String args[])
	{
		boolean isNotAPriem = false;
		
		for(int i = 1; i<100; i++) 
		{
			for(int j = 2;j < i; j++)
			{
				if(i % j == 0)
				{
					isNotAPriem = true;
				}
				
			}

			if(!isNotAPriem) 
				{
					System.out.println(i + " is een priemgetal.");
				}
				isNotAPriem = false;
		}
	}
	

}