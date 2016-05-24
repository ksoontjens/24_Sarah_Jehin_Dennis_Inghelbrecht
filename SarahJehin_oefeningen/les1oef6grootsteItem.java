public class les1oef6grootsteItem {

	public static void main (String arg[])
	{
		//int[] getallen;
		//getallen = new int[8];
		int getallen[] = {12,34,56,78,123,234,99,88};
		grootsteItem(getallen);
		//System.out.println("xx");
	}

	public static void grootsteItem(int[] getallen) {
		
		int grootste = 0;
		
		int i = 0;		

		for(i = 0; i<getallen.length; i++) {
			if(getallen[i] > grootste) {
				grootste = getallen[i];
			}
		}

		System.out.println("Grootste getal van de reeks is " + grootste);

	}

}