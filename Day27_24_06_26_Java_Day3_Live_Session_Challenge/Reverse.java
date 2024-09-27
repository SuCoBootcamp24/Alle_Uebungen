public class Reverse {
    public static void main(String[] args) {
        // Live Session Challenge 1, an int[] should be put out backwards

        int[] numbers = new int[] {19, 0, 239, 30, 459, 30, 29};
        int i = numbers.length;
while (i > 0) {
    System.out.println(numbers[i - 1]);
    i--;
}
        }
}
