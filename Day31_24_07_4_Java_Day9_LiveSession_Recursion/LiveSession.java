
public class LiveSession {
    public static void main(String[] args) {
        // LiveSession Challenge 1. create a method sum(int[] numbers) recursiv.
        // plus: create this method as a loop.

        int[] numbers = {3, 5, 6, 120, 29, -23, 3};
        int resultRecu = sum(numbers);
        int resultLoop = sumLoop(numbers);
        System.out.println(resultRecu);
        System.out.println(resultLoop);
    }

    private static int sum(int[] numbers) {
      return sumHelper(numbers, numbers.length -1);
    }

    private static int sumHelper(int[] numbers, int index) {
        if (index < 0) return 0;
        return numbers[index] + sumHelper(numbers, index - 1);
    }

    private static int sumLoop(int[] numbers) {
        int result = 0;
        for (int z : numbers) {
            result += z;   
        }
        return result;
      }
}