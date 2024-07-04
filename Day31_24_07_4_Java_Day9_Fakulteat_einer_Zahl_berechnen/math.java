public class math {
    public static void main(String[] args) {
        System.out.println(powerOfNumber(8, 10));
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
        if (n == 0) return 1;
        return x * powerOfNumber(x , n -1);
    }
}
