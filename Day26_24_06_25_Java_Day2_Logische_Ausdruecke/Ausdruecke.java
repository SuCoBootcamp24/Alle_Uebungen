public class Ausdruecke {
    public static void main(String[] args) {
        
        int a = 45;
        int b = -5;
        int c = 33;

        System.out.println("1. ) Überprüfe, ob eine Zahl zwischen 10 und 20 liegt");
        System.out.println( (10 < a && a < 20));

        System.out.println("2. ) Bestimme, ob eine Person entweder zwischen 18 und 25 Jahren alt ist oder älter als 65 Jahre");
        System.out.println( (18 < a && a > 25)|| a > 65);

        System.out.println("3. ) Schreibe einen Ausdruck, der wahr ist, wenn mindestens zwei von drei Zahlen positiv sind");
        System.out.println( (a > 0 && b > 0) || (b > 0 && c > 0) || (c > 0 && a > 0));

        System.out.println("4. ) Schreibe einen Ausdruck, der wahr ist, wenn eine Zahl weder durch 2 noch durch 3 teilbar ist");
        System.out.println( (a % 2 != 0) && (a % 3 != 0) );

        System.out.println("5. ) a, b und c sind alle 0");
        System.out.println(a == 0 && b == 0 && c == 0 );

        System.out.println("6. ) a, b und c haben den gleichen Wert");
        System.out.println(a == b && b == c && c == b);

        System.out.println("7. ) genau eines von d, e und f ist falsch");
        boolean d = true;
        boolean e = false;
        boolean f = true;

        System.out.println((d == false && e == true && f == true) ||
        (d == true && e == false && f == true) ||
        (d == true && e == true && f == false));
        
        System.out.println("8. ) a ist ein Vielfaches von 2 und 7 oder ein Vielfaches von 7 und 11");
        a = 14;
        System.out.println((a % 2 == 0 && a % 7 == 0) || (a % 7 == 0 && a % 11 == 0));
        
        System.out.println("9. ) d, e und f sind alle drei true oder alle drei false");
        d = false;
        e = false;
        f = false;
        System.out.println( (d == false && e == false && f == false) ||
        (d == true && e == true && f == true));

    }
}



