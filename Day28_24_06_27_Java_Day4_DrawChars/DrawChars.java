public class DrawChars {   
    public static void main(String[] args) {
        // Live Session Challenge 1 : Switch for to while loops from Square
        //  Live Session Challenge 2 : build a Triangle Methode
         //  Live Session Challenge 3 : the Triangle Methode should center

        // int hight = Integer.parseInt(args[0]);
        trianglReverse(3);
        triangle(3);

    }



    
    public static void trianglReverse(int hight) {

        for (int level = 0; level < hight; level++) {
            for (int lenth = 0; lenth < 2 * hight - 1; lenth++) {
                if (lenth >= level && lenth < 2 * hight - 1 - level) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    public static void triangle(int hight) {

        for (int level = 0; level < hight; level++) {
            for (int lenth = 0; lenth < 2 * hight - 1; lenth++) {
                if (lenth >= hight - level - 1 && lenth <= hight + level - 1) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        
    }

    public static void square(int sideLength) {
        // // draw multiple lines
        // for (int i = 0; i < sideLength; i++) {
        //     // draw single line loop
        //     for (int j = 0; j < sideLength; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.print("\n"); // draw \n = new line
        // }

        int i = 0;
        while (i < sideLength ) {
            int j = 0;
            while (j < sideLength ) {
                System.out.print("*");
                j++;
            }
            System.out.print("\n"); 
            i++;
        }
    }    
}