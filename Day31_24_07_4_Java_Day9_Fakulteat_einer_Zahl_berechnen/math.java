public class math {
    public static void main(String[] args) {
        System.out.println(faculty(5));
    }

    public static int faculty(int n){
        if (n == 0) {
            return 1;
        }
        return n * faculty(n - 1);
    }
}
