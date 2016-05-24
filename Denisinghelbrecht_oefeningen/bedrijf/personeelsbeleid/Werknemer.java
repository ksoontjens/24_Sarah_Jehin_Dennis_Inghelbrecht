import java.lang.*;
/**
*Dit is een programma
*@author Denis Inghelbrecht
**/
public class Werknemer {

	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	protected float salaris;
	private float RSZpercentage = 0.33f;
	

	public Werknemer( String voornaam, String achternaam, int wNummer, float salaris) 
	{
	this.voornaam = voornaam;
	this.achternaam = achternaam;
	werknemerNummer = wNummer;
	this.salaris=salaris;
	}
	
	public void salarisVerhogen(int percentage)
	{
	float verhogingsfactor = (float)percentage / 100;
	salaris += salaris * verhogingsfactor;
	}
	
	public float getSalaris()
	{
	return salaris;
	}

	public void setRSZ( float RSZ )
	{
		this.RSZpercentage = RSZ / this.salaris;
	}

	public float getRSZ ()
	{
		return RSZpercentage;
	}

	public static void main(String []args)
	{
      	Werknemer Herman;
	Werknemer Ben;
	Werknemer Jef;
	Werknemer Fred;

	Herman = new Werknemer( "Herman", "Hermans", 1, 1800.0f);
	Ben = new Werknemer( "Ben", "Bens", 2, 2200.0f);
	Jef = new Werknemer( "Jef", "Josephs", 3, 2300.0f);
	Fred = new Werknemer( "Fred", "Fredje", 4, 1700.0f);

	Herman.salarisVerhogen( 10 );
	Ben.salarisVerhogen( 10 );
	Jef.setRSZ( 650f );
	
	System.out.println( Herman.werknemerNummer );
	System.out.println( Ben.werknemerNummer );
	System.out.println( Jef.werknemerNummer );
	System.out.println( Fred.werknemerNummer );

	System.out.println( Herman.getSalaris() );
	System.out.println( Ben.getSalaris() );

	System.out.println( Jef.getRSZ() );
   	}

	

}