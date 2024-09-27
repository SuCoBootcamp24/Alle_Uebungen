public class DiagSum {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};
                          
        System.out.println("Summe der Hauptdiagonale: " + sumOfMainDiagonal(matrix));
        
    }

    public static int sumOfMainDiagonal(int[][] matrix) {
        int sum = 0;
        for (int diag = 0; diag < matrix.length && diag < matrix[0].length; diag++) {
            sum += matrix[diag][diag];
        }

        return sum;
    }
}
