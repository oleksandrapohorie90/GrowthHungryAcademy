package foundation_pre_course.week13;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_HardToDigest {
    /*
    Given an m x n matrix, return all elements of the matrix in spiral order.
    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [1,2,3,6,9,8,7,4,5]
     */
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            // 1. Iterate over top row, left to right.
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            if (++top > bottom) break;
            // 2. Iterate over right column, top to bottom.
            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            if (left > --right) break;
            // 3. Iterate over bottom row, right to left.
            for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            if (top > --bottom) break;
            // 4. Iterate over left column, bottom to top.
            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            if (++left > right) break;
        }
        return res;
    }
}
