public class Palindrom {
    public static void main(String[] args) {
        String text = "amok oma";
        String otherString = "abc";

        System.out.println(checkPalindrom(text));
        System.out.println(checkPalindrom(otherString));
        
    }

    private static boolean checkPalindrom(String input) {
        input = input.replaceAll("\\W","").toLowerCase();
        String inputReverse = new StringBuffer(input).reverse().toString();
    

        if (input.equals(inputReverse)) return true;
        return false;
    }
}
