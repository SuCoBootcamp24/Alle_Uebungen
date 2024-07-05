
public class LiveSession {
    public static void main(String[] args) {
        // LiveSession Challenge 1. create a method isPalingdrome() method recursiv.
        System.out.println(isPalindrome("otto"));
    }

    public static boolean isPalindrome(String input) {
        return isPalindrome(input, 0, input.length() - 1);
    }

    private static boolean isPalindrome(String input, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (input.charAt(left) != input.charAt(right)) {
            return false;
        }
        return isPalindrome(input, left + 1, right - 1);
    }

}