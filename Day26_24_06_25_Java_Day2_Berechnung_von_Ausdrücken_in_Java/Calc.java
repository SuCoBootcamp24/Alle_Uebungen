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
        int_ergebnis = c - a * 3;  //möglich (-3)
        System.out.println(int_ergebnis);
        System.out.println("");

        System.out.println("2.");
        int_ergebnis = c / a ;  //möglich (2)
        System.out.println(int_ergebnis);
        System.out.println("");
        
        System.out.println("3.");
        int_ergebnis = c / b;  //möglich (1)
        System.out.println(int_ergebnis);
        System.out.println("");
        
        System.out.println("4.");
        int_ergebnis = a + b / c; //möglich (3)
        System.out.println(int_ergebnis);
        System.out.println("");
        
        System.out.println("5.");
        int_ergebnis = a++; //möglich a = 3    wird dann mit 1 addiert
        System.out.println(int_ergebnis);
        System.out.println("");
        
        System.out.println("6.");
        int_ergebnis = ++a; //möglich a = 5    wird erst mit 1 addiert
        System.out.println(int_ergebnis);
        System.out.println("");
        
        System.out.println("7.");
        int_ergebnis = b + a--;   // möglich (10) nach der berechnung wird a um 1 reduziert (4)
        System.out.println(int_ergebnis);
        System.out.println("");
        
        System.out.println("8.");
        int_ergebnis = b + --a;  // möglich (8) Vor der berechnung wird a um 1 reduziert (3)
        System.out.println(int_ergebnis);
        System.out.println("");
        
        System.out.println("9.");
        // int_ergebnis = a**;  Geht nicht
        System.out.println("");

        System.out.println("10.");
        double_ergebnis = c / b;  //möglich (1.0)
        System.out.println(double_ergebnis);
        System.out.println("");
        
        System.out.println("11.");
        double_ergebnis = x + y * b;  //möglich (13.0)
        System.out.println(double_ergebnis);
        System.out.println("");
        
        System.out.println("12.");
        double_ergebnis = (x + y) * b; //möglich (19.0)
        System.out.println(double_ergebnis);
        System.out.println("");
        
        System.out.println("13.");
        double_ergebnis = c + a / b;  //möglich (6.0)
        System.out.println(double_ergebnis);
        System.out.println("");
        double_ergebnis = 0;
        System.out.println("14.");
        double_ergebnis =  (x * c - a); //möglich (6.0) die klammern sind aber überflüssig wenn nichts weiter gemacht werden soll
        System.out.println(double_ergebnis);
        System.out.println("");
        


    }
}
