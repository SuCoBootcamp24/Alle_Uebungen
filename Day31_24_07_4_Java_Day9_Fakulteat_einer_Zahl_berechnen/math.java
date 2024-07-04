public class math {
    public static void main(String[] args) {
        System.out.println(faculty(5));
    }

    public static int faculty(int n){
        int index = 1;
        return faculty(index, n);
    }

    public static int faculty(int index, int n) {
        if (index == n) return n;
        return index * faculty(index + 1, n);
    }
}
