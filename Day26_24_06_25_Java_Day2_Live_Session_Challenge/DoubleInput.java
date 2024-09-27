import java.util.Scanner;

public class DoubleInput {
    
    public static void main(String[] args) {

        //--- eingabe über Tastatur

        // Scanner input = new Scanner(System.in);
        // int number = input.nextInt();
        // input.close();


        //--- eingabe über als parameter 
        int number = Integer.parseInt(args[0]);

        System.out.print(number + " * 2 = ");
        System.out.println(number * 2);
    }
}
