
public class DrawChars {   
    public static void main(String[] args) {
        // Live Session Challenge 1 : Switch for to while loops from Square.
        //  Live Session Challenge 2 : build a Triangle Method.
        //    Live Session Challenge 3 : the Triangle Method should center.
        
        // Bonus Challenge 1 : Create a Method to draw a Diamond.
        // Bonus Challenge 2 : Create a Method to draw a chessfield.

        // self Challenge 1 Create a Chessfield with big Cells.

        // int hight = Integer.parseInt(args[0]);
    
        bigChessfield(6);

    }

    public static void bigChessfield(int size){
        int cellSize = 3;
        int count = 0;
        char cellChar = '#';
    
        for(int level = 0; level < size; level++) {
            if (level % 2 == 0 || level == 0) {
                for (int cellLevel = 0; cellLevel < cellSize; cellLevel++) {
                    for (int legth = 1; legth <= size; legth++) {
                        if (legth % 2 != 0) {
                            cellChar = '#';
                        } else {
                            cellChar = ' ';
                        }
                        while (count < cellSize + 1) {
                            System.out.print(cellChar);
                            count++;
                        }
                        count = 0;
                    }
                    System.out.println("");
                }
            } else if (level % 2 != 0 || level != 0) {
                for (int cellLevel = 0; cellLevel < cellSize; cellLevel++) {
                    for (int legth = 1; legth <= size; legth++) {
                    
                        if (legth % 2 == 0) {
                            cellChar = '#';
                        } else {
                            cellChar = ' ';
                        }
                     
                        while (count < cellSize + 1) {
                            System.out.print(cellChar);
                            count++;
                        }
                        count = 0;
                    }
                    System.out.println("");
                }
            }
            
        }
    }



    public static void chessfield(int size){
        
        for (int level = 0; level < size; level++) {
            for (int i = 0; i < size; i++) {
                if (level % 2 != 0) {
                    if (i % 2 != 0) {System.out.print("#");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    if (i % 2 == 0) {System.out.print("#");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("");
        }
    }

    public static void Diamond(int hight) {

        int parthight = hight/ 2;

        for (int level = 0; level < hight; level++) {
            if ( level <= parthight) {
                for (int length = 0; length < 2 * hight - 1; length++) {
                    if (length >= hight - level - 1 && length <= hight + level - 1) {
                        System.out.print("#");
                    } else {
                        System.out.print(" ");
                    }
                }
            } else {
                for (int length = 0; length < 2 * hight - 1; length++) {
                    if (length >= level && length < 2 * hight - 1 - level) {
                        System.out.print("#");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("");
        }
    }

   



    public static void emptyRectangle(int hight, int length) {
        for (int level = 0; level < hight; level++) {
            for (int i = 0; i < length; i++) {
                if ((i == 0 || i == length - 1) || level == 0 || level == hight - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n"); // draw \n = new line
        }

    }


    public static void rectangle(int hight, int length) {
        for (int i = 0; i < hight; i++) {
                for (int j = 0; j < length; j++) {
                    System.out.print("*");
                }
                System.out.print("\n"); // draw \n = new line
            }
    }

    public static void trianglReverse(int hight) {

        for (int level = 0; level < hight; level++) {
            for (int length = 0; length < 2 * hight - 1; length++) {
                if (length >= level && length < 2 * hight - 1 - level) {
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
            for (int length = 0; length < 2 * hight - 1; length++) {
                if (length >= hight - level - 1 && length <= hight + level - 1) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        
    }

    public static void emptySquare(int sideLength) {
        for (int i = 0; i < sideLength; i++) {
            // draw single line loop
            for (int j = 0; j < sideLength; j++) {
                if ((i == 0 || i == sideLength - 1) || j == 0 || j == sideLength - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n"); // draw \n = new line
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