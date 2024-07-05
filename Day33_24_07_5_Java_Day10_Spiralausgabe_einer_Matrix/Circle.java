public class Circle {
    public static void main(String[] args) {
        int[][] matrix = {{1,  2,  3,  4},
                          {5,  6,  7,  8},
                          {9, 10, 11, 12},
                          {13, 14, 15, 16}};
        
        showCircleOutput(matrix);
        System.out.println("");
        showCircleOutputRecusiv(matrix);
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

    private static void showCircleOutputRecusiv(int[][] matrix ) {
        int m = matrix.length;
        int n = matrix[0].length;
        showCircleOutputRecusiv(matrix, 0, 0, m, n);
    }


    private static void showCircleOutputRecusiv(int[][] matrix, int startX, int startY, int m, int n) {
        if (m <= 0 || n <= 0) return;

        // Traverse the top row from the remaining rows
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[startX][startY + i] + " ");
        }

        // Traverse the last column from the remaining columns
        for (int i = 1; i < m; i++) {
            System.out.print(matrix[startX + i][startY + n - 1] + " ");
        }

        // Traverse the bottom row from the remaining rows
        if (m > 1) {
            for (int i = n - 2; i >= 0; i--) {
                System.out.print(matrix[startX + m - 1][startY + i] + " ");
            }
        }

        // Traverse the first column from the remaining columns
        if (n > 1) {
            for (int i = m - 2; i > 0; i--) {
                System.out.print(matrix[startX + i][startY] + " ");
            }
        }

        // Recursive call for the next layer of the matrix
        showCircleOutputRecusiv(matrix, startX + 1, startY + 1, m - 2, n - 2);
    }

}
