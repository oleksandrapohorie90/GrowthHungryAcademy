package data_structures_and_algorithms_CS210.Second_Cohort.week16_arrays2_ComeBack;

public class IncrementSubmatricesByOne_RevisitPrefixSums {
    /**
     * You are given a positive integer n, indicating that we initially have an n x n 0-indexed integer matrix mat filled with zeroes.
     * <p>
     * You are also given a 2D integer array query. For each query[i] = [row1i, col1i, row2i, col2i], you should do the following operation:
     * <p>
     * Add 1 to every element in the submatrix with the top left corner (row1i, col1i) and the bottom right corner (row2i, col2i). That is, add 1 to mat[x][y] for all row1i <= x <= row2i and col1i <= y <= col2i.
     * Return the matrix mat after performing every query.
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: n = 3, queries = [[1,1,2,2],[0,0,1,1]]
     * Output: [[1,1,0],[1,2,1],[0,1,1]]
     * Explanation: The diagram above shows the initial matrix, the matrix after the first query, and the matrix after the second query.
     * - In the first query, we add 1 to every element in the submatrix with the top left corner (1, 1) and bottom right corner (2, 2).
     * - In the second query, we add 1 to every element in the submatrix with the top left corner (0, 0) and bottom right corner (1, 1).
     * Example 2:
     * <p>
     * Input: n = 2, queries = [[0,0,1,1]]
     * Output: [[1,1],[1,1]]
     * Explanation: The diagram above shows the initial matrix and the matrix after the first query.
     * - In the first query we add 1 to every element in the matrix.
     */

    public int[][] rangeAddQueries(int n, int[][] queries) {
        // Creating a bigger array, so that I don't have to care
        // about going out of bounds in any computations.
        int[][] a = new int[n + 2][n + 2];

        for (int[] query : queries) {
            // Intentionally adding 1 to all indices to make
            // the array and queries 1-indexed.
            int r1 = query[0] + 1, c1 = query[1] + 1;
            int r2 = query[2] + 1, c2 = query[3] + 1;

            // O(1) per update
            // Apply +1 on a[r1 .. n][c1 .. n]
            a[r1][c1] += 1;
            // Undo +1 on a[r2+1 .. n][c1 .. n]
            a[r2 + 1][c1] -= 1;
            // Undo +1 on a[r1][c2+1 .. n]
            a[r1][c2 + 1] -= 1;
            // Apply +1 on a[r2+1 .. n][c2+1 .. n] because +1 was undone twice (-2)
            a[r2 + 1][c2 + 1] += 1;
        }

        // O(N^2)
        // Compute 2D prefix sums, i.e. the final array.
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                a[r][c] = (a[r - 1][c] +
                        a[r][c - 1] -
                        a[r - 1][c - 1]) + a[r][c];
            }
        }

        // O(N^2)
        // The problem requires returning a strictly n x n array
        // [my array "a" is (n+2)x(n+2)], so I copy results to this array "r"
        // that I will return.
        int[][] r = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                r[i][j] = a[i + 1][j + 1];
            }
        }
        return r;
    }
}
