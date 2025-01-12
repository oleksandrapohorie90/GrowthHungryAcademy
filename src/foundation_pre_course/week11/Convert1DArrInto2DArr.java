package foundation_pre_course.week11;

import java.util.Arrays;

public class Convert1DArrInto2DArr {
    /*
    You are given a 0-indexed 1-dimensional (1D) integer array original, and two integers, m and n. You are tasked with creating a 2-dimensional (2D) array with  m rows and n columns using all the elements from original.

The elements from indices 0 to n - 1 (inclusive) of original should form the first row of the constructed 2D array, the elements from indices n to 2 * n - 1 (inclusive) should form the second row of the constructed 2D array, and so on.

Return an m x n 2D array constructed according to the above procedure, or an empty 2D array if it is impossible.
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int m = 2;
        int n = 2;

        System.out.println(Arrays.deepToString(construct2DArray(arr, m, n)));
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        //It checks if the total number of elements in the original array (original.length) matches the size of the 2D array you want to construct (m * n).
        //If they don’t match, it returns an empty 2D array (with dimensions [0][0]).
        //Debugging Case:
        //
        //For arr = {1, 2, 3, 4}, m = 2, and n = 2, the condition evaluates as false because 4 == 2 * 2.
        if (original.length != m * n) {
            return new int[0][0];
        }
        //    arr = [
        //    [0, 0],
        //    [0, 0]
        //    ]
        int[][] arr = new int[m][n];

        //A variable current_index is initialized to 0 to track the position in the original array.
        int current_index = 0;

        //You iterate through the rows (i) and columns (j) of the 2D array.
        //For each position arr[i][j], you assign the value from original[current_index] and then increment current_index.
        //Step-by-Step Execution:
        //
        //Iteration 1: i = 0, j = 0 → arr[0][0] = original[0] = 1, current_index = 1
        //Iteration 2: i = 0, j = 1 → arr[0][1] = original[1] = 2, current_index = 2
        //Iteration 3: i = 1, j = 0 → arr[1][0] = original[2] = 3, current_index = 3
        //Iteration 4: i = 1, j = 1 → arr[1][1] = original[3] = 4, current_index = 4
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = original[current_index];
                current_index++;
            }
        }
        return arr;
    }

}
