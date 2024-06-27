public class DrawChars {   
    public static void main(String[] args) {

        int sideLength = Integer.parseInt(args[0]);

        // // draw multiple lines
        // for (int i = 0; i < sideLength; i++) {
        //     // draw single line loop
        //     for (int j = 0; j < sideLength; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.print("\n"); // draw \n = new line
        // }

        // Live Session Challenge 1
        // Switch for to while loops


        int i = 0;
        

        while (i < sideLength ) {
               int j = 0;
                while (j < sideLength ) {
                    System.out.print("*");
                    j++;
                }
                System.out.print("\n"); 
                j = 0;
                i++;
            }


    }
}