package data_structures_and_algorithms_CS210.Leetcode.Arrays;

public class RangeSumQuery2D_PrefixSum {

//    private int [][] matrix;
//    public RangeSumQuery2D_PrefixSum(int[][] matrix) {
//        this.matrix = matrix;
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int res = 0;
//        for (int r = row1; r <= row2; r++) {
//            for (int c = col1; c <= col2; c++) {
//                res += matrix[r][c];
//            }
//        }
//        return res;
//    }

    int[][] sum;

    public RangeSumQuery2D_PrefixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
// sum[i][j] is the sum of all elements
// inside the prefix-submatrix matrix[1 .. i][1 .. j].
// `sum` is a 1-indexed matrix whereas `matrix` is 0-indexed.
// This is intentional to simplify computations.
// If you make `sum` matrix 0-indexed, you will have to
// write many `if` statements to check that you didn't go out-of-bounds.
// Assume its 0-th row (sum[0][...]) and 0-th column (sum[...][0]) are filled with
// That indeed greatly simplifies computations.
        sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
// sum of all elems from (1, 1) till (i, j) =
                sum[i][j] = (sum[i - 1][j] + //~> add sum of all elems from (1, 1) till (i - 1, j) // + sum(matrix[1 .. i - 1][1 .. j (+)])
                        sum[i][j - 1] - //~> add sum of all elems from (1, 1) till (i, j - 1) // + sum(matrix[1 .. i (+)][1 .. j - 1])
                        sum[i - 1][j - 1]) + // - sum(matrix[1 .. i - 1][1 .. j - 1])~> sub sum of all elems from (1, 1) till (i - 1, j - 1) because they were added twice
                        matrix[i - 1][j - 1]; // + matrix[i][j] ~> add the value in cell (i, j)
// matrix[i - 1][j - 1] because `matrix` is actually 0-indexed.
// Please draw the `sum` matrix on a piece of paper and compute it by hand step by step to understand.
            }
        }
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {
// Since our `sum` matrix is 1-indexed and given r1, c1, r2, c2 are 0-indexed, we increase r1, c1, r2, c2 by 1.
        r1++;
        c1++;
        r2++;
        c2++;
        return (sum[r2][c2] - // + sum(matrix[1 .. r2][1 .. c2]) ~> add, sum of all elems from (1, 1) till (r2, c2) (+)
                sum[r2][c1 - 1] - //- sum of all elems from (1, 1) till (r2, c1 - 1) // - sum(matrix[1 .. r2][1 .. c1 - 1]) (-) ~> sub
                sum[r1 - 1][c2] + // - sum of all elems from (1, 1) till (r1 - 1, c2) // - sum(matrix[1 .. r1 - 1][1 .. c2]) ~> sub(-) 39.
                sum[r1 - 1][c1 - 1]); // + sum(matrix[1 .. r1 - 1][1 .. c1 - 1]) ~> add sum of all elems from (1, 1) till (r1 - 1, c1 - 1) because they were added once and twice subbed
    }
}
