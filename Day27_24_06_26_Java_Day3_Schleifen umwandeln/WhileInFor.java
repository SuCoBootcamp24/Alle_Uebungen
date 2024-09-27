public class WhileInFor{
	
	public static void main(String args[]){
		// Wandle folgende Do-While-Schleife in eine For-Schleife um

		int a = 0;
		do{
			a += 2;
			System.out.println(a);
		}while(a < 7);

	
		System.out.println("");
		System.out.println("");
	//Lösung:

		for (a = 2; a < 9; a += 2) {
			System.out.println(a);
		}



	}
}