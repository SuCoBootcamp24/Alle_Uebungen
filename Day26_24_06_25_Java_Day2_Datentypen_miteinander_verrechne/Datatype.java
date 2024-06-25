public class Datatype {
    public static void main(String[] args) {
        int a = 10;
        double b = 5.5;
        char c = 'A';
        String text = "Hallo";

        // 1. Addieren von a, b und c und Zuweisen des Ergebnisses zu 
        // einer double-Variable result1
        double result1 = a + b + c;
        System.out.println(result1);

        // 2. Multiplizieren von a und c und Zuweisen des Ergebnisses zu einer
        // int-Variable result2
        int result2 = a * (int) b * c;
        System.out.println(result2);

        // 3. Dividieren von b durch c und Zuweisen des Ergebnisses zu einer
        // double-Variable result3
        double result3 = b / c;
        System.out.println(result3);

        // 4. Konkatenieren von text und c (als String) und Zuweisen des 
        // Ergebnisses zu einer String-Variable result4
        String result4 = "" + c;
        System.out.println(result4);


    }
}
