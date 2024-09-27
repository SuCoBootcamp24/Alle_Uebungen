import java.util.Arrays;
import java.util.Collections;

public class ArrayReihenfolge{
	
	public static void main(String args[]){
	
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		// Platz für deine Lösung
		System.out.println(Arrays.toString(arr));
		System.out.println("");
		int temp;
		
		for (int i = 0; i < arr.length /2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length - (1+i)];
			arr[arr.length - (1+i)] = temp;	
		}

		System.out.println(Arrays.toString(arr));
		System.out.println("oder");
		System.out.println("");
		//---------------------------
		//oder

		int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(Arrays.toString(arr2));
		System.out.println("");

		int x = 0;
		int y = arr.length - 1;
		int temp2;

		while (x < y) {
			
			temp2 = arr2[x];
			arr2[x] = arr2[y];
			arr2[y] = temp2;
			x++;
			y--;
			
		}
		System.out.println(Arrays.toString(arr2));
	}
}