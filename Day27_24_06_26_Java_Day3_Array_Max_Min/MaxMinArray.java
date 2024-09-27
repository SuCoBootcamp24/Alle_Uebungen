import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxMinArray{
	
	public static void main(String args[]){
	
		int arr [] = {3, 44, 87, 2, 4, 99, 112, -1, 9, 14, 89, 21};

		// Platz für deine Lösung

		int maxValue = 0;

		for (int i : arr) {
			if (i > maxValue) {
				maxValue = i;		
			}
		}

		int minValue = maxValue;
		for (int i : arr) {
			if (i < minValue) {
				minValue = i;
			}
		}

		System.out.println("Minimumwert: " + minValue);
		System.out.println("Maximumwert: " + maxValue);
		

		System.out.println("");
		System.out.println("oder");
		System.out.println("");
		/// ODER auch
		
		System.out.println(Arrays.stream(arr).min().getAsInt());
		System.out.println(Arrays.stream(arr).max().getAsInt());

	}
}