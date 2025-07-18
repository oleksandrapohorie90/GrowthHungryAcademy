package data_structures_and_algorithms_CS210.Leetcode.Arrays;

public class RangeSumQuery2D_PrefixSum {

    private int [][] matrix;
    public RangeSumQuery2D_PrefixSum(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int r = row1; r <= row2; r++) {
            for (int c = col1; c <= col2; c++) {
                res += matrix[r][c];
            }
        }
        return res;
    }
}
