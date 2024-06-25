public class Calc {
    public static void main(String[] args) {

        int a = 3;
        int b = 5;
        int c = 6;
        double x = 1.5;
        double y = 2.3;
        int int_ergebnis;
        double double_ergebnis;

        System.out.println("1.");
        int_ergebnis = c - a * 3;  
        System.out.println(int_ergebnis);
        System.out.println("");

        System.out.println("2.");
        int_ergebnis = c / a ;  
        System.out.println(int_ergebnis);
        System.out.println("");
        
        System.out.println("3.");
        int_ergebnis = c / b;  
        System.out.println(int_ergebnis);
        System.out.println("");
        
        System.out.println("4.");
        int_ergebnis = a + b / c; 
        System.out.println(int_ergebnis);
        System.out.println("");
        
        System.out.println("5.");
        int_ergebnis = a++;
        System.out.println(int_ergebnis);
        System.out.println("");
        
        System.out.println("6.");
        int_ergebnis = ++a;
        System.out.println(int_ergebnis);
        System.out.println("");
        
        System.out.println("7.");
        int_ergebnis = b + a--;
        System.out.println(int_ergebnis);
        System.out.println("");
        
        System.out.println("8.");
        int_ergebnis = b + --a;
        System.out.println(int_ergebnis);
        System.out.println("");
        
        System.out.println("9.");
        // int_ergebnis = a**;  Geht nicht
        System.out.println("");

        System.out.println("10.");
        double_ergebnis = c / b;
        System.out.println(double_ergebnis);
        System.out.println("");
        
        System.out.println("11.");
        double_ergebnis = x + y * b;
        System.out.println(double_ergebnis);
        System.out.println("");
        
        System.out.println("12.");
        double_ergebnis = (x + y) * b;
        System.out.println(double_ergebnis);
        System.out.println("");
        
        System.out.println("13.");
        double_ergebnis = c + a / b;
        System.out.println(double_ergebnis);
        System.out.println("");
        
        System.out.println("14.");
        double_ergebnis =  (x * c - a);
        System.out.println(double_ergebnis);
        System.out.println("");
        


    }
}
