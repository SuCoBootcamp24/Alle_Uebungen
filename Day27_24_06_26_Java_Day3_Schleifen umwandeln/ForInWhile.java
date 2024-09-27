public class ForInWhile{
	
	public static void main(String args[]){
		//  Wandle folgende For-Schleife in eine While-Schleife um
		int summe = 0;

		for(int i = 0; i < 10; i++){
			  System.out.println("Durchlauf: " + i);
				summe += i;
		}

		int i = 0;
		System.out.println(summe);
		System.out.println("");
		System.out.println("");
		
		// Lösung:

		summe = 0;

		while (i < 10) {
			System.out.println("Durchlauf: " + i);
			summe += i;
			i++;
		}



		System.out.println(summe);

	}
}