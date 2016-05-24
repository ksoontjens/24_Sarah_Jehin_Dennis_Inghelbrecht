import java.lang.*;
/**
*Dit is een programma
*@author Denis Inghelbrecht
**/
public class PartTimeWerknemer extends Werknemer {

	public int urenGewerkt;

	public PartTimeWerknemer( String voornaam, String achternaam, int nr, float sal, int urengw) 
	{
	super(voornaam, achternaam, nr, sal);
	this.urenGewerkt=urengw;
	}

	public float getWeekLoon()
	{
	return this.salaris * (float)this.urenGewerkt;
	}

	public void salarisVerhogen( int percentage )
	{
		if( percentage > 5 )
		{
		percentage = 0;
		System.out.println("Fout: slechts 5% opslag toegestaan");
		}
		else
		{
		super.salarisVerhogen( percentage );
		}
	}

	public static void main(String []args)
	{
      	PartTimeWerknemer Flip;
	PartTimeWerknemer Syd;

	Flip = new PartTimeWerknemer( "Flip", "Flippens", 5, 12f, 20 );
	Syd = new PartTimeWerknemer( "Syd", "Sydney", 5, 12.5f, 24 );

	Flip.salarisVerhogen( 10 );

	Syd.setRSZ( 4f );
	
	System.out.println( Syd.getRSZ() );
	System.out.println(Flip.getSalaris());
	}
}