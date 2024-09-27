
public class Matrix {
    public static void main(String[] args) {
        // create a method to transport a matrix. turn the matrix 90deg.
        //create a assist method to show the matrix.

        int[][] matrix = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};

        showMatrix(matrix);
        System.out.println("");
        matrix = transportMatrix(matrix);
        showMatrix(matrix);

    }

    private static void showMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println("");
        }
    }
    
    private static int[][] transportMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                result[col][row] = matrix[row][col];
            }
        }
        return result;
    }


}