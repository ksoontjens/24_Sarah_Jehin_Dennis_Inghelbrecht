import java.lang.*;
/**
*Dit is een programma
*@author Denis Inghelbrecht
**/
public class StudentWerknemer extends PartTimeWerknemer {

	private float RSZpercentage = 0.05f;

	public StudentWerknemer( String voornaam, String achternaam, int nr, float sal, int urengw) 
	{
	super(voornaam, achternaam, nr, sal, urengw);
	}

	public static void main(String []args)
	{
	StudentWerknemer Sarah;
	Sarah = new StudentWerknemer( "Sarah", "Saar", 7, 10f, 25 );
	System.out.println( Sarah.getRSZ() );
	}	

	}