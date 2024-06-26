public class Average {

    public static void main(String[] args) {
        // Live Session Challenge 2, int[] should calcolate and the average be put out.

        int[] numbers = new int[] {19, 0, 239, 30, 459, 30, 29};
        int i = 0;
        double sum = 0;

        while (i < numbers.length) {
            sum += numbers[i];
            i++;
        }

        System.out.println(sum = sum / numbers.length);
        }
}
