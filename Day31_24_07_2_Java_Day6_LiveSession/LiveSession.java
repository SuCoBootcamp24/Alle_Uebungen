public class LiveSession {
    public static void main(String[] args) {
        // LiveSession Challenge 1. create a logic for the method toLowerCase

        String input = "DAS ist3 EIN TesT!";
        System.out.println(input);
        System.out.println(toLowerCase(input));
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
}
