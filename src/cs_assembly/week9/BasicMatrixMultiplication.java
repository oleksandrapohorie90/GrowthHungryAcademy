package cs_assembly.week9;

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
    }

    public int[][] matrixMultiplication(int[][] a, int[][] b){

        if(a[0].length != b.length){
            System.out.println("We are unable to multiply matrices");
        }

               int rowsB = b.length;
               int rowsB = b.length;
        int colA = a[0].length;
        int colB = b[0].length;
    }
}
