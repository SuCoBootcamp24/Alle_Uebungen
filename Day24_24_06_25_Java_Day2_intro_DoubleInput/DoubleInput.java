import java.util.Scanner;

public class DoubleInput {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        input.close();
        System.out.print(number + " * 2 = ");
        System.out.println(number * 2);
    }
}
