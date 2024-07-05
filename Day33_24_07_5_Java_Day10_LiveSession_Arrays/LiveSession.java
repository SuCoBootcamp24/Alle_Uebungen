
public class LiveSession {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    
    public static void main(String[] args) {
        int[][] display = {{ 0, 0, 1, 1, 1, 0, 0},
                           { 0, 0, 1, 1, 1, 0, 0},
                           { 0, 0, 0, 1, 0, 0, 0},
                           { 0, 3, 3, 3, 3, 3, 0},
                           { 0, 1, 0, 3, 0, 1, 0},
                           { 0, 0, 0, 3, 0, 0, 0},
                           { 0, 0, 2, 2, 2, 0, 0},
                           { 0, 0, 2, 0, 2, 0, 0}};

        printDisplay(display);
        
    }


    public static void printDisplay(int[][] display){
        for (int y = 0; y < display.length; y++) {
            for (int x = 0; x < display[y].length; x++){
                switch (display[y][x]) {
                    case 1 :
                    System.out.print(ANSI_BLACK_BACKGROUND + " " + ANSI_RESET );
                    break;
                    case 2 :
                    System.out.print(ANSI_BLUE_BACKGROUND + " " + ANSI_RESET );
                    break;
                    case 3 :
                    System.out.print(ANSI_GREEN_BACKGROUND + " " + ANSI_RESET );
                    break;
                    case 4 :
                    System.out.print(ANSI_RED_BACKGROUND + " " + ANSI_RESET );
                    break;
                    case 5 :
                    System.out.print(ANSI_PURPLE_BACKGROUND + " " + ANSI_RESET );
                    break;
                    default : 
                    System.out.print(ANSI_WHITE_BACKGROUND + " " + ANSI_RESET );

                }
            }
                
            System.out.println("");
        }
    }

   

}