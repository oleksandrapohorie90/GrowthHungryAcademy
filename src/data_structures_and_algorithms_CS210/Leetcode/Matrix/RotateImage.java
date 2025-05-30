package data_structures_and_algorithms_CS210.Leetcode.Matrix;

public class RotateImage {

        public void rotate(int[][] matrix) {
            transpose(matrix);
            mirror(matrix);
        }

        public void transpose(int[][] matrix) {

            for(int i = 0; i < matrix.length; i++){
                for(int j = i+1; j < matrix.length; j++){
                    int tmp = matrix[i][j]; //  0,1 = 2
                    matrix[i][j] = matrix[j][i]; // 1,0 = 4
                    matrix[j][i] = tmp;
                }
            }
        }
        public void mirror(int[][] matrix) {
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix.length/2; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length-j-1];
                    matrix[i][matrix.length-j-1] = temp;
                }
            }
        }
        //  i j.  i j.  i j
        // [0,0] [0,1] [0,2] [0,3]
        // [1,0] [1,1] [1,2] [1,3]
        // [2,0] [2,1] [2,2] [2,3]
    }

