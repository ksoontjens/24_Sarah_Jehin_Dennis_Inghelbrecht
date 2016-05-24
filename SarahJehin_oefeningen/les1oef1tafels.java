public class les1oef1tafels {

	public static void main (String arg[])
	{
		tafels();
	}

	public static void tafels()
	{

		int x;
		int y;
		for(x=1; x<10; x++)
		{
			for(y=1; y<10; y++)
			{
				System.out.println(x + " x " + y + " = " + (x*y));
			}
		}
	}

}