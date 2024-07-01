package cs_and_programming.week9;

public class BasicMatrixMultiplication {
    public static void main(String[] args) {

        //2X3
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        //3X2
        int[][] matrix2 = {
                {7, 8},
                {9, 10},
                {11, 12},
        };
        int[][] result = matrixMultiplication(matrix1, matrix2);
        printMatrix(result);
    }

    public static int[][] matrixMultiplication(int[][] a, int[][] b) {

        if (a[0].length != b.length) {
            System.out.println("We are unable to multiply matrices");
        }

        //product of above matrices will be rows of 1st X columns of 2nd

        int rowsA = a.length;
        int colB = b[0].length;
        int colA = a[0].length;
        //new matrix where we will put result
        int[][] result = new int[rowsA][colB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < colA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    //check again
    public static void printMatrix(int[][] matrixRes) {
        for (int[] row : matrixRes) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}