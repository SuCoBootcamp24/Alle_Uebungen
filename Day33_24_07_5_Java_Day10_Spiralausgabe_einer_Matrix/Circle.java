public class Circle {
    public static void main(String[] args) {
    int[][] matrix = {{1,  2,  3,  4},
                      {5,  6,  7,  8},
                      {9, 10, 11, 12},
                      {13, 14, 15, 16}};
    
    showCircleOutput(matrix);

    }

    private static void showCircleOutput(int[][] matrix ) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while ( top <= bottom && left <= right) {
             // Topside from left to right
             for (int col = left; col <= right; col++) {
                System.out.print(matrix[top][col] + " ");
            }
            top++;
            
            // Rightside from top to bottom
            for (int row = top; row <= bottom; row++) {
                System.out.print(matrix[row][right] + " ");
            }
            right--;
            
            // botside from left to right
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    System.out.print(matrix[bottom][col] + " ");
                }
                bottom--;
            }
            
            // Leftside from bottom to top
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    System.out.print(matrix[row][left] + " ");
                }
                left++;
            }

        }


    }


}
