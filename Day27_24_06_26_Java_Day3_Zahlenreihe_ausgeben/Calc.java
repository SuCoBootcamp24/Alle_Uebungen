public class Calc {
    public static void main(String[] args) {
        int sum = 0;

        // 1. Schreibe ein Programm, das die Summe der Zahlen von 1 bis 100 berechnet und ausgibt
        for (int i = 1; i <= 100; i++) {
        sum += i;
        }

       System.out.println("1. " + sum);
        sum = 0;

       // 2. Schreibe ein Programm, das die Summer aller geraden Zahlen von 1 bis 100 berechnet und ausgibt
       for (int i = 1; i <= 100; i++) {
        if (i % 2 == 0) sum += i;
        }

       System.out.println("1. " + sum);
        sum = 0;

        // 3. Schreibe ein Programm, das die Summer aller ungeraden Zahlen von 1 bis 100 berechnet und ausgibt
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) sum += i;
            }
    
           System.out.println("1. " + sum);
        
    }
}
