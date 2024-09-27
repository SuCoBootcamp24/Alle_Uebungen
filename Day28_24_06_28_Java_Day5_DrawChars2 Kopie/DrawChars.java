
public class DrawChars {   
    public static void main(String[] args) {
        // Live Session Challenge 1 : create a Rectangle with a draw line method
    
        drawRect(6, 8);

    }

    public static void drawRect(int width, int height) {
        for (int level = 0; level < height; level++) {
            if (level == 0 || level == height - 1){
                drawLine(width, '#');
            } else {
                drawCutLine(width, '#');
            }
            System.out.println("");
        }
    }

    //-----------------------
    
    private static void drawLine(int length, char lineChar) {
        for(int i = 0; i < length; i++) {
            System.out.print(lineChar);
        }
    }
    
    private static void drawCutLine(int length, char lineChar) {
        for(int i = 0; i < length; i++) {
            if (i == 0 || i == length - 1){
            System.out.print(lineChar);
            }  else {
                System.out.print(" ");
            }
        }
    }
}
 
   
