public class math {
    public static void main(String[] args) {
        System.out.println(quersumme(1456789));

    }

    public static int faculty(int n){
        if (n == 0) {
            return 1;
        }
        return n * faculty(n - 1);
    }

    public static int sumNatureNumbers(int n) {
        return sumNatureNumbers(1, n);
    }
    
    public static int sumNatureNumbers(int index, int n) {
        if (index >= n) return n;
        return index + sumNatureNumbers(index + 1, n);
    }

    public static int powerOfNumber(int x, int n) {
        if (x < 0) return 0;
        if (n == 0) return 1;
        return x * powerOfNumber(x , n -1);
    }

    public static int quersumme(int number) {
        if (number < 10) {
            return number;
        }                                   // Basisfall: Wenn die Zahl kleiner als 10 ist, ist ihre Quersumme einfach die Zahl selbst.
        
        int lastDigit = number % 10;        // Letzte Ziffer der Zahl berechnen (Modulo 10)
        int restNumber = number / 10;       // Rekursiver Aufruf für den Rest der Zahl
        return lastDigit + quersumme(restNumber);
    }
}
