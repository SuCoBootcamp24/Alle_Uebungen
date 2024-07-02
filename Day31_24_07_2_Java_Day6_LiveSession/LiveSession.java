public class LiveSession {
    public static void main(String[] args) {
        // LiveSession Challenge 1. create a logic for the method toLowerCase

        String input = "Hallo Freunde!";
       System.out.println(indexOf(input, "und"));
    }

    public static String toLowerCase(String input) {
        if (input.isEmpty() || input.isBlank()) {
            return null;
        }
    
            StringBuilder result = new StringBuilder(input.length());
    
            
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
    
                
                if (ch >= 'A' && ch <= 'Z') {
                    
                    ch = (char) (ch + 32);
                }
    
                
                result.append(ch);
            }
    
            return result.toString();
    }


        // challenge2. implements the own indexOf Methode:
    // input = "Hallo Freunde!"
    // search = "und"
    // indexOf(input, search) --> 9
    // indexOf(input, "blabla") --> -1 (not exist)
    
    public static int indexOf(String input, String searchInput) {
    if (input == null || searchInput == null || searchInput.length() > input.length()) {
        return -1;
    }

    for (int i = 0; i <= input.length() - searchInput.length(); i++) {
        int j;
        for (j = 0; j < searchInput.length(); j++) {
            if (input.charAt(i + j) != searchInput.charAt(j)) {
                break;
            }
        }
        if (j == searchInput.length()) {
            return i;
        }
    }

    return -1;
    }


    public static int compareTo(String s1, String s2) {
    if (s1 == null || s2 == null) {
        throw new NullPointerException("Strings must not be null");
    }

    int len1 = s1.length();
    int len2 = s2.length();
    int minLength = Math.min(len1, len2);

    for (int i = 0; i < minLength; i++) {
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(i);
        if (c1 != c2) {
            return c1 - c2;
        }
    }

    return len1 - len2;
}





}